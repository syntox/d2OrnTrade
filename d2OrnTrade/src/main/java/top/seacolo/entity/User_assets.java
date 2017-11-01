package top.seacolo.entity;

/**
 * 用户资产类
 */
public class User_assets {
    private String assets_id;           //资产编号
    private double available_assets;    //可用资产
    private double unavailable_assets;  //冻结资产
    private double all_assets;          //总资产
    private User user;                  //用户 FK

    public String getAssets_id() {
        return assets_id;
    }

    public void setAssets_id(String assets_id) {
        this.assets_id = assets_id;
    }

    public double getAvailable_assets() {
        return available_assets;
    }

    public void setAvailable_assets(double available_assets) {
        this.available_assets = available_assets;
    }

    public double getUnavailable_assets() {
        return unavailable_assets;
    }

    public void setUnavailable_assets(double unavailable_assets) {
        this.unavailable_assets = unavailable_assets;
    }

    public double getAll_assets() {
        return all_assets;
    }

    public void setAll_assets(double all_assets) {
        this.all_assets = all_assets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
