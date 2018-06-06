/**
 * 全局通用的js
 * 在这边初始化对插件的使用
 */
$(function() {

	if($('[data-toggle="validate"]').length > 0) {
		$('[data-toggle="validate"]').validate({
			errorElement: "em", //可以用其他标签，记住把样式也对应修改
            success: function(label) {
                //label指向上面那个错误提示信息标签em
                label.text(" ")        //清空错误提示消息
                    .addClass("");  //加上自定义的success类
            }
        });
	}


    // 返回按钮
    $(".sub-title").append("<button id='goBack'>返回</button>");
    var url=window.location.href;
    $("#goBack").click(function(){
        if(url.indexOf("page-import-questionnaire")>0){
            if($("#questionnaireForm").is(":hidden")){
                $("#select-area").hide();
                $("#questionnaireForm").show();
            }else{
                history.go(-1);
            }
        }else{
            history.go(-1);
        }
    });


});
function swalConfirm(warningText,confirmBtnText,cancelBtnText,callback){
    if(warningText==""){
        warningText="确认要删除吗？"
    }
    if(confirmBtnText==""){
        confirmBtnText="确定";
    }
    if(cancelBtnText==""){
        cancelBtnText="取消";
    }
    var img="";
        img=basePath+"/resources/global/img/question.png";

    swal({
            title:"",
            text: warningText,
            imageUrl :img,
            imageSize : "70x70",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: confirmBtnText,
            cancelButtonText:cancelBtnText,
            closeOnConfirm: false
        },
    	function(confirm){
            if(confirm){
                callback();

            }

        });
}

/**
 * text 为弹出的提示标题
 * time 为默认自动关闭时间1000即1秒
 * url 点击后跳转链接
 * type 类型 成功还是警告，成功即success 警告即warning
 * @param text
 * @param time
 * @param url
 * @param type
 */
function swalAlert(text,time,url,type){
    if(text==""){
        text="保存成功";
    };
    var img="";
    if(type=="warning"){
        img=basePath+"/resources/global/img/warning.png";
    }else{
        img=basePath+"/resources/global/img/success.png";
    }
    if(time==""){
        time=1000;
    }
    swal({
        title : '',
        text : text,
        confirmButtonColor:"#f08000",
        imageUrl : img,
        imageSize : "70x70",
        timer:time,
    },function(){
        console.log(url)
        if(url == "reload"){
            window.location.reload();
        }
        if(url != "" && url != "reload"){
            window.location.href=url;
        }

    });
}

/**
 * 图片回显公共方法
 * @param inputId
 * @param imgId
 */
// function imgReShow(inputId,imgId,width,height){
//     if(width==""||width==null){
//         width=150;
//     }
//     if(height=""||height==null){
//         height=150;
//     }
//     var fil=$("#"+inputId);
//     var fils=$("#"+inputId).get(0).files[0];  //得到file对象
//     var srcc=window.URL.createObjectURL(fils);     //传入的参数创建一个指向该参数对象的URL
//     $("#"+imgId).attr({'src':srcc,'width':width+'px','height':height+'px'});
//
// }
function imgReShow(inputId,imgId,width,height){
    if(width==""||width==null){
        width=150;
    }
    if(height=""||height==null){
        height=150;
    }
    var fil=$("#"+inputId);
    var fils=$("#"+inputId).get(0).files[0];  //得到file对象
    var srcc=window.URL.createObjectURL(fils);     //传入的参数创建一个指向该参数对象的URL
    $("#"+imgId).attr({'src':srcc,'width':width+'px','height':height+'px'});

}
/**
 * 敏感操作的警告框提示
 * @param Func 点击确认删除后执行的方法（点击取消退出弹框，不执行）
 * @param warningText 删除前的提示文本
 * @param btnText 确认按钮的文本
 */
function isDelete(Func,warningText,btnText) {
    swal({
        title : "",
        text : warningText,
        imageUrl : basePath+"/resources/global/img/question.png",
        imageSize : "70x70",
        showCancelButton : true,
        confirmButtonColor : "#DD6B55",
        confirmButtonText : btnText,
        cancelButtonText : "取消",
        closeOnConfirm : false,
    }, function(isConfirm) {
        if (isConfirm) {
            Func();
        }
    });
}

/**
 * 后台传递的JSON分页对象，包含相关分页数据
 * 此方法作用为相关总页数，每页显示数参数的设置和页面展示
 * @param pageInfo
 */
function loadPageInfo(pageInfo){
    var firstPageStr="<li onclick='Page(1,"+pageInfo.pageSize+");'><a href='javascript:;'>首页</a></li>";
    var prePageStr="";
    if(pageInfo.prePage==0){
        prePageStr="<li class='disabled' onclick='Page("+pageInfo.prePage+","+pageInfo.pageSize+");'><a href='javascript:;'>上一页</a></li>";
    }else{
        prePageStr="<li onclick='Page("+pageInfo.prePage+","+pageInfo.pageSize+");'><a href='javascript:;'>上一页</a></li>";
    }
    var nextPageStr="";
    if(pageInfo.nextPage==0){
        nextPageStr="<li class='disabled' onclick='Page("+pageInfo.nextPage+","+pageInfo.pageSize+");'><a href='javascript:;'>下一页</a></li>";
    }else{
        nextPageStr="<li onclick='Page("+pageInfo.nextPage+","+pageInfo.pageSize+");'><a href='javascript:;'>下一页</a></li>";
    }
    var lastPageStr="<li onclick='Page("+pageInfo.pages+","+pageInfo.pageSize+");'><a href='javascript:;'>末页</a></li>";
    var pageStr="";
    $(pageInfo.navigatepageNums).each(function(i,item){
        if(item==pageInfo.pageNum){
            pageStr=pageStr+"<li onclick='Page("+item+","+pageInfo.pageSize+")' class='active'><a href='javascript:;'>"+item+"</a></li>";
        }else{
            pageStr=pageStr+"<li onclick='Page("+item+","+pageInfo.pageSize+")'><a href='javascript:;'>"+item+"</a></li>";
        }
    });
    var totalPageStr=firstPageStr+prePageStr+pageStr+nextPageStr+lastPageStr;
    $(".pagination").empty();
    $(".pagination").append(totalPageStr);
}

/**
 * 为空判断函数
 * @param str1
 * @param str2
 * @returns {*}
 */
function ifNull(str1,str2){
	if(typeof str1 == 'number') {
		return str1;
	}
    if(str1==""||str1==null||typeof(str1)=="undefined"||str1=="undefined"){
        return str2;
    }
    return str1;

}
function ifEqNull(str1,str2,str3){

    if(str1==""||str1==null||typeof(str1)=="undefined"){
        return str2;
    }
    return str3;
}


/**
 * 如果str1=str2，则输出str3
 * @param str1
 * @param str2
 */
function ifValue(str1,str2,str3){
    if(str1==str2){
        return str3;
    }
    return str1;

}

/**
 * 根据条件判断显示值
 * @param condition
 * @param val1
 * @param val2
 * @returns {*}
 */
function ifTrue(condition,val1,val2){
    if(condition){
        return val1;
    }
    return val2;
}
function timeExchange(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }

    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    return y+"-"+m+"-"+d;
}

function timeChange(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }

    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h = data.getHours();
    var min = data.getMinutes();
    var s=data.getSeconds();
    return h+":"+min+":"+s;
}

function timeExchangeHM(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }
    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h = data.getHours();
    var min = data.getMinutes();
    return y + "-" + m + "-" + d + " " + h + ":" + min;
}


function timeExchangeHMS(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }
    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h = data.getHours();
    var min = data.getMinutes();
    var s=data.getSeconds();
    return y + "-" + m + "-" + d + " " + h + ":" + min + ":"+s;
}
/**
 * 提示插件
 * @param title
 * @returns
 */
function loading(title) {
    if(title==""){
        title="加载中...";
    }
    $('body').loading({
    	selector: 'body',
        loadingWidth:240,
        title:title,
        name:'bodyMsg',
        discription:'...',
        direction:'column',
        type:'origin',
        originBg:'rgba(120, 124, 123, 0.67)',
        originDivWidth:40,
        originDivHeight:40,
        originWidth:6,
        originHeight:6,
        smallLoading:false,
        loadingBg:'rgba(120, 124, 123, 0.67)',
        loadingMaskBg:'rgba(123,122,222,0.2)'
    });
}

/**
 * 根据val选中相应select的option
 * @param id
 * @param val
 */
function autoSelect(id,val){
    $("#"+id).find("option").each(function(i,item){
        if($(this).val()==val){
            $(this).attr("selected",true);
        }
    })
}

/**
 * 根据ID禁用或启用相关表单输入选择框
 * @param id
 * @param bool true或false
 */
function changeForm(id,bool){
    $("#"+id).find("input").each(function(i,item){
        $(this).attr("disabled",bool);
    });
    $("#"+id).find("select").each(function(i,item){
        $(this).attr("disabled",bool);
    });
    $("#"+id).find("textarea").each(function(i,item){
        $(this).attr("disabled",bool);
    });

}
function getRoleListForSelect(id,selectVal){
    $.ajax({
        url:basePath+'/management/user/getRoleList',
        async:false,
        type:'POST',
        success:function (result) {
            if(result.success){
                $("#"+id).find("option").remove();
                var option="";
                option=option+"<option value=''>请选择角色</option>";
                $("#"+id).append(option);
                $(result.data).each(function (i,item) {
                    var option="";
                    if(item.id==selectVal){
                        option=option+"<option value='"+item.id+"'selected>"+item.name+"</option>";
                    }else{
                        option=option+"<option value='"+item.id+"'>"+item.name+"</option>";
                    }

                    $("#"+id).append(option);
                });
            }else{
                swal({
                    title : '',
                    text : "加载角色列表失败",
                    confirmButtonColor:"#f08000",
                    imageUrl : basePath+"/resources/global/img/warning.png",
                    imageSize : "70x70",
                    timer:1000,
                },function(){

                });
            }


        }
    });
}

function getSampleStatusListForSelect(id,selectVal,surveyId){
    console.log(surveyId);
     getDictionaryListForSelectSampleStatus(id,selectVal,surveyId,"请选择样本状态");
     // getDictioanryListForSelect(id,selectVal,"sample_status","请选择样本状态");
}
function getKnowledgeTypeListForSelect(id,selectVal){
    getDictioanryListForSelectKnowledge(id,selectVal,"knowledge_type","请选择知识类型");
}
function getKnowledgeStatusListForSelect(id,selectVal){
    getDictioanryListForSelectKnowledge(id,selectVal,"knowledge_status","请选择知识状态");
}

/**
 * 通用获取字典表
 * @param id
 * @param selectVal
 * @param type
 * @param text
 */
function getDictioanryListForSelect(id,selectVal,type,text){
    $.ajax({
        url:basePath+'/dictionary/getDictionaryList',
        data:{
            "type":type
        },
        async:false,
        type:'POST',
        success:function (result) {
            if(result.success){
                $("#"+id).find("option").remove();
                var option="";
                option=option+"<option value=''>"+text+"</option>";
                $("#"+id).append(option);
                $(result.data).each(function (i,item) {
                    var option="";
                    if(item.id==selectVal){
                        option=option+"<option value='"+item.code+"'selected>"+item.codeDescription+"</option>";
                    }else{
                        option=option+"<option value='"+item.code+"'>"+item.codeDescription+"</option>";
                    }

                    $("#"+id).append(option);
                });
            }else{
                swal({
                    title : '',
                    text : "加载列表失败",
                    confirmButtonColor:"#f08000",
                    imageUrl : basePath+"/resources/global/img/warning.png",
                    imageSize : "70x70",
                    timer:1000,
                },function(){

                });
            }


        }
    });
}
/**
 * 通用获取字典表
 * @param id
 * @param selectVal
 * @param type
 * @param text
 */
function getDictionaryListForSelectSampleStatus(id,selectVal,surveyId,text){
    console.log(surveyId)
    $.ajax({
        url:basePath+'/dictionary/getStatusList',
        data:{
            "surveyId":surveyId,
        },
        async:false,
        type:'POST',
        success:function (result) {
            if(result.success){
                $("#"+id).find("option").remove();
                var option="";
                option=option+"<option value=''>"+text+"</option>";
                $("#"+id).append(option);
                $(result.data).each(function (i,item) {
                    var option="";
                    if(item.id==selectVal){
                        option=option+"<option value='"+item.code+"'selected>"+item.codeDescription+"</option>";
                    }else{
                        option=option+"<option value='"+item.code+"'>"+item.codeDescription+"</option>";
                    }

                    $("#"+id).append(option);
                });
            }else{
                swal({
                    title : '',
                    text : "加载列表失败",
                    confirmButtonColor:"#f08000",
                    imageUrl : basePath+"/resources/global/img/warning.png",
                    imageSize : "70x70",
                    timer:1000,
                },function(){

                });
            }


        }
    });
}
/**
 * 知识模块获取下拉菜单（需要这样写：item.code==selectVal）
 * @param id
 * @param selectVal
 * @param type
 * @param text
 */
function getDictioanryListForSelectKnowledge(id,selectVal,type,text){
    $.ajax({
        url:basePath+'/dictionary/getDictionaryList',
        data:{
            "type":type
        },
        async:false,
        type:'POST',
        success:function (result) {
            if(result.success){
                $("#"+id).find("option").remove();
                var option="";
                option=option+"<option value=''>"+text+"</option>";
                $("#"+id).append(option);
                $(result.data).each(function (i,item) {
                    var option="";
                    if(item.code==selectVal){
                        option=option+"<option value='"+item.code+"'selected>"+item.codeDescription+"</option>";
                    }else{
                        option=option+"<option value='"+item.code+"'>"+item.codeDescription+"</option>";
                    }

                    $("#"+id).append(option);
                });
            }else{
                swal({
                    title : '',
                    text : "加载角色列表失败",
                    confirmButtonColor:"#f08000",
                    imageUrl : basePath+"/resources/global/img/warning.png",
                    imageSize : "70x70",
                    timer:1000,
                },function(){

                });
            }


        }
    });
}
/**
 * 用户类型下拉列表
 * @param id
 * @param selectVal
 */
function getUserTypeListForSelect(id,selectVal){
    getDictioanryListForSelect(id,selectVal,"user_type","请选择用户类型");
}

/**
 * 调查项目状态下拉列表
 * @param id
 * @param selectVal
 */
function getSurveyStatusListForSelect(id,selectVal){
    getDictioanryListForSelect(id,selectVal,"survey_status","请选择项目状态");
}

/**
 * 获取cadi样本属性列表
 * @param id
 * @param selectVal
 * @param surveyId
 */
function getCadiSamplePropertyDicListForSelect(id,selectVal,surveyId){
    $.ajax({
        url:basePath+'/cadi/sample/getCadiSamplePropertyDicListForSelect',
        data:{
            "surveyId":surveyId
        },
        async:false,
        type:'POST',
        success:function (result) {
            if(result.success){
                $("#"+id).find("option").remove();
                var option="";
                option=option+"<option value=''>请选择属性列表</option>";
                $("#"+id).append(option);
                $(result.data).each(function (i,item) {
                    var option="";
                    if(item.id==selectVal){
                        option=option+"<option value='"+item.code+"'selected>"+item.name+"</option>";
                    }else{
                        option=option+"<option value='"+item.code+"'>"+item.name+"</option>";
                    }

                    $("#"+id).append(option);
                });
            }else{
                swal({
                    title : '',
                    text : "加载属性列表失败",
                    confirmButtonColor:"#f08000",
                    imageUrl : basePath+"/resources/global/img/warning.png",
                    imageSize : "70x70",
                    timer:1000,
                },function(){

                });
            }


        }
    });
}

function audioFileName(timestamp) {
    var date = new Date(timestamp);
    Y = date.getFullYear();
    M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1);
    D = (date.getDate() + 1 < 10 ? '0' + (date.getDate() + 1) : date.getDate() + 1);

    h = (date.getHours() + 1 < 10 ? '0' + (date.getHours() + 1) : date.getHours() + 1);
    m = (date.getMinutes() + 1 < 10 ? '0' + (date.getMinutes() + 1) : date.getMinutes() + 1);
    s = (date.getSeconds() + 1 < 10 ? '0' + (date.getSeconds() + 1) : date.getSeconds() + 1);

    return Y + M + D + h + m + s;
}




