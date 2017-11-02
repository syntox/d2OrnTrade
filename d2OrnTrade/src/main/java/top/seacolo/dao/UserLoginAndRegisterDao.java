package top.seacolo.dao;

import org.apache.ibatis.annotations.Param;
import top.seacolo.entity.User;

import java.util.HashMap;

public interface UserLoginAndRegisterDao {
    /**
     * 按照用户或邮箱或手机号码查找用户
     *
     * @param map
     *
     * Map: user_name: ***
     *      user_mail: ***@***.***
     *      user_phonenumber: ***********
     */
    User SelectOneUser(HashMap<String,Object> map);
    /**
     * 按照邮箱密码查找用户
     *
     * @param user_mail
     * @param user_pwd
     * @return
     */
    User selectUserByMailAndPwd(@Param("user_mail") String user_mail,@Param("user_pwd") String user_pwd);

    /**
     * 增加一条用户
     *
     * @param user
     * @return
     */
    int insertOneUser(@Param("user") User user);
}
