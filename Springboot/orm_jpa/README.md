# ORM e JPA

## ORM
Mapeamento de Objeto Relacional é um recurso que aproxima a [Programação Orientada à Objetos](https://github.com/lelia-salles/java/tree/main/ProgramacaoOrientada-a-Objetos(POO)) ao contexto de [Banco de Dados Relacional](https://github.com/lelia-salles/Banco-de-Dados-Relacional).

O **ORM** é uma técnica que cria uma "ponte" entre programas orientados a objetos e bancos de dados relacionais. Em vez de escrever consultas SQL diretamente, é possível usar ferramentas para interagir com o banco de dados de forma mais intuitiva, utilizando objetos e classes da linguagem de programação.

O seu uso é realizado por `mapeamento de objeto` para uma tabela por um biblioteca ou framework para transformação de objetos em dados.

## JPA
A **Java Persistence API (JPA)** é uma especificação do Java que define como os dados devem ser persistidos em bancos de dados relacionais que utiliza o conceito de ORM para mapear objetos Java para tabelas de banco de dados e vice-versa.

Ele fornece uma interface padrão para gerenciar entidades persistentes, facilitando o desenvolvimento de aplicações Java que interagem com bancos de dados. É uma specificação baseada em interfaces que usa um framework para reaizar operações de persistência de objetos Java. O framework atende às especificações do JPA para interação com o Banco de Dados. 

### Mapeamento

Aspectos das anotações de mapeamento usadas no JPA. A classe precisa ter `identificação`, atributos com `definições` associadas ao DDL (como objetos e tabelas são criadas dentro do banco de dados - obrigatório, chave, precisão, comprimento, limite de caracteres, características do dado), `relacionamento` entre as tabelas, `herança` mesmo em contexto de banco de dados para manter compatibilidade de estrutura e configuraçãos, `persistência` atribui um valor específico ao Banco de Dados sem explicitar essas informações

#### Principais Implementações de JPA: ####

- **Hibernate:** Uma das implementações mais populares, oferece recursos avançados como cache de segundo nível e suporte a HQL (Hibernate Query Language).
- **EclipseLink:** Uma solução de persistência de código aberto para serviços da Web relacionais, XML e banco de dados.
- **Apache OpenJPA:** Outra implementação popular que pode ser usada como uma camada de persistência independente².

Essas ferramentas e especificações ajudam a simplificar o desenvolvimento e a manutenção de aplicações que precisam interagir com bancos de dados, tornando o processo mais eficiente e seguro.


** Referências:**
 [freeCodeCamp](https://www.freecodecamp.org/portuguese/news/o-que-e-um-orm-o-significado-das-ferramentas-de-mapeamento-relacional-de-objetos-de-banco-de-dados/)
 [DIO](https://www.dio.me/articles/mapeamento-objeto-relacional-orm-em-java-simplificando-o-acesso-a-bancos-de-dados)
[Universidade Java](http://www.universidadejava.com.br/jee/jpa-introducao/)
[O que é um ORM – o significado das ferramentas de mapeamento relacional .... ](https://www.freecodecamp.org/portuguese/news/o-que-e-um-orm-o-significado-das-ferramentas-de-mapeamento-relacional-de-objetos-de-banco-de-dados/)
[Mapeamento Objeto-Relacional (ORM) em Java: Simplificando o Acesso a ....](https://www.dio.me/articles/mapeamento-objeto-relacional-orm-em-java-simplificando-o-acesso-a-bancos-de-dados)
[JPA - Introdução • Universidade Java](http://www.universidadejava.com.br/jee/jpa-introducao/)
[JPA: Examinando os conceitos fundamentais da Jakarta Persistence API](https://www.dio.me/articles/jakarta-persistence-api-jpa)



