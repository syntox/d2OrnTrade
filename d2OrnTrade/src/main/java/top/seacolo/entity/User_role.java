package top.seacolo.entity;

/**
 * 用户角色类
 *
 * ('1', '管理员', '');
 * ('2', '普通用户', '');
 * ('3', '会员用户', '');
 * ('4', '超级管理员', '');
 */
public class User_role {
    private int role_id;        //角色编号
    private String role_name;   //角色名称
    private String role_desc;   //角色描述

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public User_role() {
    }

    public User_role(int role_id) {
        this.role_id = role_id;
    }

    public User_role(String role_name) {
        this.role_name = role_name;
    }
}
