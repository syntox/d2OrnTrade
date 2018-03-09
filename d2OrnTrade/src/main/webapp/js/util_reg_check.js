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
                    return true;
                } else if (data.retCode === "205") {
                    $("#"+label_warning).text("邮箱已被注册").css("color", "red");
                    return false;
                }
            },
            error: function () {
                alert("服务器发生故障！");
            }
        })
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
        /**
         * 提交到服务器查重
         */
        $.ajax({
            type: "post",
            dataType: "json",
            data: {"user_name": user_name},
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            url: "/isExistUser",
            async: true,
            success: function (data) {
                if (data.retCode === "666") {
                    $("#"+label_warning).text("用户名可以使用").css("color", "green");
                    return true;
                } else if (data.retCode === "205") {
                    $("#"+label_warning).text("用户名已被使用").css("color", "red");
                    return false;
                }
            },
            error: function () {
                alert("服务器发生故障！");
            }
        })
    }
}