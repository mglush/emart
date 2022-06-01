<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eMart</title>
    <link rel="stylesheet" href="./resources/css/products.css">
</head>
<body>
<center>
<h1>
    Product Details.
</h1>

<%
if (request.getSession().getAttribute("displayID").toString().equals("AA00101")) {
%>
  <a class="image">
    <form method="post" action="/emart/OrderLine">
      <img alt="Laptop" src="https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp-spacegray-select-202011_GEO_US?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1632948875000"
           style="width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00101">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00201")) {
%>
  <a class="image" id="desktopImage">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="desktopHeader" style="text-align:justify; color:white;background:black;">AA00201</p>
      <img alt="desktopImage" src="https://i.dell.com/is/image/DellContent//content/dam/ss2/product-images/dell-client-products/desktops/optiplex-desktops/5090-sff/pdp/desktop_optiplex_5090_sff_pdp_mod.psd?fmt=pjpg&pscan=auto&scl=1&wid=3584&hei=3383&qlt=100,0&resMode=sharp2&size=3584,3383"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
       <button type="submit" name="addToCartButton" value="AA00201">Add to cart</button>
       <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00202")) {
%>
  <a class="image" id="desktopImage">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="desktopHeader2" style="text-align:justify; color:white;background:black;">AA00202</p>
      <img alt="desktopImage2" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/9703/9703523_ra.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
       <button type="submit" name="addToCartButton" value="AA00202">Add to cart</button>
       <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
     </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00301")) {
%>
  <a class="image" id="monitorImage">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="monitorHeader" style="text-align:justify; color:white;background:black;">AA00301</p>
      <img alt="monitorImage" src="https://c1.neweggimages.com/ProductImage/24-197-015-02.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
       <button type="submit" name="addToCartButton" value="AA00301">Add to cart</button>
       <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
     </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00302")) {
%>
  <a class="image" id="monitorImage2">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="monitorHeader2" style="text-align:justify; color:white;background:black;">AA00302</p>
      <img alt="monitorImage2" src="https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6404/6404835_rd.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00302">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00401")) {
%>
  <a class="image" id="softwareImage">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="softwareImage" style="text-align:justify; color:white;background:black;">AA00401</p>
      <img alt="softwareImage" src="https://yt3.ggpht.com/1vIT_uqWhP7T_ko4t2rCnXErXmt891dGX0CVl--NtR7E38aq1W6mwrYCzq-v1HAdanS8vE0K=s900-c-k-c0x00ffffff-no-rj"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00401">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00402")) {
%>
  <a class="image" id="softwareImage2">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="softwareImage2" style="text-align:justify; color:white;background:black;">AA00402</p>
      <img alt="softwareImage2" src="https://i5.walmartimages.com/asr/aa0c80ce-3319-4ef7-8b61-eb8c85d82342_1.c96ca9371ac19ff3e670348900e92824.jpeg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00402">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00501")) {
%>
  <a class="image" id="printerImage">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="printerImage" style="text-align:justify; color:white;background:black;">AA00501</p>
      <img alt="printerImage" src="https://st2.depositphotos.com/3562409/5316/i/600/depositphotos_53161005-stock-photo-printer.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00501">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00601")) {
%>
  <a class="image" id="cameraImage">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="cameraImage" style="text-align:justify; color:white;background:black;">AA00601</p>
      <img alt="cameraImage" src="https://www.dpreview.com/files/p/articles/9681242405/Images/hpr707frontview.jpeg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00601">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
} if (request.getSession().getAttribute("displayID").toString().equals("AA00602")) {
%>
  <a class="image" id="cameraImage2">
    <form method="post" action="/emart/OrderLine">
      <p class = "header" id="cameraImage2" style="text-align:justify; color:white;background:black;">AA00602</p>
      <img alt="cameraImage2" src="https://www.lifewire.com/thmb/U9YbRm9hD61WuJXo13b4-VNpN5E=/900x0/filters:no_upscale():max_bytes(150000):strip_icc()/CanonPowerShotSX70-78e77997720547d4ac1c2cc3f62fd7dc.jpg"
           style="float: left; width: 250px; height:250px; margin-right: 1%; margin-bottom: 0.5em; display: block; margin:0auto;">
      <button type="submit" name="addToCartButton" value="AA00602">Add to cart</button>
      <input type="text" placeholder="quantity" name="quantityToAdd" style="text-align:justify;"> </input>
    </form>
  </a>
<%
}
%>

<%
out.println("<div style='float:left; padding:60px;'>" + "<br>Here's the product we are looking at:"  + "<br><br>"
    + "Stock Number = " + request.getSession().getAttribute("displayID").toString()  + "<br><br>"
    + "Category = " + request.getSession().getAttribute("displayCategory").toString()  + "<br><br>"
    + "Model Number = " + request.getSession().getAttribute("displayModelNumber").toString()  + "<br><br>"
    + "Warranty = " + request.getSession().getAttribute("displayWarranty").toString()  + "<br><br>"
    + "Price = " + request.getSession().getAttribute("displayPrice").toString()  + "<br><br>" + "</div>");
%>

<p style="clear: both;">

</body>
</html>