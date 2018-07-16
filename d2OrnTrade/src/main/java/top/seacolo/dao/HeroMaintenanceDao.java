package top.seacolo.dao;

import org.apache.ibatis.annotations.Param;
import top.seacolo.entity.Hero;

import java.util.HashMap;
import java.util.List;

public interface HeroMaintenanceDao {

    /**
     * 查询所有英雄个数
     */
    int SelectCountAllHeros();

    /**
     * 查询某种属性英雄个数
     */
    int SelectCountAllHerosWithAttr(HashMap<String, Object> map);

    /**
     * 添加一个英雄
     */
    int insertOneHero(@Param("hero")Hero hero);

    /**
     * 分页查找所有英雄(不限属性)
     */
    List<Hero> SelectHeroWithPage(HashMap<String, Object> map);

    /**
     * 分页查找所有英雄(限属性)
     */
    List<Hero> SelectHeroWithPageAndAttr(HashMap<String, Object> map);
}
