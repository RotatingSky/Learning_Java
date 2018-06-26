<%--
    Assignment Management System (AMS)
    Created for student to select submissions from database.
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
            String studentID = (String)session.getAttribute("id_number");
            Student curStudent = new Student();
            int subjectID = curStudent.getSubjectID(subjectName);
            List<Submission> submissionList = curStudent.getSubmissionsAll(subjectID, studentID);
            session.setAttribute("current_subject_name", subjectName);
            session.setAttribute("submissions", submissionList);
            response.sendRedirect("manage_self.jsp");
        %>
    </body>
</html>