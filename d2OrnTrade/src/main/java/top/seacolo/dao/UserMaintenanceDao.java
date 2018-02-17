package top.seacolo.dao;

import top.seacolo.entity.User;

import java.util.List;

public interface UserMaintenanceDao {
    /**
     * 查找所有用户
     */
    List<User> SelectAllUsers();
}
