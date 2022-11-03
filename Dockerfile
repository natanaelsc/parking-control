FROM eclipse-temurin:11-jdk-alpine
# FROM openjdk:11-jdk-slim
VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
COPY target/cloud-parking-0.0.1-SNAPSHOT.jar cloudparking.jar
EXPOSE 8080
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar cloudparking.jar

# ENTRYPOINT exec java $JAVA_OPTS -jar cloudparking.jar

# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar cloudparking.jar
