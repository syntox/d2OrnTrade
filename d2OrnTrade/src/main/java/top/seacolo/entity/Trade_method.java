package top.seacolo.entity;

/**
 * 交易方式类
 */
public class Trade_method {
    private int trade_method_id;        //交易方式编号
    private String trade_method_name;   //交易方式名称
    private String trade_method_desc;   //交易方式描述

    public int getTrade_method_id() {
        return trade_method_id;
    }

    public void setTrade_method_id(int trade_method_id) {
        this.trade_method_id = trade_method_id;
    }

    public String getTrade_method_name() {
        return trade_method_name;
    }

    public void setTrade_method_name(String trade_method_name) {
        this.trade_method_name = trade_method_name;
    }

    public String getTrade_method_desc() {
        return trade_method_desc;
    }

    public void setTrade_method_desc(String trade_method_desc) {
        this.trade_method_desc = trade_method_desc;
    }
}
