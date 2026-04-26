@echo off
:: Force the console to UTF-8
chcp 65001 > nul

:: Run Maven and tell the JVM to use UTF-8 internally
mvn exec:java -Dexec.mainClass="com.deweydeci.DeweyDeciManagement" -Dfile.encoding=UTF-8

pause