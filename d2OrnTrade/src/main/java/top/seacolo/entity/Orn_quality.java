package top.seacolo.entity;

/**
 * 饰品品质类
 */
public class Orn_quality {
    private int quality_id;         //品质编号
    private String quality_name;    //品质名称
    private String quality_desc;    //品质描述

    public int getQuality_id() {
        return quality_id;
    }

    public void setQuality_id(int quality_id) {
        this.quality_id = quality_id;
    }

    public String getQuality_name() {
        return quality_name;
    }

    public void setQuality_name(String quality_name) {
        this.quality_name = quality_name;
    }

    public String getQuality_desc() {
        return quality_desc;
    }

    public void setQuality_desc(String quality_desc) {
        this.quality_desc = quality_desc;
    }
}
