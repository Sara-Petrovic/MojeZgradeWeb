<%-- 
    Document   : register
    Created on : Apr 28, 2021, 4:01:53 PM
    Author     : Sara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>This is home page</h1>

        <jsp:include page="../fragment/login-user.jsp" flush="true"/>

    </body>
</html>
