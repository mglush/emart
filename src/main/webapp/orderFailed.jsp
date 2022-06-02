<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Failed</title>
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
    We sincerely apologize, one of the items you chose is out of stock. Go ahead and try again.
</h1>
<button type="button" onclick="goBack()">Go Back</button>
</body>
</html>