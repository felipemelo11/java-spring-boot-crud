# CRUD API 🖥️🚀

Este projeto é uma API simples de CRUD (Create, Read, Update, Delete) desenvolvida com **Java Spring Boot**, integrando um banco de dados **MySQL** via **Docker** e utilizando **JPA/Hibernate** para gerenciar entidades. O objetivo é fornecer uma estrutura básica para gerenciar entidades de usuário, utilizando as melhores práticas de desenvolvimento.

## 📋 Funcionalidades:

- 🧾 **Criar usuário:** Permite criar um novo registro de usuário.
- 🔍 **Listar usuários:** Recupera todos os registros de usuários armazenados no banco de dados.
- ✏️ **Atualizar usuário:** Permite modificar os dados de um usuário existente.
- ❌ **Deletar usuário:** Remove um registro de usuário do sistema.

## 🛠️ Tecnologias utilizadas:
- Java Spring Boot 🛡️
- Banco de Dados MySQL 🗄️
- Hibernate/JPA 🔄
- Docker 🐳
- Maven 🐘

## Estrutura do Projeto

O projeto segue uma estrutura padrão para aplicações Spring Boot:

- `controller`: Contém as classes responsáveis por lidar com as requisições HTTP.
- `service`: Contém a lógica de negócios.
- `repository`: Gerencia a interação com o banco de dados.
- `model`: Define as entidades do sistema.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

- **JDK 17 ou superior**
- **Maven**
- **Docker** (opcional, caso queira usar o banco de dados MySQL via container)

##  🚀 Configuração

1. Clone o repositório para sua máquina local:

```bash
git clone https://github.com/seu-usuario/java-spring-boot-crud.git
```

2. Navegue até o diretório do projeto:

```bash
cd java-spring-boot-crud
```

3. Configure o banco de dados no arquivo `application.properties` ou `application.yml` localizado em `src/main/resources`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

4. (Opcional) Execute um container MySQL com Docker:

```bash
docker run --name mysql-crud -e MYSQL_ROOT_PASSWORD=admin -e MYSQL_DATABASE=crud_db -p 3306:3306 -d mysql:8.0
```

5. Compile e execute a aplicação:

```bash
mvn spring-boot:run
```

## 📝 Endpoints principais:

A API expõe os seguintes endpoints:

- **POST /users**: Cria um novo usuário.
- **GET /users**: Retorna a lista de usuários.
- **GET /users/{id}**: Retorna os detalhes de um usuário específico.
- **PUT /users/{id}**: Atualiza os dados de um usuário.
- **DELETE /users/{id}**: Remove um usuário.

## Exemplos de Requisição

### Criar um usuário

**POST users**

```json
{
  "name": "João Silva",
  "email": "joao.silva@email.com",
  "password": 123
}
```

### Atualizar um usuário

**PUT users/UUID**

```json
{
  "name": "João Silva Atualizado",
  "password": 789
}
```

## Testes

O projeto inclui testes básicos para verificar a funcionalidade dos endpoints. Para executá-los, use o comando:

```bash
mvn test
```

## Autor
Felipe de Melo Brito

https://www.linkedin.com/in/felipemelo1106
---
