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
        
        <h1>List of cities...</h1>
        <table>
            <thead>
                <tr>
                    <th>City code</th>
                    <th>City name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cities}" var="cityDto">
                 <tr>
                    <td>${cityDto.ptt}</td>
                    <td>${cityDto.naziv}</td>
                    <td>Action</td>
                </tr>                    
                </c:forEach>
            </tbody>
            
        </table>
    </body>
</html>
