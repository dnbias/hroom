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

WORKDIR /check-in-service

COPY --from=build /app/target/*.jar /check-in-service/check-in-service-*.jar

ENTRYPOINT ["java","-jar","check-in-service-*.jar"]
