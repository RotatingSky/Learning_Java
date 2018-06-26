<%--
    Assignment Management System (AMS)
    Created for students managing self.
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
            String studentID = (String)session.getAttribute("id_number");
            String studentName = (String)session.getAttribute("real_name");
            Student curStudent = new Student();
            List<String> subjectNames = curStudent.getSubjectNamesAll();
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
                    <p class="user_name"><%=studentName%> &emsp;</p>
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
                        <a href="download_assignment.jsp" onclick="setFlag('1')">下载作业题</a>
                    </li>
                    <li class="option_link">
                        <a href="manage_self.jsp">个人作业管理</a>
                    </li>
                </ul>
                <form id="book_form" method="POST" action="change_tab.jsp">
                    <input id="remove_flag" name="remove_flag" type="hidden">
                </form>
            </div>
            <div class="body_field">
                <%-- 1. Upload the answer file --%>
                <%-- 2. Check the score of submission --%>
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
                            <input name="student_id" type="hidden" value="<%=studentID%>">
                            <input name="student_name" type="hidden" value="<%=studentName%>">
                            <input name="occupation" type="hidden" value="0">;
                            <input class="form-btn-submit" type="submit" value="提交">
                        </div>
                    </form>
                    <form id="select_form" method="POST" action="select_my_submissions.jsp">
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
                                <th class="manSelf_table-th">作业ID</th>
                                <th class="manSelf_table-filename">文件名</th>
                                <th class="manSelf_table-th">上传者</th>
                                <th class="manSelf_table-th">上传时间</th>
                                <th class="manSelf_table-th">成绩</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="S" items="${submissions}">
                                <tr>
                                    <td>${S.submissionID}</td>
                                    <td>${S.fileName}</td>
                                    <td>${S.studentName}</td>
                                    <td>${S.subDate}</td>
                                    <td><c:if test="${S.score>=0}">${S.score}</c:if></td>
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