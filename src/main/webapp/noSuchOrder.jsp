<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Failed</title>
    <link rel="stylesheet" href="./resources/css/products.css">
    <script>
    function otherFeatures() {
        window.location.href = "/emart/home.jsp";
    }
    </script>
</head>
<body>
<center>
<h1>
    We apologize, but an order with this order number does not exist.
</h1>
<button type="button" onclick="otherFeatures()">Home Page</button>
</body>
</html>