package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.HeroAttrDao;
import top.seacolo.entity.Hero_attribute;
import top.seacolo.service.HeroAttrService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.ReturnSty;

import java.util.List;

@Service
public class HeroAttrServiceImpl implements HeroAttrService{
    @Autowired(required = false)
    HeroAttrDao heroAttrDao;

    public ReturnSty<List<Hero_attribute>> SelectAllHeroAttr() {
        ReturnSty<List<Hero_attribute>> returnSty = new ReturnSty<List<Hero_attribute>>();
        List<Hero_attribute> hero_attributes = heroAttrDao.SelectAllHeroAttr();
        if(hero_attributes != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(hero_attributes);
            returnSty.setRetMessage("查找所有英雄属性成功");
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTALLHEROATTRFAIL);
            returnSty.setRetMessage("查找所有英雄属性失败");
        }
        return returnSty;
    }
}
