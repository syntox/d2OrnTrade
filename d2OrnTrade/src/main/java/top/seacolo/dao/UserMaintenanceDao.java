package top.seacolo.dao;

import org.apache.ibatis.annotations.Param;
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

    /**
     * 添加一条用户
     * @param user
     * @return
     */
    int insertOneUser(@Param("user") User user);

    /**
     * 查找某个用户
     *      user_id:*
     *      user_name: *
     *      user_mail: *
     *      user_phonenumber: *
     * @param map
     * @return
     */
    User SelectUniqueUser(HashMap<String,Object> map);

    /**
     * 管理员修改某个用户
     * @param user
     * @return
     */
    int modifyOneUser(@Param("user")User user);
}
