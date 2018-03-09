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

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    ReturnSty UMS_addUser(User user);

    /**
     * 查找某个用户信息
     * @param map
     * @return
     */
    ReturnSty SelectUniqueUser(HashMap<String,Object> map);

    /**
     * 管理员修改某个用户
     * @param user
     * @return
     */
    ReturnSty modifyOneUser(User user);
}
