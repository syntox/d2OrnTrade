package top.seacolo.entity;

/**
 * 流通饰品状态类
 */
public class Currency_state {
    private int currency_state_id;          //流通饰品状态编号
    private String currency_state_name;     //流通饰品状态名称
    private String currency_state_desc;     //流通饰品状态描述

    public int getCurrency_state_id() {
        return currency_state_id;
    }

    public void setCurrency_state_id(int currency_state_id) {
        this.currency_state_id = currency_state_id;
    }

    public String getCurrency_state_name() {
        return currency_state_name;
    }

    public void setCurrency_state_name(String currency_state_name) {
        this.currency_state_name = currency_state_name;
    }

    public String getCurrency_state_desc() {
        return currency_state_desc;
    }

    public void setCurrency_state_desc(String currency_state_desc) {
        this.currency_state_desc = currency_state_desc;
    }

    public Currency_state() {
    }
}
