# ps-java

# Sobre o projeto
Esse projeto foi desenvolvido para atender ao processo seletivo para desenvolvedor java na Supera Inovação. Ele consistem em uma camada de serviço para um pseudo ecommerce de games mobile.
O projeto foi desenvolvido no modelo Restful utilizando Spring Boot.

# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/devsuperior/sds1-wmazoni

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run

#empacotar o projeto
./mvnw clean package
```
# Endpoints
Listar Produtos
- GET localhost:8080/produtos

Adicionar Produto ao Carrinho
- PUT localhost:8080/carrinho/produtoId
- DELETE localhost:8080/carrinho/produtoId

# Autor

Michel Corrêa

https://www.linkedin.com/in/
