package top.seacolo.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 充值记录类
 */
public class Recharge_record {
    private String recharge_record_id;      //充值记录编号
    private double recharge_money;          //充值金额
    private double before_recharge_money;   //充值前金额
    private Timestamp recharge_date;             //充值日期
    private User user;                      //用户 FK

    public String getRecharge_record_id() {
        return recharge_record_id;
    }

    public void setRecharge_record_id(String recharge_record_id) {
        this.recharge_record_id = recharge_record_id;
    }

    public double getRecharge_money() {
        return recharge_money;
    }

    public void setRecharge_money(double recharge_money) {
        this.recharge_money = recharge_money;
    }

    public double getBefore_recharge_money() {
        return before_recharge_money;
    }

    public void setBefore_recharge_money(double before_recharge_money) {
        this.before_recharge_money = before_recharge_money;
    }

    public Timestamp getRecharge_date() {
        return recharge_date;
    }

    public void setRecharge_date(Timestamp recharge_date) {
        this.recharge_date = recharge_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
