package top.seacolo.util;

public class ClassifyUtil {
    public static String classifyUserRole(String role_name){
        if(role_name.equals("管理员")){
            return "1";
        }else if(role_name.equals("普通用户")){
            return "2";
        }else if (role_name.equals("会员用户")){
            return "3";
        }else if(role_name.equals("超级管理员")){
            return "4";
        }else {
            return "0";
        }
    }

    public static String classifyUserLv(String lv_name){
        if(lv_name.equals("白银用户")){
            return "1";
        }else if(lv_name.equals("黄金用户")){
            return "2";
        }else if (lv_name.equals("白金用户")){
            return "3";
        }else if(lv_name.equals("钻石用户")){
            return "4";
        }else {
            return "0";
        }
    }

    public static String classifyHeroAttr(String attr_name){
        if(attr_name.equals("力量")){
            return "1";
        }else if(attr_name.equals("敏捷")){
            return "2";
        }else if (attr_name.equals("智力")){
            return "3";
        }else if(attr_name.equals("不限")){
            return "4";
        }else {
            return "0";
        }
    }
}
