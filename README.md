# Credit card invoice query microservice

A service using Rest API in Java (Quarkus) that provides invoice data information from a credit card available in a database.


### Integrated tools:

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



### Build
mvn clean package


### Local execution
mvn quarkus:dev -Ddebug=false


### Execution via docker-compose
docker-compose --env-file ./.env up


### Generating private key
openssl genrsa -out rsaPrivateKey.pem 2048


### Generating public key
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem


### Converting private key to PKCS#8 format:
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem



# Indicadors
![image](https://user-images.githubusercontent.com/17239827/225927764-6ea876b9-919d-4761-822e-acf100f2f3c7.png)


# Performance
![image](https://user-images.githubusercontent.com/17239827/225932487-f5e90504-3015-4e74-a9fd-c492ea9c3c69.png)


# Tracing no Jaeger
![image](https://user-images.githubusercontent.com/17239827/225927438-e5b6bbf1-12fd-400d-956c-836eb6abe36f.png)


# Indicadores Kubernetes
![image](https://user-images.githubusercontent.com/17239827/225927225-93b47c5d-1fe7-42ab-9314-58baa8d67f0a.png)


# Project Structure
![image](https://user-images.githubusercontent.com/17239827/225925543-26bb4148-5283-4d1a-b98a-f72ab3e681d1.png)


# Test in container
![image](https://user-images.githubusercontent.com/17239827/225934234-bdb98f70-d4ac-486a-b412-ebb001f5175d.png)



# Autor
Reinaldo Jesus Santana - reinaldojsantana@gmail.com
