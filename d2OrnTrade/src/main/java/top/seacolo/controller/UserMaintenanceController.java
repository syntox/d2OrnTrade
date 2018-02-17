package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.entity.User;
import top.seacolo.service.impl.UserMaintenanceServiceImpl;
import top.seacolo.util.ReturnSty;

/**
 *   1. 用户信息查询
 *   2. 用户信息维护：增删改
 */
@Controller
@RequestMapping("/User")
public class UserMaintenanceController {
    @Autowired(required = false)
    UserMaintenanceServiceImpl userMaintenanceService;

    @RequestMapping(value = "/selectAllUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty SelectAllUser(){
        ReturnSty returnSty = userMaintenanceService.SelectAllUsers();
        return returnSty;
    }

}
