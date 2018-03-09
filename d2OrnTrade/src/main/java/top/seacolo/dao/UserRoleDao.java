package top.seacolo.dao;

import top.seacolo.entity.User_role;

import java.util.List;

public interface UserRoleDao {
    /**
     * 查找所有的角色
     */
    List<User_role> SelectAllUserRole();
}
