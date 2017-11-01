package top.seacolo.entity;

/**
 * 英雄部位对应类
 */
public class Hero_and_part {
    private int hero_and_part_id;           //对应编号
    private Hero hero;                      //英雄 FK
    private Hero_part hero_part;            //部位 FK
    private String hero_and_part_desc;      //英雄部位对应描述

    public int getHero_and_part_id() {
        return hero_and_part_id;
    }

    public void setHero_and_part_id(int hero_and_part_id) {
        this.hero_and_part_id = hero_and_part_id;
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

    public String getHero_and_part_desc() {
        return hero_and_part_desc;
    }

    public void setHero_and_part_desc(String hero_and_part_desc) {
        this.hero_and_part_desc = hero_and_part_desc;
    }
}
