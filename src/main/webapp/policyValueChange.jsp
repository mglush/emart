<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Contents</title>
    <link rel="stylesheet" href="./resources/css/product.css">
    <script>
    function goBack() {
        window.history.back()
    }
    </script>
</head>
<body>
<center>
    <h1>
        Policy value has successfully been chaned!
    </h1>
<%
String previousPolicy = request.getSession().getAttribute("previousPolicy").toString();
%>
    <h2>
        This was the policy information before the change:
    </h2>
<%
    out.println("<br>" + previousPolicy + "<br><br>");
%>
<%
String policyToPrint = request.getSession().getAttribute("policyToPrint").toString();
%>
    <h2>
        Here is the information about the policy now:
    </h2>
<%
    out.println("<br>" + policyToPrint + "<br><br>");
%>

    <form method="post" onclick=goBack()>
        <button class="goBackButton" type="submit">Go Back</button>
    </form>
    <form method="post" action="/emart/manager.html">
        <button class="otherWebsiteFeaturesButton" type="submit">Manager Home</button>
    </form>
</body>
</html>