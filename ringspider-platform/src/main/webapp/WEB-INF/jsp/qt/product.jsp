
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag.jsp" %>
<html>
<head>
    <%@ include file="../common/meta.jsp" %>
</head>
<body>
<c:set var="menuFlag"  value= "product"></c:set>
    <%@ include file="../common/menu.jsp" %>



<div class="mianbao zong">
    <a href="${ctx}/">Home</a> / <a href="${ctx}/product/" class="co5e">Products</a></div>
<div class="prmain zong">
    <div class="prnav">
        <div class="img-scroll">
            <span class="prev"></span>
            <span class="next"></span>
            <div class="img-list">
                <ul style="margin-left: 0px;">
                    <li>
                        <a href="http://www.wellpower4.com/wireless-charger/">Wireless Charger</a>
                    </li>            <li>
                    <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/">3 in 1 USB Charging Cable</a>
                </li>            <li>
                    <a href="http://www.wellpower4.com/bluetooth-earphone-headphone/">Bluetooth Earphone Headphone</a>
                </li><li>
                    <a href="http://www.wellpower4.com/usb-c-cable/">USB-C Cable</a>
                </li><li>
                    <a href="http://www.wellpower4.com/mfi-cable/">MFI Cable</a>
                </li><li>
                    <a href="http://www.wellpower4.com/el-light-up-usb-cable/">EL Light Up  USB Cable</a>
                </li><li>
                    <a href="http://www.wellpower4.com/charger/">Charger</a>
                </li><li>
                    <a href="http://www.wellpower4.com/el-light-earphone/">EL Light Earphone</a>
                </li><li>
                    <a href="http://www.wellpower4.com/micro-usb-cable/">MICRO USB Cable</a>
                </li><li>
                    <a href="http://www.wellpower4.com/lightning-earphone/">Lightning Earphone</a>
                </li></ul>
            </div>
        </div>
    </div><form action="http://www.wellpower4.com/inquiry_list.php" method="post" enctype="multipart/form-data">


    <c:forEach items="${result.data}" var="o">
    <div class="chanlie ">
        <div class="chantu">
            <a href="#" title="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android" class="chantun"><img src="${ctx}/uploaded/${o.productMainPic}" alt="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android" title="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android"></a>
            <div class="chanfu">
                <a href="${ctx}/getProductById">Read</a>
            </div>
            <input type="checkbox" name="id[]" value="${o.id}">
        </div>
        <a class="chanzi" href="http://www.wellpower4.com/3-in-1-usb-charging-cable/902.html" title="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android">${o.productName}</a>
        <%--点击跳转到立即咨询按钮--%>
        <a href="${ctx}/concat_us" class="chanmor">Inquire Now</a>
    </div>
    </c:forEach>



    <div class="clear"></div>
    <div class="fenye">
        <div class="fenyen">
            <a class="sx no">Previous</a><a class="dangqianfen">1</a><a href="http://www.wellpower4.com/products/list-2.html">2</a><a href="http://www.wellpower4.com/products/list-3.html">3</a><a href="http://www.wellpower4.com/products/list-4.html">4</a><a href="http://www.wellpower4.com/products/list-5.html">5</a><a href="http://www.wellpower4.com/products/list-2.html" class="sx">Next</a><div class="clear"></div>
        </div>
        <div class="fuxuan"><input type="submit" value="Add to Inquiry List"></div>
        <div class="clear"></div>
    </div>
</form>
</div>
<div class="hotmain zong">
    <a href="http://www.wellpower4.com/products/" class="hotbiao">hot products</a>
    <div class="img-scroll2">
        <div class="hotnav">
            <span class="prev2"></span>
            <span class="next2"></span>
        </div>
        <div class="img-list2">
            <ul>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/bluetooth-earphone-headphone/bluetooth sports headphones earphones .html" title="Wireless Sports Headphones Bluetooth V4.1 EDR Stereo Headset Earphones With Mic  Hands Free Calling" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2018/0403/20180403035300541.jpg" title="Wireless Sports Headphones Bluetooth V4.1 EDR Stereo Headset Earphones With Mic  Hands Free Calling"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/bluetooth-earphone-headphone/bluetooth sports headphones earphones .html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/bluetooth-earphone-headphone/bluetooth sports headphones earphones .html" class="hotzi" title="Wireless Sports Headphones Bluetooth V4.1 EDR Stereo Headset Earphones With Mic  Hands Free Calling">Wireless Sports Headphones Bluetoo...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/mfi-cable/ 2 in 1 Lightning and Micro USB Charging Cable.html" title=" 2 in 1 Lightning and Micro USB Charging Cable" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2018/0324/20180324110735191.jpg" title=" 2 in 1 Lightning and Micro USB Charging Cable"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/mfi-cable/ 2 in 1 Lightning and Micro USB Charging Cable.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/mfi-cable/ 2 in 1 Lightning and Micro USB Charging Cable.html" class="hotzi" title=" 2 in 1 Lightning and Micro USB Charging Cable"> 2 in 1 Lightning and Micro USB Ch...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/904.html" title="3 in 1 Type -C /Lightning /Micro USB Phone Charger Charging Cable for Apple iPone and Android device" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2018/0205/20180205051419219.jpg" title="3 in 1 Type -C /Lightning /Micro USB Phone Charger Charging Cable for Apple iPone and Android device"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/904.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/904.html" class="hotzi" title="3 in 1 Type -C /Lightning /Micro USB Phone Charger Charging Cable for Apple iPone and Android device">3 in 1 Type -C /Lightning /Micro U...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/903.html" title="3 in 1 Type -C /Lightning /Micro USB Phone Charger Charging Cable for Apple iPone and Android device" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2018/0205/20180205051419219.jpg" title="3 in 1 Type -C /Lightning /Micro USB Phone Charger Charging Cable for Apple iPone and Android device"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/903.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/903.html" class="hotzi" title="3 in 1 Type -C /Lightning /Micro USB Phone Charger Charging Cable for Apple iPone and Android device">3 in 1 Type -C /Lightning /Micro U...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/902.html" title="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2018/0205/20180205025346885.jpg" title="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/902.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/902.html" class="hotzi" title="3 in 1 Type -C /Lightning /Micro USB Charging Cable -Sync/Charge for Apple and Android">3 in 1 Type -C /Lightning /Micro U...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/wireless-charger/wirelss-charger.html" title="Qi certified wireless charging stand 5W 7.5W 10W for iPhone X/8/8plus" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2018/0131/20180131032239535.jpg" title="Qi certified wireless charging stand 5W 7.5W 10W for iPhone X/8/8plus"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/wireless-charger/wirelss-charger.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/wireless-charger/wirelss-charger.html" class="hotzi" title="Qi certified wireless charging stand 5W 7.5W 10W for iPhone X/8/8plus">Qi certified wireless charging sta...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/el-light-earphone/el-glowing-light-sports-earphone-with-mic-ep005.html" title="EL Glowing Light Sports Earphone with MIC EP005" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2017/0321/20170321112149657.jpg" title="EL Glowing Light Sports Earphone with MIC EP005"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/el-light-earphone/el-glowing-light-sports-earphone-with-mic-ep005.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/el-light-earphone/el-glowing-light-sports-earphone-with-mic-ep005.html" class="hotzi" title="EL Glowing Light Sports Earphone with MIC EP005">EL Glowing Light Sports Earphone w...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/el-light-up-usb-cable/el-visible-type-c to-usb-flowing-flat-cable-ldf004.html" title="EL Visible  Type-C to USB Flowing Flat Cable LDF004" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2017/0321/20170321111545523.jpg" title="EL Visible  Type-C to USB Flowing Flat Cable LDF004"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/el-light-up-usb-cable/el-visible-type-c to-usb-flowing-flat-cable-ldf004.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/el-light-up-usb-cable/el-visible-type-c to-usb-flowing-flat-cable-ldf004.html" class="hotzi" title="EL Visible  Type-C to USB Flowing Flat Cable LDF004">EL Visible  Type-C to USB Flowing ...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/usb-c-cable/usb-c3-to-usb-c3-cable-with-metal-tp005.html" title="USB-C(3.0) to USB-C(3.0) Cable With Metal TP005" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2017/0321/20170321105133549.jpg" title="USB-C(3.0) to USB-C(3.0) Cable With Metal TP005"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/usb-c-cable/usb-c3-to-usb-c3-cable-with-metal-tp005.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/usb-c-cable/usb-c3-to-usb-c3-cable-with-metal-tp005.html" class="hotzi" title="USB-C(3.0) to USB-C(3.0) Cable With Metal TP005">USB-C(3.0) to USB-C(3.0) Cable Wit...</a>
                </li>

                <li>
                    <div class="hottu">
                        <a href="http://www.wellpower4.com/usb-c-cable/usb-a-to-usb-c-cable-with-metal-tp003.html" title="USB-A to USB-C Cable With Metal TP003" class="hottun"><img src="http://www.wellpower4.com/uploadfile/2017/0321/20170321104900118.jpg" title="USB-A to USB-C Cable With Metal TP003"></a>
                        <div class="chanfu"><a href="http://www.wellpower4.com/usb-c-cable/usb-a-to-usb-c-cable-with-metal-tp003.html">Read</a></div>
                    </div>
                    <a href="http://www.wellpower4.com/usb-c-cable/usb-a-to-usb-c-cable-with-metal-tp003.html" class="hotzi" title="USB-A to USB-C Cable With Metal TP003">USB-A to USB-C Cable With Metal TP...</a>
                </li>
            </ul>
        </div>
    </div>
    <script type="text/javascript" src="js/qiehuan.js"></script>
</div>
<div class="prne zong">
    <a href="http://www.wellpower4.com/news/" class="hotbiao">Latest NEWS</a>
    <div class="m7lie fl maln">
        <div class="m7shijian"><a>08</a><p>Apr 2018</p></div>
        <div class="m7zi">
            <a href="http://www.wellpower4.com/news/car-charger-for-sale.html" title="We supply car charger for sale">We supply car charger for sale</a>
            <p><a href="http://www.wellpower4.com/news/car-charger-for-sale.html" title="Our car charger for sale is quite affordable to many people, with many models costing less than ten dollars.">Our car charger for sale is quite affordable to many people, with many models costing less than ten dollars.</a></p>
        </div>
    </div>
    <div class="m7lie fr maln">
        <div class="m7shijian"><a>02</a><p>Apr 2018</p></div>
        <div class="m7zi">
            <a href="http://www.wellpower4.com/news/luminous-earphone.html" title="How to choose your headphones?">How to choose your headphones?</a>
            <p><a href="http://www.wellpower4.com/news/luminous-earphone.html" title="To be more comfortable you may also want luminous earphone.">To be more comfortable you may also want luminous earphone.</a></p>
        </div>
    </div>
    <div class="clear"></div>
</div>
<ul class="prr zong">
    <li><a href="http://www.wellpower4.com/usb-c-cable/">USB-C Cable</a></li>          <li><a href="http://www.wellpower4.com/mfi-cable/">MFI Cable</a></li>          <li><a href="http://www.wellpower4.com/el-light-up-usb-cable/">EL Light Up  USB Cable</a></li>          <li><a href="http://www.wellpower4.com/charger/">Charger</a></li>          <li><a href="http://www.wellpower4.com/el-light-earphone/">EL Light Earphone</a></li>          <li><a href="http://www.wellpower4.com/micro-usb-cable/">MICRO USB Cable</a></li>          <li><a href="http://www.wellpower4.com/lightning-earphone/">Lightning Earphone</a></li>          <li><a href="http://www.wellpower4.com/wireless-charger/">Wireless Charger</a></li>          <li><a href="http://www.wellpower4.com/3-in-1-usb-charging-cable/">3 in 1 USB Charging Cable</a></li>          <li><a href="http://www.wellpower4.com/bluetooth-earphone-headphone/">Bluetooth Earphone Headphone</a></li>
</ul>

    <%@ include file="../common/bottom.jsp" %>

</body>
</html>