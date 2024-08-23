# Parking Control

![repo size](https://img.shields.io/github/repo-size/natanaelsc/cloud-parking)

Neste projeto foi implementado um conjunto de API's utilizando Spring Boot para o controle de estacionamento de veículos. São controladas as entradas e saídas dos veículos e o valor a ser cobrado do cliente. Foram aplicadas boas práticas de desenvolvimento de API's, incluindo segurança com Spring Security, acesso a banco de dados PostgreSQL, testes e documentação com Swagger.

## Executando o projeto

* Copie o arquivo `.env.example` para `.env` e configure as variáveis de ambiente.

* Baixe o [*Docker*](https://www.docker.com/products/docker-desktop) e execute o comando abaixo:

  ```sh
  docker compose -f docker-compose.prod.yml up --build
  ```

* Para parar os containers e remover os resíduos:

  ```sh
  docker compose down --remove-orphans --volumes --rmi local
  ```

## Compilando e Executando JAR

Instale o JDK 11 e execute os comandos abaixo:

```sh
./mvnw clean install
```

```sh
java -Djava.security.egd=file:/dev/./urandom -jar target/cloud-parking-0.0.1-SNAPSHOT.jar
```

## Adminer

<http://localhost:8083>

**Acesso:**

```txt
Sistema: PostgreSQL
Servidor: postgres
Usuário: admin
Senha: 6e96c406d6008575611293c6388a713
Base de dados: parking
```

## Swagger

<http://localhost:8081/swagger-ui/index.html>

## Acessando recursos seguros

### Credenciais de acesso

```txt
user: cloud
password: p@rk!ng
```

### Requisições com curl

```sh
curl -v -u "cloud:p@rk!ng" -X GET "http://localhost:8081/parking"
```

```sh
curl -X GET "http://localhost:8080/parking" -H "accept: */*" -H "authorization: Basic Y2xvdWQ6cEByayFuZw=="
```

### Encode base64

```sh
echo -n 'cloud:p@rk!ng' | base64
```

## Ferramentas

* [Docker](https://www.docker.com/products/docker-desktop)

* [SpringDoc - OpenAPI 3 & Spring Boot](https://springdoc.org)

* [REST Assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

* [Testcontainers](https://www.testcontainers.org)

* [Teste de integração com Testcontainers](https://www.baeldung.com/spring-boot-testcontainers-integration-test)
