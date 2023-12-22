# immagine docker
FROM openjdk:21-jdk-slim

# imposto la working directory
WORKDIR /app-server

# Copia l'eseguibile jar del progetto server (* serve per matchare ogni aumenti di versione)
COPY target/hroom-server*.jar /app-server/hroom-server.jar

# Specifica la porta su cui l'applicazione ascolterà le richieste
EXPOSE 8080

# imposto il comando di avvio
# imposto il profilo "docker" che prende come properties: application-docker.properties (che ha la connessione al db docker)
CMD ["java", "-jar", "hroom-server.jar", "--spring.profiles.active=docker"]
