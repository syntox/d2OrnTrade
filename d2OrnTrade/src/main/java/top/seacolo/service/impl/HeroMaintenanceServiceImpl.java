package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.HeroMaintenanceDao;
import top.seacolo.entity.Hero;
import top.seacolo.service.HeroMaintenanceService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.PageUtil;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;
import java.util.List;

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
        int count = heroMaintenanceDao.insertOneHero(hero);
        if(count > 0){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("添加英雄成功");
        }else {
            returnSty.setRetCode(ConstantUtil.INSERTONEHEROFAIL);
            returnSty.setRetMessage("添加英雄失败");
        }
        return returnSty;
    }

    /**
     * 分页查找所有英雄（不限属性）
     *
     * @param pageMap
     * @return
     */
    public ReturnSty<Hero> SelectHeroWithPage(HashMap<String, Object> pageMap) {
        ReturnSty returnSty = new ReturnSty();
        PageUtil pageInfo = new PageUtil();
        HashMap<String, Object> pageMap_temp = new HashMap<String, Object>();

        int heroesCount = heroMaintenanceDao.SelectCountAllHeros();    //查询英雄总数
        pageInfo.pageInfoSet((Integer) pageMap.get("pageNow"),(Integer) pageMap.get("pageSize"), heroesCount);    //分页信息设置
        pageMap_temp.put("startPos", pageInfo.getStartPos());    //查询起始位置
        pageMap_temp.put("pageSize", pageInfo.getPageSize());    //查询页面大小
        List<Hero> heroes = heroMaintenanceDao.SelectHeroWithPage(pageMap_temp);

        if(heroes != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
            stringObjectHashMap.put("heroes", heroes);
            stringObjectHashMap.put("pageInfo", pageInfo);
            returnSty.setRetValue(stringObjectHashMap);
            returnSty.setRetMessage("查找所有英雄成功");
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTHEROWITHPAGEFAIL);
            returnSty.setRetMessage("查找所有英雄失败");
        }
        return returnSty;

    }

    /**
     * 分页查找所有英雄（限属性）
     *
     * @param map
     * @return
     */
    public ReturnSty<Hero> SelectHeroWithPageAndAttr(HashMap<String, Object> map) {
        ReturnSty returnSty = new ReturnSty();
        PageUtil pageInfo = new PageUtil();
        HashMap<String, Object> pageMap_temp = new HashMap<String, Object>();

        int heroesCount = heroMaintenanceDao.SelectCountAllHerosWithAttr(map);    //查询英雄总数
        pageInfo.pageInfoSet((Integer) map.get("pageNow"),(Integer) map.get("pageSize"), heroesCount);    //分页信息设置
        pageMap_temp.put("startPos", pageInfo.getStartPos());    //查询起始位置
        pageMap_temp.put("pageSize", pageInfo.getPageSize());    //查询页面大小
        pageMap_temp.put("attr_name",map.get("attr_name"));    //属性名称
        List<Hero> heroes = heroMaintenanceDao.SelectHeroWithPageAndAttr(pageMap_temp);

        if(heroes != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
            stringObjectHashMap.put("heroes", heroes);
            stringObjectHashMap.put("pageInfo", pageInfo);
            returnSty.setRetValue(stringObjectHashMap);
            returnSty.setRetMessage("查找该属性英雄成功");
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTHEROWITHPAGEANDATTRFAIL);
            returnSty.setRetMessage("查找该属性英雄失败");
        }
        return returnSty;
    }
}
