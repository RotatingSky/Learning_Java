<%--
    Assignment Management System (AMS)
    Sign-in interface of AMS.
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
        <script>
            if(${succeed_flag}) {
                alert("注册成功!");
            }
            <%
                session.setAttribute("succeed_flag", false);
            %>
        </script>
        <div class="container">
            <img class="container-logo" src="../images/kite.png" alt="logo">
            <div id="signin" class="content">
                <form method="POST" action="check.jsp" onsubmit="return checkSubmit()">
                    <div class="form-header">
                        <h1>用户登录</h1>
                    </div>
                    <div class="form-body">
                        <label for="user_name" class="form-label">Username</label>
                        <input id="user_name" class="form-input" type="text" name="user_name" placeholder="请输入用户名" onblur="onBlur0()" onfocus="onFocus0()">
                        <!-- When the user value is empty, it will alert! -->
                        <p id="remind_0" class="form-remind"></p>
                        <label for="password" class="form-label">Password</label>
                        <input id="password" class="form-input" type="password" name="password" placeholder="请输入密码" onblur="onBlur1()" onfocus="onFocus1()">
                        <!-- When the password value is empty, it will alert! -->
                        <p id="remind_1" class="form-remind"></p>
                        <input class="form-btn-submit" type="submit" value="登录">
                        <%
                            boolean errorFlag = false;
                            if(session.getAttribute("error_flag") != null) {
                                errorFlag = (boolean)session.getAttribute("error_flag");
                                session.setAttribute("error_flag", false);
                            }
                            if(errorFlag) {
                        %>
                                <p class="form-remind">用户名或密码错误!</p>
                        <%  }%>
                    </div>
                </form>
                <div class="signin-description">没有账户？</div>
                <div><a class="sign-link" href="signup.jsp">注册</a></div>
            </div>
        </div>
        <script src="../js/signin.js"></script>
    </body>
</html>