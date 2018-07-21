
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
                        <form id="userForm"  class="form-horizontal" action="${ctx}/admin/saveProduct" method="post">
                            <div id="demo-accordion" class="panel-group accordion">
                                <div class="panel">

                                    <!-- Accordion title -->
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-parent="#demo-accordion" data-toggle="collapse" href="#demo-acc-panel-1">商品详情</a>
                                        </h4>
                                    </div>

                                    <!-- Accordion content -->
                                    <div  >
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">名称</label>
                                                <div class="col-lg-7">
                                                    <input type="hidden" name="id" value="${product.id}">
                                                    <input type="text" class="form-control" name="productName" placeholder="请输入商品详情" value="${product.productName}" required>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">详情</label>
                                                <div id="newsContent" style="width: 100px;"  class="col-lg-7">
                                                        <h4></h4>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">简介</label>
                                                <div class="col-lg-7">

                                                    <input type="text" class="form-control" name="productIntr" placeholder="请输入商品简介" value="${product.productIntr}" required>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">主图</label>
                                                <div class="col-lg-7">
                                                    <input type="file" class="form-control" name="file" >
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">分类</label>
                                                <div class="col-lg-7">
                                                   <select class="form-control" name="productCat">
                                                       <c:forEach items="${cats}" var="cat">
                                                           <c:if test="${cat.id == product.productCat}">
                                                               <option value="${cat.id}" selected>${cat.catName}</option>
                                                           </c:if>
                                                           <c:if test="${cat.id != product.productCat}">
                                                               <option value="${cat.id}">${cat.catName}</option>
                                                           </c:if>
                                                       </c:forEach>
                                                   </select>

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
        $('#newsContent').summernote({
            callbacks: {
                onImageUpload: function(files, editor, $editable) {
                    sendFile(files,editor,$editable);
                }
            }
        });
        function sendFile(files, editor, $editable) {
            var data = new FormData();
            data.append("file", files[0]);
            $.ajax({
                data : data,
                type : "POST",
                url : "${ctx}/admin/uploadFile", //图片上传出来的url，返回的是图片上传后的路径，http格式
                cache : false,
                contentType : false,
                processData : false,
                dataType : "json",
                success: function(data) {//data是返回的hash,key之类的值，key是定义的文件名
                    $('#summernote').summernote('insertImage', data.data);
                },
                error:function(){
                    alert("上传失败");
                }
            });
        }
        $("#userForm").ajaxForm({
            beforeSubmit:function () {

            },
            success:function (result) {
                if(result.success){
                    window.location.href="/admin/product/list";
                }
            }

        });
    });




</script>
</body>
</html>