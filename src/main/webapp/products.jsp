<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eMart</title>
    <link rel="stylesheet" href="./resources/css/products.css">
    <script>
    function goBack() {
        window.history.back()
    }
    </script>
</head>
<body>
<center>
<h1>
    Found Products
</h1>
<%
request.getSession().setAttribute("currStockNumber", "");
%>
<%
if (request.getSession().getAttribute("AA00101") == "true") {
%>
  <a class="image" id="laptopImage">
      <form method="post" action="/emart/DisplayProduct">
          <p class = "header" id="laptopHeader" style="text-align:justify; color:white;background:black;" onClick="confused();">AA00101</p>
          <img alt="Laptop" src="https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp-spacegray-select-202011_GEO_US?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1632948875000"
               style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
          <button type="submit" name="checkDetailsButton" value="AA00101">See Details</button>
      </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00201") == "true") {
%>
  <a class="image" id="desktopImage">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="desktopHeader" style="text-align:justify; color:white;background:black;">AA00201</p>
      <img alt="desktopImage" src="https://i.dell.com/is/image/DellContent//content/dam/ss2/product-images/dell-client-products/desktops/optiplex-desktops/5090-sff/pdp/desktop_optiplex_5090_sff_pdp_mod.psd?fmt=pjpg&pscan=auto&scl=1&wid=3584&hei=3383&qlt=100,0&resMode=sharp2&size=3584,3383"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00201">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00202") == "true") {
%>
  <a class="image" id="desktopImage">
      <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="desktopHeader2" style="text-align:justify; color:white;background:black;">AA00202</p>
      <img alt="desktopImage2" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/9703/9703523_ra.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00202">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00301") == "true") {
%>
  <a class="image" id="monitorImage">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="monitorHeader" style="text-align:justify; color:white;background:black;">AA00301</p>
      <img alt="monitorImage" src="https://c1.neweggimages.com/ProductImage/24-197-015-02.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00301">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00302") == "true") {
%>
  <a class="image" id="monitorImage2">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="monitorHeader2" style="text-align:justify; color:white;background:black;">AA00302</p>
      <img alt="monitorImage2" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6404/6404835_rd.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00302">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00401") == "true") {
%>
  <a class="image" id="softwareImage">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="softwareImage" style="text-align:justify; color:white;background:black;">AA00401</p>
      <img alt="softwareImage" src="https://yt3.ggpht.com/1vIT_uqWhP7T_ko4t2rCnXErXmt891dGX0CVl--NtR7E38aq1W6mwrYCzq-v1HAdanS8vE0K=s900-c-k-c0x00ffffff-no-rj"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00401">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00402") == "true") {
%>
  <a class="image" id="softwareImage2">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="softwareImage2" style="text-align:justify; color:white;background:black;">AA00402</p>
      <img alt="softwareImage2" src="https://i5.walmartimages.com/asr/aa0c80ce-3319-4ef7-8b61-eb8c85d82342_1.c96ca9371ac19ff3e670348900e92824.jpeg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00402">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00501") == "true") {
%>
  <a class="image" id="printerImage">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="printerImage" style="text-align:justify; color:white;background:black;">AA00501</p>
      <img alt="printerImage" src="https://st2.depositphotos.com/3562409/5316/i/600/depositphotos_53161005-stock-photo-printer.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00501">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00601") == "true") {
%>
  <a class="image" id="cameraImage">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="cameraImage" style="text-align:justify; color:white;background:black;">AA00601</p>
      <img alt="cameraImage" src="https://www.dpreview.com/files/p/articles/9681242405/Images/hpr707frontview.jpeg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00601">See Details</button>
    </form>
  </a>
<%
}
if (request.getSession().getAttribute("AA00602") == "true") {
%>
  <a class="image" id="cameraImage2">
    <form method="post" action="/emart/DisplayProduct">
      <p class = "header" id="cameraImage2" style="text-align:justify; color:white;background:black;">AA00602</p>
      <img alt="cameraImage2" src="https://www.lifewire.com/thmb/U9YbRm9hD61WuJXo13b4-VNpN5E=/900x0/filters:no_upscale():max_bytes(150000):strip_icc()/CanonPowerShotSX70-78e77997720547d4ac1c2cc3f62fd7dc.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="checkDetailsButton" value="AA00602">See Details</button>
    </form>
  </a>
<%
}
%>
<button class="goBackButton" id="goBackButton" type="button" onclick="goBack()">Go Back</button>
<p style="clear: both;">
</body>
</html>