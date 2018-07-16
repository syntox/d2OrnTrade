package top.seacolo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.seacolo.entity.User;
import top.seacolo.entity.User_assets;
import top.seacolo.service.UserAssetsService;
import top.seacolo.service.impl.UserAssetsServiceImpl;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;

@Controller
@RequestMapping("/UserAssets")
public class UserAssetsController {
    @Autowired(required = false)
    UserAssetsServiceImpl userAssetsService;

    /**
     * 添加默认的用户资产
     */
    @RequestMapping(value = "/addUserAssetsInfo",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty addUserAssetsInfo(String user_id){
        User user = new User(user_id);     //获取需要添加资产的用户id
        User_assets user_assets = new User_assets();
        user_assets.setUser(user);     //此处对象只需要传用户id即可

        ReturnSty returnSty = userAssetsService.addUserAssets(user_assets);
        return returnSty;
    }


    /**
     * 查找用户资产
     */
    @RequestMapping(value = "/selectUserAssetsInfo",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty selectUserAssetsInfo(String user_id){
        HashMap map = new HashMap();
        map.put("user_id",user_id);
        ReturnSty returnSty = userAssetsService.selectUserAssets(map);
        return returnSty;
    }

}
