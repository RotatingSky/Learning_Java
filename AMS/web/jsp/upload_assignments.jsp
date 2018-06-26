<%--
    Assignment Management System (AMS)
    Created for teacher uploading assignments.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.ams.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
        <link href="ams.css", rel="stylesheet" type="text/css">
        <%
            String teacherID = (String)session.getAttribute("id_number");
            String teacherName = (String)session.getAttribute("real_name");
            Teacher curTeacher = new Teacher();
            List<String> subjectNames = curTeacher.getSubjectNameList(teacherID);
            session.setAttribute("subject_name_list", subjectNames);
        %>
    </head>
    <body>
        <div class="container">
            <div class="head_field">
                <div class="logo_field">
                    <h1>AMS</h1>
                </div>
                <div class="logout_field">
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
                        <a href="manage_students.jsp" onclick="setFlag('4')">学生作业管理</a>
                    </li>
                </ul>
                <form id="book_form" method="POST" action="change_tab.jsp">
                    <input id="remove_flag" name="remove_flag" type="hidden">
                </form>
            </div>
            <div class="body_field">
                <%-- 1. Select subject --%>
                <%-- 2. Upload an assignment --%>
                <%-- 3. Display result --%>
                <div class="form_field">
                    <form method="POST" action="/ams/UploadServlet" enctype="multipart/form-data" onsubmit="return checkUpload()">
                        <div class="select_field">
                            选择课程
                            <%-- Display selected option again --%>
                            <select id="subject_combo" name="subject_combo" value="${current_subject_name}" onchange="setSubjectName1()">
                                <option value=""></option>
                                <c:forEach var="SN" items="${subject_name_list}">
                                    <option value="${SN}" ${current_subject_name eq SN ? "selected" : ""}>${SN}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="upload_field">
                            选择文件上传
                            <input id="upload_file" name="upload_file" type="file">
                            <input name="teacher_id" type="hidden" value="<%=teacherID%>">
                            <input name="teacher_name" type="hidden" value="<%=teacherName%>">
                            <input name="occupation" type="hidden" value="1">;
                            <input class="form-btn-submit" type="submit" value="上传">
                        </div>
                    </form>
                    <form id="select_form" method="POST" action="select_assignments.jsp">
                        <input id="subject_name" name="subject_name" type="hidden">
                    </form>
                </div>
                <div class="line_field">
                    <hr class="split_body_inside">
                </div>
                <div class="table_field">
                    <table class="ams_table">
                        <thead>
                            <tr>
                                <th class="upA_table-th">作业ID</th>
                                <th class="upA_table-th">课程名</th>
                                <th class="upA_table-filename">文件名</th>
                                <th class="upA_table-th">上传者</th>
                                <th class="upA_table-th">上传时间</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="A" items="${assignments}">
                                <tr>
                                    <td>${A.assignmentID}</td>
                                    <td>${current_subject_name}</td>
                                    <td>${A.fileName}</td>
                                    <td>${A.teacherName}</td>
                                    <td>${A.subDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="copyright">
			    <p>Copyright &copy; Sny 2018-06-21</p>
		    </div>
        </div>
        <script src="../js/check.js"></script>
    </body>
</html>