package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserMaintenanceDao;
import top.seacolo.entity.User;
import top.seacolo.entity.User_level;
import top.seacolo.entity.User_role;
import top.seacolo.service.UserMaintenanceService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.PageUtil;
import top.seacolo.util.RandomIdUtil;
import top.seacolo.util.ReturnSty;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserMaintenanceServiceImpl implements UserMaintenanceService {
    @Autowired(required = false)
    UserMaintenanceDao userMaintenanceDao;

    /**
     * 查找所有用户
     */
    public ReturnSty SelectAllUsers() {
        ReturnSty returnSty = new ReturnSty();
        List<User> users = userMaintenanceDao.SelectAllUsers();
        if (users != null) {
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(users);
            returnSty.setRetMessage("查找用户成功");
        } else {
            returnSty.setRetCode(ConstantUtil.UNIQUEERROR);
            returnSty.setRetMessage("查找用户失败");
        }
        return returnSty;
    }

    /**
     * 分页查询部分用户数据
     *
     * @param map
     * @return
     */
    public ReturnSty<User> SelectUserWithPage(HashMap<String, Object> map) {
        ReturnSty returnSty = new ReturnSty();
        PageUtil pageInfo = new PageUtil();
        HashMap<String, Object> pageMap = new HashMap<String, Object>();

        int usersCount = userMaintenanceDao.SelectCountAllUsers();    //查询用户总数
        pageInfo.pageInfoSet((Integer) map.get("pageNow"), (Integer) map.get("pageSize"), usersCount);     //获取分页信息
        pageMap.put("startPos", pageInfo.getStartPos());    //查询偏移位置
        pageMap.put("pageSize", pageInfo.getPageSize());    //查询大小
        List<User> users = userMaintenanceDao.SelectUserWithPage(pageMap);    //分页查询用户

        if (users != null) {
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
            stringObjectHashMap.put("users", users);
            stringObjectHashMap.put("pageInfo", pageInfo);
            returnSty.setRetValue(stringObjectHashMap);
            returnSty.setRetMessage("查找用户成功");
        } else {
            returnSty.setRetCode(ConstantUtil.UNIQUEERROR);
            returnSty.setRetMessage("查找用户失败");
        }
        return returnSty;
    }

    /**
     * 添加用户信息
     *
     * @param user
     */
    public ReturnSty UMS_addUser(User user) {
        ReturnSty returnSty = new ReturnSty();
        //随机id防止重复
        String user_id = RandomIdUtil.getID();
        //获取当前时间作为注册时间
        Timestamp register_date = new Timestamp(new Date().getTime());
        //默认普通用户
        User_role user_role = new User_role(2);
        //默认白银用户
        User_level user_level = new User_level(1);

        User user_temp = new User(user_id,
                user.getUser_name(),
                user.getUser_pwd(),
                user.getUser_mail(),
                user.getUser_phonenumber(),
                user.getUser_pic(),
                register_date,
                user_role,
                user_level);
        int count = userMaintenanceDao.insertOneUser(user_temp);
        if (count > 0) {
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(user_id);
            returnSty.setRetMessage("用户添加成功！");
            return returnSty;
        } else {
            returnSty.setRetCode(ConstantUtil.UMSADDUSERFAIL);
            returnSty.setRetMessage("用户添加失败！");
            return returnSty;
        }
    }

    /**
     * 查找某个用户信息
     *
     * @param map
     * @return
     */
    public ReturnSty SelectUniqueUser(HashMap<String, Object> map) {
        ReturnSty returnSty = new ReturnSty();
        User user = userMaintenanceDao.SelectUniqueUser(map);
        if(user != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(user);
            returnSty.setRetMessage("用户已查找到");
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTUNIQUEUSERFAIL);
            returnSty.setRetMessage("没有查找到某个用户");
        }
        return returnSty;
    }

    /**
     * 管理员修改某个用户
     *
     * @param user
     * @return
     */
    public ReturnSty modifyOneUser(User user) {
        ReturnSty returnSty = new ReturnSty();
        int count = userMaintenanceDao.modifyOneUser(user);
        if(count > 0){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("修改用户信息成功");
        }else {
            returnSty.setRetCode(ConstantUtil.MODIFYONEUSERFAIL);
            returnSty.setRetMessage("修改用户信息失败");
        }
        return returnSty;
    }
}
