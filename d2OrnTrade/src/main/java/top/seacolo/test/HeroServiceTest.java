package top.seacolo.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.seacolo.dao.HeroMaintenanceDao;
import top.seacolo.entity.Hero;
import top.seacolo.entity.Hero_attribute;
import top.seacolo.service.impl.HeroMaintenanceServiceImpl;


public class HeroServiceTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HeroMaintenanceDao heroMaintenanceDao;
    @Autowired
    private HeroMaintenanceServiceImpl heroMaintenanceService;

    @Test
    public void insertUser() {
        Hero_attribute hero_attribute = new Hero_attribute(1);
        Hero hero = new Hero("haha","path",hero_attribute);
        int count = heroMaintenanceDao.insertOneHero(hero);
        if(count > 0){
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
    }
}
