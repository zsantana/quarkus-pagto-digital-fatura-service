# Credit card invoice query microservice

A service using Rest API in Java (Quarkus) that provides invoice data information from a credit card available in a database.



## 💻 Getting started

```bash
# Build 
$ mvn clean package

# Local execution
$ mvn quarkus:dev -Ddebug=false
```


## Getting started Docker
```bash
# Install image from file build_docker_push.sh 
$ ./build_docker_push.sh 

# Started and attaches to containers for a service
$ docker-compose --env-file ./.env up
```


## Getting started Docker (Native Image)
```bash
# Install image from file build_docker_push.sh 
$ ./build_docker_native.sh 

# Started and attaches to containers for a service
$ docker-compose -f docker-compose-native.yml --env-file ./.env up
```


## ✔️ Required
* Maven: 3.8.4
* Java version: 17
* Docker version: 20.10.17
* Docker-compose version: v2.2.2


Docker Image:
* Minikube: v1.29.0
* Keycloak: 19.0.3
* postgres: 13
* jaegertracing/all-in-one: 1
* grafana/grafana: latest
* elasticsearch: 8.4.1
* Kibana: 8.4.1
* azul/zulu-openjdk: 17-latest


## Integrated tools:

Observability:

* smallrye-openapi
* smallrye-metrics
* smallrye-health 
* opentelemetry


Database:
* hibernate-reactive-panache
* reactive-pg-client


Authentication and Security:
* oidc-client
* keycloak-authorization

Other integrations:
* resteasy-reactive-jackson
* lombok
* mapstruct

Unit and Integration testing:
* testcontainers
* keycloak-admin-client
* test-oidc-server
* rest-assured





### Swagger
![image](https://user-images.githubusercontent.com/17239827/226056309-295315a2-4403-4ff6-ad0b-5bfd335d1b07.png)



### Generating private key
openssl genrsa -out rsaPrivateKey.pem 2048


### Generating public key
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem


### Converting private key to PKCS#8 format:
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem



# Indicadors
![image](https://user-images.githubusercontent.com/17239827/225927764-6ea876b9-919d-4761-822e-acf100f2f3c7.png)


# Test performance with (hey)
hey -z 10s -H "Authorization: Bearer ACCESS_TOKEN" http://localhost:8080/credit-cards-accounts/api/v1/accounts/8dcb8be4-bf5a-11ed-a85b-0242c0a89002/123/transactions

![image](https://user-images.githubusercontent.com/17239827/226060297-5c2ee5d4-6e26-4bba-84bd-86c030352a22.png)


# Test performance with ApacheBench
ab -k -n 10000 -c 10 -H "Authorization: Bearer ACCESS_TOKEN" http://localhost:8080/credit-cards-accounts/api/v1/accounts/8dcb8be4-bf5a-11ed-a85b-0242c0a89002/123/transactions

![image](https://user-images.githubusercontent.com/17239827/226060776-58d7b271-2716-4880-b441-b4a0494343d6.png)


# Tracing no Jaeger
![image](https://user-images.githubusercontent.com/17239827/225927438-e5b6bbf1-12fd-400d-956c-836eb6abe36f.png)


# Indicadors Kubernetes
![image](https://user-images.githubusercontent.com/17239827/225927225-93b47c5d-1fe7-42ab-9314-58baa8d67f0a.png)


# Project Structure
![image](https://user-images.githubusercontent.com/17239827/225925543-26bb4148-5283-4d1a-b98a-f72ab3e681d1.png)


# Test in container
![image](https://user-images.githubusercontent.com/17239827/225934234-bdb98f70-d4ac-486a-b412-ebb001f5175d.png)



# Autor
Reinaldo Jesus Santana - reinaldojsantana@gmail.com
