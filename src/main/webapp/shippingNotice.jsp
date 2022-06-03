<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QuantitySearch</title>
    <link rel="stylesheet" href="./resources/css/products.css">
</head>
<body>

<h1>
    Process the Warehouse's Automatically Generated Shipping Notices
</h1>
<%--<%--%>
<%--    if(request.getSession().getAttribute("AA00101") == "true"){--%>
<%--%>--%>
<%
    if(request.getSession().getAttribute("emptynotices") == "false"){
%>
<h3>
    Current shipping notices:${notices}
</h3>
<form>

</form>

<%
    } else {
%>
<h3>
    Currently no shipping notices to be processed
</h3>
<%
    }
%>
<%--<%--%>
<%--    }--%>
<%--%>--%>

</body>
</html>