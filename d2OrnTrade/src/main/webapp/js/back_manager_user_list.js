/**
 * Created by MaYY on 2018/2/16.
 */
$(document).ready(function () {
    //引入动态添加html的方法
    document.write("<script src='../js/util_show_all.js'></script>");
    //默认查找所有用户
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/User/selectAllUser",
        async: true,
        success: function (data) {
            if (data.retCode === "666") {
                for(var i = 0; i<data.retValue; i++)
                bm_user_list(data, 'bm_user_list_table_users');
            } else if (data.retCode === "555") {
                alert("没有查找到用户！");
            }


        },
        error: function () {
            alert("服务器发生故障！");
        }
    })

});