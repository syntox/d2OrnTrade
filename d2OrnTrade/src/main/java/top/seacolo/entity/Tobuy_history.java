package top.seacolo.entity;

/**
 * 求购饰品和交易历史对应类
 */
public class Tobuy_history {
    private String tobuy_history_id;        //求购交易历史编号
    private Tobuy_orn tobuy_orn;            //求购饰品 FK
    private Trade_history trade_history;    //交易历史 FK

    public String getTobuy_history_id() {
        return tobuy_history_id;
    }

    public void setTobuy_history_id(String tobuy_history_id) {
        this.tobuy_history_id = tobuy_history_id;
    }

    public Tobuy_orn getTobuy_orn() {
        return tobuy_orn;
    }

    public void setTobuy_orn(Tobuy_orn tobuy_orn) {
        this.tobuy_orn = tobuy_orn;
    }

    public Trade_history getTrade_history() {
        return trade_history;
    }

    public void setTrade_history(Trade_history trade_history) {
        this.trade_history = trade_history;
    }

    public Tobuy_history() {
    }
}
