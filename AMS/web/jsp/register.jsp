<%--
    Assignment Management System (AMS)
    Sign-up interface of AMS.
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
            String idNum = request.getParameter("id_number");
            String realName = request.getParameter("name");
            char ocChar = idNum.charAt(0);
            int occupation = -1;
            // Check the id_number and define occupation
            if(ocChar == 's') {
                occupation = 0;
            }
            else if(ocChar == 't') {
                occupation = 1;
            }
            else {
                occupation = -1;
            }
            if(occupation >= 0) {
                User newUser = new User(0, userName, userPassword, occupation, idNum, realName);
                Transaction ams = new Transaction();
                if(ams.signup(newUser)) {
                    session.setAttribute("succeed_flag", true);
                }
                else {
                    session.setAttribute("succeed_flag", false);
                }
            }
            else {
                session.setAttribute("succeed_flag", false);
            }
            response.sendRedirect("signup.jsp");
        %>
    </body>
</html>