$(document).ready(function () {
    img_preView("bm_user_modify_form_pic", "img_preView");    //图片预览开启
    SelectAllUserRole();    //角色下拉信息显示
    SelectAllUserLv();    //等级下拉信息显示
    /**
     * 查找某个用户信息用来修改
     */
    $("#bm_user_modify_filter_button").click(function () {
        var bm_user_modify_filter_input = $("#bm_user_modify_filter_input").val();
        if (bm_user_modify_filter_input !== null) {
            $.ajax({
                type: "post",
                data: {"userInfo": bm_user_modify_filter_input},
                dataType: "json",
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/User/selectUniqueUser",
                async: true,
                success: function (data) {
                    if (data.retCode === "666") {
                        var user_temp = makeUserObject(data.retValue);
                        showUserInfoInForm(user_temp);    //将读取到的数据填充到表单中用以修改
                        localStorage.setItem("bm_modify_user_mail",user_temp.user_mail);    //将本页面的邮箱信息保存
                        localStorage.setItem("bm_modify_user_name",user_temp.user_name);    //将本页面的用户名信息保存
                        localStorage.setItem("bm_modify_user_id",user_temp.user_id);    //将本页面的用户编号信息保存
                    } else if (data.retCode === "212") {
                        alert(data.retMessage);
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            });
        } else {
            alert("请先输入用户信息");
        }
    });
    var bm_user_info_check_flag = user_modify_info_check();    //用户信息格式确认
    $("#bm_user_modify_form_submit").click(function () {
        if(bm_user_info_check_flag.bm_user_info_user_name_check_flag === true &&
            bm_user_info_check_flag.bm_user_info_user_pwd_check_flag === true &&
            bm_user_info_check_flag.bm_user_info_user_mail_check_flag === true ){
            var user_temp = getUserInfoToSub();

            $("#bm_user_modify_form").ajaxSubmit({
                data: user_temp,
                type: 'POST',
                url: '/User/ModifyUserInfo',
                success: function (data) {
                    alert("修改用户成功");
                },
                error: function () {
                    alert("修改失败，服务器异常");
                }
            });
        }else {
            alert("请核实输入内容"+bm_user_info_check_flag.bm_user_info_user_name_check_flag+bm_user_info_check_flag.bm_user_info_user_pwd_check_flag+bm_user_info_check_flag.bm_user_info_user_mail_check_flag);
        }
    })

});

/**
 * 查找所有用户角色
 */
function SelectAllUserRole() {
    // {"   retCode":"666",
    //     "retMessage":"查找所有角色信息成功",
    //     "retValue":
    //                      [{"role_id":1,
    //                        "role_name":"管理员",
    //                        "role_desc":""},
    //                     {"role_id":2,
    //                      "role_name":"普通用户",
    //                      "role_desc":""},
    //                    {"role_id":3,
    //                     "role_name":"会员用户",
    //                     "role_desc":""},
    //                   {"role_id":4,
    //                    "role_name":"超级管理员",
    //                    "role_desc":""}]}
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/SelectAllUserRole",
        async: false,
        success: function (data) {
            if (data.retCode === "666") {
                for (var i = 0; i < data.retValue.length; i++) {
                    var userRole_temp = makeRoleObject(data.retValue[i]);
                    showRoleOptionInfo(userRole_temp);    //显示角色下拉内容
                }
            } else if (data.retCode === "211") {
                alert("没有查找到角色信息！");
            }
        },
        error: function () {
            alert("服务器发生故障！");
        }
    });
}
/**
 * 查找所有等级信息
 */
function SelectAllUserLv() {
    //{"retCode":"666",
    // "retMessage":"查找所有等级信息成功",
    // "retValue":
    //              [{"lv_id":1,
    //                "lv_name":"白银用户",
    //                "lv_desc":""}, ... ]}
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/selectAllUserLv",
        async: false,
        success: function (data) {
            if (data.retCode === "666") {
                for (var i = 0; i < data.retValue.length; i++) {
                    var userLv_temp = makeLvObject(data.retValue[i]);
                    showLvOptionInfo(userLv_temp);    //显示等级下拉内容
                }
            } else if (data.retCode === "210") {
                alert("没有查找到用户的等级信息！");
            }
        },
        error: function () {
            alert("服务器发生故障！");
        }
    });
}
/**
 * 组装用户对象
 * @param retValue
 * @return {{user_id: *, user_name: *, user_pwd: *, user_mail: *, user_phonenumber: *, user_pic: *, user_role: *, user_level: *}}
 */
function makeUserObject(retValue) {
    return {
        "user_id": retValue.user_id,
        "user_name": retValue.user_name,
        "user_pwd": retValue.user_pwd,
        "user_mail": retValue.user_mail,
        "user_phonenumber": retValue.user_phonenumber,
        "user_pic": retValue.user_pic,
        "user_role": retValue.user_role.role_name,
        "user_level": retValue.user_level.lv_name
    };
}
/**
 *  组装每一个角色信息对象
 * @param retValue
 * @return {{role_id: *, role_name: *, role_desc: *}}
 */
function makeRoleObject(retValue) {
    return {
        "role_id": retValue.role_id,
        "role_name": retValue.role_name,
        "role_desc": retValue.role_desc
    };
}
/**
 * 组装每一个的等级信息对象
 * @param retValue
 * @return {{lv_id: *, lv_name: *, lv_desc: *}}
 */
function makeLvObject(retValue) {
    return {
        "lv_id": retValue.lv_id,
        "lv_name": retValue.lv_name,
        "lv_desc": retValue.lv_desc
    };
}
/**
 * 显示角色下拉内容
 * @param userRole
 */
function showRoleOptionInfo(userRole) {
    $("#bm_user_modify_role").append("<option>" + userRole.role_name + "</option>")
}
/**
 * 显示等级下拉内容
 * @param userLv
 */
function showLvOptionInfo(userLv) {
    $("#bm_user_modify_lv").append("<option>" + userLv.lv_name + "</option>")
}
/**
 * 将读取到的数据填充到表单中用以修改
 * @param user
 */
function showUserInfoInForm(user) {
    $("#bm_user_modify_form_userName").val(user.user_name);
    $("#bm_user_modify_form_password").val(user.user_pwd);
    $("#bm_user_modify_form_mail").val(user.user_mail);
    $("#bm_user_modify_form_number").val(user.user_phonenumber);
    $("#bm_user_modify_lv").val(user.user_level);
    $("#bm_user_modify_role").val(user.user_role);
    $("#img_preView").attr("src",user.user_pic);
}

/**
 * 邮箱格式验证
 * @param email                     邮箱
 * @param label_warning       用于提示的控件id
 * @return {boolean}
 */
function is_mail_check(email,label_warning) {
    var mailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;    //邮箱格式
    /**
     * 邮箱检测
     */
    if (email.trim().length === 0) {
        $("#"+label_warning).text("邮箱不能为空").css("color", "red");
        return false;
    } else if (!mailReg.test(email)) {
        $("#"+label_warning).text("邮箱格式不正确").css("color", "red");
        return false;
    } else {
        if(localStorage.getItem("bm_modify_user_mail") === email){
            //没有做修改时没必要做查重
        }else {
            var tf_flag = false;
            $.ajax({
                type: "post",
                dataType: "json",
                data: {"user_mail": email},
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/isExistUser",
                async: true,
                success: function (data) {
                    if (data.retCode === "666") {
                        $("#"+label_warning).text("邮箱可以使用").css("color", "green");
                        tf_flag =  true;
                    } else if (data.retCode === "205") {
                        $("#"+label_warning).text("邮箱已被注册").css("color", "red");
                        tf_flag =  false;
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
}
/**
 * 密码验证
 * @param pwd                    密码
 * @param label_warning    用于提示的控件id
 * @return {boolean}
 */
function is_pwd_check(pwd,label_warning) {
    var pwdReg = /^[a-zA-Z0-9_]+$/;    //密码格式
    /**
     * 密码检测
     */
    if (pwd === null || pwd.trim().length === 0) {
        $("#"+label_warning).text("密码不能为空或含有空格").css("color","red");
        return false;
    } else if (pwd.length < 6) {
        $("#"+label_warning).text("密码不得少于6位").css("color","red");
        return false;
    } else if (pwd.length > 20) {
        $("#"+label_warning).text("密码过长").css("color","red");
        return false;
    } else if (!pwdReg.test(pwd)) {
        $("#"+label_warning).text("密码只能含有大小写字母，数字，下划线").css("color", "red");
        return false;
    } else {
        $("#"+label_warning).text("密码可以使用").css("color", "green");
        return true;
    }
}
/**
 * 用户名验证
 * @param user_name        用户名
 * @param label_warning    用于提示的控件id
 * @return {boolean}
 */
function is_user_name_check(user_name,label_warning) {
    if (user_name === null || user_name.trim().length === 0) {
        $("#"+label_warning).text("用户名不能为空或含有空格").css("color","red");
        return false;
    } else if (user_name.length < 4) {
        $("#"+label_warning).text("用户名不能小于4位").css("color","red");
        return false;
    } else if (user_name.length >= 10) {
        $("#"+label_warning).text("用户名过长").css("color","red");
        return false;
    } else {
        if(localStorage.getItem("bm_modify_user_name") === user_name){
            //用户名没有做修改时没必要做查重
            $("#"+label_warning).text("").css("color","green");
            return true;
        }else {
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
                        $("#"+label_warning).text("用户名可以使用").css("color", "green");
                        tf_flag = true;
                    } else if (data.retCode === "205") {
                        $("#"+label_warning).text("用户名已被使用").css("color", "red");
                        tf_flag =  false;
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                    tf_flag =  false;
                }
            });
            return tf_flag;
        }
    }
}
/**
 * 用户信息格式确认
 * @return {{bm_user_info_user_name_check_flag: boolean, bm_user_info_user_pwd_check_flag: boolean, bm_user_info_user_mail_check_flag: boolean}}
 */
function user_modify_info_check() {
    var bm_user_info_check_flag = {
        "bm_user_info_user_name_check_flag": true,
        "bm_user_info_user_pwd_check_flag": true,
        "bm_user_info_user_mail_check_flag": true
    };
    $("#bm_user_modify_form_userName").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_name_check_flag = is_user_name_check($("#bm_user_modify_form_userName").val(),"bm_user_modify_form_userName_warning");
    });
    $("#bm_user_modify_form_password").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_pwd_check_flag = is_pwd_check($("#bm_user_modify_form_password").val(),"bm_user_modify_form_password_warning");
    });
    $("#bm_user_modify_form_mail").blur(function () {
        bm_user_info_check_flag.bm_user_info_user_mail_check_flag = is_mail_check($("#bm_user_modify_form_mail").val(),"bm_user_modify_form_mail_warning");
    });
    return bm_user_info_check_flag;
}
/**
 * 获取修改完成后的数据
 * @return {{user_id, user_name: (*|jQuery), user_pwd: (*|jQuery), user_mail: (*|jQuery), user_phonenumber: (*|jQuery), user_pic: string, user_role: (*|jQuery), user_level: (*|jQuery)}}
 */
function getUserInfoToSub() {
    return {
        "user_id": localStorage.getItem("bm_modify_user_id"),
        "user_name": $("#bm_user_modify_form_userName").val(),
        "user_pwd":  $("#bm_user_modify_form_password").val(),
        "user_mail":  $("#bm_user_modify_form_mail").val(),
        "user_phonenumber":  $("#bm_user_modify_form_number").val(),
        "role_name":  $("#bm_user_modify_role").val(),
        "level_name":  $("#bm_user_modify_lv").val()
    }
}