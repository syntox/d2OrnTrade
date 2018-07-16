buttonOfPageName = 'bm_hero_list';    //页面控制按钮所属页面名称

$(document).ready(function () {
    var pageNow = 1;   //默认当前页为1
    var pageSize = 2;    //默认每页显示2条用户数据
    var pageInit = 1;    //初始页码
    var heroAttrInit = "不限";    //初始页码
    // var buttonOfPageName = 'bm_hero_list';    //页面控制按钮所属页面名称
    localStorage.setItem("bm_hero_list_PageInfo", null);

    /**
     * 初始化属性选择按钮
     */
    hero_list_attr_select();
    /**
     * 初始化页面控制按钮
     */
    page_ctrl_init(buttonOfPageName, pageInit);
    /**
     * 按照pageNow显示pageSize条数据
     */
    var storage_pageInfo = selectHero(pageNow, pageSize, heroAttrInit);
    localStorage.setItem("bm_hero_list_PageInfo", JSON.stringify(storage_pageInfo));    //将分页信息转化为JSON字符串保存在浏览器端
    /**
     * 初始化页面控制按钮事件
     */
    bm_hero_list_page_ctrl_events(buttonOfPageName, pageInit, pageSize);
    /**
     * 调整页面控制按钮
     */
    page_ctrl_change(buttonOfPageName, JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")));

})

/**
 * 查找相应条件下的英雄
 * @param pageNow
 * @param pageSize
 * @param heroAttr
 * @return {*}
 */
function selectHero(pageNow, pageSize, heroAttr) {
    var pageInfo = null;     //创建页面信息对象

    $.ajax({
        type: "post",
        data: {"pageNow": pageNow, "pageSize": pageSize, "heroAttr": heroAttr},
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/hero/SelectHeroWithPage",
        async: false,
        success: function (data) {
            if (data.retCode === "666") {
                pageInfo = makePageInfo(data.retValue.pageInfo);     //存储分页信息
                for (var i = 0; i < data.retValue.heroes.length; i++) {
                    var hero = makeEveryHero(data.retValue.heroes[i]);         //存储英雄信息
                    showEveryHero(hero, i);     //显示每个英雄数据
                }
            } else if (data.retCode === "216") {
                alert("没有查找到英雄！");
            } else {
                alert("未知异常");
            }
        },
        error: function () {
            alert("服务器发生故障！");
        }
    });
    return pageInfo;     //返回页面信息对象
}

/**
 * 每次选择属性切换显示的英雄
 */
function hero_list_attr_select() {
    $("#bm_hero_list_attr_select").change(function () {
        var pageNow = 1;   //重新定义 默认当前页为1
        var pageSize = 2;    //重新定义 默认每页显示2条用户数据
        // alert($("#bm_hero_list_attr_select").val());
        list_clear_by_class("bm_hero_list_table_heros_tr");
        var storage_pageInfo = selectHero(pageNow, pageSize, $("#bm_hero_list_attr_select").val());
        localStorage.setItem("bm_hero_list_PageInfo", JSON.stringify(storage_pageInfo));    //将分页信息转化为JSON字符串保存在浏览器端
        /**
         * 调整页面控制按钮
         */
        page_ctrl_change(buttonOfPageName, JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")));
    })
}

/**
 * 功能 ： bm_hero_list分页控制点击事件
 */
function bm_hero_list_page_ctrl_events(buttonOfPageName, pageInit, pageSize) {
    /**
     * 第一页点击事件
     */
    $("#bm_hero_list_page_ctrl_first").bind("click", {
        buttonOfPageName: buttonOfPageName,
        pageInit: pageInit,
        pageSize: pageSize
    }, function (event) {
        list_clear_by_class("bm_hero_list_table_heros_tr");
        var pageInfo_temp = selectHero(event.data.pageInit, event.data.pageSize, $("#bm_hero_list_attr_select").val());
        page_ctrl_change(event.data.buttonOfPageName, pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
    /**
     * 上一页点击事件
     */
    $("#bm_hero_list_page_ctrl_pre").bind("click", {buttonOfPageName: buttonOfPageName}, function (event) {
        list_clear_by_class("bm_hero_list_table_heros_tr");
        var pageInfo_temp = selectHero(JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")).pageNow - 1, JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")).pageSize, $("#bm_hero_list_attr_select").val());
        page_ctrl_change(event.data.buttonOfPageName, pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
    /**
     * 下一页点击事件
     */
    $("#bm_hero_list_page_ctrl_next").bind("click", {buttonOfPageName: buttonOfPageName}, function (event) {
        list_clear_by_class("bm_hero_list_table_heros_tr");
        var pageInfo_temp = selectHero(JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")).pageNow + 1, JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")).pageSize, $("#bm_hero_list_attr_select").val());
        page_ctrl_change(event.data.buttonOfPageName, pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
    /**
     * 尾页点击事件
     */
    $("#bm_hero_list_page_ctrl_last").bind("click", {buttonOfPageName: buttonOfPageName}, function (event) {
        list_clear_by_class("bm_hero_list_table_heros_tr");
        var pageInfo_temp = selectHero(JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")).totalPageCount, JSON.parse(localStorage.getItem("bm_hero_list_PageInfo")).pageSize, $("#bm_hero_list_attr_select").val());
        page_ctrl_change(event.data.buttonOfPageName, pageInfo_temp);
        pageInfo_storage(pageInfo_temp);
    });
}

/**
 * 组装每一个英雄
 * @param heroOfJava
 */
function makeEveryHero(heroOfJava) {
    return {
        "hero_id": heroOfJava.hero_id,
        "hero_name": heroOfJava.hero_name,
        "hero_pic": heroOfJava.hero_pic,
        "attr_name": heroOfJava.hero_attribute.attr_name
    };
}


/**
 * <!--显示7个用户-->
 <!--<tr  class="bm_hero_list_table_heros_tr" id="list_table_heros_u1">-->
 <!--<td class="bm_hero_list_table_heros_hero_id"><p></p></td>-->
 <!--<td class="bm_hero_list_table_heros_hero_name"><p></p></td>-->
 <!--<td class="bm_hero_list_table_heros_hero_pic"><img src=''></img></td>-->
 <!--<td class="bm_hero_list_table_heros_hero_attr"><p></p></td>-->
 <!--</tr>-->
 */
function showEveryHero(hero, i) {
    $("#bm_hero_list_table_heros").append(
        "<tr class='bm_hero_list_table_heros_tr' id='list_table_heros_u" + i + "'>"
        + "<td class='bm_hero_list_table_heros_hero_id'><p>" + hero.hero_id + "</p></td>"
        + "<td class='bm_hero_list_table_heros_hero_name'><p>" + hero.hero_name + "</p></td>"
        + "<td class='bm_hero_list_table_heros_hero_pic'><img src='" + hero.hero_pic + "'></img></td>"
        + "<td class='bm_hero_list_table_heros_hero_attr'><p>" + hero.attr_name + "</p></td>"
        + "</tr>");
}

function pageInfo_storage(pageInfo) {
    localStorage.setItem("bm_hero_list_PageInfo", JSON.stringify(pageInfo));
}