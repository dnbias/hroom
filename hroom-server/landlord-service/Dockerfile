FROM openjdk:21 AS build

WORKDIR /app

COPY pom.xml mvnw ./
RUN chmod +x mvnw
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -Dmaven.test.skip

FROM openjdk:21-jdk-slim

WORKDIR /landlord-service

COPY --from=build /app/target/*.jar /landlord-service/landlord-service-*.jar

ENTRYPOINT ["java","-jar","landlord-service-*.jar"]
