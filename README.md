# Microsserviço de consulta de fatura de cartão de crédito

Serviço utilizando API Rest em Java (Quarkus) que prove informações de dados da fatura de uma cartão disponível em base de dados.


### Build
mvn clean package


### Execução local
mvn quarkus:dev -Ddebug=false


### Execução via docker-compose
docker-compose --env-file ./.env up


### gerando chave privada
openssl genrsa -out rsaPrivateKey.pem 2048

### gerando chave pública
openssl rsa -pubout -in rsaPrivateKey.pem -out publicKey.pem

### Convertendo chave privada formato PKCS#8
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsaPrivateKey.pem -outform pem -out privateKey.pem



# Indicadores e Performance
![image](https://user-images.githubusercontent.com/17239827/225927764-6ea876b9-919d-4761-822e-acf100f2f3c7.png)


# Tracing no Jaeger
![image](https://user-images.githubusercontent.com/17239827/225927438-e5b6bbf1-12fd-400d-956c-836eb6abe36f.png)


# Indicadores Kubernetes
![image](https://user-images.githubusercontent.com/17239827/225927225-93b47c5d-1fe7-42ab-9314-58baa8d67f0a.png)


# Estrutura do Protejo
![image](https://user-images.githubusercontent.com/17239827/225925543-26bb4148-5283-4d1a-b98a-f72ab3e681d1.png)


# Autor
Reinaldo Jesus Santana - reinaldojsantana@gmail.com
