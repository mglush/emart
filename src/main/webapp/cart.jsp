<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Contents</title>
    <link rel="stylesheet" href="./resources/css/product.css">
    <script>
    function shopMore() {
        window.history.go(-3)
    }
    </script>
</head>
<body>
<center>
    <h1>
        Current cart contents.
    </h1>
<%
List<String> result = (List<String>) request.getSession().getAttribute("cart");
out.println("<br><br><br>");
if (result != null) {
    Iterator it = result.iterator();
    while (it.hasNext()) {
        out.println(it.next() + "<br>");
    }
    out.println("Cart subtotal: $" + request.getSession().getAttribute("subtotal"));
}
%>
    <form method="post" action="/emart/RemoveItem">
        <input type="text" class="removeItemInput" id="removeItemInput" placeholder="Enter stock number to remove!" name="removeStockNumber" size="42" maxlength="100">
        <button class="removeItemButton" id="removeItemButton" type="submit">Remove from cart</button>
    </form>
    <form method="post" action="/emart/Checkout">
        <button class="cartPageButtonProceedToCheckout" type="submit">Proceed to checkout</button>
    </form>
    <form method="post" action="/emart/home.jsp">
        <button class="cartPageButtonShopMore" type="submit">Shop more items</button>
    </form>

<%
if (result == null) {
%>
<h2>
There is currently nothing in your cart.
</h2>
<%}%>
</body>
</html>