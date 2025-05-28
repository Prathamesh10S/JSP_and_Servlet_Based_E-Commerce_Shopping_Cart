# Use Tomcat 10 base image with JDK 17
FROM tomcat:10.1-jdk17

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR file to Tomcat webapps folder
COPY target/Shopping_Cart-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8081
EXPOSE 8081

# Start Tomcat
CMD ["catalina.sh", "run"]
