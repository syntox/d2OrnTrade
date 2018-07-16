package top.seacolo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.seacolo.dao.UserAssetsDao;
import top.seacolo.entity.User_assets;
import top.seacolo.service.UserAssetsService;
import top.seacolo.util.ConstantUtil;
import top.seacolo.util.RandomIdUtil;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;

@Service
public class UserAssetsServiceImpl implements UserAssetsService {
    @Autowired(required = false)
    UserAssetsDao userAssetsDao;

    /**
     * 添加默认的用户资产
     * @param user_assets
     * @return
     */
    public ReturnSty addUserAssets(User_assets user_assets) {
        ReturnSty returnSty = new ReturnSty();
        //随机id防止重复
        String assets_id = RandomIdUtil.getID();
        user_assets.setAssets_id(assets_id);
        user_assets.setAll_assets(0);    //默认总资产为0
        user_assets.setAvailable_assets(0);    //默认可用资产为0
        user_assets.setUnavailable_assets(0);    //默认不可用资产为0

        int count = userAssetsDao.addUserAssets(user_assets);
        if(count > 0){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("资产添加成功！");
        }else {
            returnSty.setRetCode(ConstantUtil.INSERTADMINUSERASSETSFAIL);
            returnSty.setRetMessage("资产添加失败！");
        }
        return returnSty;
    }


    /**
     * 根据用户id查找用户资产情况
     * @param map
     * @return
     */
    public ReturnSty selectUserAssets(HashMap<String,Object> map) {
        ReturnSty returnSty = new ReturnSty();
        User_assets user_assets = userAssetsDao.selectUserAssets(map);
        if(user_assets != null){
            returnSty.setRetCode(ConstantUtil.SUCCESS);
            returnSty.setRetMessage("用户资产查找成功");
            returnSty.setRetValue(user_assets);
        }else {
            returnSty.setRetCode(ConstantUtil.SELECTADMINUSERASSETSFAIL);
            returnSty.setRetMessage("用户资产查找失败");
        }
        return returnSty;
    }
}
