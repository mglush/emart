<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eMart</title>

    <script>
        function updateImageId()
        {

        }
    </script>

    <link rel="stylesheet" href="./resources/css/products.css">
</head>
<body>
<center>
<h1>
    Found Products
</h1>
<%
List<String> result = (List<String>) request.getAttribute("products");
out.println("<br>We found the following products:" + "<br><br>");
Iterator it = result.iterator();
while (it.hasNext()) {
    out.println(it.next() + "<br>");
}
%>
<!--<figure class="imageFigure" style="width: 1250px; height: 600px;">-->
<!--    <a class="image" id="laptop" href="/emart">-->
<!--        <img alt="Laptop" src="https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp-spacegray-select-202011_GEO_US?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1632948875000"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->
<!--    <a class="image" id="desktop" href="/emart">-->
<!--        <img alt="Desktop" src="https://png.pngitem.com/pimgs/s/493-4933521_mac-desktop-png-tile-game-widget-mac-transparent.png"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->
<!--    <a class="image" id="printer" href="/emart">-->
<!--        <img alt="Printer" src="https://st2.depositphotos.com/3562409/5316/i/600/depositphotos_53161005-stock-photo-printer.jpg"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->
<!--    <a class="image" id="camera" href="/emart">-->
<!--        <img alt="Camera" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6409/6409982_sd.jpg;maxHeight=640;maxWidth=550"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->

<!--    <a class="image" id="software" href="/emart">-->
<!--        <img alt="software" src="https://brandongaille.com/wp-content/uploads/2013/07/Microsoft-Company-Logo.jpg"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->

<!--    <a class="image" id="monitor" href="/emart">-->
<!--        <img alt="monitor" src="https://www.publicdomainpictures.net/pictures/20000/nahled/computer-monitor-isolated-113001152897GC.jpg"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->

<!--    <a class="image" id="temp3" href="/emart">-->
<!--        <img alt="temp3" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6409/6409982_sd.jpg;maxHeight=640;maxWidth=550"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->

<!--    <a class="image" id="temp4" href="/emart">-->
<!--        <img alt="temp4" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6409/6409982_sd.jpg;maxHeight=640;maxWidth=550"-->
<!--             style="float: left; width: 24%; height:40%; margin-right: 1%; margin-bottom: 0.5em;">-->
<!--    </a>-->
<!--    <p style="clear: both;">-->
<!--</figure>-->

</body>
</html>