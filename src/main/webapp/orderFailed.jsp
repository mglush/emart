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
    We sincerely apologize, one of the items you chose is out of stock. Go ahead and try again.
</h1>
<button type="button" onclick="otherFeatures()">Home Page</button>
</body>
</html>