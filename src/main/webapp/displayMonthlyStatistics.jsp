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
        Our monthly sales statistics are as follows:
    </h1>
<%
List<String> monthlyProductSales = (List<String>) request.getSession().getAttribute("monthlyProductSales");
%>
    <h2>
        Monthly sales by product:
    </h2>
<%
    Iterator it = monthlyProductSales.iterator();
    while (it.hasNext()) {
        out.println(it.next() + "<br>");
    }
%>
<%
List<String> monthlyCategorySales = (List<String>) request.getSession().getAttribute("monthlyCategorySales");
%>
    <h3>
        Monthly sales by category:
    </h3>
<%
    it = monthlyCategorySales.iterator();
    while (it.hasNext()) {
        out.println(it.next() + "<br>");
    }
%>
<%
String customerMostPurchase = request.getSession().getAttribute("customerMostPurchase").toString();
%>
    <h4>
        Customer who spent the most money in this store:
    </h4>
<%
out.println(customerMostPurchase + "<br>");
%>

    <form method="post" onclick=goBack()>
        <button class="goBackButton" type="submit">Go Back</button>
    </form>
    <form method="post" action="/emart/manager.html">
        <button class="otherWebsiteFeaturesButton" type="submit">Manager Home</button>
    </form>

</body>
</html>