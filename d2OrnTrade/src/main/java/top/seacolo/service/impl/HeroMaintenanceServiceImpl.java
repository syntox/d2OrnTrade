package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.HeroMaintenanceDao;
import top.seacolo.entity.Hero;
import top.seacolo.service.HeroMaintenanceService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.ReturnSty;

@Service
public class HeroMaintenanceServiceImpl implements HeroMaintenanceService {
    @Autowired(required = false)
    HeroMaintenanceDao heroMaintenanceDao;

    /**
     * 添加一个英雄
     *
     * @param hero
     * @return
     */
    public ReturnSty insertOneHero(Hero hero) {
        ReturnSty returnSty = new ReturnSty();
        System.out.println("111");
        int count = heroMaintenanceDao.insertOneHero(hero);
        System.out.println("222");
        if(count > 0){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("添加英雄成功");
        }else {
            returnSty.setRetCode(ConstantUtil.INSERTONEHEROFAIL);
            returnSty.setRetMessage("添加英雄失败");
        }
        return returnSty;
    }
}
