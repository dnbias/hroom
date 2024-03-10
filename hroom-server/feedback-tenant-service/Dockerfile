FROM openjdk:21 AS build

WORKDIR /app

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /feedback-tenant-service

COPY --from=build /app/target/*.jar /feedback-tenant-service/feedback-tenant-service-*.jar

ENTRYPOINT ["java","-jar","feedback-tenant-service-*.jar"]
