FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAR_FILE
COPY target/hroom-landlords-service*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
