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

@Controller
@RequestMapping("/hero")
public class HeroMaintenanceController {
    @Autowired(required = false)
    HeroMaintenanceServiceImpl heroMaintenanceService;

    @RequestMapping(value = "/insertOneHero",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty insertOneHero(@RequestParam(value = "hero_add_img", required = true) MultipartFile imgFile,
                                   String hero_name,
                                   String attr_name){
        String hero_pic = UploadUtil.heroImgFileUpload(imgFile);    //图片上传
        Hero_attribute hero_attribute = new Hero_attribute(Integer.parseInt(ClassifyUtil.classifyHeroAttr(attr_name)));

        Hero hero = new Hero(hero_name,hero_pic,hero_attribute);
        ReturnSty returnSty = heroMaintenanceService.insertOneHero(hero);
        return returnSty;
    }
}
