#!/bin/bash

# Comando Maven per buildare tutti i sottoprogetti
MAVEN_COMMAND="mvn clean package -Dmaven.test.skip=true"

# Comando Docker Compose per creare ed avviare i container docker dei sottoprogetti
DOCKER_COMPOSE_COMMAND="docker-compose up -d"

# Esegui il comando Maven
echo "Building all subprojects - Running: $MAVEN_COMMAND"
$MAVEN_COMMAND

# Esegui il comando Docker Compose
echo "Building docker images and starting docker containers - Running: $DOCKER_COMPOSE_COMMAND"
$DOCKER_COMPOSE_COMMAND

# Avviare lo script con un engine linux | se si ha windows: gitbash (https://gitforwindows.org/)
# se lo script non si avvia con problemi di permessi eseguire:
# chmod 777 start.sh
# Poi avviare lo script con:
# .\start.sh