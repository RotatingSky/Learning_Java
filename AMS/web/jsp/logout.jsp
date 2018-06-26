<%--
    Assignment Management System (AMS)
    Created for students.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("signin.jsp");
        %>
    </body>
</html>