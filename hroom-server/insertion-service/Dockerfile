FROM openjdk:21 AS build

WORKDIR /app

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /insertion-service

COPY --from=build /app/target/*.jar /insertion-service/insertion-service-*.jar

ENTRYPOINT ["java","-jar","insertion-service-*.jar"]
