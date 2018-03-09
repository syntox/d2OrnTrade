$(document).ready(function () {
    /**
     * 加载头部页面
     */

    $("#register-header").load("../html/header.html");


    /**
     * 定义是否可以提交注册的标识
     */
    var register_flag = {
        username_tf: false,
        pwd_tf: false,
        pwd_check_tf: false,
        email_tf: false
    };

    /**
     * 验证用户名格式以及查重
     */
    $("#input-username").blur(function () {
        // 用户名验证
        var input_username = $("#input-username").val();
        if (input_username === null || input_username.trim().length === 0) {
            $("#register-body-username-warning").text("用户名不能为空或空格").css("color", "red");
            register_flag.username_tf = false;
        } else if (input_username.length < 4) {
            $("#register-body-username-warning").text("用户名不得少于4位").css("color", "red");
            register_flag.username_tf = false;
        } else if (input_username.length >= 10) {
            $("#register-body-username-warning").text("用户名过长").css("color", "red");
            register_flag.username_tf = false;
        } else {
            /**
             * 提交到服务器查重
             */
            $.ajax({
                type: "post",
                dataType: "json",
                data: {"user_name": input_username},
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/isExistUser",
                async: true,
                success: function (data) {
                    if (data.retCode === "666") {
                        $("#register-body-username-warning").text("用户名可以使用").css("color", "green");
                        register_flag.username_tf = true;
                    } else if (data.retCode === "205") {
                        // 用户名已存在
                        $("#register-body-username-warning").text("用户名已被使用").css("color", "red");
                        register_flag.username_tf = false;
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            })
        }
    });
    /**
     * 验证密码格式
     */
    $("#input-pwd").blur(function () {
        var input_pwd = $("#input-pwd").val();
        var input_pwd_check = $("#input-pwd-check").val();
        var pwdReg = /^[a-zA-Z0-9_]+$/;

        if (input_pwd === null || input_pwd.trim().length === 0) {
            $("#register-body-pwd-warning").text("密码不能为空或含有空格").css("color", "red");
            register_flag.pwd_tf = false;
        } else if (input_pwd.length < 6) {
            $("#register-body-pwd-warning").text("密码不得少于6位").css("color", "red");
            register_flag.pwd_tf = false;
        } else if (input_pwd.length > 20) {
            $("#register-body-pwd-warning").text("密码过长").css("color", "red");
            register_flag.pwd_tf = false;
        } else if (!pwdReg.test(input_pwd)) {
            $("#register-body-pwd-warning").text("密码只能含有大小写字母，数字，下划线").css("color", "red");
            register_flag.pwd_tf = false;
        } else {
            $("#register-body-pwd-warning").text("密码可以使用").css("color", "green");
            register_flag.pwd_tf = true;
        }
        if (input_pwd_check !== null && input_pwd_check.trim().length !== 0) {
            if (input_pwd_check !== input_pwd) {
                $("#register-body-checkpwd-warning").text("密码确认不一致").css("color", "red");
                register_flag.pwd_check_tf = false;
            } else {
                $("#register-body-checkpwd-warning").text("确认密码一致").css("color", "green");
                register_flag.pwd_check_tf = true;
            }
        }
    });
    /**
     * 密码确认验证
     */
    $("#input-pwd-check").blur(function () {
        var input_pwd = $("#input-pwd").val();
        var input_pwd_check = $("#input-pwd-check").val();
        if (input_pwd_check.trim().length === 0 || input_pwd_check === null) {
            $("#register-body-checkpwd-warning").text("请再次输入密码").css("color", "red");
            register_flag.pwd_check_tf = false;
        }
        if (input_pwd !== null && input_pwd.trim().length !== 0) {
            if (input_pwd_check !== input_pwd) {
                $("#register-body-checkpwd-warning").text("密码确认不一致").css("color", "red");
                register_flag.pwd_check_tf = false;
            } else {
                $("#register-body-checkpwd-warning").text("确认密码一致").css("color", "green");
                register_flag.pwd_check_tf = true;
            }
        }
    });
    /**
     * 邮箱查重验证
     */
    $("#input-email").blur(function () {
        var input_email = $("#input-email").val();
        var mailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

        if (input_email.trim().length === 0) {
            $("#register-body-email-warning").text("邮箱不能为空").css("color", "red");
            register_flag.email_tf = false;
        } else if (!mailReg.test(input_email)) {
            $("#register-body-email-warning").text("邮箱格式不正确").css("color", "red");
            register_flag.email_tf = false;
        } else {
            $.ajax({
                type: "post",
                dataType: "json",
                data: {"user_mail": input_email},
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/isExistUser",
                async: true,
                success: function (data) {
                    if (data.retCode === "666") {
                        $("#register-body-email-warning").text("邮箱可以使用").css("color", "green");
                        register_flag.email_tf = true;
                    } else if (data.retCode === "205") {
                        // 邮箱已被注册
                        $("#register-body-email-warning").text("邮箱已被注册").css("color", "red");
                        register_flag.email_tf = false;
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            })
        }
    });
    /**
     * 邮箱验证码发送
     */
    $("#get-email-check").click(function () {
        // 邮箱
        var input_email = $("#input-email").val();
        $.ajax({
            type: "post",
            dataType: "json",
            data: {"user_mail": input_email},
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            url: "/sendMail",
            async: true,
            success: function (data) {
                if (data.retCode === "666") {
                    alert(data.retMessage);
                } else if (data.retCode === "202") {
                    // 邮件发送失败
                    alert(data.retMessage);
                }
            },
            error: function () {
                alert("服务器发生故障！");
            }
        })
    });
    /**
     * 注册点击
     */
    $("#register-btn").click(function () {
        // 用户名
        var input_username = $("#input-username").val();
        // 密码
        var input_pwd = $("#input-pwd").val();
        // 邮箱
        var input_email = $("#input-email").val();
        // 邮箱验证码
        var input_email_check = $("#input-email-check").val();

        // 声明注册用的用户js对象
        var register_userInfo = {
            "user_name": input_username,
            "user_pwd": input_pwd,
            "user_mail": input_email,
            "verificationCode": input_email_check
        };

        if (register_flag.username_tf     === true
            && register_flag.pwd_tf       === true
            && register_flag.pwd_check_tf === true
            && register_flag.email_tf     === true) {
            /**
             * 注册点击事件，提交数据，验证码后台验证
             */
            $.ajax({
                type: "post",
                dataType: "json",
                data: register_userInfo,
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/registerByMail",
                async: false,
                success: function (data) {
                    if (data.retCode === "666") {
                        alert(data.retMessage);
                    } else if (data.retCode === "201") {
                        // 邮箱注册失败
                        alert(data.retMessage);
                    } else if (data.retCode === "202") {
                        // 邮件发送失败
                        alert(data.retMessage);
                    } else if (data.retCode === "203") {
                        // 邮箱验证码为空或已过时
                        alert(data.retMessage);
                    } else if (data.retCode === "204") {
                        // 邮箱验证码错误
                        alert(data.retMessage);
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            })
        }else {
            alert("确认信息是否填写正确");
        }

    });
});