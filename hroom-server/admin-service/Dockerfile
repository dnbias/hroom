FROM openjdk:21 AS build

WORKDIR /app

COPY pom.xml mvnw ./
COPY parent parent
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /admin-service

COPY --from=build /app/target/*.jar /admin-service/admin-service-*.jar

ENTRYPOINT ["java","-jar","admin-service-*.jar"]
