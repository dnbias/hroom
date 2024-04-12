FROM openjdk:21 AS build

WORKDIR /app

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /check-out-service

COPY --from=build /app/target/*.jar /check-out-service/check-out-service-*.jar

ENTRYPOINT ["java","-jar","check-out-service-*.jar"]
