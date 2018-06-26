<%--
    Assignment Management System (AMS)
    Created for teacher managing submissions of students.
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
                        <a href="upload_assignments.jsp" onclick="setFlag('3')">上传作业题</a>
                    </li>
                    <li class="option_link">
                        <a href="manage_students.jsp">学生作业管理</a>
                    </li>
                </ul>
                <form id="book_form" method="POST" action="change_tab.jsp">
                    <input id="remove_flag" name="remove_flag" type="hidden">
                </form>
            </div>
            <div class="body_field">
                <%-- 1. Select subject --%>
                <%-- 2. Display result --%>
                <%-- 3. Teacher can download files --%>
                <div class="form_field">
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
                    <div class="body_place_holer"></div>
                    <form id="select_form" method="POST" action="select_submissions.jsp">
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
                                <th class="manS_table-th">作业ID</th>
                                <th class="manS_table-filename">下载链接</th>
                                <th class="manS_table-th">学生ID</th>
                                <th class="manS_table-th">学生姓名</th>
                                <th class="manS_table-th">上传时间</th>
                                <th class="manS_table-th">成绩</th>
                                <th class="manS_table-th">提交成绩</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="S" items="${submissions}">
                                <form id="score_form" method="POST" action="given_score.jsp" onsubmit="return checkSubmit(${S.score})">
                                    <tr>
                                        <td>
                                            ${S.submissionID}
                                            <input name="submission_id" type="hidden" value="${S.submissionID}">
                                        </td>
                                        <td>
                                            <c:url var="downloadURL" value="/DownloadServlet">
                                                <c:param name="file_name" value="${S.fileName}"></c:param>
                                            </c:url>
                                            <a href="${downloadURL}">${S.fileName}</a>
                                        </td>
                                        <td>${S.studentID}</td>
                                        <td>${S.studentName}</td>
                                        <td>${S.subDate}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${S.score>=0}">${S.score}</c:when>
                                                <c:otherwise>
                                                    <input id="score" class="form-input-score" type="text" name="score">
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:if test="${S.fileName != null}">
                                                <input name="subject_name_score" type="hidden" value="${current_subject_name}">
                                                <input class="form-btn-submit-score" type="submit" value="提交">
                                            </c:if>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </tbody>
                        <tfoot>
                            <td>平均成绩</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>${average_score}</td>
                            <td></td>
                        </tfoot>
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