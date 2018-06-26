#!/bin/bash

echo "Compile com.ams"
cd ./classes/com/ams
rm *.class
cd ../../../
javac -d ./classes -classpath ./lib/mysql-connector-java-8.0.11.jar: ./src/com/ams/*.java

echo "Compile com.servlet"
cd ./classes/com/servlet
rm *.class
cd ../../../
javac -d ./classes -classpath ./lib/commons-fileupload-1.3.3.jar:./lib/commons-io-2.6.jar:${CATALINA_HOME}/lib/servlet-api.jar:./classes: ./src/com/servlet/*.java