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

### O `@EntityManager` é uma interface fundamental na Java Persistence API (JPA) que permite interagir com o contexto de persistência. Aqui estão alguns pontos importantes sobre o `EntityManager`:

Gerencia o ciclo de vida das entidades persistentes. Ele permite criar, ler, atualizar e deletar entidades no banco de dados. Cada instância de `EntityManager` está associada a um contexto de persistência, que é um conjunto de instâncias de entidades que são gerenciadas e rastreadas pelo `EntityManager`².

### Principais Funcionalidades
1. **Persistência de Entidades**: Você pode usar o método `persist()` para salvar uma nova entidade no banco de dados.
2. **Busca de Entidades**: O método `find()` permite buscar uma entidade pelo seu identificador primário.
3. **Atualização de Entidades**: O método `merge()` é usado para atualizar uma entidade existente.
4. **Remoção de Entidades**: O método `remove()` permite deletar uma entidade do banco de dados.
5. **Consultas**: Você pode criar consultas usando JPQL (Java Persistence Query Language) ou SQL nativo com os métodos `createQuery()` e `createNativeQuery()`¹.

### Exemplo de Uso
Aqui está um exemplo básico de como usar o `EntityManager`:

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Criar uma nova entidade
        MinhaEntidade entidade = new MinhaEntidade();
        entidade.setId(1);
        entidade.setNome("Exemplo");
        em.persist(entidade);

        // Buscar uma entidade
        MinhaEntidade encontrada = em.find(MinhaEntidade.class, 1);
        System.out.println(encontrada.getNome());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
```

### Tipos de `EntityManager`
- **Gerenciado pelo Contêiner**: O contêiner (como um servidor de aplicações) gerencia o ciclo de vida do `EntityManager`.
- **Gerenciado pela Aplicação**: A aplicação cria e gerencia o ciclo de vida do `EntityManager`¹.

O `EntityManager` é uma ferramenta poderosa que simplifica muito a interação com bancos de dados em aplicações Java, tornando o desenvolvimento mais eficiente e menos propenso a erros.

** Referências:**
[Baeldung](https://www.baeldung.com/hibernate-entitymanager)
[Oracle](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html)
[EntityManager (Java(TM) EE 7 Specification APIs) - Oracle.](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html).
[ Guide to the Hibernate EntityManager | Baeldung.](https://www.baeldung.com/hibernate-entitymanager).
[How to Access EntityManager with Spring Data | Baeldung.](https://www.baeldung.com/spring-data-entitymanager).
[Java Persistence API (JPA) 之 EntityManager - CSDN博客. ](https://blog.csdn.net/htjl575896870/article/details/138151308).
[EntityManager (Jakarta Persistence API documentation). ](https://jakartaee.github.io/persistence/latest-nightly/api/jakarta.persistence/jakarta/persistence/EntityManager.html).
[freeCodeCamp](https://www.freecodecamp.org/portuguese/news/o-que-e-um-orm-o-significado-das-ferramentas-de-mapeamento-relacional-de-objetos-de-banco-de-dados/)
 [DIO](https://www.dio.me/articles/mapeamento-objeto-relacional-orm-em-java-simplificando-o-acesso-a-bancos-de-dados)
[Universidade Java](http://www.universidadejava.com.br/jee/jpa-introducao/)
[O que é um ORM – o significado das ferramentas de mapeamento relacional .... ](https://www.freecodecamp.org/portuguese/news/o-que-e-um-orm-o-significado-das-ferramentas-de-mapeamento-relacional-de-objetos-de-banco-de-dados/)
[Mapeamento Objeto-Relacional (ORM) em Java: Simplificando o Acesso a ....](https://www.dio.me/articles/mapeamento-objeto-relacional-orm-em-java-simplificando-o-acesso-a-bancos-de-dados)
[JPA - Introdução • Universidade Java](http://www.universidadejava.com.br/jee/jpa-introducao/)
[JPA: Examinando os conceitos fundamentais da Jakarta Persistence API](https://www.dio.me/articles/jakarta-persistence-api-jpa)



