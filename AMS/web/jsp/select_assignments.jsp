<%--
    Assignment Management System (AMS)
    Created for select assignments from database.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.ams.*" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String subjectName = (String)request.getParameter("subject_name");
            String teacherID = (String)session.getAttribute("id_number");
            Teacher curTeacher = new Teacher();
            int subjectID = curTeacher.getSubjectID(subjectName);
            List<Assignment> assignmentList = curTeacher.getAssignmentsAll(subjectID, teacherID);
            session.setAttribute("current_subject_name", subjectName);
            session.setAttribute("assignments", assignmentList);
            response.sendRedirect("upload_assignments.jsp");
        %>
    </body>
</html>