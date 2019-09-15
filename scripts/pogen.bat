@echo off
cd %~dp0

if "%JAVA_HOME%"=="" (
  set JAVA_CMD="java.exe"
) else (
  if exist %JAVA_HOME% (
    set JAVA_CMD="%JAVA_HOME%\bin\java.exe"
  ) else (
    set JAVA_CMD="java.exe"
  )
)

set JVM_OPTS=

%JAVA_CMD% %JVM_OPTS% -jar pogen.jar

pause
