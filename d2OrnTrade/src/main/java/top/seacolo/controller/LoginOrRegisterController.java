package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.service.impl.LoginOrRegisterServiceImpl;
import top.seacolo.util.ReturnSty;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginOrRegisterController {
    @Autowired
    private LoginOrRegisterServiceImpl loginOrRegisterService;

    @RequestMapping(value = "/loginByMail", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty loginController(String user_mail, String user_pwd){
        ReturnSty returnSty = loginOrRegisterService.loginByMail(user_mail,user_pwd);
        return returnSty;
    }

    @ResponseBody
    @RequestMapping(value = "/registerByMail", produces = "application/json;charset=UTF-8")
    public ReturnSty registerController(String user_name, String user_pwd, String user_mail){
        ReturnSty returnSty = loginOrRegisterService.registerByMail(user_name,user_pwd,user_mail);
        return  returnSty;
    }

    @ResponseBody
    @RequestMapping(value = "/sendMail", produces = "application/json;charset=UTF-8")
    public ReturnSty sendMail(String user_mail, HttpSession session){
        ReturnSty returnSty = loginOrRegisterService.receiveMail(user_mail);
        session.setAttribute(user_mail,returnSty.getRetValue());
        //设置时间为3分钟
        return returnSty;
    }
}
