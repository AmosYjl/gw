/**
 * 分页JS
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
 * BootBox插件
 * @param size
 * @param title
 * @param message
 * @param callback
 */
function alertBootBox(message) {
    bootbox.alert({
        buttons: {
            ok: {
                label: '好的',
            }
        },
        message: message
    })
}
function confirmBootBox(message,callback) {
    bootbox.confirm({
        message: message,
        buttons: {
            confirm: {
                label: '确认',
            },
            cancel: {
                label: '取消',
            }
        },
        callback: callback
    })
}
function messageLoading(title) {
    if(title==""){
        title="加载中，请稍候....";
    }
    $('body').loading({
        loadingWidth:240,
        title:title,
        name:'bodyMsg',
        discription:'',
        direction:'column',
        type:'origin',
        // originBg:'#71EA71',
        originDivWidth:40,
        originDivHeight:40,
        originWidth:6,
        originHeight:6,
        smallLoading:false,
        loadingMaskBg:'rgba(0,0,0,0.2)'
    });
    setTimeout(function () {
        removeLoading('bodyMsg');
    }, 2000);
}

/**
 * 移除消息弹框
 */
function removeMessageLoading(){
    removeLoading("bodyMsg");
}
/**
 * 弹框确认公用函数
 * title:标题,message:提示内容,callback:点击确认后的函数
 * @param title
 * @param message
 * @param callback
 */
function alertConfirm(title,message,callback) {
    if(title == ""){
        title = "提示";
    }
    if(message == ""){
        message = "请确认您的操作";
    }

    $.myConfirm({
        title:title,
        message:message,
        callback:callback
    })
}

/**
 * 弹框提示函数
 * @param message
 */
function alertMessage(message) {
    $.myAlert(message);

}

/**
 * 时间格式转换
 * @param time
 * @returns {*}
 */
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
function timeExchange2(time){
    if(time==""||typeof (time)=="undefined"||typeof (time)=="null"||time==null){
        return "";
    }

    var data = new Date(time);
    var y = data.getFullYear();//年
    var m = data.getMonth() + 1;//月
    var d = data.getDate();//日
    var h= data.getHours();
    var s= data.getSeconds();
    return y+"-"+m+"-"+d+" "+h+":"+s;
}