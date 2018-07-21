
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../ht_common/tag.jsp" %>
<html>
<head>
    <%@ include file="../ht_common/meta.jsp" %>
</head>
<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">

    <!--NAVBAR-->
    <%@ include file="../ht_common/header.jsp" %>
    <div class="boxed">
        <!--===================================================-->
        <div id="content-container">
            <!--Page Title-->
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <div id="page-title">
                <h1 class="page-header text-overflow">导航</h1>

                <!--Searchbox-->
                <div class="searchbox">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="搜索">
                        <span class="input-group-btn">
                                <button class="text-muted" type="button"><i class="demo-pli-magnifi-glass"></i></button>
                            </span>
                    </div>
                </div>
            </div>
            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
            <!--End page title-->

            <!--Page content-->
            <!--===================================================-->
            <div id="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">留言列表</h3>
                            </div>
                            <!--Data Table-->
                            <!--===================================================-->
                            <div class="panel-body">
                                <div class="pad-btm form-inline">
                                    <div class="row">
                                        <div class="col-sm-6 table-toolbar-left">



                                        </div>
                                        <div class="col-sm-6 table-toolbar-right">
                                            <div class="form-group">
                                                <input type="text"  autocomplete="off" class="form-control" placeholder="Search" id="keyWord">
                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="table-responsive">
                                    <table class="table table-striped" style="min-height: 150px;">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>用户</th>
                                            <th>邮箱</th>
                                            <th>电话</th>
                                            <th>详情</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody id="tbody">
                                        </tbody>
                                    </table>
                                </div>
                                <hr>
                                <div class="pull-right">
                                    <ul class="pagination text-nowrap mar-no">
                                        <li class="page-pre disabled">
                                            <a href="#">&lt;</a>
                                        </li>
                                        <li class="page-number active">
                                            <span>1</span>
                                        </li>
                                        <li class="page-number">
                                            <a href="#">2</a>
                                        </li>
                                        <li class="page-number">
                                            <a href="#">3</a>
                                        </li>
                                        <li>
                                            <span>...</span>
                                        </li>
                                        <li class="page-number">
                                            <a href="#">9</a>
                                        </li>
                                        <li class="page-next">
                                            <a href="#">&gt;</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <!--===================================================-->
                            <!--End Data Table-->

                        </div>
                    </div>
                </div>



            </div>
            <!--===================================================-->
            <!--End page content-->


        </div>
        <!--===================================================-->
        <!--END CONTENT CONTAINER-->






        <!--菜单-->
        <%@ include file="../ht_common/menu.jsp" %>

    </div>
    <%@ include file="../ht_common/bottom.jsp" %>

</div>
<script>
    $(function () {
        Page(1,10);
    });

    $("body").on("click",".messageEdit",function () {
        var id = $(this).attr("data-id");
        window.location.href="${ctx}/admin/message/detail?id="+id;
    });
    $("body").on("click",".messageDelete",function () {
        var id = $(this).attr("data-id");
        $.ajax({
            url:'${ctx}/admin/messageDelete',
            data:{
                "id":id
            },
            type:'POST',
            success:function () {
                alert("删除成功!");
                Page(1,10);
            }
        })

    });



    function Page(page,showCount) {
        var keyWord = $("#keyWord").val();
        $.ajax({
            url:'${ctx}/admin/getMessageListPage',
            data:{
                "page":page,
                "showCount":showCount,
                "keyWord":keyWord
            },
            type:'POST',
            success:function (result) {
                if(result.success){
                    $("#tbody").empty();
                    loadPageInfo(result.data);
                    $(result.data.list).each(function(i,item){
                        var pageStr="<tr>";
                        pageStr=pageStr+"<td >"+ifNull(item.id,"")+"</td>";
                        pageStr=pageStr+"<td >"+ifNull(item.username,"")+"</td>";
                        pageStr=pageStr+"<td >"+ifNull(item.email,"")+"</td>";
                        pageStr=pageStr+"<td >"+ifNull(item.phone,"")+"</td>";
                        pageStr=pageStr+"<td >"+ifNull(item.content,"")+"</td>";
                        pageStr=pageStr+"<td>" +
                            "<div class='btn-group dropdown'>" +
                            "<button type='button' class='btn btn-default dropdown-toggle' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>" +
                            "操作 <span class='caret'></span>" +
                            "</button> "+
                            "<ul class='dropdown-menu'>" +
                            "<li><a data-id='"+item.id+"'  class='messageEdit editDispatch' href='#'>编辑</a></li>" +
                            "<li class='survey-end-hide'><a data-id='"+item.id+"' class='messageDelete ' href='#'>删除</a></li>" +
                            "</ul>"+
                            "</div>"+
                            "</td>";
                        pageStr=pageStr+"<tr>";
                        $("#tbody").append(pageStr);
                    });

                }
            }
        })


    }
</script>
</body>
</html>