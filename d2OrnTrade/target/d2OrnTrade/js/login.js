$(document).ready(function () {
    // 加载头部页面
    $("#login-header").load("../html/header.html");

    //切换登录方式
    $("#login-by-mail").click(function () {
        $("#login-by-mail").addClass("active");
        $("#login-by-username").removeClass("active");
        $("#login-input-email").css("display","block");
        $("#login-input-username").css("display","none");
    })

    $("#login-by-username").click(function () {
        $("#login-by-username").addClass("active");
        $("#login-by-mail").removeClass("active");
        $("#login-input-username").css("display","block");
        $("#login-input-email").css("display","none");
    })
})

