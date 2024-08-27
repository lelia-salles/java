# SpringBoot

**Spring** é um framework open source desenvolvido para a plataforma Java baseado nos padrões de projetos de inversão de controle (atribuir responsabilidade a um conteiner) e injeção de dependência (adquirir recursos necessários para a aplicação).

A estrutura é baseada em módulos para reduzir a complexidade, ou sehja, cada funcionalidade estará em um módulo.

## Spring Módulos

```mermaid
graph TD
    A[Spring Framework] --> B[Core Container]
    A --> C[Data Access/Integration]
    A --> D[Web]
    A --> E[AOP (Aspect-Oriented Programming)]
    A --> F[Testing]
    A --> G[Security]
    A --> H[Cloud]

    B --> B1[Spring Core]
    B --> B2[Spring Beans]
    B --> B3[Spring Context]
    B --> B4[SpEL]

    C --> C1[JDBC]
    C --> C2[ORM]
    C --> C3[Transaction Management]
    C --> C4[Spring Data]

    D --> D1[Spring Web]
    D --> D2[Spring WebMVC]
    D --> D3[Spring WebFlux]
    D --> D4[Spring WebSocket]

    E --> E1[Spring AOP]
    F --> F1[Spring Test]
    G --> G1[Spring Security]
    H --> H1[Spring Cloud]

**1. Core Container**

* Spring Core: É o núcleo do framework. Este módulo fornece o mecanismo de injeção de dependência (IoC - Inversion of Control), permitindo que os objetos sejam configurados e gerenciados de forma declarativa.

* Spring Beans: Complementa o módulo Core, lidando com a criação, configuração e gerenciamento dos objetos (beans) da aplicação.

* Spring Context: Fornece acesso a objetos configurados. Ele é uma extensão do módulo Core, adicionando suporte a eventos, internacionalização e acesso a recursos.

* Spring Expression Language (SpEL): Uma linguagem expressiva para manipular e consultar beans e propriedades de maneira dinâmica dentro do contexto do Spring.

**2. Data Access/Integration**

* JDBC: Simplifica o uso do JDBC, eliminando a necessidade de código repetitivo ao lidar com exceções, abertura/fechamento de conexões, etc.

* [ORM](https://github.com/lelia-salles/Banco-de-Dados-Relacional/blob/main/conceitos-basicos.md): Integração com frameworks de mapeamento objeto-relacional (ORM) como Hibernate, JPA, JDO, entre outros.
Transaction Management: Facilita a implementação de transações programáticas e declarativas.

* Spring Data: Abstrai e simplifica o acesso a dados em diferentes fontes, oferecendo repositórios genéricos e suporte a várias tecnologias de persistência.

**3. Web**

* Spring Web: Oferece funcionalidades para desenvolvimento de aplicações web, incluindo suporte ao modelo MVC (Model-View-Controller) e integração com tecnologias web como servlets e JSP.

* Spring WebMVC: Um framework completo para desenvolvimento de aplicações web baseadas em MVC. Ele suporta injeção de dependência, validação, e manipulação de exceções, entre outras funcionalidades.

* [Spring WebFlux](https://github.com/lelia-salles/java/tree/main/ProgramacaoReativa/Reactor-Webflux): Um módulo para desenvolvimento de aplicações reativas e não-bloqueantes, baseado no modelo de programação reativa.

* Spring WebSocket: Suporte a comunicação bidirecional em tempo real entre cliente e servidor usando WebSockets.

**4. AOP (Aspect-Oriented Programming)**

* Spring AOP: Permite a implementação de funcionalidades transversais (como logging, segurança, transações) de forma modular, através de aspectos que podem ser aplicados em pontos específicos do código.

**5. Testing**

Spring Test: Fornece suporte para testes de unidade e integração com o framework Spring, permitindo a execução de testes com contextos configuráveis, suporte a mock objects e muito mais.

**6. Security**

* Spring Security: Um módulo especializado para implementar autenticação e autorização em aplicações Java, com suporte a várias tecnologias de segurança, como OAuth, JWT, e autenticação baseada em tokens.

**7. Cloud**

* Spring Cloud: Um conjunto de ferramentas para construção de sistemas distribuídos e nativos da nuvem, facilitando a implementação de padrões como configuração distribuída, descoberta de serviços, circuit breakers, e muito mais.
