FROM eclipse-temurin:11-jdk-alpine AS development

RUN addgroup -S abc && adduser -S abc -G abc

USER abc

WORKDIR /api

COPY --chown=abc:abc .mvn/ .mvn

COPY --chown=abc:abc mvnw pom.xml ./

FROM eclipse-temurin:11-jdk-alpine AS builder

WORKDIR /api

COPY --chown=abc:abc src ./src

COPY --chown=abc:abc --from=development /api/ ./

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:11-jre-alpine AS production

WORKDIR /api

COPY --from=builder /api/target/*.jar ./app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
