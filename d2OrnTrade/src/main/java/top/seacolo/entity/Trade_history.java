package top.seacolo.entity;

import java.util.Date;

/**
 * 交易历史类
 */
public class Trade_history {
    private String trade_history_id;        //交易历史编号
    private double trade_history_price;     //交易金额
    private Date trade_history_date;        //交易日期
    private User buyer;                     //买方    FK
    private User seller;                    //卖方    FK
    private Currency_orn currency_orn;      //流通饰品 FK
    private Trade_method trade_method;      //交易方式 FK

    public String getTrade_history_id() {
        return trade_history_id;
    }

    public void setTrade_history_id(String trade_history_id) {
        this.trade_history_id = trade_history_id;
    }

    public double getTrade_history_price() {
        return trade_history_price;
    }

    public void setTrade_history_price(double trade_history_price) {
        this.trade_history_price = trade_history_price;
    }

    public Date getTrade_history_date() {
        return trade_history_date;
    }

    public void setTrade_history_date(Date trade_history_date) {
        this.trade_history_date = trade_history_date;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Currency_orn getCurrency_orn() {
        return currency_orn;
    }

    public void setCurrency_orn(Currency_orn currency_orn) {
        this.currency_orn = currency_orn;
    }

    public Trade_method getTrade_method() {
        return trade_method;
    }

    public void setTrade_method(Trade_method trade_method) {
        this.trade_method = trade_method;
    }
}
