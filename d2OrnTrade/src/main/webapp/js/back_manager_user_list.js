$(document).ready(function () {

    var pageNow = 1;   //默认当前页为1
    var pageSize = 2;    //默认每页显示2条用户数据
    var pageInit = 1;    //初始页码
    var buttonOfPageName = 'bm_user_list';    //页面控制按钮所属页面名称
    localStorage.setItem("PageInfo", null);

    /**
     * 初始化页面控制按钮
     */
    page_ctrl_init(buttonOfPageName,pageInit);
    /**
     * 按照pageNow显示pageSize条数据
     */
    var storage_pageInfo = selectUser(pageNow,pageSize);
    localStorage.setItem("PageInfo", JSON.stringify(storage_pageInfo));    //将分页信息转化为JSON字符串保存在浏览器端
    /**
     * 初始化页面控制按钮事件
     */
    bm_user_list_page_ctrl_events(buttonOfPageName,pageInit,pageSize);
    /**
     * 调整页面控制按钮
     */
    page_ctrl_change(buttonOfPageName,JSON.parse(localStorage.getItem("PageInfo")));

});

/**
 *  功能 ： 查找用户并显示
 * @param pageNow
 * @param pageSize
 *
 * @return pageInfo    页面信息对象
 */
function selectUser(pageNow,pageSize) {
    var pageInfo = null;     //创建页面信息对象
    /**
     *     默认查找所有用户(分页)
     */
    /**
     * 返回格式预览
     *
     * {"retCode":"666",
     *  "retMessage":"查找用户成功",
     *  "retValue":
     *      {
     *   "pageInfo":
     *       {"pageNow":1,
     *        "pageSize":2,
     *        "totalCount":3,
     *        "totalPageCount":2,
     *        "startPos":0,
     *        "hasFirst":false,
     *        "hasPre":false,
     *        "hasNext":true,
     *        "hasLast":true}
     *  "users":[
     *      {"user_id":"1512194584818zDBaK42",
     *       "user_name":"aaaaaaaaa",
     *       "user_pwd":"123456",
     *       "user_mail":"1255173612@qq.com",
     *       "user_phonenumber":"",
     *       "user_pic":"",
     *       "register_date":1512194585000,
     *       "user_role":{"role_id":0,
     *                          "role_name":"普通用户",
     *                          "role_desc":null},
     *       "user_level":{"lv_id":0,
     *                           "lv_name":"白银用户",
     *                           "lv_desc":null}
     *      },{...},{...}]
     * }
     */
    $.ajax({
        type: "post",
        data: {"pageNow": pageNow, "pageSize": pageSize},
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/User/SelectUserWithPage",
        async: false,
        success: function (data) {
            if (data.retCode === "666") {
                pageInfo = makePageInfo(data.retValue.pageInfo);     //存储分页信息
                for (var i = 0; i < data.retValue.users.length; i++) {
                    var user = makeEveryUser(data.retValue.users[i]);         //存储用户信息
                    showEveryUser(user,i);     //显示每个用户数据
                }
            } else if (data.retCode === "555") {
                alert("没有查找到用户！");
            }
        },
        error: function () {
            alert("服务器发生故障！");
        }
    });
    return pageInfo;     //返回页面信息对象
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
 *
 * @param User
 */
function makeEveryUser(userOfJava) {
    var thisUser = {
        "user_id": userOfJava.user_id,
        "user_name": userOfJava.user_name,
        "user_pwd": userOfJava.user_pwd,
        "user_mail": userOfJava.user_mail,
        "user_phonenumber": userOfJava.user_phonenumber,
        "user_pic": userOfJava.user_pic,
        "register_date": userOfJava.register_date,
        "user_role": userOfJava.user_role.role_name,
        "user_level": userOfJava.user_level.lv_name
    };

    return thisUser;
}

/**
 * 功能： 动态显示每一个用户信息
 *
 <tr>
        <td class='bm_user_list_table_users_user_id'><p></p></td>
        <td class='bm_user_list_table_users_user_name'><p></p></td>
        <td class='bm_user_list_table_users_user_pwd'><p></p></td>
        <td class='bm_user_list_table_users_user_mail'><p></p></td>
        <td class='bm_user_list_table_users_user_phonenumber'><p></p></td>
        <td class='bm_user_list_table_users_user_pic'><img src=''></img></td>
        <td class='bm_user_list_table_users_register_date'><p></p></td>
        <td class='bm_user_list_table_users_user_role'><p></p></td>
        <td class='bm_user_list_table_users_user_level'><p></p></td>
 </tr>
 * @param User     用户对象
 * @param i           对象次序
 */
function showEveryUser(User, i) {
    $("#bm_user_list_table_users").append(
    "<tr class='bm_user_list_table_users_tr' id='list_table_users_u"+i+"'>"
    +  "<td class='bm_user_list_table_users_user_id'><p>"+User.user_id+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_name'><p>"+User.user_name+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_pwd'><p>"+User.user_pwd+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_mail'><p>"+User.user_mail+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_phonenumber'><p>"+User.user_phonenumber+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_pic'><img src='"+User.user_pic+"'></img></td>"
    +  "<td class='bm_user_list_table_users_register_date'><p>"+getFormatDateByLong(User.register_date,"yyyy-MM-dd")+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_role'><p>"+User.user_role+"</p></td>"
    +  "<td class='bm_user_list_table_users_user_level'><p>"+User.user_level+"</p></td>"
    +  "</tr>");
}

/**
 * 功能 ： bm_user_list分页控制点击事件
 */
function bm_user_list_page_ctrl_events(buttonOfPageName, pageInit, pageSize) {
    /**
     * 第一页点击事件
     */
    $("#bm_user_list_page_ctrl_first").bind("click",{buttonOfPageName:buttonOfPageName, pageInit:pageInit, pageSize:pageSize},function (event) {
        list_clear_by_class("bm_user_list_table_users_tr");
        var pageInfo_temp = selectUser(event.data.pageInit, event.data.pageSize);
        page_ctrl_change(event.data.buttonOfPageName,pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
    /**
     * 上一页点击事件
     */
    $("#bm_user_list_page_ctrl_pre").bind("click",{buttonOfPageName:buttonOfPageName},function (event) {
        list_clear_by_class("bm_user_list_table_users_tr");
        var pageInfo_temp = selectUser(JSON.parse(localStorage.getItem("PageInfo")).pageNow-1,JSON.parse(localStorage.getItem("PageInfo")).pageSize);
        page_ctrl_change(event.data.buttonOfPageName,pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
    /**
     * 下一页点击事件
     */
    $("#bm_user_list_page_ctrl_next").bind("click",{buttonOfPageName:buttonOfPageName},function (event) {
        list_clear_by_class("bm_user_list_table_users_tr");
        var pageInfo_temp = selectUser(JSON.parse(localStorage.getItem("PageInfo")).pageNow+1,JSON.parse(localStorage.getItem("PageInfo")).pageSize);
        page_ctrl_change(event.data.buttonOfPageName,pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
    /**
     * 尾页点击事件
     */
    $("#bm_user_list_page_ctrl_last").bind("click",{buttonOfPageName:buttonOfPageName},function (event) {
        list_clear_by_class("bm_user_list_table_users_tr");
        var pageInfo_temp = selectUser(JSON.parse(localStorage.getItem("PageInfo")).totalPageCount,JSON.parse(localStorage.getItem("PageInfo")).pageSize);
        page_ctrl_change(event.data.buttonOfPageName,pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
}




