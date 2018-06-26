// Created by Sny on 2018-06-08.
// Used by signin.jsp

function onBlur0() {
    var userName = document.getElementsByTagName("input")[0].value;
    if(!userName) {
        document.getElementById("remind_0").innerHTML = "请输入用户名！";
    }
    else {
        document.getElementById("remind_0").innerHTML = "";
    }
}

function onBlur1() {
    var passWord = document.getElementsByTagName("input")[1].value;
    if(!passWord) {
        document.getElementById("remind_1").innerHTML = "请输入密码！";
    }
    else {
        document.getElementById("remind_1").innerHTML = "";
    }
}

function onFocus0() {
    document.getElementById("remind_0").innerHTML = "";
}

function onFocus1() {
    document.getElementById("remind_1").innerHTML = "";
}

function checkSubmit() {
    var userName = document.getElementsByTagName("input")[0].value;
    var passWord = document.getElementsByTagName("input")[1].value;
    if(!userName && !passWord) {
        document.getElementById("remind_0").innerHTML = "请输入用户名！";
        document.getElementById("remind_1").innerHTML = "请输入密码！";
        return false;
    }
    else if(!userName) {
        document.getElementById("remind_0").innerHTML = "请输入用户名！";
        return false;
    }
    else if(!passWord) {
        document.getElementById("remind_1").innerHTML = "请输入密码！";
        return false;
    }
}