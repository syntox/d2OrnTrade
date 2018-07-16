package top.seacolo.dao;


import org.apache.ibatis.annotations.Param;
import top.seacolo.entity.User_assets;

import java.util.HashMap;

public interface UserAssetsDao {
    /**
     * 添加用户资产
     * @param user_assets
     * @return
     */
    int addUserAssets(@Param("user_assets") User_assets user_assets);

    /**
     * 查找某个用户的资产
     * @param map
     * @return
     */
    User_assets selectUserAssets(HashMap<String, Object> map);
}
