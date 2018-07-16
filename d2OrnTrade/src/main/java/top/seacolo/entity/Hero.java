package top.seacolo.entity;

/**
 * 英雄信息类
 */
public class Hero {
    private int hero_id;                        //英雄编号
    private String hero_name;                   //英雄名称
    private String hero_pic;                    //英雄图片路径
    private Hero_attribute hero_attribute;      //英雄属性 FK

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public String getHero_name() {
        return hero_name;
    }

    public void setHero_name(String hero_name) {
        this.hero_name = hero_name;
    }

    public String getHero_pic() {
        return hero_pic;
    }

    public void setHero_pic(String hero_pic) {
        this.hero_pic = hero_pic;
    }

    public Hero_attribute getHero_attribute() {
        return hero_attribute;
    }

    public void setHero_attribute(Hero_attribute hero_attribute) {
        this.hero_attribute = hero_attribute;
    }



    public Hero(String hero_name, String hero_pic, Hero_attribute hero_attribute) {
        this.hero_name = hero_name;
        this.hero_pic = hero_pic;
        this.hero_attribute = hero_attribute;
    }

    public Hero(int hero_id, String hero_name, String hero_pic, Hero_attribute hero_attribute) {
        this.hero_id = hero_id;
        this.hero_name = hero_name;
        this.hero_pic = hero_pic;
        this.hero_attribute = hero_attribute;
    }

    public Hero() {
    }
}
