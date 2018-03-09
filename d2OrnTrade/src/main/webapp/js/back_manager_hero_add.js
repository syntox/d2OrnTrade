$(document).ready(function () {
    img_preView("bm_hero_add_form_pic", "img_preView");    //图片预览开启
    SelectAllHeroAttr();    //下拉控件显示所有可选的英雄属性

    /**
     * 确认提交
     */
    $("#bm_hero_add_form_submit").click(function () {
        var hero_temp = makeHeroObject();
        if (heroAddInfoCheck()) {
            $("#bm_hero_add_form").ajaxSubmit({
                type: "post",
                data: hero_temp,
                url: "/hero/insertOneHero",
                success: function (data) {
                    if (data.retCode === "666") {
                        alert("添加英雄成功");
                    } else if (data.retCode === "215") {
                        alert("添加英雄出现问题");
                    }
                },
                error: function () {
                    alert("服务器发生故障！");
                }
            });
        } else {
            alert("输入信息有误");
        }
    })
});



/**
 * 输入信息核对
 * @return {boolean}
 */
function heroAddInfoCheck() {
    var heroAddInfoCheck_flag = {
        "bm_hero_add_form_heroName": false,
        "bm_hero_add_form_pic": false
    };

    if ($("#bm_hero_add_form_heroName").val() !== null) {
        heroAddInfoCheck_flag.bm_hero_add_form_heroName = true;
    } else {
        heroAddInfoCheck_flag.bm_hero_add_form_heroName = false;
        $("#bm_hero_add_form_heroName_warning").text("内容不能为空").css("color", "red");
    }

    if ($("#bm_hero_add_form_pic").val() !== null) {
        heroAddInfoCheck_flag.bm_hero_add_form_pic = true;
    } else {
        heroAddInfoCheck_flag.bm_hero_add_form_pic = false;
        alert("请先上传图片");
    }

    if (heroAddInfoCheck_flag.bm_hero_add_form_pic === true &&
        heroAddInfoCheck_flag.bm_hero_add_form_heroName === true) {
        return true;
    } else {
        return false;
    }
}
/**
 * 组装添加英雄所需的英雄信息
 * @return {{hero_name: (*|jQuery), attr_name: (*|jQuery)}}
 */
function makeHeroObject() {
    return {
        "hero_name": $("#bm_hero_add_form_heroName").val(),
        "attr_name": $("#bm_hero_add_attr").val()
    };
}
/**
 * 查询所有可选的英雄属性
 */
function SelectAllHeroAttr() {
    // {"retCode":"666",
    // "retMessage":"查找所有英雄属性成功",
    //  "retValue":[{
    //                  "attr_id":1,
    //                  "attr_name":"力量",
    //                  "attr_desc":"力量型英雄"},
    //                  ...]}
    $.ajax({
        type: "post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: "/selectAllHeroAttr",
        async: false,
        success: function (data) {
            if (data.retCode === "666") {
                for (var i = 0; i < data.retValue.length; i++) {
                    var heroAttr_temp = makeHeroAttrObject(data.retValue[i]);
                    showheroAttrOptionInfo(heroAttr_temp);    //显示属性下拉内容
                }
            } else if (data.retCode === "214") {
                alert("属性查询出现问题");
            }
        },
        error: function () {
            alert("服务器发生故障!!!");
        }
    });
}
/**
 * 组装属性对象
 * @param retValue
 * @return {{attr_id: *, attr_name: *, attr_desc: *}}
 */
function makeHeroAttrObject(retValue) {
    return {
        "attr_id": retValue.attr_id,
        "attr_name": retValue.attr_name,
        "attr_desc": retValue.attr_desc
    };
}
/**
 * 显示属性下拉内容
 * @param heroAttr
 */
function showheroAttrOptionInfo(heroAttr) {
    $("#bm_hero_add_attr").append("<option>" + heroAttr.attr_name + "</option>");
}