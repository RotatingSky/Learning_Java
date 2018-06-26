/**
 * Created by Sny on 2018-06-19
 * Show current time by Javascript.
 */

setInterval("curTime(show_time)", 1);

function curTime(timeID) {
    var date = new Date();
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    var w = '星期' + '日一二三四五六'.charAt(new Date().getDay());
    var h = date.getHours();
    var min = date.getMinutes();
    var s = date.getSeconds();
    if(m < 10) {
        m = "0" + m;
    }
    if(d < 10) {
        d = "0" + d;
    }
    if(h < 10) {
        h = "0" + h;
    }
    if(min < 10) {
        min = "0" + min;
    }
    if(s < 10) {
        s = "0" + s;
    }
    document.getElementById(timeID.id).innerHTML =
        y + "-" + m + "-" + d + " " +
        h + ":" + min + ":" + s + " " + w;
}