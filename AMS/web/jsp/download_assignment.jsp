<%--
    Assignment Management System (AMS)
    Created for students downloading assignment.
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
                        <a href="download_assignment.jsp">下载作业题</a>
                    </li>
                    <li class="option_link">
                        <a href="manage_self.jsp" onclick="setFlag('2')">个人作业管理</a>
                    </li>
                </ul>
                <form id="book_form" method="POST" action="change_tab.jsp">
                    <input id="remove_flag" name="remove_flag" type="hidden">
                </form>
            </div>
            <div class="body_field">
                <%-- 1. Select subject --%>
                <%-- (It will select one assignment according to subject) --%>
                <%-- 2. Download the assignment --%>
                <div class="form_field">
                    <form id="select_form" method="POST" action="select_my_assignment.jsp" onsubmit="return checkDownload()">
                        <div class="select_field">
                            选择课程
                            <%-- Display selected option again --%>
                            <select id="subject_combo" name="subject_combo" value="${current_subject_name}" onchange="setSubjectName0()">
                                <option value=""></option>
                                <c:forEach var="SN" items="${subject_name_list}">
                                    <option value="${SN}" ${current_subject_name eq SN ? "selected" : ""}>${SN}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="generate_field">
                            生成我的作业
                            <input id="subject_name" name="subject_name" type="hidden">
                            <input class="form-btn-submit" type="submit" value="开始">
                        </div>
                    </form>
                </div>
                <div class="line_field">
                    <hr class="split_body_inside">
                </div>
                <div class="table_field">
                    <table class="ams_table">
                        <thead>
                            <tr>
                                <th class="downA_table-th">作业ID</th>
                                <th class="downA_table-th">课程名</th>
                                <th class="downA_table-filename">文件名</th>
                                <th class="downA_table-th">老师姓名</th>
                                <th class="downA_table-th">上传时间</th>
                                <th class="downA_table-th">下载链接</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${assignment.assignmentID}</td>
                                <td>${current_subject_name}</td>
                                <td>${assignment.fileName}</td>
                                <td>${assignment.teacherName}</td>
                                <td>${assignment.subDate}</td>
                                <td>
                                    <c:url var="downloadURL" value="/DownloadServlet">
                                        <c:param name="file_name" value="${assignment.fileName}"></c:param>
                                    </c:url>
                                    <a id="download_link" href="${downloadURL}"></a>
                                </td>
                                <script>
                                    var fileName = document.getElementById("subject_combo").value;
                                    if(fileName) {
                                        document.getElementById("download_link").innerHTML = "下载";
                                    }
                                </script>
                            </tr>
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