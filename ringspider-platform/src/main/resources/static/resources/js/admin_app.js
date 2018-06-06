
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