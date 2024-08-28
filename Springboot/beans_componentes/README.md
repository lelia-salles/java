# Beans vs Components

Beans são elementos responsáveis por criar objetos gerenciados por contêiners, mas quando usar as annotations @Bean e @Component para aprimorar a implementação da Inversão de Controle (IoC) e Injeção de Dependências (DI)?


As anotações `@Bean` e `@Component` são fundamentais no Spring para implementar IoC e DI, mas cada uma tem seu uso específico:

### @Component
- **Uso:** Quando você tem acesso ao código-fonte e deseja que o Spring gerencie automaticamente seus objetos.
- **Funcionamento:** O Spring escaneia o pacote e seus subpacotes em busca de classes anotadas com `@Component` e as registra como beans no contexto da aplicação.
- **Exemplo:** Transformar um arquivo JSON em um objeto, como você mencionou. Também é comum em classes de serviço, repositórios, etc.

```java
@Component // significa que pode injetar este componente em qualquer ecossistema
do springboot sem a necessidade de criar uma nova instância do objeto usando new)
public class JsonParser {
    // lógica para transformar JSON em objeto
}
```

### @Bean
- **Uso:** Quando você precisa de mais controle sobre a criação do bean ou quando está configurando beans de bibliotecas de terceiros.
- **Funcionamento:** Você define métodos anotados com `@Bean` dentro de uma classe de configuração (`@Configuration`). Esses métodos retornam instâncias dos objetos que você deseja que o Spring gerencie.
- **Exemplo:** Configurar um bean de uma biblioteca externa que não pode ser anotada diretamente com `@Component`.

```java
@Configuration
public class AppConfig {
    @Bean
    public ExternalService externalService() {
        return new ExternalService();
    }
}
```

### Quando usar cada um?
- **@Component:** Use quando você está desenvolvendo a classe e pode anotá-la diretamente. É mais simples e direto.
- **@Bean:** Use quando você precisa configurar beans de forma mais detalhada ou quando está lidando com classes de bibliotecas externas. 

Essas práticas ajudam a manter seu código desacoplado e mais fácil de testar,.

**Referências:**
(1) [Inversion of Control and Dependency Injection with Spring - Baeldung.](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring.)
(2) [DIO](https://www.dio.me/articles/inversao-de-controle-e-injecao-de-dependencia-no-spring-simplificado.)
(3) [Beans, entendendo a base fundamental do Spring Framework - DIO](https://www.dio.me/articles/beans-entendendo-a-base-fundamental-do-spring-framework)
(4) [Como funciona a Injeção de Dependências no Spring - AlgaWorks](https://blog.algaworks.com/injecao-de-dependencias-spring/)
(5) [Utilizando boas práticas da Injeção de Dependência com uso do Spring](https://dev.to/joangele/utilizando-boas-praticas-da-injecao-de-dependencia-com-uso-do-spring-b4l)
(6) [Dev](https://dev.to/eidher/spring-injection-types-c6d)
