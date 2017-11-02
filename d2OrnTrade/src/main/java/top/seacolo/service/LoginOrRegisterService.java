package top.seacolo.service;

import top.seacolo.entity.User;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;

public interface LoginOrRegisterService {
    /**
     * 普通登录
     *
     * @param user_mail
     * @param user_pwd
     * @return
     */
    ReturnSty login(String user_mail, String user_pwd);

    /**
     * 注册
     *
     * @param user_name
     * @param user_pwd
     * @param user_mail
     * @return
     */
    ReturnSty register(String user_name, String user_pwd, String user_mail);

    /**
     * 查找该用户名或邮箱或手机号码是否被使用
     * @param map
     * @return
     */
    ReturnSty isExistUser(HashMap<String,Object> map);
}
