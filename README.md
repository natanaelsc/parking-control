# Cloud Parking

![repo size](https://img.s.io/github/repo-size/natanaelsc/cloud-parking?logo=gitlfs&logoColor=F64935&color=F64935)

Neste projeto foi desenvolvido um conjunto de API's utilizando Spring Boot para controle de estacionamento de veículos. São controladas as entradas e saídas dos veículos e o valor a ser cobrado do cliente. Foram aplicadas boas práticas de desenvolvimento de API's, incluindo segurança com Spring Security, acesso a banco de dados PostgreSQL, testes e documentação com Swagger. Foi feito o deploy na cloud do Heroku a fim de disponibilizar para a internet.

## Iniciando

### Requisitos

* [Docker Desktop](https://www.docker.com/products/docker-desktop/) `(Pode ser baixado e instalado para Windows, Mac e Linux)`

### Rodando com [Compose](/docker-compose.yaml)

Para subir containers do PostgreSQL e Adminer. Execute o comando no terminal dentro da pasta do projeto.

```sh
docker compose up -d
```

Derrubando containers e resíduos:

```sh
docker compose down --remove-orphans -v
```

### CLI

Para subir o container do PostgreSQL:

```sh
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine
```

Derrubando container:

```sh
docker stop parking-db
```

### Compilando e Executando JAR

Na raiz do projeto, execute os comandos a seguir:

```sh
./mvnw clean install
```

```sh
java -Djava.security.egd=file:/dev/./urandom -jar target/cloud-parking-0.0.1-SNAPSHOT.jar
```

## [Adminer](http://localhost:8082)

```url
http://localhost:8082
```

**Dados de acesso:**

```txt
Sistema: PostgreSQL
Servidor: postgres
Usuário: admin
Senha: 12345
Base de dados: parking
```

## [Swagger](http://localhost:8080/swagger-ui/index.html)

```url
http://localhost:8080/swagger-ui/index.html
```

## Acessando recursos seguros

### Credenciais de acesso

```txt
user: cloud
password: p@rk!ng
```

### Requisições com o curl

```sh
curl -v -u "cloud:p@rk!ng" -X GET "http://localhost:8080/parking"
```

```sh
curl -X GET "http://localhost:8080/parking" -H "accept: */*" -H "authorization: Basic Y2xvdWQ6cEByayFuZw=="
```

### Encode base64

```sh
echo -n 'cloud:p@rk!ng' | base64
```

## Ambiente de desenvolvimento

A base do projeto foi gerada a partir do [Spring Initializr](https://start.spring.io/) e desenvolvido em ambiente Linux WSL2 com Docker.

## Ferramentas

* [Docker](https://www.docker.com/products/docker-desktop/)

* [SpringDoc - OpenAPI 3 & Spring Boot](https://springdoc.org)

* [REST Assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

* [Testcontainers](https://www.testcontainers.org)
