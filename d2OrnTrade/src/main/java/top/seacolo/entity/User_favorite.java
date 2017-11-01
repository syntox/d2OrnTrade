package top.seacolo.entity;

import java.util.Date;

/**
 * 用户收藏类
 */
public class User_favorite {
    private String favorite_id;             //收藏编号
    private Date favorite_date;             //收藏日期
    private User user;                      //用户 FK
    private Currency_orn currency_orn;      //流通饰品 FK

    public String getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(String favorite_id) {
        this.favorite_id = favorite_id;
    }

    public Date getFavorite_date() {
        return favorite_date;
    }

    public void setFavorite_date(Date favorite_date) {
        this.favorite_date = favorite_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Currency_orn getCurrency_orn() {
        return currency_orn;
    }

    public void setCurrency_orn(Currency_orn currency_orn) {
        this.currency_orn = currency_orn;
    }
}
