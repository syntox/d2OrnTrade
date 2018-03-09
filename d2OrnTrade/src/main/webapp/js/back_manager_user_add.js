$(document).ready(function () {
    img_preView("bm_user_add_form_pic", "img_preView");    //图片预览开启

    var bm_user_info_check_flag = {
        "bm_user_info_user_name_check_flag": false,
        "bm_user_info_user_pwd_check_flag": false,
        "bm_user_info_user_pwd_two_checking_flag": false,
        "bm_user_info_user_mail_check_flag": false
    };
    $("#bm_user_add_form_userName").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_name_check_flag = bm_user_info_user_name_check($("#bm_user_add_form_userName").val());
    });
    $("#bm_user_add_form_password").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_pwd_check_flag = bm_user_info_user_pwd_check($("#bm_user_add_form_password").val());
    });
    $("#bm_user_add_form_password_checking").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_pwd_two_checking_flag = bm_user_info_user_pwd_two_checking($("#bm_user_add_form_password").val());
    });
    $("#bm_user_add_form_mail").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_mail_check_flag = bm_user_info_user_mail_check($("#bm_user_add_form_mail").val());
    });
    /**
     * 确认后台添加用户事件
     */
    $("#bm_user_add_form_submit").click(function () {
        var img_check_temp = img_upload_click_check("bm_user_add_form_pic");    //验证上传内容
        if (img_check_temp === true) {
            if (bm_user_info_check_flag.bm_user_info_user_name_check_flag === false ||
                bm_user_info_check_flag.bm_user_info_user_pwd_check_flag === false ||
                bm_user_info_check_flag.bm_user_info_user_pwd_two_checking_flag === false ||
                bm_user_info_check_flag.bm_user_info_user_mail_check_flag === false) {
                alert("核实输入信息");
            } else {
                var user_temp = bm_user_getUserInfo();
                //可以添加用户到数据库
                $("#bm_user_add_form").ajaxSubmit({
                    data: user_temp,
                    type: 'POST',
                    url: '/User/AddUserInfo',
                    success: function (data) {
                        alert("添加用户成功");
                    },
                    error: function () {
                        alert("上传失败，服务器异常");
                    }
                });
            }
        } else {
            //图片上传有误
        }
    })
});

/**
 * 从页面获取用户信息
 * @return {*}
 */
function bm_user_getUserInfo() {
    var bm_user_add_form_userName = $("#bm_user_add_form_userName").val();    //用户名
    var bm_user_add_form_password = $("#bm_user_add_form_password").val();    //密码
    var bm_user_add_form_mail = $("#bm_user_add_form_mail").val();    //邮箱
    var bm_user_add_form_number = $("#bm_user_add_form_number").val();     //电话号码
    /**
     * 生成用户的json对象
     */
    var user_temp = make_user_object(bm_user_add_form_userName,
        bm_user_add_form_password,
        bm_user_add_form_mail,
        bm_user_add_form_number
    );

    return user_temp;
}
/**
 * 功能： 组装user对象
 *
 * private String user_id;                            //用户编号
 * private String user_name;                     //用户名
 * private String user_pwd;                       //用户密码
 * private String user_mail;                      //邮箱
 * private String user_phonenumber;     //电话号码
 * private String user_pic;                        //用户头像
 * private Timestamp register_date;       //注册日期
 * private User_role user_role;                //角色 FK
 * private User_level user_level;             //等级 FK
 */
function make_user_object(user_name, user_pwd, user_mail, user_phonenumber, user_pic) {
    var user_temp = {
        "user_name": user_name,
        "user_pwd": user_pwd,
        "user_mail": user_mail,
        "user_phonenumber": user_phonenumber
    };
    return user_temp;
}
/**
 * 验证上传图片核实内容
 */
function img_upload_click_check(img_div_id) {
    var img_upload_name = $("#" + img_div_id + "").val();    //获取上传图片的图片名
    if (img_upload_name === "") {
        alert("别忘记先上传图片哟！");
        return false;
    } else {
        //取 . 后面字符，判断是否为图片
        var strExtension = img_upload_name.substr(img_upload_name.lastIndexOf('.') + 1);
        if (strExtension !== 'jpg' && strExtension !== 'JPG'
            && strExtension !== 'png' && strExtension !== 'PNG'
            && strExtension !== 'bmp' && strExtension !== 'BMP'
            && strExtension !== 'gif' && strExtension !== 'GIF') {
            alert("请确认上传文件为图片");
            return false;
        } else {
            return true;
        }
    }
}

/**
 * 用户名检测
 */
function bm_user_info_user_name_check(user_name) {
    if (user_name === null || user_name.trim().length === 0) {
        $("#bm_user_add_form_userName_warning").text("用户名不能为空或含有空格").css("color","red");
        return false;
    } else if (user_name.length < 4) {
        $("#bm_user_add_form_userName_warning").text("用户名不能小于4位").css("color","red");
        return false;
    } else if (user_name.length >= 10) {
        $("#bm_user_add_form_userName_warning").text("用户名过长").css("color","red");
        return false;
    } else {
        /**
         * 提交到服务器查重
         */
        var tf_flag = false;
        $.ajax({
            type: "post",
            dataType: "json",
            data: {"user_name": user_name},
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            url: "/isExistUser",
            async: false,
            success: function (data) {
                if (data.retCode === "666") {
                    // 用户名可以使用
                    $("#bm_user_add_form_userName_warning").text("用户名可以使用").css("color", "green");
                    tf_flag = true;
                } else if (data.retCode === "205") {
                    // 用户名已存在
                    $("#bm_user_add_form_userName_warning").text("用户名已被使用").css("color", "red");
                    tf_flag = false;
                }
            },
            error: function () {
                alert("服务器发生故障！");
                tf_flag = false;
            }
        });
        return tf_flag;
    }
}
/**
 * 密码检测
 */
function bm_user_info_user_pwd_check(user_pwd) {
    var pwdReg = /^[a-zA-Z0-9_]+$/;    //密码格式
    /**
     * 密码检测
     */
    if (user_pwd === null || user_pwd.trim().length === 0) {
        $("#bm_user_add_form_password_warning").text("密码不能为空或含有空格").css("color","red");
        return false;
    } else if (user_pwd.length < 6) {
        $("#bm_user_add_form_password_warning").text("密码不得少于6位").css("color","red");
        return false;
    } else if (user_pwd.length > 20) {
        $("#bm_user_add_form_password_warning").text("密码过长").css("color","red");
        return false;
    } else if (!pwdReg.test(user_pwd)) {
        $("#bm_user_add_form_password_warning").text("密码只能含有大小写字母，数字，下划线").css("color", "red");
        return false;
    } else {
        //密码可以使用
        $("#bm_user_add_form_password_warning").text("密码可以使用").css("color", "green");
        return true;
    }
}
/**
 * 确认密码检测
 */
function bm_user_info_user_pwd_two_checking(user_pwd) {
    var bm_user_add_form_password_checking = $("#bm_user_add_form_password_checking").val();
    if (bm_user_add_form_password_checking === user_pwd) {
        //确认密码成功
        $("#bm_user_add_form_password_checking_warning").text("密码可以使用").css("color", "green");
        return true;
    } else {
        $("#bm_user_add_form_password_checking_warning").text("请确认密码是否正确").css("color","red");
        return false;
    }
}
/**
 * 邮箱检测
 */
function bm_user_info_user_mail_check(user_mail) {
    var mailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;    //邮箱格式
    /**
     * 邮箱检测
     */
    if (user_mail.trim().length === 0) {
        $("#bm_user_add_form_mail_warning").text("邮箱不能为空").css("color", "red");
        return false;
    } else if (!mailReg.test(user_mail)) {
        $("#bm_user_add_form_mail_warning").text("邮箱格式不正确").css("color", "red");
        return false;
    } else {
        var tf_flag = false;
        $.ajax({
            type: "post",
            dataType: "json",
            data: {"user_mail": user_mail},
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            url: "/isExistUser",
            async: false,
            success: function (data) {
                if (data.retCode === "666") {
                    /**
                     * 邮箱可以使用
                     */
                    $("#bm_user_add_form_mail_warning").text("邮箱可以使用").css("color", "green");
                    tf_flag = true;
                } else if (data.retCode === "205") {
                    // 邮箱已被注册
                    $("#bm_user_add_form_mail_warning").text("邮箱已被注册").css("color", "red");
                    tf_flag = false;
                }
            },
            error: function () {
                alert("服务器发生故障！");
                tf_flag = false;
            }
        });
        return tf_flag;
    }
}

