
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
                        <form id="userForm"  class="form-horizontal" action="${ctx}/admin/saveProductCat" method="post">
                            <div id="demo-accordion" class="panel-group accordion">
                                <div class="panel">

                                    <!-- Accordion title -->
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-parent="#demo-accordion" data-toggle="collapse" href="#demo-acc-panel-1">商品分类详情</a>
                                        </h4>
                                    </div>

                                    <!-- Accordion content -->
                                    <div  >
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">分类名称</label>
                                                <div class="col-lg-7">
                                                    <input type="hidden" name="id" value="${productCat.id}">
                                                    <input type="text" class="form-control" name="catName" placeholder="请输入分类详情" value="${productCat.catName}" required>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">顺序</label>
                                                <div class="col-lg-7">
                                                    <input type="number" class="form-control" name="orderBy" id="password" placeholder="请输入分类顺序" value="${productCat.orderBy}" required>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-lg-7 col-lg-offset-3">
                                                    <button type="submit" class="btn btn-primary" name="signup" value="保存">保存</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </form>
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
        $("#userForm").ajaxForm({
            beforeSubmit:function () {

            },
            success:function (result) {
                if(result.success){
                    window.location.href="/admin/product_cat/list";
                }
            }

        });
    });




</script>
</body>
</html>