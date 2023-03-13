#!/bin/bash

mvn clean package

docker build --no-cache -t 442494/poc-quarkus-reactive-bd:v1.0.0 .
#docker push 442494/poc-quarkus-reactive-bd:v1.0.0

#kubectl apply -f minikube-deployment-all.yaml
docker-compose --env-file ./.env up