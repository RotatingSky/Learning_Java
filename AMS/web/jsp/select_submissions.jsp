<%--
    Assignment Management System (AMS)
    Created for teacher to select submissions from database.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.text.DecimalFormat, java.util.*, com.ams.*" %>

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
            Teacher curTeacher = new Teacher();
            int subjectID = curTeacher.getSubjectID(subjectName);
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
            if(validNum > 0) {
                float aveScore = 1.f * sumScore / validNum;
                String aveScoreStr = new DecimalFormat("##.##").format(aveScore);
                session.setAttribute("average_score", aveScoreStr);
            }
            else {
                session.removeAttribute("average_score");
            }
            response.sendRedirect("manage_students.jsp");
        %>
    </body>
</html>