<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eMart Home Page</title>

    <link rel="stylesheet" href="./resources/css/index.css">
    <script type="text/javascript">
        $(function () {
            $('#orderViewButton').click(function () {
                if ($('#orderViewInput').val() == "") {
                    $('#orderViewValueRequired').show();
                    return false;
                }
                $('#orderViewValueRequired').hide();
            });
        });
    </script>
</head>
<h1>CS174a Project by Michael Glushchenko.</h1>
<h2>Welcome to the home page of our online store!</h2>
<h3>Choose the product search method:</h3>
<body>
    <form action="/emart/searchProducts.html">
        <input type="submit" class="button" value="Search for products" />
    </form>

    <form action="/emart/searchCompatibleProducts.html">
        <input type="submit" class="button" value="Search for compatible products" />
    </form>

    <form method="post" action="/emart/ViewCart">
        <input type="submit" class="viewCartButton" value="View Cart" />
    </form>

    <form method="post" action="/emart/ViewOrder">
        <input type="submit" class="viewingOrder" id="orderViewButton" value="View Order" />
        <input type="text" class="viewingOrder" id="orderViewInput" placeholder="Enter an order number!" name="orderToView" size="21" maxlength="100">
    </form>
    <span class="viewingOrder" id="orderViewValueRequired" style="display:none;color:white;background:black;">Enter order number to perform this action!</span>

    <form method="post" action="/emart/RerunOrder">
        <input type="submit" class="runningOrder" id="orderRunButton" value="Re-run Order" />
        <input type="text" class="runningOrder" id="orderRunInput" placeholder="Enter an order number!" name="orderToRun" size="21" maxlength="100">
    </form>
    <span class="runningOrder" id="orderToRunValueRequired" style="display:none;color:white;background:black;">Enter order number to perform this action!</span>
<%
if (request.getSession().getAttribute("manager").equals("true")) {
%>
    <form method="post" action="/emart/home.jsp">
        <input type="submit" class="button" id="managerButton" value="Filler -- will be a button for the manager to manage store" />
    </form>
<%
}
%>
</body>
</html>