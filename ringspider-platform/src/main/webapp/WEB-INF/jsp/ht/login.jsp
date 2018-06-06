
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../ht_common/tag.jsp" %>
<html>
<head>
    <%@ include file="../ht_common/meta.jsp" %>
</head>

<body>
<div id="container" class="cls-container">

    <!-- BACKGROUND IMAGE -->
    <!--===================================================-->
    <div id="bg-overlay"></div>


    <!-- LOGIN FORM -->
    <!--===================================================-->
    <div class="cls-content">
        <div class="cls-content-sm panel">
            <div class="panel-body">
                <div class="mar-ver pad-btm">

                    <br>
                    <h3 class="h4 mar-no">欢迎来到后台管理系统!</h3>
                    <p class="text-muted">请登录</p>
                </div>
                <form id="userLogin" action="${ctx}/admin/doLogin" method="post">
                    <div class="form-group">
                        <input type="text" style="height: auto;" name="username" class="form-control" placeholder="请输入用户名称" autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password" style="height: auto;" name="password" class="form-control" placeholder="请输入用户密码" value="">
                    </div>
                    <!--<div class="checkbox pad-btm text-left">-->
                    <!--<input id="demo-form-checkbox" class="magic-checkbox" type="checkbox">-->
                    <!--<label for="demo-form-checkbox">记住用户名</label>-->
                    <!--</div>-->
                    <button class="btn btn-primary btn-lg btn-block" type="submit">登录</button>
                </form>
            </div>

            <div class="pad-all">


                <!--<div class="media pad-top bord-top">-->
                <!--<div class="pull-right">-->
                <!--<a href="#" class="pad-rgt"><i class="demo-psi-facebook icon-lg text-primary"></i></a>-->
                <!--<a href="#" class="pad-rgt"><i class="demo-psi-twitter icon-lg text-info"></i></a>-->
                <!--<a href="#" class="pad-rgt"><i class="demo-psi-google-plus icon-lg text-danger"></i></a>-->
                <!--</div>-->
                <!--<div class="media-body text-left">-->
                <!--第三方登录-->
                <!--</div>-->
                <!--</div>-->
            </div>
        </div>
    </div>
    <!--===================================================-->
</div>
<!--===================================================-->
<!-- END OF CONTAINER -->
<script>
    $(function () {
        $("#userLogin").ajaxForm({
            success:function (result) {
                if(result.success){
                    window.location.href="${ctx}/admin/home";
                }
            }

        });
    })
</script>
</body>
</html>