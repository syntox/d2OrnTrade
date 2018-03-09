package top.seacolo.service;


import top.seacolo.entity.Hero;
import top.seacolo.util.ReturnSty;

public interface HeroMaintenanceService {
    /**
     * 添加一个英雄
     * @param hero
     * @return
     */
    ReturnSty insertOneHero(Hero hero);
}
