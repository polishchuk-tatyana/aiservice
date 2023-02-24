FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /app/src
COPY pom.xml /app

RUN mvn -f /app/pom.xml clean package -DskipTests
FROM openjdk:17-alpine

ARG JAR_FILE=*.jar
COPY --from=maven-builder ${JAR_FILE} /aiservice/aiservice.jar
WORKDIR /aiservice

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "aiservise.jar"]