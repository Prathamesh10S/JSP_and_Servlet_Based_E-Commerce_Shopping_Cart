# Use Tomcat 9 base image with JDK
FROM tomcat:9.0-jdk17

# Remove default webapps to avoid default Tomcat page
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR file to ROOT.war
COPY target/Shopping_Cart-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port Render will use
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
