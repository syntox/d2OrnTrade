package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.entity.User;
import top.seacolo.service.impl.UserMaintenanceServiceImpl;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;
import java.util.Map;

/**
 *   1. 用户信息查询
 *   2. 用户信息维护：增删改
 */
@Controller
@RequestMapping("/User")
public class UserMaintenanceController {
    @Autowired(required = false)
    UserMaintenanceServiceImpl userMaintenanceService;

    /**
     * 查找所有用户
     * @return
     */
    @RequestMapping(value = "/selectAllUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty SelectAllUser(){
        ReturnSty returnSty = userMaintenanceService.SelectAllUsers();
        return returnSty;
    }

    /**
     * 分页查找所有用户
     * @param pageNow
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/SelectUserWithPage",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty SelectUserWithPage(int pageNow, int pageSize){
        HashMap<String, Object> pageMap = new HashMap<String, Object>();
        pageMap.put("pageNow",pageNow);
        pageMap.put("pageSize",pageSize);
        ReturnSty returnSty = userMaintenanceService.SelectUserWithPage(pageMap);
        return returnSty;
    }



}
