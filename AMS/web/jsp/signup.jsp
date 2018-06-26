<%--
    Assignment Management System (AMS)
    Sign-up interface of AMS.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8">
        <title>作业管理系统</title>
        <link href="sign.css", rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container">
            <img class="container-logo" src="../images/kite.png" alt="logo">
            <div id="signin" class="content">
                <form method="POST" action="register.jsp" onsubmit="return checkSubmit()">
                    <div class="form-header">
                        <h1>创建账户</h1>
                    </div>
                    <div class="form-body">
                        <label for="user_name" class="form-label">Username</label>
                        <input id="user_name" class="form-input" type="text" name="user_name" placeholder="请输入用户名" onblur="onBlur0()" onfocus="onFocus0()">
                        <p id="remind_0" class="form-remind"></p>
                        <label for="password" class="form-label">Password</label>
                        <input id="password" class="form-input" type="password" name="password" placeholder="请输入密码" onblur="onBlur1()" onfocus="onFocus1()">
                        <p id="remind_1" class="form-remind"></p>
                        <label for="repassword" class="form-label">Repeat Password</label>
                        <input id="repassword" class="form-input" type="password" name="repassword" placeholder="请再次输入密码" onblur="onBlur2()" onfocus="onFocus2()">
                        <p id="remind_2" class="form-remind"></p>
                        <label for="id_number" class="form-label">Student/Employee ID</label>
                        <input id="id_number" class="form-input" type="text" name="id_number" placeholder="请输入学号/教工号" onblur="onBlur3()" onfocus="onFocus3()">
                        <p id="remind_3" class="form-remind"></p>
                        <%
                            boolean succeed_flag = false;
                            if(session.getAttribute("succeed_flag") != null) {
                                succeed_flag = (boolean)session.getAttribute("succeed_flag");
                            }
                            if(succeed_flag) {
                                response.sendRedirect("signin.jsp");
                            }
                        %>
                        <label for="name" class="form-label">Name</label>
                        <input id="name" class="form-input" type="text" name="name" placeholder="请输入真实姓名" onblur="onBlur4()" onfocus="onFocus4()">
                        <p id="remind_4" class="form-remind"></p>
                        <input class="form-btn-submit" type="submit" value="注册">
                    </div>
                </form>
                <div class="signin-description">已经有账户？</div>
                <div><a class="sign-link" href="signin.jsp">登录</a></div>
            </div>
        </div>
        <script src="../js/signup.js"></script>
    </body>
</html>