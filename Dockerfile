FROM tomcat:9-jdk17
ADD target/MyWebApp.war /usr/local/tomcat/webapps/MyWebApp.war
EXPOSE 8080
CMD ["catalina.sh", "run"]