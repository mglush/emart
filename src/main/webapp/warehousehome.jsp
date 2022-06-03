<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eMart Home Page</title>

    <link rel="stylesheet" href="./resources/css/index.css">

</head>

<h2>Warehouse tools</h2>
<h3>Choose an action:</h3>
<body>
    <form method="post" action="/emart/searchQuantity.html">
        <input type="submit" class="button" id="searchQuantity" value="Search product availability" />
    </form>
    <form method="post" action="/emart/shippingNotice.jsp">
        <input type="submit" class="button" id="shippingnotice" value="Process shipping notices" />
    </form>

</body>
</html>