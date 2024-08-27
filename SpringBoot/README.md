# Spring Framework

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

## Scope

Existem 5 tipos de escopo categorizados para conceitos ```standalone``` e ```http(web)```

No Spring Framework, o **escopo** de um bean determina a sua vida útil e a forma como o contêiner gerencia suas instâncias. Em outras palavras, o escopo define quantas instâncias de um bean existirão e por quanto tempo elas serão mantidas pelo contêiner Spring. Existem vários escopos predefinidos que você pode configurar para beans, cada um com características específicas que atendem a diferentes necessidades de aplicação.

1. **Singleton** (padrão): É o escopo mais comum, onde o Spring cria uma única instância do bean e a reutiliza em toda a aplicação. Essa instância única é compartilhada entre todos os componentes que solicitam o bean, o que economiza recursos e melhora o desempenho. O bean no escopo singleton é criado quando o contêiner é iniciado e destruído quando o contêiner é encerrado.

2. **Prototype**: Nesse escopo, o Spring cria uma nova instância do bean cada vez que ele é solicitado. Isso é útil para beans que mantêm estado ou têm comportamento específico para cada instância. Beans com escopo prototype não são gerenciados pelo contêiner depois que são criados, portanto, o gerenciamento do ciclo de vida após a criação fica a cargo do desenvolvedor.

3. **Request**: Este escopo é específico para aplicações web e cria uma nova instância do bean para cada solicitação HTTP. Isso significa que cada solicitação recebe uma instância separada do bean, e essa instância é destruída ao final da solicitação. É útil para beans que precisam manter estado relacionado a uma única requisição do usuário.

4. **Session**: Também específico para aplicações web, o escopo session cria uma nova instância do bean para cada sessão HTTP. A instância do bean é associada a uma sessão do usuário e é destruída quando a sessão termina. Esse escopo é adequado para beans que precisam manter estado ao longo de uma sessão do usuário.

Claro! Vou completar a explicação do escopo **Global Session**:

5. **Global Session**: É semelhante ao escopo **Session**, mas é utilizado em ambientes de múltiplos portais, como em aplicações web que utilizam portlets. O escopo **Global Session** cria uma instância do bean para cada sessão global e mantém essa instância durante a vida da sessão global. Esse escopo é útil em contextos onde múltiplas aplicações ou portlets compartilham a mesma sessão global e precisam acessar e manipular o mesmo estado de sessão.

## Autowired

Uma anotação onde deverá ocorrer uma injeção automática de dependência

* byName - busca o método set que corresponde ao nome do Bean
* byName - considera o tipo da classe para a inclusão do Bean
* byType - usamos o construtor para incluir a dependência

O **@Autowired** é uma anotação fornecida pelo Spring Framework que facilita a injeção de dependências em componentes Spring. Essa anotação permite que o Spring resolva e injetar automaticamente as dependências de um bean, eliminando a necessidade de configuração manual e explícita.

Quando um bean é anotado com **@Autowired**, o Spring tenta encontrar e injetar uma instância do tipo especificado no bean anotado. Isso pode ocorrer em diversos contextos, como em construtores, métodos setters ou diretamente em campos. A injeção pode ser feita de três maneiras principais:

1. **Injeção por Construtor**: A anotação **@Autowired** pode ser aplicada ao construtor de uma classe. O Spring identificará quais dependências devem ser injetadas com base nos parâmetros do construtor e as fornecerá automaticamente quando criar o bean.

   ```java
   @Component
   public class MyService {
       private final MyRepository repository;

       @Autowired
       public MyService(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```

2. **Injeção por Setter**: **@Autowired** pode ser aplicada a um método setter. O Spring chamará esse método após a criação do bean, passando a dependência necessária como argumento.

   ```java
   @Component
   public class MyService {
       private MyRepository repository;

       @Autowired
       public void setRepository(MyRepository repository) {
           this.repository = repository;
       }
   }
   ```

3. **Injeção por Campo**: **@Autowired** também pode ser aplicada diretamente em campos da classe. O Spring injetará a dependência diretamente no campo correspondente. Embora seja mais simples, essa abordagem é menos recomendada porque torna o código menos testável e mais difícil de manter.

   ```java
   @Component
   public class MyService {
       @Autowired
       private MyRepository repository;
   }
   ```

O Spring realiza a injeção de dependências com base no tipo do bean. Se houver mais de uma instância do tipo desejado, o Spring tentará resolver o conflito com base em nomes ou qualificadores adicionais. Em casos onde não há uma instância disponível e a injeção não é obrigatória, o Spring pode configurar o bean para ser `null`, ou você pode usar o atributo `required=false` para indicar que a injeção é opcional.

Em resumo, **@Autowired** simplifica a injeção de dependências, permitindo que o Spring gerencie automaticamente as instâncias e resolva as dependências necessárias, promovendo um design mais limpo e desacoplado.

No Spring Framework, **byName**, **byType** e **byConstructor** são estratégias para a injeção de dependências que o contêiner Spring pode utilizar para resolver e fornecer as dependências necessárias a um bean. Cada estratégia determina a forma como o Spring identifica e injeta as dependências. Aqui está uma explicação de cada uma:

### 1. **byName**

A injeção **byName** é baseada no nome do bean. Quando o Spring utiliza essa estratégia, ele procura por um bean com o mesmo nome que o nome do campo ou propriedade onde a dependência deve ser injetada.

- **Como Funciona**: O contêiner Spring verifica o nome do campo ou da propriedade onde a dependência deve ser injetada e procura um bean registrado com o mesmo nome no contêiner. Se encontrar uma correspondência, ele injeta essa instância no campo ou na propriedade.

- **Exemplo**:

  ```java
  @Component
  public class MyService {
      private MyRepository repository;

      @Autowired
      public void setRepository(MyRepository repository) {
          this.repository = repository;
      }
  }

  @Component
  public class MyRepository {
      // implementação do repositório
  }
  ```

  No exemplo acima, se você registrar o bean `MyRepository` no contêiner, o Spring injetará automaticamente a instância do `MyRepository` no campo `repository` do `MyService` com base no nome do campo.

### 2. **byType**

A injeção **byType** é baseada no tipo do bean. Com essa estratégia, o Spring procura um bean que corresponda ao tipo do campo ou da propriedade onde a dependência deve ser injetada.

- **Como Funciona**: O Spring verifica o tipo do campo ou da propriedade e procura um bean registrado com o mesmo tipo no contêiner. Se encontrar exatamente um bean do tipo correspondente, ele injeta essa instância.

- **Exemplo**:

  ```java
  @Component
  public class MyService {
      @Autowired
      private MyRepository repository;

      // A dependência MyRepository será injetada com base no tipo
  }

  @Component
  public class MyRepository {
      // implementação do repositório
  }
  ```

  Neste exemplo, o Spring injetará a instância de `MyRepository` no campo `repository` de `MyService` com base no tipo `MyRepository`.

### 3. **byConstructor**

A injeção **byConstructor** é baseada no tipo dos parâmetros do construtor. Quando você utiliza essa estratégia, o Spring resolve as dependências fornecidas ao construtor de uma classe.

- **Como Funciona**: O Spring analisa os parâmetros do construtor e procura por beans que correspondam aos tipos dos parâmetros. Ele cria a instância do bean e injeta as dependências fornecidas pelo construtor.

- **Exemplo**:

  ```java
  @Component
  public class MyService {
      private final MyRepository repository;

      @Autowired
      public MyService(MyRepository repository) {
          this.repository = repository;
      }
  }

  @Component
  public class MyRepository {
      // implementação do repositório
  }
  ```

  No exemplo acima, o Spring cria uma instância de `MyService` e injeta uma instância de `MyRepository` no construtor de `MyService`, com base no tipo do parâmetro do construtor.

# Springboot

O Spring Boot é uma extensão do Spring Framework que facilita o desenvolvimento de aplicações Java ao simplificar a configuração e inicialização. Ele oferece configurações automáticas, dependências “starter” para incluir bibliotecas necessárias, e servidores embutidos como **Tomcat** ou **Jetty**, eliminando a necessidade de configuração externa. 

Antes do Springboot havia maior dependência individual, verbosidade, incompatibilidade entre versões, complexidade de gestão, configurações complexas e repetitivas

Com o Spring Boot, é possível criar aplicações robustas e prontas para produção com menos esforço e código, tornando o desenvolvimento mais ágil e eficiente.

Enquanto o Spring Framework é baseado no padrão de injeção de dependências, o Springboot foca na configuração automática.

| **Aspecto**             | **Spring Framework**                                                                 | **Spring Boot**                                                                 |
|-------------------------|--------------------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| **Configuração**        | Requer configurações detalhadas, muitas vezes em arquivos XML.                       | Minimiza configurações com automação e anotações.                               |
| **Inicialização**       | Pode ser mais demorado devido à necessidade de configurações manuais.                | Permite iniciar rapidamente com menos código e configurações.                   |
| **Dependências**        | Necessário adicionar cada dependência manualmente.                                   | Simplifica a gestão de dependências com "starters".                             |
| **Servidor Embutido**   | Não possui servidor embutido, requer configuração externa.                           | Inclui servidores embutidos como Tomcat ou Jetty.                               |
| **Funcionalidades**     | Oferece suporte a IoC, DI, Spring MVC, Spring Security, Spring Data, Spring AOP, etc. | Inclui todas as funcionalidades do Spring Framework com configurações simplificadas. |
| **Monitoramento**       | Requer configuração adicional para monitoramento e métricas.                         | Ferramentas integradas para monitoramento e métricas.                           |

## Starters

No contexto do Spring Boot, starters são pacotes de dependências pré-configurados que facilitam a inclusão de funcionalidades específicas em um projeto. Por exemplo:

data-jpa: Integração ao banco de dados via JPA - Hibernate.
data-mongodb: Interação com banco de dados MongoDB.
web: Inclusão do container Tomcat para aplicações REST.
web-services: Webservices baseados na arquitetura SOAP. 
batch: Implementação de JOBs de processos.
test: Disponibilização de recursos para testes unitários como JUnit
openfeign: Client HTTP baseado em interfaces
actuator: Gerenciamento de monitoramento da aplicação. 



Benefícios do Starter: coesão, versões compatíveis, otimização do tempo, configuração simples, foco no negócio.

### Referências
1. [www.fusion-reactor.com](https://www.fusion-reactor.com/blog/the-difference-between-spring-framework-vs-spring-boot/)
2. [https://dev.to](https://dev.to/eduwyre/settling-spring-vs-spring-boot-debate-8ek )
3. [https://www.reply.com](https://www.reply.com/solidsoft-reply/en/content/webservices-soap-and-rest-a-simple-introduction)
4. [https://www.geeksforgeeks.org](https://www.geeksforgeeks.org/difference-between-spring-and-spring-boot/)
5. [https://github.com/digitalinnovationone](https://github.com/digitalinnovationone/dio-springboot)

