package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.service.impl.HeroAttrServiceImpl;
import top.seacolo.util.ReturnSty;

@Controller
@RequestMapping("/")
public class HeroAttrController {
    @Autowired(required = false)
    HeroAttrServiceImpl heroAttrService;

    /**
     * 查找所有英雄属性
     * @return
     */
    @RequestMapping(value = "/selectAllHeroAttr",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty selectAllHeroAttr(){
        ReturnSty returnSty = heroAttrService.SelectAllHeroAttr();
        return returnSty;
    }
}
