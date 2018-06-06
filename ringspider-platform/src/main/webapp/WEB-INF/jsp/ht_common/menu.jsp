<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!--MAIN NAVIGATION-->
<!--===================================================-->
<nav id="mainnav-container">
    <div id="mainnav">

        <!--Menu-->
        <!--================================-->
        <div id="mainnav-menu-wrap">
            <div class="nano">
                <div class="nano-content">

                    <!--Profile Widget-->
                    <!--================================-->
                    <div id="mainnav-profile" class="mainnav-profile">
                        <div class="profile-wrap">
                            <div class="pad-btm">


                            </div>
                            <a href="#profile-nav" class="box-block" data-toggle="collapse" aria-expanded="false">
                                            <span class="pull-right dropdown-toggle">
                                                <i class="dropdown-caret"></i>
                                            </span>
                                <p class="mnp-name">Admin</p>
                                <span class="mnp-desc">邮箱@qq.com</span>
                            </a>
                        </div>
                        <div id="profile-nav" class="collapse list-group bg-trans">
                            <a href="#" class="list-group-item">
                                <i class="demo-pli-male icon-lg icon-fw"></i> 查看头像
                            </a>
                            <a href="#" class="list-group-item">
                                <i class="demo-pli-gear icon-lg icon-fw"></i> 设置
                            </a>
                            <a href="#" class="list-group-item">
                                <i class="demo-pli-information icon-lg icon-fw"></i> 帮助
                            </a>
                            <a href="#" class="list-group-item">
                                <i class="demo-pli-unlock icon-lg icon-fw"></i> 登出
                            </a>
                        </div>
                    </div>




                    <ul id="mainnav-menu" class="list-group">

                        <!--Category name-->
                        <li class="list-header">菜单</li>

                        <!--Menu list item-->
                        <li class="active-link">
                            <a href="/">
                                <i class="psi-home"></i>
                                <span class="menu-title">
												<strong>主页</strong>
											</span>
                            </a>
                        </li>


                        <!--Menu list item-->
                        <li>
                            <a href="${ctx}/admin/user/list">
                                <i class="psi-evil"></i>
                                <span class="menu-title">用户管理</span>

                            </a>
                        </li>
                        <li>
                            <a href="${ctx}/admin/product_cat/list">
                                <i class="psi-police-station"></i>
                                <span class="menu-title">商品分类管理</span>

                            </a>
                        </li>
                        <li>
                            <a href="${ctx}/admin/product/list">
                                <i class="psi-police-station"></i>
                                <span class="menu-title">商品管理</span>

                            </a>
                        </li>
                        <li>
                            <a href="${ctx}/admin/news/list">
                                <i class="psi-police-station"></i>
                                <span class="menu-title">新闻管理</span>

                            </a>
                        </li>
                        <li>
                            <a href="${ctx}/admin/message/list">
                                <i class="psi-police-station"></i>
                                <span class="menu-title">留言管理</span>

                            </a>
                        </li>
                        <li>
                            <a href="${ctx}/admin/setting/list">
                                <i class="psi-police-station"></i>
                                <span class="menu-title">网站设置</span>

                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>
        <!--================================-->
        <!--End menu-->

    </div>
</nav>
