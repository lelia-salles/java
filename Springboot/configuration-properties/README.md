# Configuration Properties

@ConfigurationPorperties é uma anotação dependente do application.properties para centralizar todas as informações pertinentes a um contexto. Todos os valores de um Bean será enviado pelo application properties através do configuration properties. Exemplo de uso: autenticação, envio de mensagens, acesso FTP.

A anotação `@ConfigurationProperties` é usada para mapear propriedades de configuração externas (como arquivos `application.properties` ou `application.yml`) para objetos Java. Isso facilita a gestão de configurações complexas e hierárquicas.

## Como usar `@ConfigurationProperties`?

Neste exemplo temos o envio de mensagens por e-mail.

1. **Adicionar dependências**: Certifique-se de que você tem as dependências necessárias no seu `pom.xml`:

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    ```

2. **Criar uma classe de configuração**: Crie uma classe POJO (Plain Old Java Object) para armazenar as propriedades.

    ```java
    import org.springframework.boot.context.properties.ConfigurationProperties;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    @ConfigurationProperties(prefix = "mail")
    public class MailProperties {
        private String hostName;
        private int port;
        private String from;

        // Getters e Setters
        public String getHostName() { return hostName; }
        public void setHostName(String hostName) { this.hostName = hostName; }
        public int getPort() { return port; }
        public void setPort(int port) { this.port = port; }
        public String getFrom() { return from; }
        public void setFrom(String from) { this.from = from; }
    }
    ```

3. **Configurar o arquivo de propriedades**: Adicione as propriedades no arquivo `application.properties` ou `application.yml`.

    ```properties
    mail.hostName=smtp.example.com
    mail.port=587
    mail.from=no-reply@example.com
    ```

4. **Habilitar a configuração**: Certifique-se de que a classe de configuração está sendo escaneada pelo Spring Boot.

    ```java
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.boot.context.properties.EnableConfigurationProperties;

    @SpringBootApplication
    @EnableConfigurationProperties(MailProperties.class)
    public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
    ```


### Exemplo 1: Configuração de um Servidor de E-mail

Imagine que você precisa configurar um servidor de e-mail para enviar notificações. Usando `@ConfigurationProperties`, você pode facilmente gerenciar essas configurações.

1. **Classe de Propriedades**:

    ```java
    @Configuration
    @ConfigurationProperties(prefix = "email")
    public class EmailProperties {
        private String host;
        private int port;
        private String username;
        private String password;

        // Getters e Setters
    }
    ```

2. **Arquivo de Propriedades** (`application.properties`):

    ```properties
    email.host=smtp.mailtrap.io
    email.port=2525
    email.username=your-username
    email.password=your-password
    ```

3. **Classe de Serviço**:

    ```java
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class EmailService {
        private final EmailProperties emailProperties;

        @Autowired
        public EmailService(EmailProperties emailProperties) {
            this.emailProperties = emailProperties;
        }

        public void sendEmail(String to, String subject, String body) {
            // Lógica para enviar e-mail usando as propriedades configuradas
            System.out.println("Enviando e-mail para " + to);
            System.out.println("Host: " + emailProperties.getHost());
            System.out.println("Port: " + emailProperties.getPort());
        }
    }
    ```

### Exemplo 2: Configuração de Conexão com Banco de Dados

1. **Classe de Propriedades**:

    ```java
    @Configuration
    @ConfigurationProperties(prefix = "database")
    public class DatabaseProperties {
        private String url;
        private String username;
        private String password;

        // Getters e Setters
    }
    ```

2. **Arquivo de Propriedades** (`application.properties`):

    ```properties
    database.url=jdbc:mysql://localhost:3306/mydb
    database.username=root
    database.password=secret
    ```

3. **Classe de Configuração**:

    ```java
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import javax.sql.DataSource;
    import org.apache.commons.dbcp2.BasicDataSource;

    @Configuration
    public class DataSourceConfig {
        private final DatabaseProperties databaseProperties;

        @Autowired
        public DataSourceConfig(DatabaseProperties databaseProperties) {
            this.databaseProperties = databaseProperties;
        }

        @Bean
        public DataSource dataSource() {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(databaseProperties.getUrl());
            dataSource.setUsername(databaseProperties.getUsername());
            dataSource.setPassword(databaseProperties.getPassword());
            return dataSource;
        }
    }
    ```

Referências;
(1) [Guide to @ConfigurationProperties in Spring Boot | Baeldung.](https://www.baeldung.com/configuration-properties-in-spring-boot).
(2) [Properties and Configuration :: Spring Boot.](https://docs.spring.io/spring-boot/how-to/properties-and-configuration.html).
(3) [Common Application Properties :: Spring Boot.](https://docs.spring.io/spring-boot/appendix/application-properties/index.html).
(4) [Spring Boot @ConfigurationProperties: Binding external configurations ....](https://www.callicoder.com/spring-boot-configuration-properties-example/).
(5) [Testes realmente unitários no Spring Boot - DEV Community.](https://dev.to/luizleite_/testes-realmente-unitarios-no-spring-boot-3gm8).
(6) [Tutorial do Apidog: Como Criar Cenários de Teste com Exemplos. ](https://apidog.com/pt/blog/create-test-scenarios-with-examples/).
(7) [Aplicação Web com Spring Boot e Spring MVC - DevMedia.](https://www.devmedia.com.br/desenvolvendo-uma-aplicacao-web-com-spring-boot-e-spring-mvc/34122).
(8) [Example Spring codebase containing real world examples (CRUD, auth ....](https://github.com/gothinkster/spring-boot-realworld-example-app).
(9) [Java 21 + Spring Boot 3 - GitHub.](https://github.com/1chz/realworld-java21-springboot3).
(10) [GitHub - Drill4J/spring-boot-realworld-example-app: Backend for https ....](https://github.com/Drill4J/spring-boot-realworld-example-app).
(11) [Spring Boot Secret Properties: How to store secrets in your Configuration Properties.](https://www.youtube.com/watch?v=PmGLn3ua_lU).
(12) [Spring Boot @ConfigurationProperties Annotation Tutorial. ](https://www.youtube.com/watch?v=23FaI_EWH4w).
(13) [Spring Boot + Apache Kafka Tutorial - #5 - Configure Kafka Producer and Consumer].(https://www.youtube.com/watch?v=xCyW3S-vgGA).
(14) [How To Use @ConfigurationProperties In Spring Boot.](https://www.zainabed.com/tutorials/spring-boot-configuration-properties-tutorial/).
(15) [Configuring a Spring Boot Module with @ConfigurationProperties.](ttps://reflectoring.io/spring-boot-configuration-properties/).
(16)[Github Gothinkster](https://github.com/gothinkster/spring-boot-realworld-example-app/blob/master/src/main/resources/schema/schema.graphqls).
(17) [github.com Lukerano](https://github.com/lukereno/tutorials/tree/aea1c41d3e71130752d89e3c4e7d83dfeadac078/spring-boot%2Fsrc%2Fmain%2Fjava%2Forg%2Fbaeldung%2Fproperties%2FConfigProperties.java).
(18) [DIO](https://github.com/digitalinnovationone/dio-springboot)


