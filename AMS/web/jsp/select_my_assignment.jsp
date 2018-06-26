<%--
    Assignment Management System (AMS)
    Created for student to select the assignment from database.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.io.*, java.util.*, com.ams.*" %>

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
            Student curStudent = new Student();
            int subjectID = curStudent.getSubjectID(subjectName);
            Assignment assignment = curStudent.getAssignment(subjectID);
            if(assignment != null) {
                session.setAttribute("current_subject_name", subjectName);
                session.setAttribute("assignment", assignment);
                // Get filename
                String FILE_DIR = "WEB-INF/datas";
                String filePath = this.getServletContext().getRealPath(FILE_DIR);
                File fileDir = new File(filePath, assignment.getFileName());
                session.setAttribute("filename_key", fileDir.getName());
            }
            response.sendRedirect("download_assignment.jsp");
        %>
    </body>
</html>