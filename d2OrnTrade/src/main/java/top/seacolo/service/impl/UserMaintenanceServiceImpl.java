package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserMaintenanceDao;
import top.seacolo.entity.User;
import top.seacolo.service.UserMaintenanceService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.ReturnSty;

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
}
