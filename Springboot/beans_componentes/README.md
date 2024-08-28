# Beans vs Components

Beans são elementos responsáveis por criar objetos gerenciados por contêiners, mas quando usar as annotations @Bean e @Component para aprimorar a implementação da Inversão de Controle (IoC) e Injeção de Dependências (DI)?


As anotações `@Bean` `@Autowired` e `@Component` são fundamentais no Spring para implementar IoC e DI, mas cada uma tem seu uso específico (`@Repository` e `@Service` veremos em outra ocasião):

## @Component
- **Uso:** Quando você tem acesso ao código-fonte e deseja que o Spring gerencie automaticamente seus objetos.
- **Funcionamento:** O Spring escaneia o pacote e seus subpacotes em busca de classes anotadas com `@Component` e as registra como beans no contexto da aplicação.
- **Exemplo:** Transformar um arquivo JSON em um objeto. Também é comum em classes de serviço, repositórios, etc.

Você está no caminho certo! Vamos ajustar um pouco o código para garantir que ele funcione corretamente.

### Definindo o Componente

Primeiro, definimos o componente `JsonParser` com a anotação `@Component`:

```java
@Component
public class JsonParser {
    // lógica para transformar JSON em objeto
}
```

### Injetando o Componente com CommandLineRunner

Para injetar o componente `JsonParser` e utilizá-lo na inicialização da aplicação, você pode usar o `CommandLineRunner` dentro de uma classe de configuração ou na classe principal da aplicação. Aqui está um exemplo completo:

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringNameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNameApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(JsonParser parser) {
        return args -> {
            // código, comandos
            System.out.println("Executando o CommandLineRunner com JsonParser");
            // Exemplo de uso do parser
            // parser.parseJson(...);
        };
    }
}
```

### Explicação

1. **Definição do Componente:** `@Component` é usado para que o Spring gerencie a instância de `JsonParser`.
2. **Injeção de Dependência:** O `JsonParser` é injetado no método `run` do `CommandLineRunner` através da anotação `@Bean`.
3. **Execução:** Quando a aplicação é iniciada, o método `run` é executado, permitindo que você utilize o `JsonParser` conforme necessário.

Isso garante a reutilização do componente `JsonParser` sem precisar criar novas instâncias manualmente. O `CommandLineRunner` não é o que permite a injeção de dependência em si. A injeção de dependência é uma funcionalidade do Spring Framework, que permite que o Spring gerencie a criação e a injeção de objetos (beans) em outras partes da aplicação.

- **Injeção de Dependência:** O Spring gerencia a criação e injeção de beans.
- **CommandLineRunner:** Permite executar código após a inicialização da aplicação, mas não é responsável pela injeção de dependência.

#### Papel do CommandLineRunner

O `CommandLineRunner` é uma interface no Spring Boot que permite executar um bloco de código assim que a aplicação é iniciada. Ele é útil para executar tarefas iniciais, como carregar dados ou configurar serviços.

#### Injeção de Dependência

A injeção de dependência é realizada pelo Spring através de anotações como `@Autowired`, `@Component`, `@Service`, `@Repository`, e `@Bean`. No exemplo que discutimos, a injeção de dependência é feita pelo Spring quando ele injeta o `JsonParser` no método `run` do `CommandLineRunner`.

#### Exemplo Completo

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringNameApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNameApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(JsonParser parser) {
        return args -> {
            // código, comandos
            System.out.println("Executando o CommandLineRunner com JsonParser");
            // Exemplo de uso do parser
            // parser.parseJson(...);
        };
    }
}

@Component
public class JsonParser {
    // lógica para transformar JSON em objeto
}
```


## @Bean
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

Essas práticas ajudam a manter seu código desacoplado e mais fácil de testar.

#### Observação

Caso haja necessidade de se criar vários beans para gerenciamento externo, a prática recomendável é criar uma classe Bean ou BeanFactory para não poluir a classe Main com muitas anotações, sendo necessária a inserção da anotação @Configuration antes de @Bean dependendo da versão

**Referências:**
(1) [Inversion of Control and Dependency Injection with Spring - Baeldung.](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring.)
(2) [DIO](https://www.dio.me/articles/inversao-de-controle-e-injecao-de-dependencia-no-spring-simplificado.)
(3) [Beans, entendendo a base fundamental do Spring Framework - DIO](https://www.dio.me/articles/beans-entendendo-a-base-fundamental-do-spring-framework)
(4) [Como funciona a Injeção de Dependências no Spring - AlgaWorks](https://blog.algaworks.com/injecao-de-dependencias-spring/)
(5) [Utilizando boas práticas da Injeção de Dependência com uso do Spring](https://dev.to/joangele/utilizando-boas-praticas-da-injecao-de-dependencia-com-uso-do-spring-b4l)
(6) [Dev](https://dev.to/eidher/spring-injection-types-c6d)
