/**
 *  功能： 组装pageInfo对象
 * @param pageInfoOfJava
 * @returns {{pageNow: *, pageSize: *, totalCount: *, totalPageCount: *, startPos: *, hasFirst: *, hasPre: *, hasNext: *, hasLast: *}}
 */
function makePageInfo(pageInfoOfJava){
    var thisPageInfo = {
        "pageNow": pageInfoOfJava.pageNow,
        "pageSize": pageInfoOfJava.pageSize,
        "totalCount": pageInfoOfJava.totalCount,
        "totalPageCount": pageInfoOfJava.totalPageCount,
        "startPos": pageInfoOfJava.startPos,
        "hasFirst": pageInfoOfJava.hasFirst,
        "hasPre": pageInfoOfJava.hasPre,
        "hasNext": pageInfoOfJava.hasNext,
        "hasLast": pageInfoOfJava.hasLast
    };
    return thisPageInfo;
}

/**
 *  功能： 初始化分页控制按钮
 */
function page_ctrl_init(buttonOfPageName, pageInit) {
    $("#"+buttonOfPageName+"_page_ctrl_first").attr("disabled","true");     //禁用第一页按钮
    $("#"+buttonOfPageName+"_page_ctrl_pre").attr("disabled","true");     //禁用上一页按钮
    $("#"+buttonOfPageName+"_page_ctrl_now").html("第"+pageInit+"页");     //修改当前页码
    $("#"+buttonOfPageName+"_page_ctrl_next").removeAttr("disabled");;     //启用下一页按钮
    $("#"+buttonOfPageName+"_page_ctrl_last").removeAttr("disabled");      //启用尾页按钮
}

/**
 * 功能 ： 调整分页控制按钮
 * @param pageInfo
 */
function page_ctrl_change(buttonOfPageName, pageInfo) {
    if(pageInfo.pageNow != null){
        $("#"+buttonOfPageName+"_page_ctrl_now").html("第"+pageInfo.pageNow+"页");    //当前页码设置
        if(pageInfo.pageNow === 1){
            $("#"+buttonOfPageName+"_page_ctrl_first").attr("disabled","true");     //禁用第一页按钮
            $("#"+buttonOfPageName+"_page_ctrl_pre").attr("disabled","true");     //禁用上一页按钮
        }else if(pageInfo.pageNow > 1){
            $("#"+buttonOfPageName+"_page_ctrl_first").removeAttr("disabled");      //启用第一页按钮
            $("#"+buttonOfPageName+"_page_ctrl_pre").removeAttr("disabled");      //启用上一页按钮
        }else{
            $("#"+buttonOfPageName+"_page_ctrl_first").attr("disabled","true");     //禁用第一页按钮
            $("#"+buttonOfPageName+"_page_ctrl_pre").attr("disabled","true");     //禁用上一页按钮
        }
        if(pageInfo.pageNow === pageInfo.totalPageCount){
            $("#"+buttonOfPageName+"_page_ctrl_next").attr("disabled","true");     //禁用下一页按钮
            $("#"+buttonOfPageName+"_page_ctrl_last").attr("disabled","true");     //禁用尾页按钮
        }else if(pageInfo.pageNow < pageInfo.totalPageCount){
            $("#"+buttonOfPageName+"_page_ctrl_next").removeAttr("disabled");     //启用下一页按钮
            $("#"+buttonOfPageName+"_page_ctrl_last").removeAttr("disabled");      //启用尾页按钮
        }else{
            $("#"+buttonOfPageName+"_page_ctrl_next").attr("disabled","true");     //禁用下一页按钮
            $("#"+buttonOfPageName+"_page_ctrl_last").attr("disabled","true");     //禁用尾页按钮
        }
    }
}

/**
 * 重新刷新分页内容
 * @param class_name
 */
function list_clear_by_class(class_name) {
    $("."+class_name+"").remove();
}

/**
 * 全局存储分页控制信息
 * @param pageInfo
 */
// function pageInfo_storage(pageInfo) {
//     localStorage.setItem("PageInfo", JSON.stringify(pageInfo));
// }