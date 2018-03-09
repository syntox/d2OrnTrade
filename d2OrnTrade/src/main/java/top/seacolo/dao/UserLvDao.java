package top.seacolo.dao;

import top.seacolo.entity.User_level;

import java.util.List;

public interface UserLvDao {
    /**
     * 查找所有的等级
     */
    List<User_level> SelectAllUserLv();
}
