var login_type = true;    //true 邮箱登陆  false  用户名登陆

$(document).ready(function () {
    // 加载头部页面
    $("#login-header").load("../html/header.html");
    //更新登陆方式
    get_login_type();
    //切换登录方式
    change_login_type();
    //登陆信息核实
    login_input_check();
    //登陆提交
    login_submit();

});
/**
 * 修改登陆方式
 */
function change_login_type() {
    $("#login-by-mail").click(function () {
        $("#login-by-mail").addClass("active");
        $("#login-by-username").removeClass("active");
        $("#login-input-email").css("display","block");
        $("#login-input-username").css("display","none");
    });
    $("#login-by-username").click(function () {
        $("#login-by-username").addClass("active");
        $("#login-by-mail").removeClass("active");
        $("#login-input-username").css("display","block");
        $("#login-input-email").css("display","none");
    });
};
/**
 * 登陆信息核实
 */
function login_input_check() {
    $("#input-email").blur(function () {
        if($("#input-email").val() === null || $("#input-email").val().trim().length === 0){
            $("#login-body-email-warning").text("邮箱不能为空或空格").css("color", "red");
        }else {
            $("#login-body-email-warning").text("").css("color", "green");
        }
    });

    $("#input-username").blur(function () {
        if($("#input-username").val() === null || $("#input-username").val().trim().length === 0){
            $("#login-body-username-warning").text("用户名不能为空").css("color", "red");
        }else {
            $("#login-body-username-warning").text("").css("color", "green");
        }
    });

    $("#input-pwd").blur(function () {
        if($("#input-pwd").val() === null || $("#input-pwd").val().trim().length === 0){
            $("#login-body-pwd-warning").text("用户名不能为空").css("color", "red");
        }else {
            $("#login-body-pwd-warning").text("").css("color", "green");
        }
    });
}
/**
 * 更新登陆方式
 */
function get_login_type() {
    $("#login_by_mail").click(function () {
        login_type = true;
    });

    $("#login_by_username").click(function () {
        login_type = false;
    });
}
/**
 * 登陆提交
 */
function login_submit() {
    $("#login-btn").click(function () {
        if(login_type === true){    //邮箱登陆
            var email = $("#input-email").val();
            var pwd = $("#input-pwd").val();

            $.ajax({
                type: "post",
                dataType: "json",
                data: {"user_mail": email, "user_pwd": pwd},
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/loginByMail",
                async: false,
                success: function (data) {
                    if (data.retCode === "666") {
                        //设置用户session
                        local_storage_userInfo_set(data.retValue);
                        location.href="../html/fore_main.html";
                    } else if (data.retCode === "206") {
                        alert("邮箱不存在或密码有误");
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            });
        }else if(login_type === false){
            var username = $("#input-username").val();
            var pwd = $("#input-pwd").val();
            $.ajax({
                type: "post",
                dataType: "json",
                data: {"user_name": username, "user_pwd": pwd},
                contentType: "application/x-www-form-urlencoded;charset=UTF-8",
                url: "/loginByUsername",
                async: false,
                success: function (data) {
                    if (data.retCode === "666") {
                        local_storage_userInfo_set(data.retValue);
                        location.href="../html/fore_main.html";
                    } else if (data.retCode === "207") {
                        alert("用户名不存在或密码有误");
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            })
        }

    });
}

/**
 * 登陆成功后查询用户信息用户设置
 */
function local_storage_userInfo_set(user) {
    localStorage.setItem("currentUser",JSON.stringify(user));    //设置当前用户信息
}
