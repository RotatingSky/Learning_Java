<%--
    Assignment Management System (AMS)
    Created for teacher giving score of the submission.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.ams.*" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
        <link href="ams.css", rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String subjectName = (String)request.getParameter("subject_name_score");
            int submissionID = Integer.valueOf(request.getParameter("submission_id"));
            int score = Integer.valueOf(request.getParameter("score"));
            Teacher curTeacher = new Teacher();
            int subjectID = curTeacher.getSubjectID(subjectName);
            // Update score of the submission
            curTeacher.updateScore(submissionID, score);
            // Display all submissions information
            List<Submission> submissionList = curTeacher.getSubmissionsAll(subjectID);
            session.setAttribute("current_subject_name", subjectName);
            session.setAttribute("submissions", submissionList);
            int sumScore = 0;
            int validNum = 0;
            for(Submission submission : submissionList) {
                if(submission.getScore() >= 0)
                {
                    sumScore += submission.getScore();
                    validNum++;
                }
            }
            float aveScore = 1.f * sumScore / validNum;
            System.out.println(aveScore);
            session.setAttribute("average_score", aveScore);
            response.sendRedirect("manage_students.jsp");
        %>
    </body>
</html>