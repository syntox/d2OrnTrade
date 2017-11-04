package top.seacolo.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户类
 */
public class User {
    private String user_id;             //用户编号
    private String user_name;           //用户名
    private String user_pwd;            //用户密码
    private String user_mail;           //邮箱
    private String user_phonenumber;    //电话号码
    private String user_pic;            //用户头像
    private Timestamp register_date;         //注册日期
    private User_role user_role;        //角色 FK
    private User_level user_level;      //等级 FK

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getUser_phonenumber() {
        return user_phonenumber;
    }

    public void setUser_phonenumber(String user_phonenumber) {
        this.user_phonenumber = user_phonenumber;
    }

    public String getUser_pic() {
        return user_pic;
    }

    public void setUser_pic(String user_pic) {
        this.user_pic = user_pic;
    }

    public Timestamp getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Timestamp register_date) {
        this.register_date = register_date;
    }

    public User_role getUser_role() {
        return user_role;
    }

    public void setUser_role(User_role user_role) {
        this.user_role = user_role;
    }

    public User_level getUser_level() {
        return user_level;
    }

    public void setUser_level(User_level user_level) {
        this.user_level = user_level;
    }

    public User() {
    }

    public User(String user_id, String user_name, String user_pwd, String user_mail, Timestamp register_date, User_role user_role, User_level user_level) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_mail = user_mail;
        this.register_date = register_date;
        this.user_role = user_role;
        this.user_level = user_level;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", user_phonenumber='" + user_phonenumber + '\'' +
                ", user_pic='" + user_pic + '\'' +
                ", register_date=" + register_date +
                ", user_role=" + user_role +
                ", user_level=" + user_level +
                '}';
    }
}
