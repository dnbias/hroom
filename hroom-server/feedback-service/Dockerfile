FROM openjdk:21 AS build

WORKDIR /app

COPY parent parent
COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /feedback-service

COPY --from=build /app/target/*.jar /feedback-service/feedback-service-*.jar

ENTRYPOINT ["java","-jar","feedback-service-*.jar"]
