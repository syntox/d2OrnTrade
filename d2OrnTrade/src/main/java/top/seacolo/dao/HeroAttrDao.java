package top.seacolo.dao;

import top.seacolo.entity.Hero_attribute;

import java.util.List;

public interface HeroAttrDao {
    /**
     * 查询所有英雄的属性信息
     */
    List<Hero_attribute> SelectAllHeroAttr();
}
