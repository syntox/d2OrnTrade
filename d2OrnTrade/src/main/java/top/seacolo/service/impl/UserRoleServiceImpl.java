package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserRoleDao;
import top.seacolo.entity.User_role;
import top.seacolo.service.UserRoleService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.ReturnSty;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired(required = false)
    UserRoleDao userRoleDao;

    /**
     * 查找所有角色信息
     *
     * @return
     */
    public ReturnSty<List<User_role>> SelectAllUserRole() {
        ReturnSty<List<User_role>> returnSty = new ReturnSty<List<User_role>>();
        List<User_role> user_roles = userRoleDao.SelectAllUserRole();
        if(user_roles != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(user_roles);
            returnSty.setRetMessage("查找所有角色信息成功");
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTALLUSERROLEFAIL);
            returnSty.setRetMessage("查找所有角色信息失败");
        }
        return returnSty;
    }
}
