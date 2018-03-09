package top.seacolo.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 用户足迹类
 */
public class User_footprint {
    private String footprint_id;            //足迹编号
    private Timestamp footprint_date;            //足迹添加日期
    private Currency_orn currency_orn;      //流通饰品 FK
    private User user;                      //用户 FK

    public String getFootprint_id() {
        return footprint_id;
    }

    public void setFootprint_id(String footprint_id) {
        this.footprint_id = footprint_id;
    }

    public Timestamp getFootprint_date() {
        return footprint_date;
    }

    public void setFootprint_date(Timestamp footprint_date) {
        this.footprint_date = footprint_date;
    }

    public Currency_orn getCurrency_orn() {
        return currency_orn;
    }

    public void setCurrency_orn(Currency_orn currency_orn) {
        this.currency_orn = currency_orn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User_footprint() {
    }
}
