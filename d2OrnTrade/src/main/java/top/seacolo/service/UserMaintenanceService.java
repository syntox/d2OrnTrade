package top.seacolo.service;

import top.seacolo.entity.User;
import top.seacolo.util.ReturnSty;

import java.util.List;

/**
 *  用户信息维护
 */
public interface UserMaintenanceService {
    /**
     *  查询所有用户信息并返回
     * @return
     */
    ReturnSty<User> SelectAllUsers();
}
