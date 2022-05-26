# AGENDA INTELIGENTE - POC UTILIZANDO CIRCUIT BREAKER

O objetivo do projeto e demonstrar a utilizacao do que, em projeto de programacao, e considerado um design pattern o Circuit Breaker. 

Abaixo o esquema de entidades usado como conceito:

![diagrama](diagrama-pdz.png)

---

# 1. Ferramentas utilizadas:
- Java 11
- Spring Boot [Spring initializr](https://start.spring.io/)
    - JPA
    - Web
    - actuator
- Resilience4j [Documentacao](https://resilience4j.readme.io/docs)
- MariaDB [MariaDB](https://mariadb.org/)
- WildFly 20 [Documentacao](https://docs.wildfly.org/20/)

# 2. Os sistemas:

* **database:**

O sistema database e responsavel pela conexao com o banco de dados, e fazer os CRUD (Create, REad, Update, Delete) dos dados. Ele fornece uma API para fazer isso, porem nao possui validacao.

* **webservice**
O sistema e responsavel pro validar os dados ao fazer a chamada para sistema database. Nele foi implementado o Circuit Breaker. Entao, o texto sera focado nesse sistema.

---

# 3. Circuit Breaker

O Circuit breaker na questao do mundo da computacao e um Design Pattern atualmente, utilizado para construir servicos sao tolerantes a falhas e/ou sobrecarga de comunicacao entre sistemas/microservico. 