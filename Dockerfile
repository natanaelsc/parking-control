FROM eclipse-temurin:11-jdk-alpine
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
EXPOSE 8080
CMD ["./mvnw", "spring-boot:run"]

# FROM eclipse-temurin:11-jdk-alpine
# VOLUME /tmp
# COPY target/cloud-parking-0.0.1-SNAPSHOT.jar cloudparking.jar
# EXPOSE 8080
# ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar cloudparking.jar