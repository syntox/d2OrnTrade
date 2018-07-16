package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.seacolo.entity.Hero;
import top.seacolo.entity.Hero_attribute;
import top.seacolo.service.HeroMaintenanceService;
import top.seacolo.service.impl.HeroMaintenanceServiceImpl;
import top.seacolo.util.ClassifyUtil;
import top.seacolo.util.RandomIdUtil;
import top.seacolo.util.ReturnSty;
import top.seacolo.util.UploadUtil;

import java.util.HashMap;

@Controller
@RequestMapping("/hero")
public class HeroMaintenanceController {
    @Autowired(required = false)
    HeroMaintenanceServiceImpl heroMaintenanceService;

    /**
     * 插入一个英雄
     * @param imgFile
     * @param hero_name
     * @param attr_name
     * @return
     */
    @RequestMapping(value = "/insertOneHero", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty insertOneHero(@RequestParam(value = "hero_add_img", required = true) MultipartFile imgFile,
                                   String hero_name,
                                   String attr_name) {
        String hero_pic = UploadUtil.heroImgFileUpload(imgFile);    //图片上传
        Hero_attribute hero_attribute = new Hero_attribute(Integer.parseInt(ClassifyUtil.classifyHeroAttr(attr_name)));

        Hero hero = new Hero(hero_name, hero_pic, hero_attribute);
        ReturnSty returnSty = heroMaintenanceService.insertOneHero(hero);
        return returnSty;
    }

    /**
     * 分页查询英雄
     * @param pageNow
     * @param pageSize
     * @param heroAttr
     * @return
     */
    @RequestMapping(value = "/SelectHeroWithPage", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty SelectHeroWithPage(int pageNow,
                                        int pageSize,
                                        String heroAttr) {
        ReturnSty returnSty;

        if (heroAttr.equals("不限")) {
            HashMap<String, Object> pageMap = new HashMap<String, Object>();
            pageMap.put("pageNow", pageNow);
            pageMap.put("pageSize", pageSize);
            returnSty = heroMaintenanceService.SelectHeroWithPage(pageMap);
        } else if (heroAttr.equals("力量")
                || heroAttr.equals("敏捷")
                || heroAttr.equals("智力")) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("pageNow", pageNow);
            map.put("pageSize", pageSize);
            map.put("attr_name", heroAttr);
            returnSty = heroMaintenanceService.SelectHeroWithPageAndAttr(map);
        } else {
            //do nothing
            returnSty = null;
        }
        System.out.println(returnSty.getRetValue());
        return returnSty;
    }
}
