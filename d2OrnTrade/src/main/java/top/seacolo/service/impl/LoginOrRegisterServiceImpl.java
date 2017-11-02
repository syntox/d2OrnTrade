package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserLoginAndRegisterDao;
import top.seacolo.entity.User;
import top.seacolo.entity.User_level;
import top.seacolo.entity.User_role;
import top.seacolo.service.LoginOrRegisterService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.RandomIdUtil;
import top.seacolo.util.ReturnSty;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class LoginOrRegisterServiceImpl implements LoginOrRegisterService {
    @Autowired(required = false)
    UserLoginAndRegisterDao userLoginAndRegisterDao;
    /**
     * 普通登录
     *
     * @param user_mail
     * @param user_pwd
     * @return
     */
    @Override
    public ReturnSty login(String user_mail, String user_pwd) {
        ReturnSty returnSty = new ReturnSty();
        return returnSty;
    }

    /**
     * 注册
     *
     * @param user_name
     * @param user_pwd
     * @param user_mail
     * @return
     */
    @Override
    public ReturnSty register(String user_name, String user_pwd, String user_mail) {
        ReturnSty returnSty = new ReturnSty();

        //需要封装的参数
        // user_id, user_name, user_pwd, user_mail, register_date, role_id, lv_id
        String user_id = RandomIdUtil.getID();
        Timestamp register_date = new Timestamp(new Date().getTime());
        //默认普通用户
        User_role user_role = new User_role(2);
        //默认白银用户
        User_level user_level = new User_level(1);

        User user = new User(user_id, user_name, user_pwd, user_mail, register_date, user_role, user_level);
        int count = userLoginAndRegisterDao.insertOneUser(user);
        if(count > 0){
            returnSty.setRetCode(ConstantUtil.REGISTER_SUCCESS);
            returnSty.setRetMessage("注册成功！");
            return returnSty;
        }else {
            returnSty.setRetCode(ConstantUtil.REGISTER_FAIL);
            returnSty.setRetMessage("注册失败！");
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
    public ReturnSty isExistUser(HashMap<String, Object> map) {
        ReturnSty returnSty = new ReturnSty();
        return returnSty;
    }
}
