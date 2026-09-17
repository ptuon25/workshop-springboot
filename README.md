# TSells

API REST exemplar construída com Spring Boot — projeto de portfólio que modela um pequeno domínio de vendas (produtos, categorias, usuários, pedidos, itens e pagamentos). Ideal para estudo de Spring Data JPA, H2/Postgres, testes e consumo via REST.

## Tecnologias
- Java 25
- Spring Boot 4.1.0
- Spring Data JPA
- H2 (perfil de teste)
- PostgreSQL (runtime preparado)
- Kafka (starter incluído)
- Resilience4j (circuit breaker)
- Lombok (opcional)
- Maven (mvnw / mvnw.cmd)

## Modelo de domínio (resumo)
- Product: id, name, description, price, imgUrl — ManyToMany com Category; relaciona-se a OrderItem.
- Category: id, name — ManyToMany com Product.
- User: id, name, email, phone, password — OneToMany com Order.
- Order: id, createdAt (Instant), orderStatus (enum), client (User), payment (OneToOne), orderItems (Set).
- OrderItem: chave composta (Order, Product), quantity, price, subTotal.
- Payment: id (mesmo id do pedido), moment (Instant).
- OrderStatus: PENDING_PAYMENT, PAID, SHIPPED, DELIVERED, CANCELED.

## Endpoints principais
Base: http://localhost:8080
- GET /products — lista produtos
- GET /products/{id} — obtém produto por id

- GET /categories — lista categorias
- GET /categories/{id}

- GET /users — lista usuários
- GET /users/{id}
- POST /users — cria usuário (JSON)
- PUT /users/{id} — atualiza usuário
- DELETE /users/{id} — remove usuário

- GET /orders — lista pedidos
- GET /orders/{id}

- GET /order_items — lista itens de pedido
- GET /order_items/{id}

Observação: respostas usam as entidades JPA diretamente; campos como orders/products podem ser ignorados por @JsonIgnore para evitar ciclos.

## Exemplos rápidos (curl)
- Listar produtos:
  curl http://localhost:8080/products

- Criar usuário:
  curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"João\",\"email\":\"joao@example.com\",\"phone\":\"99999\",\"password\":\"senha\"}" http://localhost:8080/users

## Como rodar
Windows (PowerShell / CMD):
- mvnw.cmd spring-boot:run

Unix / Git Bash:
- ./mvnw spring-boot:run

Gerar JAR:
- ./mvnw -DskipTests package
- java -jar target/tsells-0.0.1-SNAPSHOT.jar

Executar testes:
- ./mvnw test

## Perfis e banco de dados
- application.properties ativa o perfil `dev` por padrão.
- application-test.properties configura H2 em memória e habilita /h2-console (path `/h2-console`).
- Para iniciar com dados de exemplo use o profile `test` (o `TestConfig` popula a base):
  ./mvnw -Dspring-boot.run.profiles=test spring-boot:run

## Dados de teste (seeding)
Classe `TestConfig` cria categorias, produtos, usuários, pedidos, order items e um pagamento para o profile `test`.

## Observações para desenvolvimento
- Pacotes:
  - `resources` contém os controllers REST
  - `services` contém regras de negócio
  - `repositories` são interfaces JPA
  - `entities` contém o modelo
  - `resources/exceptions` possui tratamento de erros centralizado

- Se for conectar a PostgreSQL, adicione um `application-dev.properties` com `spring.datasource.*` e ajuste `spring.profiles.active` ou passe a profile por variável de ambiente.

## Contribuição
Pull requests são bem-vindos. Abrir issue antes de mudanças grandes é recomendado.

---
Arquivo gerado a partir da estrutura do projeto; edite conforme preferir para incluir instruções específicas de deploy, exemplos de payloads e documentação Swagger/OpenAPI se adicionar suporte.