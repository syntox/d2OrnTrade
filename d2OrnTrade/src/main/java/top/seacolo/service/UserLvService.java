package top.seacolo.service;

import top.seacolo.entity.User_level;
import top.seacolo.util.ReturnSty;

import java.util.List;

public interface UserLvService {
    /**
     * 查找所有等级信息
     * @return
     */
    ReturnSty<List<User_level>> SelectAllUserLv();
}
