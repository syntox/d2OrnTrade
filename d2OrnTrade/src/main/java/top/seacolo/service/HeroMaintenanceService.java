package top.seacolo.service;


import top.seacolo.entity.Hero;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;

public interface HeroMaintenanceService {
    /**
     * 添加一个英雄
     * @param hero
     * @return
     */
    ReturnSty insertOneHero(Hero hero);

    /**
     * 分页查找所有英雄（不限属性）
     * @param pageMap
     * @return
     */
    ReturnSty<Hero> SelectHeroWithPage(HashMap<String, Object> pageMap);

    /**
     * 分页查找所有英雄（限属性）
     * @param map
     * @return
     */
    ReturnSty<Hero> SelectHeroWithPageAndAttr(HashMap<String, Object> map);
}
