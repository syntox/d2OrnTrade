package top.seacolo.entity;

/**
 * 英雄部位类
 */
public class Hero_part {
    private int part_id;        //部位编号
    private String part_name;   //部位名称
    private String part_desc;   //部位描述

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getPart_desc() {
        return part_desc;
    }

    public void setPart_desc(String part_desc) {
        this.part_desc = part_desc;
    }

    public Hero_part() {
    }
}
