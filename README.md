# Parking Control

![repo size](https://img.shields.io/github/repo-size/natanaelsc/cloud-parking)

Neste projeto foi implementado um conjunto de API's utilizando Spring Boot para o controle de estacionamento de veículos. São controladas as entradas e saídas dos veículos e o valor a ser cobrado do cliente. Foram aplicadas boas práticas de desenvolvimento de API's, incluindo segurança com Spring Security, acesso a banco de dados PostgreSQL, testes e documentação com Swagger.

## Executando o projeto

1. Copie o arquivo `.env.example` para `.env` e configure as variáveis de ambiente.

    ```sh
    cp .env.example .env
    ```

2. Baixe o [*Docker*](https://www.docker.com/products/docker-desktop) e execute o comando abaixo:

    ```sh
    docker compose up --build
    ```

3. Para parar os containers e remover os resíduos:

    ```sh
    docker compose down --remove-orphans --volumes --rmi local
    ```

## Adminer

<http://localhost:8083>

| Opção          | Valor                           |
| :------------- | :------------------------------ |
| Sistema:       | PostgreSQL                      |
| Servidor:      | postgres                        |
| Usuário:       | postgres                        |
| Senha:         | postgres                        |
| Base de dados: | parking                         |

## Swagger

<http://localhost:8081/swagger-ui/index.html>

## Acessando recursos seguros

### Credenciais de acesso

```txt
user: cloud
password: p@rk!ng
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
