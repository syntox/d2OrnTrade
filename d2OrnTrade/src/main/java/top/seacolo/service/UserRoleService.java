package top.seacolo.service;

import top.seacolo.entity.User_role;
import top.seacolo.util.ReturnSty;

import java.util.List;

public interface UserRoleService {
    /**
     * 查找所有角色信息
     * @return
     */
    ReturnSty<List<User_role>> SelectAllUserRole();
}
