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
                src="${ctx}/resources/img/logo.png" title="High Quality EL Light Up USB Cable, Earphone, MFI Cable Quote, Factory"
                alt="High Quality EL Light Up USB Cable, Earphone, MFI Cable Quote, Factory"></a></div>
        <ul class="daohang">
            <li><a href="${ctx}" <c:if test="${menuFlag == 'home'}">class="dangqiandao"</c:if> >Home</a></li>
            <li><a href="${ctx}/product" <c:if test="${menuFlag == 'product'}">class="dangqiandao"</c:if>>Products</a>
                <ul class="yiji">
                    <li><a href="http://www.wellpower4.com/usb-c-cable/">USB-C Cable</a></li>
                    <li><a href="http://www.wellpower4.com/mfi-cable/">MFI Cable</a></li>
                    <li><a href="http://www.wellpower4.com/el-light-up-usb-cable/">EL Light Up USB Cable</a></li>
                    <li><a href="http://www.wellpower4.com/charger/">Charger</a></li>
                    <li><a href="http://www.wellpower4.com/el-light-earphone/">EL Light Earphone</a></li>
                    <li><a href="http://www.wellpower4.com/micro-usb-cable/">MICRO USB Cable</a></li>
                    <li><a href="http://www.wellpower4.com/lightning-earphone/">Lightning Earphone</a></li>
                    <li><a href="http://www.wellpower4.com/wireless-charger/">Wireless Charger</a></li>
                    <li><a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/">3 in 1 USB Charging Cable</a>
                    </li>
                    <li><a href="http://www.wellpower4.com/bluetooth-earphone-headphone/">Bluetooth Earphone
                        Headphone</a></li>
                </ul>
            </li>
            <li><a href="${ctx}/about_us" <c:if test="${menuFlag == 'about_us'}">class="dangqiandao"</c:if>>About Us</a></li>
            <li><a href="${ctx}/news" <c:if test="${menuFlag == 'news'}">class="dangqiandao"</c:if>>News</a></li>
            <li><a href="${ctx}/support" <c:if test="${menuFlag == 'support'}">class="dangqiandao"</c:if>>SUPPORT</a></li>
            <li><a href="${ctx}/concat_us" <c:if test="${menuFlag == 'concat_us'}">class="dangqiandao"</c:if>">Contact Us</a></li>


            <%--<li><a href="http://www.wellpower4.com/" class="dangqiandao">Home</a></li>--%>
            <%--<li><a href="http://www.wellpower4.com/products/">Products</a>--%>
                <%--<ul class="yiji">--%>
                    <%--<li><a href="http://www.wellpower4.com/usb-c-cable/">USB-C Cable</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/mfi-cable/">MFI Cable</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/el-light-up-usb-cable/">EL Light Up USB Cable</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/charger/">Charger</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/el-light-earphone/">EL Light Earphone</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/micro-usb-cable/">MICRO USB Cable</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/lightning-earphone/">Lightning Earphone</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/wireless-charger/">Wireless Charger</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/">3 in 1 USB Charging Cable</a>--%>
                    <%--</li>--%>
                    <%--<li><a href="http://www.wellpower4.com/bluetooth-earphone-headphone/">Bluetooth Earphone--%>
                        <%--Headphone</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li><a href="http://www.wellpower4.com/about-us/">About Us</a>--%>
                <%--<ul class="yiji">--%>
                    <%--<li><a href="http://www.wellpower4.com/company-profile/">Company Profile</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/factory-tour/">Factory Tour</a>--%>
                        <%--<ul class="erji">--%>
                            <%--<li><a href="http://www.wellpower4.com/working-environment/">Working Environment</a></li>--%>
                            <%--<li><a href="http://www.wellpower4.com/prodution-site/">Prodution Site</a></li>--%>
                            <%--<li><a href="http://www.wellpower4.com/equipment/">Equipment</a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li><a href="http://www.wellpower4.com/certificates/">Certificates</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li><a href="http://www.wellpower4.com/news/">News</a></li>--%>
            <%--<li><a href="http://www.wellpower4.com/video/">Video</a>--%>
                <%--<ul class="yiji">--%>
                    <%--<li><a href="http://www.wellpower4.com/video-classification-1/">Video Classification 1</a></li>--%>
                    <%--<li><a href="http://www.wellpower4.com/video-classification-2/">Video Classification 2</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li><a href="http://www.wellpower4.com/guestbook/">Contact Us</a></li>--%>
            <div class="clear"></div>
        </ul>
        <div class="clear"></div>
    </div>
</div>


<iframe id="google_osd_static_frame_2601350684115" name="google_osd_static_frame"
        style="display: none; width: 0px; height: 0px;"></iframe>
<div class="slide_container">
    <ul class="rslides" id="slider">
        <li><a href="http://www.wellpower4.com/products/" class="pic" title="Bluetooth Headset"> <img class="pic"
                                                                                                      src="img/banner1.jpg"
                                                                                                      alt="Bluetooth Headset"
                                                                                                      title="Bluetooth Headset">
        </a></li>
        <li><a href="http://www.wellpower4.com/el-light-earphone/" class="pic" title="Earphone"> <img class="pic"
                                                                                                      src="img/banner2.jpg"
                                                                                                      alt="Earphone"
                                                                                                      title="Earphone">
        </a></li>
        <li><a href="http://www.wellpower4.com/el-light-up-usb-cable/" class="pic" title="El Light Cable"> <img
                class="pic" src="img/banner3.jpg" alt="El Light Cable" title="El Light Cable"></a></li>
        <li><a href="http://www.wellpower4.com/micro-usb-cable/" class="pic" title="MFI usb Cable"> <img class="pic"
                                                                                                         src="img/banner4.jpg"
                                                                                                         alt="MFI usb Cable"
                                                                                                         title="MFI usb Cable"></a>
        </li>
        <li><a href="http://www.wellpower4.com/charger/" class="pic" title="Charger"> <img class="pic"
                                                                                           src="img/banner5.jpg"
                                                                                           alt="Charger"
                                                                                           title="Charger"></a></li>
    </ul>
</div>
<div class="carousel" id="carousel">
    <ul>
        <li style="transition: none; transform: translate3d(0px, 0px, 0px);"><a
                href="http://www.wellpower4.com/products/"><img src="img/banner1.jpg" alt="Bluetooth Headset"></a></li>
        <li style="transition: none;"><a href="http://www.wellpower4.com/el-light-earphone/"><img src="img/banner2.jpg"
                                                                                                  alt="Earphone"></a>
        </li>
        <li style="transition: none;"><a href="http://www.wellpower4.com/el-light-up-usb-cable/"><img
                src="img/banner3.jpg" alt="El Light Cable"></a></li>
        <li style="transition: none;"><a href="http://www.wellpower4.com/micro-usb-cable/"><img src="img/banner4.jpg"
                                                                                                alt="MFI usb Cable"></a>
        </li>
        <li style="transition: none;"><a href="http://www.wellpower4.com/charger/"><img src="img/banner5.jpg"
                                                                                        alt="Charger"></a></li>
    </ul>
    <ol>
        <li class="cur"></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ol>
    <div class="bafu"><img src="img/hudu.png" title="" alt=""></div>
</div>

<div class="clear"></div>
