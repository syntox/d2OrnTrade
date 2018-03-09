package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserLvDao;
import top.seacolo.entity.User_level;
import top.seacolo.service.UserLvService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.ReturnSty;

import java.util.List;

@Service
public class UserLvServiceImpl implements UserLvService{
    @Autowired(required = false)
    UserLvDao userLvDao;
    /**
     * 查找所有等级信息
     *
     * @return
     */
    public ReturnSty<List<User_level>> SelectAllUserLv() {
        ReturnSty<List<User_level>> returnSty = new ReturnSty<List<User_level>>();
        List<User_level> user_levels = userLvDao.SelectAllUserLv();
        if(user_levels != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetValue(user_levels);
            returnSty.setRetMessage("查找所有等级信息成功");
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTALLUSERLVFAIL);
            returnSty.setRetMessage("查找所有等级信息失败");
        }
        return returnSty;
    }
}
