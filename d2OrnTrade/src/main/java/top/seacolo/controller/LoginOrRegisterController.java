package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.service.impl.LoginOrRegisterServiceImpl;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.ReturnSty;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class LoginOrRegisterController {
    @Autowired
    private LoginOrRegisterServiceImpl loginOrRegisterService;

    /**
     * 通过邮箱登陆
     * @param user_mail
     * @param user_pwd
     * @return
     */
    @RequestMapping(value = "/loginByMail", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty loginByMail(String user_mail, String user_pwd){
        ReturnSty returnSty = loginOrRegisterService.loginByMail(user_mail,user_pwd);
        return returnSty;
    }

    /**
     * 用户名登陆
     * @param user_name
     * @param user_pwd
     * @return
     */
    @RequestMapping(value = "/loginByUsername", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty loginByUsername(String user_name, String user_pwd){
        ReturnSty returnSty = loginOrRegisterService.loginByUsername(user_name,user_pwd);
        return returnSty;
    }

    /**
     * 验证有户名或邮箱或手机号码是否被使用
     * @param user_name
     * @param user_mail
     * @param user_phonenumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/isExistUser", produces = "application/json;charset=UTF-8")
    public ReturnSty isExistUser(String user_name, String user_mail, String user_phonenumber){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("user_name",user_name);
        map.put("user_mail",user_mail);
        map.put("user_phonenumber",user_phonenumber);
        ReturnSty returnSty = loginOrRegisterService.isExistUser(map);
        return returnSty;
    }

    /**
     * 邮箱注册
     * @param user_name
     * @param user_pwd
     * @param user_mail
     * @param verificationCode
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/registerByMail", produces = "application/json;charset=UTF-8")
    public ReturnSty registerController(String user_name, String user_pwd, String user_mail, String verificationCode, HttpSession httpSession){
        //先进行邮箱验证码的确认
        ReturnSty returnStyOfCheck = loginOrRegisterService.checkVerificationCode(user_mail, verificationCode, httpSession);
        if(!ConstantUtil.SUCCESS.equals(returnStyOfCheck.getRetCode())){
            return returnStyOfCheck;
        }else {
            ReturnSty returnStyOfRegister = loginOrRegisterService.registerByMail(user_name,user_pwd,user_mail);
            return returnStyOfRegister;
        }
    }

    /**
     * 注册时发送邮箱验证码
     * @param user_mail
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sendMail", produces = "application/json;charset=UTF-8")
    public ReturnSty sendMail(String user_mail, HttpSession httpSession){
        ReturnSty returnSty = loginOrRegisterService.receiveMail(user_mail);
        httpSession.setAttribute(user_mail,returnSty.getRetValue());
        //设置时间为3分钟
        httpSession.setMaxInactiveInterval(3*60);
        return returnSty;
    }

    /**
     * 验证邮箱验证码是否正确
     * @param user_mail
     * @param verificationCode
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkVerificationCode", produces = "application/json;charset=UTF-8")
    public ReturnSty checkVerificationCode(String user_mail, String verificationCode, HttpSession httpSession){
        ReturnSty returnSty = loginOrRegisterService.checkVerificationCode(user_mail, verificationCode, httpSession);
        return returnSty;
    }
}
