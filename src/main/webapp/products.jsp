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
out.println("<br>We have <br><br>");
Iterator it = result.iterator();
while (it.hasNext()) {
    out.println(it.next() + "<br>");
}
%>
</body>
</html>