package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserMaintenanceDao;
import top.seacolo.entity.User;
import top.seacolo.service.UserMaintenanceService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.PageUtil;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;
import java.util.List;

@Service
public class UserMaintenanceServiceImpl implements UserMaintenanceService{
    @Autowired(required = false)
    UserMaintenanceDao userMaintenanceDao;

    /**
     * 查找所有用户
     */
    public ReturnSty SelectAllUsers() {
        ReturnSty returnSty = new ReturnSty();
        List<User> users = userMaintenanceDao.SelectAllUsers();
        if(users != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(users);
            returnSty.setRetMessage("查找用户成功");
        }else{
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
        HashMap<String ,Object> pageMap = new HashMap<String, Object>();

        int usersCount = userMaintenanceDao.SelectCountAllUsers();          //查询用户总数
        pageInfo.pageInfoSet((Integer) map.get("pageNow"), (Integer) map.get("pageSize"), usersCount); //获取分页信息
        pageMap.put("startPos",pageInfo.getStartPos());                         //查询偏移位置
        pageMap.put("pageSize",pageInfo.getPageSize());                     //查询大小
        List<User> users = userMaintenanceDao.SelectUserWithPage(pageMap);        //分页查询用户

        if(users != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
            stringObjectHashMap.put("users",users);
            stringObjectHashMap.put("pageInfo",pageInfo);
            returnSty.setRetValue(stringObjectHashMap);
            returnSty.setRetMessage("查找用户成功");
        }else{
            returnSty.setRetCode(ConstantUtil.UNIQUEERROR);
            returnSty.setRetMessage("查找用户失败");
        }
        return returnSty;
    }
}
