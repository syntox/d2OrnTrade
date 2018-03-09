package top.seacolo.dao;

import top.seacolo.entity.Hero;

public interface HeroMaintenanceDao {
    /**
     * 添加一个英雄
     * @param hero
     * @return
     */
    int insertOneHero(Hero hero);
}
