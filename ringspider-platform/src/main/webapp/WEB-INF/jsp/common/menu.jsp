<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="nav">
        <ul>
            <li><a href="${ctx}">Home</a></li>
            <li><a href="${ctx}/product">Products</a></li>
            <li><a href="${ctx}/about_us">About Us</a></li>
            <li><a href="${ctx}/news">News</a></li>
            <li><a href="${ctx}/support">SUPPORT</a></li>
            <li><a href="${ctx}/concat_us">Contact Us</a></li>
            <div class="clear"></div>
        </ul>
    </div>
    <div class="menubtn"><span class="one"></span> <span class="two"></span> <span class="three"></span></div>
</div>
<div class="head" id="head">
    <div class="zong1">
        <div class="search">
            <div id="sb-search" class="sb-search">
                <form name="productform" action="http://www.wellpower4.com/search.php" method="get">
                    <input class="sb-search-input fl" placeholder="" name="title" id="title" type="text">
                    <input class="sb-search-submit fl" type="submit" value=" " name="dosubmit">
                    <input type="hidden" value="176" name="catid">
                    <span class="sb-icon-search"></span>
                </form>
            </div>

            <script>
                new UISearch(document.getElementById('sb-search'));
            </script>
        </div>
        <div class="logo"><a href="http://www.wellpower4.com/"
                             title="High Quality EL Light Up USB Cable, Earphone, MFI Cable Quote, Factory"><img
                src="${ctx}/uploaded/${logoSetting.settingValue}" title="${logoSetting.settingTitle}"
                alt="${logoSetting.settingTitle}"></a></div>
        <ul class="daohang">
            <li><a href="${ctx}" <c:if test="${menuFlag == 'home'}">class="dangqiandao"</c:if> >Home</a></li>
            <li><a href="${ctx}/product" <c:if test="${menuFlag == 'product'}">class="dangqiandao"</c:if>>Products</a>
                <ul class="yiji">
                    <c:forEach items="${cats}" var="cat">
                        <li><a href="${ctx}/${cat.catName}/">${cat.catName}</a></li>
                    </c:forEach>
                </ul>
            </li>
            <li><a href="${ctx}/about_us" <c:if test="${menuFlag == 'about_us'}">class="dangqiandao"</c:if>>About Us</a></li>
            <li><a href="${ctx}/news" <c:if test="${menuFlag == 'news'}">class="dangqiandao"</c:if>>News</a></li>
            <li><a href="${ctx}/support" <c:if test="${menuFlag == 'support'}">class="dangqiandao"</c:if>>SUPPORT</a></li>
            <li><a href="${ctx}/concat_us" <c:if test="${menuFlag == 'concat_us'}">class="dangqiandao"</c:if>">Contact Us</a></li>



            <div class="clear"></div>
        </ul>
        <div class="clear"></div>
    </div>
</div>


<iframe id="google_osd_static_frame_2601350684115" name="google_osd_static_frame"
        style="display: none; width: 0px; height: 0px;"></iframe>
<div class="slide_container">
    <ul class="rslides" id="slider">
        <c:forEach  items="${pictures}" var="picture">
            <li><a href="http://www.wellpower4.com/products/" class="pic" title="${picture.settingTitle}"> <img class="pic"
                                                                                                          src="${ctx}/uploaded/${picture.settingValue}"
                                                                                                          alt="${picture.settingTitle}"
                                                                                                          title="">
            </a></li>
        </c:forEach>

    </ul>
</div>


<div class="clear"></div>
