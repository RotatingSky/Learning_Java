Program Usage Description
===

* Unzip the xxx.zip to Dictionary_JSP (Folder_Name)
* This is a dictionary on web.
* Before running this program, you should do:
    * Move data.txt to {CATALINA_HOME}/bin, which is tomcat path.
    * Modify the server.xml in the {CATALINA_HOME}/conf, add following code in Host.
    ```xml
    <Context path="/dictionary" docBase="xxx/Dictionary_JSP (Folder_Name)" />
    ```
* Then start the tomcat server.
    ```sh
    cd ${CATALINA_HOME}/bin
    ./startup.sh
    ```
* Open a browser, and type in "localhost:8080/dictionary/web.jsp", you will see the dictionary program.

**Reference**

* [录屏+gif](https://blog.csdn.net/w_linux/article/details/65662506)