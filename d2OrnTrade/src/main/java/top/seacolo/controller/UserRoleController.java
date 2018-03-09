package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.service.impl.UserRoleServiceImpl;
import top.seacolo.util.ReturnSty;

@Controller
@RequestMapping("/")
public class UserRoleController {
    @Autowired(required = false)
    UserRoleServiceImpl userRoleService;

    /**
     * 查找所有角色信息
     * @return
     */
    @RequestMapping(value = "/SelectAllUserRole",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty SelectAllUserRole(){
        ReturnSty returnSty = userRoleService.SelectAllUserRole();
        return  returnSty;
    }

}
