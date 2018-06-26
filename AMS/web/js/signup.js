/**
 * Created by Sny on 2018-06-08.
 * Used by signup.jsp
 */

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

function onBlur2() {
    var rePassWord = document.getElementsByTagName("input")[2].value;
    if(!rePassWord) {
        document.getElementById("remind_2").innerHTML = "请再次输入密码！";
    }
    else {
        document.getElementById("remind_2").innerHTML = "";
    }
}

function onBlur3() {
    var idNum = document.getElementsByTagName("input")[3].value;
    if(!idNum) {
        document.getElementById("remind_3").innerHTML = "请输入学号/教工号！";
    }
    else {
        document.getElementById("remind_3").innerHTML = "";
    }
}

function onBlur4() {
    var realName = document.getElementsByTagName("input")[4].value;
    if(!realName) {
        document.getElementById("remind_4").innerHTML = "请输入真实姓名！";
    }
    else {
        document.getElementById("remind_4").innerHTML = "";
    }
}

function onFocus0() {
    document.getElementById("remind_0").innerHTML = "";
}

function onFocus1() {
    document.getElementById("remind_1").innerHTML = "";
}

function onFocus2() {
    document.getElementById("remind_2").innerHTML = "";
}

function onFocus3() {
    document.getElementById("remind_3").innerHTML = "";
}

function onFocus4() {
    document.getElementById("remind_4").innerHTML = "";
}

function checkPW(passWord, rePassWord) {
    if(passWord != rePassWord) {
        return false;
    }
    else {
        return true;
    }
}

function checkSubmit() {
    var userName = document.getElementsByTagName("input")[0].value;
    var passWord = document.getElementsByTagName("input")[1].value;
    var rePassWord = document.getElementsByTagName("input")[2].value;
    var idNum = document.getElementsByTagName("input")[3].value;
    var realName = document.getElementsByTagName("input")[4].value;
    var checkFlag = true;
    if(!userName) {
        document.getElementById("remind_0").innerHTML = "请输入用户名！";
        checkFlag = false;
    }
    if(!passWord) {
        document.getElementById("remind_1").innerHTML = "请输入密码！";
        checkFlag = false;
    }
    if(!rePassWord) {
        document.getElementById("remind_2").innerHTML = "请再次输入密码！";
        checkFlag = false;
    }
    if(!idNum) {
        document.getElementById("remind_3").innerHTML = "请输入学号/教工号！";
        checkFlag = false;
    }
    if(!realName) {
        document.getElementById("remind_4").innerHTML = "请输入真实姓名！";
        checkFlag = false;
    }
    if(!checkPW(passWord, rePassWord)) {
        document.getElementById("remind_2").innerHTML = "输入密码错误！";
        checkFlag = false;
    }
    return checkFlag;
}