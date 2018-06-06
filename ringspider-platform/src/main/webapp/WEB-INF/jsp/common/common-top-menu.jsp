<!-- 导航条 -->
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div class="page-header">
	<!-- BEGIN HEADER TOP -->
	<div class="page-header-top">
		<div class="">
			<nav class="nav-bar navbar-default">
				<div class="container-header">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="true">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a href="${ctx}/collect_project/list" class="navbar-brand">
							<img src="${ctx}/resources/global/img/logo.png" alt="logo" class="logo-default">
						</a>
					</div>
					<div class="navbar-collapse collapse in" id="bs-example-navbar-collapse-1" aria-expanded="true" style="">
						<ul class="nav navbar-nav navbar-right">
							<li <c:if test="${menuFlag == 'project'}">class="active"</c:if>  >
								<a href="${ctx}/collect_project/list"><i class="fa fa-home"></i>我的项目</a>
							</li>
							<li <c:if test="${menuFlag == 'spider'}">class="active"</c:if>  >
								<a href="${ctx}/spider/spider_list"><i class="fa fa-pencil-square-o"></i>爬虫模版</a>
							</li>
							<li <c:if test="${menuFlag == 'application'}">class="active"</c:if> >
								<a href="${ctx}/application/list"><i class="fa fa-briefcase"></i>应用中心</a>
							</li>
							<li <c:if test="${menuFlag == 'usercenter'}">class="active"</c:if>>
								<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
									<i class="fa fa-user fa-fw"></i>
									<span class="dropdown-text">${sessionScope.ringspider_user.username}</span>
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li><a href="${ctx}/user/profile-acount"><i class="icon-user"></i> 个人账户 </a></li>
									<%--<li><a href="${ctx}/user/profile-manage"><i class="icon-calendar"></i> 用户管理 </a> </li>--%>
									<li><a href="${ctx}/user/profile-help"> <i class="icon-info"></i> 帮助中心 </a> </li>
									<li><a href="${ctx}/logout"> <i class="icon-key"></i> 退出 </a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- END HEADER TOP -->
</div>