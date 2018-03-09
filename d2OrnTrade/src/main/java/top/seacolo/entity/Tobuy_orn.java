package top.seacolo.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 求购饰品类
 */
public class Tobuy_orn {
    private String tobuy_orn_id;                //求购饰品编号
    private double tobuy_orn_price;             //求购价格
    private Timestamp tobuy_orn_date;                //求购发布日期
    private User user;                          //求购用户 FK
    private Orn_information orn_information;    //饰品信息 FK
    private Tobuy_state tobuy_state;            //求购状态 FK

    public String getTobuy_orn_id() {
        return tobuy_orn_id;
    }

    public void setTobuy_orn_id(String tobuy_orn_id) {
        this.tobuy_orn_id = tobuy_orn_id;
    }

    public double getTobuy_orn_price() {
        return tobuy_orn_price;
    }

    public void setTobuy_orn_price(double tobuy_orn_price) {
        this.tobuy_orn_price = tobuy_orn_price;
    }

    public Timestamp getTobuy_orn_date() {
        return tobuy_orn_date;
    }

    public void setTobuy_orn_date(Timestamp tobuy_orn_date) {
        this.tobuy_orn_date = tobuy_orn_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orn_information getOrn_information() {
        return orn_information;
    }

    public void setOrn_information(Orn_information orn_information) {
        this.orn_information = orn_information;
    }

    public Tobuy_state getTobuy_state() {
        return tobuy_state;
    }

    public void setTobuy_state(Tobuy_state tobuy_state) {
        this.tobuy_state = tobuy_state;
    }

    public Tobuy_orn() {
    }
}
