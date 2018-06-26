<%--
    Assignment Management System (AMS)
    Sign-in interface of AMS.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="com.ams.*" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String userName = request.getParameter("user_name");
            String userPassword = request.getParameter("password");
            User curUser = new User(0, userName, userPassword, 0, "", "");
            Transaction ams = new Transaction();
            if(ams.signin(curUser)) {
                session.setMaxInactiveInterval(30 * 60);
                session.setAttribute("user_name", userName);
                session.setAttribute("password", userPassword);
                session.setAttribute("id_number", curUser.getIDNum());
                session.setAttribute("real_name", curUser.getRealName());
                if(curUser.getOccupation() == 0) {
                    response.sendRedirect("student.jsp");
                }
                else if(curUser.getOccupation() == 1) {
                    response.sendRedirect("teacher.jsp");
                }
            }
            else {
                session.setAttribute("error_flag", true);
                response.sendRedirect("signin.jsp");
            }
        %>
    </body>
</html>