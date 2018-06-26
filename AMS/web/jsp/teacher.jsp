<!--
    Assignment Management System (AMS)
    Created for teachers.
-->

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
        <link href="ams.css", rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="head_field">
                <div class="logo_field">
                    <h1>AMS</h1>
                </div>
                <div class="logout_field">
                    <%
                        String teacherName = (String)session.getAttribute("real_name");
                    %>
                    <p class="user_name"><%=teacherName%> &emsp;</p>
                    <a href="logout.jsp">退出</a>
                </div>
                <script src="../js/showTime.js"></script>
                <div id="show_time" class="time_field"></div>
            </div>
            <div class="line_field">
                <hr class="split_body">
            </div>
            <div class="bookmarks">
                <ul class="options_field">
                    <li class="option_link">
                        <a href="upload_assignments.jsp">上传作业题</a>
                    </li>
                    <li class="option_link">
                        <a href="manage_students.jsp">学生作业管理</a>
                    </li>
                </ul>
            </div>
            <div class="body_field">
                <%-- Introduction of AMS --%>
            </div>
            <div class="copyright">
			    <p>Copyright &copy; Sny 2018-06-21</p>
		    </div>
        </div>
    </body>
</html>