FROM eclipse-temurin:11-jdk-alpine@sha256:0a0051c3c30b8a6c33ceb0f261a30046c81cd6010aa8970ff85c93d36810604a AS development

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY src ./src
