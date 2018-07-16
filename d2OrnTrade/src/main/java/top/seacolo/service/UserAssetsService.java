package top.seacolo.service;

import top.seacolo.entity.User_assets;
import top.seacolo.util.ReturnSty;

import java.util.HashMap;

public interface UserAssetsService {
    ReturnSty addUserAssets(User_assets user_assets);
    ReturnSty selectUserAssets(HashMap<String,Object> map);
}
