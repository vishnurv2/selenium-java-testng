cd C:\Users\Admin\IdeaProjects\magicleapTesting
set JAVA_HOME = "C:\Program Files\Java\jdk-11.0.2";
echo %JAVA_HOME%
mvn clean test -Dsurefire.suiteXmlFiles=desktop.xml

