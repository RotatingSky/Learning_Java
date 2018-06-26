<%--
    Assignment Management System (AMS)
    Created for teacher to select submissions from database.
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
            request.setCharacterEncoding("UTF-8");
            String rmFlag = request.getParameter("remove_flag");
            if(rmFlag.equals("1")) {
                session.removeAttribute("current_subject_name");
                session.removeAttribute("submissions");
                response.sendRedirect("/web/jsp/download_assignment.jsp");
            }
            else if(rmFlag.equals("2")) {
                session.removeAttribute("current_subject_name");
                session.removeAttribute("assignment");
                response.sendRedirect("/web/jsp/manage_self.jsp");
            }
            else if(rmFlag.equals("3")) {
                session.removeAttribute("current_subject_name");
                session.removeAttribute("submissions");
                session.removeAttribute("average_score");
                response.sendRedirect("/web/jsp/upload_assignments.jsp");
            }
            else if(rmFlag.equals("4")) {
                session.removeAttribute("current_subject_name");
                session.removeAttribute("assignments");
                response.sendRedirect("/web/jsp/manage_students.jsp");
            }
        %>
    </body>
</html>