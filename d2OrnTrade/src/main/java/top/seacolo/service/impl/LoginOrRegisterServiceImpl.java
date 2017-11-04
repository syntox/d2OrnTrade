package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserLoginAndRegisterDao;
import top.seacolo.entity.User;
import top.seacolo.entity.User_level;
import top.seacolo.entity.User_role;
import top.seacolo.service.LoginOrRegisterService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.MailUtil;
import top.seacolo.util.RandomIdUtil;
import top.seacolo.util.ReturnSty;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginOrRegisterServiceImpl implements LoginOrRegisterService {
    @Autowired(required = false)
    UserLoginAndRegisterDao userLoginAndRegisterDao;
    /**
     * 邮箱登录
     *
     * @param user_mail
     * @param user_pwd
     * @return
     */
    @Override
    public ReturnSty loginByMail(String user_mail, String user_pwd) {
        ReturnSty returnSty = new ReturnSty();
        return returnSty;
    }

    /**
     * 用户名登录
     *
     * @param user_name
     * @param user_pwd
     * @return
     */
    @Override
    public ReturnSty loginByUsername(String user_name, String user_pwd) {
        ReturnSty returnSty = new ReturnSty();
        return returnSty;
    }

    /**
     * 通过邮箱注册
     *
     * @param user_name
     * @param user_pwd
     * @param user_mail
     * @return
     */
    @Override
    public ReturnSty registerByMail(String user_name, String user_pwd, String user_mail) {
        ReturnSty returnSty = new ReturnSty();

        //需要封装的参数  user_id, user_name, user_pwd, user_mail, register_date, role_id, lv_id
        //随机id防止重复
        String user_id = RandomIdUtil.getID();
        //获取当前时间作为注册时间
        Timestamp register_date = new Timestamp(new Date().getTime());
        //默认普通用户
        User_role user_role = new User_role(2);
        //默认白银用户
        User_level user_level = new User_level(1);

        User user = new User(user_id, user_name, user_pwd, user_mail, register_date, user_role, user_level);
        int count = userLoginAndRegisterDao.insertOneUser(user);
        if(count > 0){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("邮箱注册成功！");
            return returnSty;
        }else {
            returnSty.setRetCode(ConstantUtil.REGISTER_FAIL);
            returnSty.setRetMessage("邮箱注册失败！");
            return returnSty;
        }

    }

    /**
     * 查找该用户名或邮箱或手机号码是否被使用
     *
     * Map: user_name: ***
     *      user_mail: ***@***.***
     *      user_phonenumber: ***********
     *
     * @param map
     * @return
     */
    @Override
    public ReturnSty isExistUser(HashMap<String,Object> map) {
        User user = userLoginAndRegisterDao.SelectOneUser(map);
        //验证是否查到用户
        ReturnSty returnSty = new ReturnSty();
        return returnSty;
    }

    /**
     * 接收用户输入的邮箱并发送邮件
     *
     * @param user_mail
     * @return
     */
    @Override
    public ReturnSty receiveMail(String user_mail) {
        ReturnSty returnSty = new ReturnSty();
        try {
            String propNum = MailUtil.sendVerifymail(user_mail);
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("邮件发送成功");
            returnSty.setRetValue(propNum);
        } catch (Exception e) {
            e.printStackTrace();
            returnSty.setRetCode(ConstantUtil.MAILSEND_FAIL);
            returnSty.setRetMessage("邮件发送失败");
        }
        return returnSty;
    }

    /**
     * 通过邮箱验证码是否正确
     *
     * @param user_mail
     * @param verificationCode
     * @return
     */
    @Override
    public ReturnSty checkVerificationCode(String user_mail, String verificationCode, HttpSession httpSession) {
        ReturnSty returnSty = new ReturnSty();
        String verificationCodeSession = (String) httpSession.getAttribute(user_mail);
        if(verificationCodeSession == null || "".equals(verificationCodeSession)){
            returnSty.setRetCode(ConstantUtil.MAILVERIFICATIONCODE_NULL);
            returnSty.setRetMessage("邮箱验证码为空或已过时");
        }else if(verificationCode.equals(verificationCodeSession)){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("邮箱验证码正确");
        }else {
            returnSty.setRetCode(ConstantUtil.MAILVERIFICATIONCODE_ERROR);
            returnSty.setRetMessage("邮箱验证码不正确");
        }
        return returnSty;
    }
}
