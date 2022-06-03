<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Contents</title>
    <link rel="stylesheet" href="./resources/css/product.css">
    <script>
    function goBack() {
        window.history.back()
    }
    </script>
</head>
<body>
<center>
    <h1>
        Product price has been successfully changed!
    </h1>
<%
String previousProduct = request.getSession().getAttribute("previousProduct").toString();
%>
    <h2>
        This was the product information before the change:
    </h2>
<%
    out.println("<br>" + previousProduct + "<br><br>");
%>
<%
String productToPrint = request.getSession().getAttribute("productToPrint").toString();
%>
    <h2>
        Here is the information about the product now:
    </h2>
<%
    out.println("<br>" + productToPrint + "<br><br>");
%>

    <form method="post" onclick=goBack()>
        <button class="goBackButton" type="submit">Go Back</button>
    </form>
    <form method="post" action="/emart/manager.html">
        <button class="otherWebsiteFeaturesButton" type="submit">Manager Home</button>
    </form>

</body>
</html>