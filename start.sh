#!/bin/bash

# set echo color
CYAN='\033[0;36m'
NOCOLOR='\033[0m'

# Comando Maven per buildare tutti i sottoprogetti
MAVEN_COMMAND="mvn clean package -Dmaven.test.skip=true"

# Comando Docker Compose up per creare ed avviare i container docker dei sottoprogetti
DOCKER_COMPOSE_COMMAND="docker-compose up --build -d"

# Comando Docker Compose down per distruggere le risorse precedenti create con il comando docker compose up
DOCKER_COMPOSE_DOWN_COMMAND="docker-compose down"

# Esegui il comando Maven
echo -e "\n${CYAN}Building all subprojects - Running: $MAVEN_COMMAND \n${NOCOLOR}"
$MAVEN_COMMAND

# Esegui il comando Docker Compose down
echo -e "\n${CYAN}Deleting previous docker resources: - Running: $DOCKER_COMPOSE_DOWN_COMMAND \n${NOCOLOR}"
$DOCKER_COMPOSE_DOWN_COMMAND

# Esegui il comando Docker Compose up
echo -e "\n${CYAN}Building docker images and starting docker containers - Running: $DOCKER_COMPOSE_COMMAND \n${NOCOLOR}"
$DOCKER_COMPOSE_COMMAND

# Avviare lo script con un engine linux | se si ha windows: gitbash (https://gitforwindows.org/)
# se lo script non si avvia con problemi di permessi eseguire:
# chmod 777 start.sh
# Poi avviare lo script con:
# .\start.sh
