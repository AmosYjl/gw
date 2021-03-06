
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
                        <form id="userForm"  class="form-horizontal" action="${ctx}/admin/saveSetting" method="post" enctype="multipart/form-data">
                            <div id="demo-accordion" class="panel-group accordion">
                                <div class="panel">

                                    <!-- Accordion title -->
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a data-parent="#demo-accordion" data-toggle="collapse" href="#demo-acc-panel-1">设置详情</a>
                                        </h4>
                                    </div>

                                    <!-- Accordion content -->
                                    <div  >
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">类型</label>
                                                <div class="col-lg-7">
                                                    <input type="hidden" name="id" value="${setting.id}">
                                                    <select id="settingType" class="form-control" name="settingType">
                                                        <option value="1">轮播图</option>
                                                        <option value="3">LOGO</option>
                                                        <option value="2">首页广告位一</option>
                                                        <option value="4">首页广告位二</option>
                                                        <option value="5">首页广告位三</option>
                                                        <option value="6">首页广告位四</option>
                                                        <option value="7">首页广告位五</option>
                                                        <option value="8">首页广告位六</option>
                                                        <option value="9">首页广告位七</option>
                                                    </select>

                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">背景图</label>
                                                <div class="col-lg-7">
                                                    <input type="hidden" name="settingValue" value="${setting.settingValue}">
                                                    <input type="file" class="form-control" name="file" placeholder="请输入选择图片" >
                                                </div>
                                            </div>
                                            <c:if test="${setting.settingValue!=null and setting.settingValue!=''}">
                                                <div class="form-group">
                                                    <label class="col-lg-3 control-label">背景图</label>
                                                    <div class="col-lg-7">
                                                        <img style="width: 80px;height: 80px;" src="${ctx}/uploaded/${setting.settingValue}">
                                                    </div>
                                                </div>
                                            </c:if>

                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">标题</label>
                                                <div class="col-lg-7">
                                                    <input type="text" class="form-control" name="settingTitle" placeholder="请输入设置标题" value="${setting.settingTitle}">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-lg-3 control-label">内容</label>
                                                <div class="col-lg-7">
                                                    <textarea type="text" class="form-control" id="settingDesc" name="settingDesc" placeholder="请输入设置详情" value="${setting.settingDesc}">
                                                    </textarea>
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
        autoSelect("settingType","${setting.settingType}");
        $("#userForm").ajaxForm({
            beforeSubmit:function () {

            },
            success:function (result) {
                if(result.success){
                    window.location.href="/admin/setting/list";
                }else{
                    alert(result.msg);
                }
            }

        });
    });




</script>
</body>
</html>