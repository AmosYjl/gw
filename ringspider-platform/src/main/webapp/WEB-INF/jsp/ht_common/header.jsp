<!-- 导航条 -->
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


	<header id="navbar">
		<div id="navbar-container" class="boxed">

			<!--Brand logo & name-->
			<!--================================-->
			<div class="navbar-header">
				<a href="index.html" class="navbar-brand">
					<img src="${ctx}/resources/img/logo.png" alt="Nifty Logo" class="brand-icon">
					<div class="brand-title">
						<span class="brand-text">${s_softName}</span>
					</div>
				</a>
			</div>
			<!--================================-->
			<!--End brand logo & name-->


			<!--Navbar Dropdown-->
			<!--================================-->
			<div class="navbar-content clearfix">
				<ul class="nav navbar-top-links pull-left">

					<!--Navigation toogle button-->
					<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
					<li class="tgl-menu-btn">
						<a class="mainnav-toggle" href="#">
							<i class="demo-pli-view-list"></i>
						</a>
					</li>
					<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
					<!--End Navigation toogle button-->



					<!--Notification dropdown-->
					<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
					<li class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle">
							<i class="demo-pli-bell"></i>
							<span class="badge badge-header badge-danger"></span>
						</a>
						<!-- 消息通知 -->
						<!--Notification dropdown menu-->
						<div class="dropdown-menu dropdown-menu-md">

							<div class="nano scrollable">
								<div class="nano-content">
									<ul class="head-list">

										<!-- Dropdown list-->
										<li>
											<a href="#">
												<div class="clearfix">
													<p class="pull-left">您好,欢迎使用本系统</p>

												</div>

											</a>
										</li>
									</ul>
								</div>
							</div>

							<!--Dropdown footer-->
							<div class="pad-all bord-top">
								<a href="#" class="btn-link text-dark box-block">
									<i class="fa fa-angle-right fa-lg pull-right"></i>查看全部
								</a>
							</div>
						</div>
					</li>
					<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
					<!--End notifications dropdown-->





				</ul>
				<ul class="nav navbar-top-links pull-right">



					<!--User dropdown-->
					<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
					<li id="dropdown-user" class="dropdown">
						<a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                                <span class="pull-right">
                                    <!--<img class="img-circle img-user media-object" src="img/profile-photos/1.png" alt="Profile Picture">-->
                                    <i class="demo-pli-male ic-user"></i>
                                </span>
							<div class="username hidden-xs">Admin</div>
						</a>


						<div class="dropdown-menu dropdown-menu-md dropdown-menu-right panel-default">






							<div class="pad-all text-right">
								<a href="pages-login.html" class="btn btn-primary">
									<i class="demo-pli-unlock"></i> 登出
								</a>
							</div>
						</div>
					</li>
					<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
					<!--End user dropdown-->


				</ul>
			</div>
			<!--================================-->
			<!--End Navbar Dropdown-->

		</div>
	</header>



