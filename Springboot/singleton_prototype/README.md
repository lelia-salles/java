# Singleton & Prototype

Por vezes é preciso determinar o escopo dos objetos gerenciados pelo conteiner no contexto do Springboot.
* Singleton - usa um objeto a cada necessidade da aplicação
* Prototype - a cada dependência há uma instância correspondete à essa necessidade

Claro! Vamos ver exemplos de uso de Singleton e Prototype no contexto do Spring Boot em cenários da vida real.

### Exemplo de Singleton

Imagine que você tem um serviço que gerencia conexões com um banco de dados. Você quer garantir que apenas uma instância desse serviço seja criada para evitar múltiplas conexões desnecessárias.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class AppConfig {

    @Bean
    public DatabaseConnectionManager databaseConnectionManager() {
        return new DatabaseConnectionManager();
    }
}

@Service
public class DatabaseConnectionManager {

    public DatabaseConnectionManager() {
        // Inicialização da conexão com o banco de dados
        System.out.println("Conexão com o banco de dados criada.");
    }

    public void connect() {
        System.out.println("Conectado ao banco de dados.");
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final DatabaseConnectionManager databaseConnectionManager;

    @Autowired
    public UserService(DatabaseConnectionManager databaseConnectionManager) {
        this.databaseConnectionManager = databaseConnectionManager;
    }

    public void performDatabaseOperation() {
        databaseConnectionManager.connect();
    }
}

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SingletonExampleApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SingletonExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserService userService = context.getBean(UserService.class);
        userService.performDatabaseOperation();
    }
}
```

### Exemplo de Prototype

Agora, imagine que você tem um serviço que gera relatórios. Cada vez que um relatório é gerado, você quer uma nova instância do serviço para garantir que os dados não sejam compartilhados entre diferentes relatórios.

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public ReportGenerator reportGenerator() {
        return new ReportGenerator();
    }
}

@Service
public class ReportGenerator {

    public ReportGenerator() {
        // Inicialização do gerador de relatórios
        System.out.println("Nova instância do gerador de relatórios criada.");
    }

    public void generateReport() {
        System.out.println("Relatório gerado.");
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ReportService {

    private final ApplicationContext context;

    @Autowired
    public ReportService(ApplicationContext context) {
        this.context = context;
    }

    public void createReport() {
        ReportGenerator reportGenerator = context.getBean(ReportGenerator.class);
        reportGenerator.generateReport();
    }
}

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeExampleApplication implements CommandLineRunner {

    @Autowired
    private ReportService reportService;

    public static void main(String[] args) {
        SpringApplication.run(PrototypeExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        reportService.createReport();
        reportService.createReport();
    }
}
```

No exemplo de Singleton, o `DatabaseConnectionManager` é criado uma vez e compartilhado em toda a aplicação. No exemplo de Prototype, uma nova instância de `ReportGenerator` é criada cada vez que um relatório é gerado.

Esses exemplos mostram como você pode usar os escopos Singleton e Prototype em cenários da vida real no Spring Boot. Se precisar de mais alguma coisa ou tiver dúvidas, estou aqui para ajudar!

**Referências**:
(1) [Example Spring codebase containing real world examples (CRUD, auth ....](https://github.com/gothinkster/spring-boot-realworld-example-app)
(2) [Create Spring Prototype Scope Bean with Runtime Arguments](https://www.baeldung.com/spring-prototype-bean-runtime-arguments)
(3) [Java 21 + Spring Boot 3 - GitHub](https://github.com/1chz/realworld-java21-springboot3)
(4)[Real world backend API built in Spring Boot - GitHub](https://github.com/alexey-lapin/realworld-backend-spring)
(5) [Singleton Design Pattern vs Singleton Beans in Spring Boot](https://www.baeldung.com/spring-boot-singleton-vs-beans)
(6) [Injecting Prototype Beans into a Singleton Instance in Spring](https://www.baeldung.com/spring-inject-prototype-bean-into-singleton)
(7) [Singleton Pattern with Spring Boot - miit.tech](https://www.miit.tech/post/singleton-pattern-with-spring-boot)
(8) [How Does the Spring Singleton Bean Serve Concurrent Requests?](https://www.baeldung.com/spring-singleton-concurrent-requests)
(9) [Github Gothinkster](https://github.com/gothinkster/spring-boot-realworld-example-app/blob/master/src/main/resources/schema/schema.graphqls)


