
# Manager

O **Manager** foi desenvolvido como parte de um projeto acadêmico, com o principal objetivo de aprender e aplicar alguns padrões de design, incluindo Strategy, Template e Singleton, além de explorar conceitos como modelagem de dados e abordagens como Code First e Database First.


## Objetivo

A proposta do projeto é criar um sistema simples de cadastro de usuários, abrangendo categorias como Players e Funcionários. O intuito é fornecer uma API que possa ser integrada em aplicações mobile, facilitando o gerenciamento de usuários.
## Padrões de Design Utilizados

- Strategy: utilizado para definir Roles do Sistema, usando como base a classe RoleStrategy como modelo das demais classes de roles (Analyst, Customer e Developer);
- Template: nesse sistema foi utilizado a classe Person como estrutura para os modelos de Player e Employee;
- Singleton: utilizamos a classe Player como Singleton, para garantir a partir do momento que a API fosse consultada, em nenhum circunstancia houvesse outro Player.
## Abordagens de Desenvolvimento

- Code First: foi utilizada para a criação de todas as classes JPA (Employee, Person, Player e Role).
## Stack utilizada

**Front-end:** JavaScript, Bootstrap, HTML5 e CSS3

**Back-end:** Java, Spring Boot


## Autores

- [@ccesarfp](https://github.com/ccesarfp)
- [@MellPadilha](https://github.com/MellPadilha)
