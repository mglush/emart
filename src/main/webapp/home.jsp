<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eMart Home Page</title>

    <link rel="stylesheet" href="./resources/css/index.css">
</head>
<h1>CS174a Project by Michael Glushchenko.</h1>
<h2>Welcome to our online store!</h2>
<h3>Choose the product search method:</h3>
<body>
    <form action="/emart/searchProducts.html">
        <input type="submit" class="button" value="Search for products" />
    </form>

    <form action="/emart/searchCompatibleProducts.html">
        <input type="submit" class="button" value="Search for compatible products." />
    </form>
<%
if (request.getSession().getAttribute("manager").equals("true")) {
%>
    <form action="/emart/home.html">
        <input type="submit" class="button" id="managerButton" value="Filler -- will be a button for the manager to manage store" />
    </form>
<%
}
%>
</body>
</html>