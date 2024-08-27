# SpringBoot

**Spring** é um framework open source desenvolvido para a plataforma Java baseado nos padrões de projetos de inversão de controle (atribuir responsabilidade a um conteiner) e injeção de dependência (adquirir recursos necessários para a aplicação).

A estrutura é baseada em módulos para reduzir a complexidade, ou sehja, cada funcionalidade estará em um módulo.

## Spring Módulos

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

## Spring vs Java EE

| Aspecto                    | Java EE                                              | Spring Boot                                         |
|----------------------------|------------------------------------------------------|-----------------------------------------------------|
| **Arquitetura e Abordagem**| Especificação completa com APIs e diretrizes, baseada em servidores de aplicação como WildFly e GlassFish. | Framework que facilita a criação de aplicações autossuficientes com configuração mínima e contêiner embutido. |
| **Facilidade de Uso**      | Mais complexo, exige configuração manual e conhecimento detalhado dos servidores de aplicação. | Focado na simplicidade e rapidez, com configuração automática e menor esforço de desenvolvimento. |
| **Configuração**           | Utiliza arquivos XML e anotações, exigindo configuração manual para componentes como EJBs e JMS. | Adota configuração automática com arquivos `application.properties` ou `application.yml` e suporte a anotações. |
| **Desempenho e Escalabilidade** | Projetado para aplicações grandes e escaláveis, mas pode exigir ajuste de desempenho. | Otimizado para iniciar rapidamente e escalar, ideal para microserviços e aplicações em nuvem. |
| **Comunidade e Suporte**   | Suportado por grandes empresas como Oracle e IBM, com uma comunidade robusta e recursos corporativos. | Mantido pela Pivotal e uma comunidade vibrante, com ampla documentação e suporte para novas tecnologias. |
| **Evolução e Inovação**    | Evolui mais lentamente com processos de padronização, agora parte da Eclipse Foundation como Jakarta EE. | Evolui rapidamente com novas funcionalidades e melhorias frequentes, focado em inovação prática. |

## Inversão de Controle (IoC)

A inversão de controle (IoC, do inglês Inversion of Control) é um princípio fundamental no design de software que visa desacoplar componentes de um sistema, facilitando a modularidade e a manutenção. 

Em termos simples, a IoC refere-se à mudança na responsabilidade pela criação e gerenciamento de objetos de uma aplicação do próprio código de implementação para um mecanismo externo (container).

Tradicionalmente, em um [programa orientado a objetos](https://github.com/lelia-salles/java/tree/main/ProgramacaoOrientada-a-Objetos(POO)), um componente cria suas próprias dependências e controla seu ciclo de vida. 

Por exemplo, se um componente precisa de um serviço, ele mesmo cria uma instância desse serviço ou o busca de alguma forma. Com a **inversão de controle, essa responsabilidade é delegada a um contêiner ou framework**, que cuida da criação e gerenciamento dos objetos e suas dependências.

Existem várias formas de implementar a IoC, mas uma das mais comuns é a ```injeção de dependência.``` Na injeção de dependência, o contêiner IoC fornece os objetos necessários para um componente quando ele é instanciado. 

Isso pode ocorrer através de injeção por [construtor](https://github.com/lelia-salles/java/tree/main/ProgramacaoOrientada-a-Objetos(POO)/Construtores), injeção por [setter](https://github.com/lelia-salles/java/tree/main/ProgramacaoOrientada-a-Objetos(POO)/Getter_Setters/) ou injeção por método. 

Por exemplo, em um framework como o Spring, você pode definir como um objeto deve ser criado e quais suas dependências em um arquivo de configuração ou por anotações. 

O contêiner Spring então cria o objeto, resolve suas dependências e o injeta no lugar apropriado no momento da execução.

A principal vantagem da IoC é o **desacoplamento**. Ao transferir a responsabilidade pela criação e gestão de objetos para um contêiner externo, você reduz a dependência direta entre os componentes do sistema. 

Isso facilita a substituição e a modificação de componentes, promove o reuso e melhora a testabilidade, pois você pode facilmente injetar mocks ou stubs em vez de instâncias reais durante os testes.

## Injeção de Dependências

A injeção de dependência é um padrão de design fundamental no desenvolvimento de software que visa promover o desacoplamento entre componentes e facilitar a gestão de suas dependências. 

Em termos simples, a injeção de dependência é uma forma de ```implementar``` a inversão de controle (IoC) onde as dependências de um objeto são fornecidas a ele externamente, em vez de serem criadas e gerenciadas pelo próprio objeto.

Quando um objeto necessita de outro objeto para funcionar corretamente, essa necessidade é chamada de dependência. Em vez de um objeto criar ou localizar suas próprias dependências, o contêiner de injeção de dependência é responsável por fornecer essas dependências. 

Essa abordagem é comumente usada em frameworks modernos como o Spring, onde as dependências são configuradas externamente e injetadas no objeto quando ele é criado.

Como dito anteriormente,  **injeção de dependência** pode ocorrer de várias maneiras: 

* injeção por construtor, onde as dependências são passadas para o objeto através de seu construtor; 
* injeção por setter, onde as dependências são fornecidas através de métodos setters após a criação do objeto; 
* injeção por método, onde as dependências são passadas diretamente para métodos específicos do objeto.

Esse padrão oferece várias vantagens, incluindo a redução do acoplamento entre componentes, o que torna o código mais modular e flexível. Também melhora a testabilidade, pois facilita a substituição de dependências reais por mocks ou stubs durante os testes. 

Além disso, a injeção de dependência ajuda a centralizar a configuração e o gerenciamento de dependências, tornando o código mais fácil de manter e evoluir.

## Beans

No contexto do Spring Framework, um **bean** é um objeto que é gerenciado pelo contêiner Spring. Representa componentes essenciais de uma aplicação é criado, configurado e mantido pelo contêiner, que cuida de seu ciclo de vida e suas dependências.

São objetos gerenciados pelo contêiner Spring, cuja criação e configuração são controladas externamente, promovendo um design desacoplado e facilitando a manutenção e a evolução da aplicação.


Um bean no Spring **é basicamente uma instância de uma classe** que o contêiner Spring configura e gerencia. A configuração dos beans é **geralmente feita em arquivos de configuração XML, por anotações no código ou por meio de uma configuração baseada em Java**. O contêiner utiliza essas configurações para criar e injetar beans conforme necessário.

```Os beans são definidos com base em configurações fornecidas pelo desenvolvedor, como o escopo de vida (por exemplo, singleton ou prototype), as dependências que eles precisam (que são injetadas pelo contêiner), e outras propriedades específicas.```

O Spring cuida de instanciar o bean, resolver suas dependências e, em muitos casos, garantir que ele seja adequadamente inicializado e finalizado.

A principal **vantagem** do uso de beans no Spring é o **gerenciamento centralizado e a desacoplação dos componentes da aplicação**. 

Ao permitir que o contêiner Spring crie e gerencie beans, você **reduz a necessidade de código manual** para a criação e configuração desses componentes, o que resulta em um design mais modular e flexível. 

Além disso, isso **facilita o gerenciamento de aspectos como transações, segurança e aspectos de integração com outras tecnologias**, uma vez que o contêiner pode aplicar essas funcionalidades de forma consistente e automatizada.




