#!/bin/bash

mvn clean package -Pnative -Dquarkus.native.container-build=true

docker build -f Dockerfile.native --no-cache -t 442494/poc-quarkus-native-reactive-bd:v1.0.0 .
#docker push 442494/quarkus-native:v3.0.0
#docker-compose -f docker-compose-native.yml --env-file ./.env up