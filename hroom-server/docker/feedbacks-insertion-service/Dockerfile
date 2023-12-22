FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAR_FILE
COPY target/hroom-feedbacks-insertion-microservice*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
