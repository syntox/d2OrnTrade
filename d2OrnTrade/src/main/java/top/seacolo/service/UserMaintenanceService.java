package top.seacolo.service;

import top.seacolo.entity.User;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;
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

    /**
     * 分页查询部分用户数据
     * @param map
     * @return
     */
    ReturnSty<User> SelectUserWithPage(HashMap<String,Object> map);
}
