# Cloud Parking

## Docker

Subindo containers do PostgreSQL e PgAdmin4

```sh
docker compose up -d
```

Derrubando containers

```sh
docker compose down
```

Ou execute no terminal

```sh
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine
```

## [Adminer]("http://localhost:8082")

```code
Sistema: PostgreSQL
Servidor: postgres
Usuário: admin
Senha: 12345
Base de dados: parking
```
