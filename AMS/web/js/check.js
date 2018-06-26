/**
 * Created by Sny on 2018-06-22.
 * Used by upload_assignments.jsp
 */

function checkUpload() {
    var subjectName = document.getElementById("subject_combo").value;
    var fileName = document.getElementById("upload_file").value;
    if(!subjectName) {
        alert("请选择课程!");
        return false;
    }
    if(!fileName) {
        alert("请选择文件!")
        return false;
    }
}

function setSubjectName0() {
    // Get subject_id
    var subjectName = document.getElementById("subject_combo").value;
    if(!subjectName) {
        alert("请选择课程");
        return false;
    }
    document.getElementById("subject_name").value = subjectName;
}

function setSubjectName1() {
    // Get subject_id
    var subjectName = document.getElementById("subject_combo").value;
    if(!subjectName) {
        alert("请选择课程");
        return false;
    }
    document.getElementById("subject_name").value = subjectName;
    // Submit the select_form
    var selectForm = document.getElementById("select_form");
    selectForm.submit();
}

function checkDownload() {
    var subjectName = document.getElementById("subject_combo").value;
    if(!subjectName) {
        alert("请选择课程");
        return false;
    }
}

function setFlag(webFlag) {
    document.getElementById("remove_flag").value = webFlag;
    var bookForm = document.getElementById("book_form");
    bookForm.submit();
}

function checkSubmit(score) {
    if(score >= 0) {
        alert("该已经有了成绩!")
        return false;
    }
}