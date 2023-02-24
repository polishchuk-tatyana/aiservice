#FROM maven:3.8.4-openjdk-17 as maven-builder
#COPY src /app/src
#COPY pom.xml /app
#
#RUN mvn -f /app/pom.xml clean package -DskipTests
#FROM openjdk:17-alpine
#
##ARG JAR_FILE=*.jar
#COPY --from=maven-builder app/target/aiservice-0.0.1-SNAPSHOT.jar  /aiservice/aiservice.jar
#WORKDIR /aiservice
#
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "aiservise.jar"]
#CMD ["-start"]

#FROM openjdk:17-alpine
#ENV DB_USERNAME=AIService
#ENV DB_NAME=AIService
#ENV DB_HOST=localhost
#ENV DB_PORT=5432
#ENV APP_PORT=8080
#COPY target/aiservice-0.0.1-SNAPSHOT.jar aiservise.jar
#ENTRYPOINT ["java", "-jar" , "-Dspring.datasource.username=${DB_USERNAME}", "-Dspring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}", "-Dserver.port=${APP_PORT}", "aiservise.jar"]

FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/aiservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} aiservice.jar
ENTRYPOINT ["java", "-jar", "/aiservice.jar"]