<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Found Products
</h1>
<%
List<String> result = (List<String>) request.getAttribute("products");
out.println("<br>We have the following " + result.get(0).substring(result.get(0).indexOf("categoryName=") + 14, result.get(0).indexOf("price=") - 3).toLowerCase() + " products:" + "<br><br>");
Iterator it = result.iterator();
while (it.hasNext()) {
    out.println(it.next() + "<br>");
}
%>
</body>
</html>