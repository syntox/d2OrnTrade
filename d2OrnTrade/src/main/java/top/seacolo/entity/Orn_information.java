package top.seacolo.entity;

/**
 * 饰品信息类
 */
public class Orn_information {
    private String info_id;             //饰品信息编号
    private String info_name;           //饰品信息名称
    private String info_pic;            //饰品信息图片
    private String info_desc;           //饰品信息描述
    private Orn_quality orn_quality;    //品质 FK
    private Hero hero;                  //英雄 FK
    private Hero_part hero_part;        //部位 FK

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public String getInfo_name() {
        return info_name;
    }

    public void setInfo_name(String info_name) {
        this.info_name = info_name;
    }

    public String getInfo_pic() {
        return info_pic;
    }

    public void setInfo_pic(String info_pic) {
        this.info_pic = info_pic;
    }

    public String getInfo_desc() {
        return info_desc;
    }

    public void setInfo_desc(String info_desc) {
        this.info_desc = info_desc;
    }

    public Orn_quality getOrn_quality() {
        return orn_quality;
    }

    public void setOrn_quality(Orn_quality orn_quality) {
        this.orn_quality = orn_quality;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero_part getHero_part() {
        return hero_part;
    }

    public void setHero_part(Hero_part hero_part) {
        this.hero_part = hero_part;
    }

    public Orn_information() {
    }
}
