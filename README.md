# Automação-API-Rest-Java
Esse é um repositório que contém alguns testes de API Rest, conhecimento adquirido em curso de testes de software criado por Júlio de Lima, os testes foram criados para exercitar a API de software criado para treinos para automação, chamado de Lojinha, criado por Júlio de Lima. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java (https://www.java.com/pt-BR/)
- Maven (https://maven.apache.org/)
- JUnit(https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.2)
- RestAssured(https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.3.0)


## Testes Automatizados
Testes para validar as partições de equivalência relacionados ao valor do produto na aplicação, que estão vinculados diretamente a regra de negócio que diz, ''O valor do produto de estar entre R$ 0,01 e R$ 7.000,00.

## Notas Gerais

- Foi utilizado a anotação Before Each para capturar o token que será utilizado posteriormente nos métodos de teste.
- Foram armazenados os dados enviados para a API em classes POJO.
- Criamos dados iniciais através do uso de classe Data Factory, para facilitar a criação e controle dos mesmos.
- Nesse projeto fazemos utilização do JUnit5, o que nos dá a possibilidade de usar a anotação DysplayName para dar descrições em português para os testes. 
