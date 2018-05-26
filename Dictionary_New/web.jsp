<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="com.dictionary.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>字典 on Web</title>
        <link href="dictionary.css" rel="stylesheet" type="text/css">
        <script>
            function dispWindow() {
                // Remove the recite button in the recite div.
                var father = document.getElementById("recite");
                var child = document.getElementById("reciteBtn");
                father.removeChild(child);
                // Add table and butons to the recite div.
                var frame = document.createElement("iframe");
                frame.id = "reciteFrame";
                frame.src = "recite.jsp";
                father.appendChild(frame);
            }
        </script>
    </head>
    <body>
        <div id="container">
            <h1>中英文互译字典</h1>
            <%-- Get parameters from the web.jsp --%>
            <%
                request.setCharacterEncoding("UTF-8");
                String chStr = request.getParameter("chinese");
                String enStr = request.getParameter("english");
                String btnName = request.getParameter("submit");
                Transaction dbDictionary = new Transaction();
                Word curWord = new Word(chStr, enStr);
                String chResult = "";
                String enResult = "";
                if(btnName != null) {
                    if(btnName.equals("Insert")) {
                        dbDictionary.insert(curWord);
                    }
                    else if(btnName.equals("Search")) {
                        dbDictionary.search(curWord);
                        chResult = curWord.getChinese();
                        enResult = curWord.getEnglish();
                    }
                }
            %>
            <form action="web.jsp" method="post">
                <%-- Create the window of dictionary. --%>
                <table>
                    <tr>
                        <th>中文</th>
                        <th>English</th>
                    </tr>
                    <tr>
                        <th><input type="text" value="<%=chResult%>" name="chinese"></th>
                        <th><input type="text" value="<%=enResult%>" name="english"></th>
                    </tr>
                </table>
                <div id="buttons">
                    <input class="btnClass" type="submit" value="Insert" name="submit">
                    <input class="btnClass" type="submit" value="Search" name="submit">
                </div>
            </form>
            <div id="gif_display">
                <h3>Operation Example</h3>
                <img id="dictionary_eg" src="dictionary_video.gif">
            </div>
            <div id="recite">
                <button id="reciteBtn" type="button" onclick="dispWindow()">开始背单词</button>
            </div>
        </div>
    </body>
</html>