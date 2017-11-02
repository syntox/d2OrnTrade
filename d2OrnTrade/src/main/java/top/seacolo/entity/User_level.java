package top.seacolo.entity;

/**
 * 用户等级类
 *
 * ('1', '白银用户', '');
 * ('2', '黄金用户', '');
 * ('3', '白金用户', '');
 * ('4', '钻石用户', '');
 */
public class User_level {
    private int lv_id;        //等级编号
    private String lv_name;   //等级名称
    private String lv_desc;   //等级描述

    public int getLv_id() {
        return lv_id;
    }

    public void setLv_id(int lv_id) {
        this.lv_id = lv_id;
    }

    public String getLv_name() {
        return lv_name;
    }

    public void setLv_name(String lv_name) {
        this.lv_name = lv_name;
    }

    public String getLv_desc() {
        return lv_desc;
    }

    public void setLv_desc(String lv_desc) {
        this.lv_desc = lv_desc;
    }

    public User_level() {
    }

    public User_level(int lv_id) {
        this.lv_id = lv_id;
    }
}
