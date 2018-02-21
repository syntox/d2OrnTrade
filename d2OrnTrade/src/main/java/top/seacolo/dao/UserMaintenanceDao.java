package top.seacolo.dao;

import top.seacolo.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMaintenanceDao {

    /**
     * 查询用户总数
     * @return   用户个数
     */
    int SelectCountAllUsers();

    /**
     * 查找所有用户
     * @return
     */
    List<User> SelectAllUsers();

    /**
     *  Map: {
     *              pageNow: ***,     当前页
     *              pageSize: ***        查询个数
     *           }
     * @param map
     * @return
     */
    List<User> SelectUserWithPage(HashMap<String,Object>  map);
}
