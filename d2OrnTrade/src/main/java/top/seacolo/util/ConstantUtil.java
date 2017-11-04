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
}
