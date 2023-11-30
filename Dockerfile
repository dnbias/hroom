FROM openjdk:21-jdk-slim
WORKDIR /hroom
# Copia il file pom.xml principale
COPY pom.xml .
# Copia tutti i file nel contesto del progetto
COPY . .
# Installa le dipendenze del progetto
RUN apt-get update && apt-get install -y maven
#RUN mvn dependency:go-offline
#COPY mvnw .
#COPY mvnw.cmd .


# Package dell'applicazione
RUN mvn package

RUN chmod 777 "hroom-server/target/hroom-server-0.0.1-SNAPSHOT.jar"
# Specifica la porta su cui l'applicazione ascolterà le richieste
EXPOSE 8080
CMD ["java", "-jar", "hroom-server/target/hroom-server-0.0.1-SNAPSHOT.jar"]

#nginx per angluar