package top.seacolo.entity;

import java.util.Date;

/**
 * 流通饰品类
 */
public class Currency_orn {
    private String currency_orn_id;             //流通饰品编号
    private double currency_orn_price;          //流通饰品价格
    private Date currency_orn_date;             //流通饰品最近操作日期（取出取回上下架）
    private Currency_state currency_state;      //流通饰品状态 FK
    private User user;                          //用户 FK
    private Orn_information orn_information;    //饰品信息 FK

    public String getCurrency_orn_id() {
        return currency_orn_id;
    }

    public void setCurrency_orn_id(String currency_orn_id) {
        this.currency_orn_id = currency_orn_id;
    }

    public double getCurrency_orn_price() {
        return currency_orn_price;
    }

    public void setCurrency_orn_price(double currency_orn_price) {
        this.currency_orn_price = currency_orn_price;
    }

    public Date getCurrency_orn_date() {
        return currency_orn_date;
    }

    public void setCurrency_orn_date(Date currency_orn_date) {
        this.currency_orn_date = currency_orn_date;
    }

    public Currency_state getCurrency_state() {
        return currency_state;
    }

    public void setCurrency_state(Currency_state currency_state) {
        this.currency_state = currency_state;
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
}
