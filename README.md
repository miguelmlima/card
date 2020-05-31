# Card API

API de consulta e atualização de dados do cartão

## Tecnologias

- Java 1.8
- Imagem Docker mongoDB
- Spring Boot 2.3.0.RELEASE

## Requisitos dev
- Eclipse ou Intellij IDEA
- JDK 1.8
- Docker 
- Robo3t 

## Como usar (dev)

- baixar primeiro imagem docker do mongo
- sudo docker pull mongo
- sudo docker run --name testemongo -p 17017:27017 -d mongo
- sudo docker ps -a
- sudo docker start testemongo

```bash
./mvnw spring-boot:run
```
## Modelo de Dados
Este projeto utiliza a base de dados MongoDB, considerando o seguinte modelo de dados:

{
  "id": "5ed2d4e19d71f468cf2e801b",
  "date": "14/05/2020",
  "time": "14:52:33",
  "value": 980.00,
  "cardApplication": "VOUCHER",
  "status": "CANCELED"
}
## Como gerar os testes e o html de cobertura

- Na pasta raiz, executar:
```bash
./mvnw verify
```
- Abrir o arquivo target/site/jacoco/index.htm

## Acessar o swagger

```bash
http://localhost:8080/swagger-ui.html
```

## Como acessar o HealthCheck
- Esta é a URL configurada para o Actuator Healthcheck:

```bash
http://localhost:8080/actuator/health
```