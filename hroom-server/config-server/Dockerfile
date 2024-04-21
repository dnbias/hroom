FROM openjdk:21 AS build

WORKDIR /app

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /config-server

COPY --from=build /app/target/*.jar /config-server/config-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","config-server-0.0.1-SNAPSHOT.jar"]
