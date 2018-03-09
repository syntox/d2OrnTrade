package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.entity.User_level;
import top.seacolo.service.impl.UserLvServiceImpl;
import top.seacolo.util.ReturnSty;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserLvController {
    @Autowired(required = false)
    UserLvServiceImpl userLvService;

    /**
     * 查找所有等级信息
     * @return
     */
    @RequestMapping(value = "/selectAllUserLv",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty selectAllUserLv(){
        ReturnSty returnSty = userLvService.SelectAllUserLv();
        return returnSty;
    }
}
