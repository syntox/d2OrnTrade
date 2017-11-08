package top.seacolo.util;

/**
 * 返回码定义类
 */
public class ConstantUtil {
    public static String SUCCESS = "666";           //成功
    public static String REGISTER_FAIL = "201";     //邮箱注册失败
    public static String MAILSEND_FAIL = "202";     //邮件发送失败
    public static String MAILVERIFICATIONCODE_NULL = "203";     //邮箱验证码为空或已过时
    public static String MAILVERIFICATIONCODE_ERROR = "204";    //邮箱验证码错误
    public static String HASEXISTUSER = "205";      //用户已存在（邮箱，用户名，手机号码已被使用）
    public static String LOGINBYMAILFAIL = "206";      //用户登录失败(邮箱不存在或密码错误)
    public static String LOGINBYNAMEFAIL = "207";      //用户登录失败(用户名不存在或密码错误)
}
