# Singleton & Prototype

Por vezes é preciso determinar o escopo dos objetos gerenciados pelo conteiner no contexto do Springboot.
* Singleton - usa um objeto a cada necessidade da aplicação
* Prototype - a cada dependência há uma instância correspondete à essa necessidade

Claro! Vamos ver exemplos de uso de Singleton e Prototype no contexto do Spring Boot em cenários da vida real.

#### Exemplo de Singleton

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

#### Exemplo de Prototype

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

Outra coisa importante de mencionar é que para que duas variáveis sejam devidamente referenciadas, é necessário especificar com a anotação @Scope ("prototype") que a aplicação deve retornar mais de um objeto.

Vamos considerar um serviço de pedidos em um sistema de e-commerce. Nesse cenário, você pode usar o escopo Singleton para gerenciar a conexão com o banco de dados e o escopo Prototype para criar novos pedidos.

#### Exemplo de Singleton: Gerenciamento de Conexão com o Banco de Dados

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
public class OrderService {

    private final DatabaseConnectionManager databaseConnectionManager;

    @Autowired
    public OrderService(DatabaseConnectionManager databaseConnectionManager) {
        this.databaseConnectionManager = databaseConnectionManager;
    }

    public void processOrder() {
        databaseConnectionManager.connect();
        System.out.println("Pedido processado.");
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
        OrderService orderService = context.getBean(OrderService.class);
        orderService.processOrder();
    }
}
```

#### Exemplo de Prototype: Criação de Novos Pedidos

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Order order() {
        return new Order();
    }
}

@Service
public class Order {

    private static int counter = 0;
    private int id;

    public Order() {
        this.id = ++counter;
        System.out.println("Nova instância de pedido criada: Pedido #" + id);
    }

    public int getId() {
        return id;
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final ApplicationContext context;

    @Autowired
    public OrderService(ApplicationContext context) {
        this.context = context;
    }

    public void createOrder() {
        Order order = context.getBean(Order.class);
        System.out.println("Pedido criado com ID: " + order.getId());
    }
}

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeExampleApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(PrototypeExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.createOrder();
        orderService.createOrder();
    }
}
```

- **Singleton**: `DatabaseConnectionManager` é um bean Singleton que gerencia a conexão com o banco de dados. Isso garante que apenas uma instância da conexão seja criada e usada em toda a aplicação, economizando recursos.

- **Prototype**: `Order` é um bean Prototype que representa um pedido. Cada vez que um novo pedido é criado, uma nova instância de `Order` é gerada, garantindo que cada pedido tenha seu próprio estado independente.

Esses exemplos mostram como você pode aplicar os escopos Singleton e Prototype em um cenário de e-commerce no Spring Boot. Se precisar de mais alguma coisa ou tiver dúvidas, estou aqui para ajudar!



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


