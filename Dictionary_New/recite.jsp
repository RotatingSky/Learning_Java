<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="com.dictionary.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Recite Words</title>
        <link href="dictionary.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="container">
            <%!
                Transaction dbDictionary = new Transaction();
                int index = -1;
                Word curWord = new Word("", "");
            %>
            <%
                request.setCharacterEncoding("UTF-8");
                String btnName = request.getParameter("submit");
                String chResult = "";
                String enResult = "";
                int times = -1;
                if(btnName != null) {
                    if(btnName.equals("Last")) {
                        if(index > 0) {
                            curWord = dbDictionary.reciteWord(--index);
                        }
                    }
                    else if(btnName.equals("Next")) {
                        if(index < dbDictionary.getSize() - 1) {
                            curWord = dbDictionary.reciteWord(++index);
                        }
                    }
                }
                chResult = curWord.getChinese();
                enResult = curWord.getEnglish();
                times = curWord.getTimes();
            %>
            <form action="recite.jsp" method="post">
                <div id="buttons">
                    <input class="btnClass" type="submit" value="Last" name="submit">
                    <input class="btnClass" type="submit" value="Next" name="submit">
                </div>
                <table id="reciteTable">
                    <tr id="tableHead">
                        <th>中文<hr></th>
                        <th>English<hr></th>
                        <th>记忆次数<hr></th>
                    </tr>
                    <tr>
                        <th><%=chResult%></th>
                        <th><%=enResult%></th>
                        <th><%=times%></th>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>