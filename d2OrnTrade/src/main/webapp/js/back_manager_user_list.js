$(document).ready(function () {

    //默认查找所有用户
    /**
     * {"retCode":"666",
     *  "retMessage":"查找用户成功",
     *  "retValue":[
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
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/User/selectAllUser",
        async: false,
        success: function (data) {
            if (data.retCode === "666") {
                for(var i = 0; i<data.retValue.length; i++){
                    var user = makeEveryUser(data.retValue[i]);
                    showAllUsers(user);
                }
            } else if (data.retCode === "555") {
                alert("没有查找到用户！");
            }
        },
        error: function () {
            alert("服务器发生故障！");
        }
    })
});

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
function makeEveryUser(UserOfJava) {
    var thisUser = {
        "user_id"                     : UserOfJava.user_id,
        "user_name"               : UserOfJava.user_name,
        "user_pwd"                 : UserOfJava.user_pwd,
        "user_mail"                 : UserOfJava.user_mail,
        "user_phonenumber": UserOfJava.user_phonenumber,
        "user_pic"                   : UserOfJava.user_pic,
        "register_date"           : UserOfJava.register_date,
        "user_role"                  : UserOfJava.user_role.role_name,
        "user_level"                 : UserOfJava.user_level.lv_name
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
 */
function showAllUsers(User) {
    $("#bm_user_list_table_users").append(
    "<tr>"
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


