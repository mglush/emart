<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Contents</title>
    <link rel="stylesheet" href="./resources/css/product.css">
    <script>
    function otherFeatures() {
        window.location.href = "/emart/home.jsp";
    }
    </script>
</head>
<body>
<center>
<%
out.println("<h1> Previous Order #" + request.getSession().getAttribute("order") + ". </h1>");
List<String> result = (List<String>) request.getSession().getAttribute("cart");
out.println("<br><br><br>");
if (result != null) {
    Iterator it = result.iterator();
    while (it.hasNext()) {
        out.println(it.next() + "<br>");
    }
}
out.println("<br><br>Cart subtotal: $" + request.getSession().getAttribute("subtotal"));
out.println("<br>Discount: " + Float.valueOf(Float.valueOf(request.getSession().getAttribute("discount").toString()) * -100).toString() + "%");
out.println("<br>Shipping and handling: " + Float.valueOf(Float.valueOf(request.getSession().getAttribute("shipping").toString()) * 100).toString() + "%");
out.println("<br>Cart total: $" + request.getSession().getAttribute("total"));
%>
    <button class="otherWebsiteFeaturesButton" type="button" onclick="otherFeatures()">Home Page</button>
</body>
</html>