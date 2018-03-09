package top.seacolo.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.seacolo.entity.User;
import top.seacolo.entity.User_level;
import top.seacolo.entity.User_role;
import top.seacolo.service.impl.UserMaintenanceServiceImpl;
import top.seacolo.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
     *  分页查找所有用户
     * @param pageNow    当前页
     * @param pageSize     每页数据量
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

    /**
     * 管理员添加用户信息
     * @param request
     * @param response
     * @param imgFile
     * @param user_name
     * @param user_pwd
     * @param user_mail
     * @param user_phonenumber
     * @return
     */
    @RequestMapping(value = "/AddUserInfo",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty AddUserInfo(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam(value = "user_img", required = true) MultipartFile imgFile,
                                 String user_name,
                                 String user_pwd,
                                 String user_mail,
                                 String user_phonenumber
                                 ){
        String user_pic = UploadUtil.imgFileUpload(imgFile);    //图片上传
        User user = new User(user_name,user_pwd,user_mail,user_phonenumber,user_pic);
        ReturnSty returnSty_temp = userMaintenanceService.UMS_addUser(user);

        return returnSty_temp;
    }

    /**
     * 查找某个用户信息
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/selectUniqueUser",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty selectUniqueUser(String userInfo){
        ReturnSty returnSty = new ReturnSty();
        HashMap<String,Object> map = new HashMap<String, Object>();
        if(userInfo.length() >= 20){    //检测是否是编号
            map.put("user_id",userInfo);
        }else if(RegCheckUtil.isEmail(userInfo)){    //检测是否是邮箱
            map.put("user_mail",userInfo);
        }else if(RegCheckUtil.isPhoneNum(userInfo)){    //检测是否是手机号码
            map.put("user_phonenumber",userInfo);
        }else {    //归类为用户名查找
            map.put("user_name",userInfo);
        }
        returnSty = userMaintenanceService.SelectUniqueUser(map);
        return  returnSty;
    }

    /**
     * 管理员修改用户信息
     * @param imgFile
     * @param user_id
     * @param user_name
     * @param user_pwd
     * @param user_mail
     * @param user_phonenumber
     * @param role_name
     * @param level_name
     * @return
     */
    @RequestMapping(value = "/ModifyUserInfo", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public ReturnSty ModifyUserInfo(@RequestParam(value = "user_modify_img", required = true) MultipartFile imgFile,
                                    String user_id,
                                    String user_name,
                                    String user_pwd,
                                    String user_mail,
                                    String user_phonenumber,
                                    String role_name,
                                    String level_name) {
        // 组装对象
        User_level user_level = new User_level(Integer.parseInt(ClassifyUtil.classifyUserLv(level_name)));
        User_role user_role = new User_role(Integer.parseInt(ClassifyUtil.classifyUserRole(role_name)));

        String user_pic = UploadUtil.imgFileUpload(imgFile);    //图片上传
        User user = new User(user_id,user_name,user_pwd,user_mail,user_phonenumber,user_role,user_level,user_pic);

        ReturnSty returnSty = userMaintenanceService.modifyOneUser(user);


        return returnSty;
    }
}
