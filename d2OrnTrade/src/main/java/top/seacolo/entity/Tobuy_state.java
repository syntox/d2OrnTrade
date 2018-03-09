package top.seacolo.entity;

/**
 * 求购饰品状态类
 */
public class Tobuy_state {
    private int tobuy_state_id;         //求购饰品状态编号
    private String tobuy_state_name;    //求购饰品状态名称
    private String tobuy_state_desc;    //求购饰品状态描述

    public int getTobuy_state_id() {
        return tobuy_state_id;
    }

    public void setTobuy_state_id(int tobuy_state_id) {
        this.tobuy_state_id = tobuy_state_id;
    }

    public String getTobuy_state_name() {
        return tobuy_state_name;
    }

    public void setTobuy_state_name(String tobuy_state_name) {
        this.tobuy_state_name = tobuy_state_name;
    }

    public String getTobuy_state_desc() {
        return tobuy_state_desc;
    }

    public void setTobuy_state_desc(String tobuy_state_desc) {
        this.tobuy_state_desc = tobuy_state_desc;
    }

    public Tobuy_state() {
    }
}
