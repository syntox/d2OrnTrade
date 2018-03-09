package top.seacolo.entity;

/**
 * 英雄属性类
 */
public class Hero_attribute {
    private int attr_id;        //属性编号
    private String attr_name;   //属性名称
    private String attr_desc;   //属性描述

    public int getAttr_id() {
        return attr_id;
    }

    public void setAttr_id(int attr_id) {
        this.attr_id = attr_id;
    }

    public String getAttr_name() {
        return attr_name;
    }

    public void setAttr_name(String attr_name) {
        this.attr_name = attr_name;
    }

    public String getAttr_desc() {
        return attr_desc;
    }

    public void setAttr_desc(String attr_desc) {
        this.attr_desc = attr_desc;
    }

    public Hero_attribute(int attr_id) {
        this.attr_id = attr_id;
    }

    public Hero_attribute() {
    }
}
