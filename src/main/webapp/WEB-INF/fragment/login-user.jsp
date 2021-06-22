<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/application/logout" var="urlLogout"></c:url>
<div>
    User:${loginUser.email} <a href="${urlLogout}">Logout</a>
</div>