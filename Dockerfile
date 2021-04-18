FROM tomcat:9-jdk8
ADD target/MyWebApp-1.0.war /usr/local/tomcat/webapps/MyWebApp-1.0.war
EXPOSE 8080
CMD ["catalina.sh", "run"]