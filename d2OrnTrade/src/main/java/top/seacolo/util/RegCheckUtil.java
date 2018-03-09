package top.seacolo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegCheckUtil {
    /**
     * 验证是否是邮箱
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if(email == null){
            return false;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        if(b) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 检测是否是手机号码
     * @param phoneNum
     * @return
     */
    public static boolean isPhoneNum(String phoneNum){
        if(phoneNum == null){
            return false;
        }
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(phoneNum);
        boolean b = m.matches();
        if(b) {
            return true;
        }else{
            return false;
        }
    }
}
