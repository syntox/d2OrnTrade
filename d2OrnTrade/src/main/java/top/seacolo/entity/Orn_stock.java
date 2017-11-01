package top.seacolo.entity;

/**
 * 饰品库存类
 */
public class Orn_stock {
    private String stock_id;                    //库存编号
    private int stock_remain_num;               //库存剩余件数（当前商城正在出售件数）
    private int stock_sold_num;                 //已交易件数
    private Orn_information orn_information;    //饰品信息 FK

    public String getStock_id() {
        return stock_id;
    }

    public void setStock_id(String stock_id) {
        this.stock_id = stock_id;
    }

    public int getStock_remain_num() {
        return stock_remain_num;
    }

    public void setStock_remain_num(int stock_remain_num) {
        this.stock_remain_num = stock_remain_num;
    }

    public int getStock_sold_num() {
        return stock_sold_num;
    }

    public void setStock_sold_num(int stock_sold_num) {
        this.stock_sold_num = stock_sold_num;
    }

    public Orn_information getOrn_information() {
        return orn_information;
    }

    public void setOrn_information(Orn_information orn_information) {
        this.orn_information = orn_information;
    }
}
