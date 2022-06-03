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
        Customer status has been successfully changed!
    </h1>
<%
String previousCustomer = request.getSession().getAttribute("previousCustomer").toString();
%>
    <h2>
        This was the customer information before the change:
    </h2>
<%
    out.println("<br>" + previousCustomer + "<br><br>");
%>
<%
String customerToPrint = request.getSession().getAttribute("customerToPrint").toString();
%>
    <h2>
        Here is the information about the customer now:
    </h2>
<%
    out.println("<br>" + customerToPrint + "<br><br>");
%>

    <form method="post" onclick=goBack()>
        <button class="goBackButton" type="submit">Go Back</button>
    </form>
    <form method="post" action="/emart/manager.html">
        <button class="otherWebsiteFeaturesButton" type="submit">Manager Home</button>
    </form>

</body>
</html>