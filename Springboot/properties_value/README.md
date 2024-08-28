# Application Properties

No Spring Boot, o arquivo `application.properties` é usado para configurar propriedades da aplicação, como parâmetros de conexão com banco de dados, URLs de APIs, entre outros. A anotação `@Value` é utilizada para injetar esses valores de configuração diretamente em campos, métodos ou parâmetros de construtores de classes gerenciadas pelo Spring. Por exemplo, você pode usar `@Value("${property.name}")` para injetar o valor da propriedade `property.name` definida no `application.properties`. Isso facilita a externalização e a gestão centralizada das configurações da aplicação.


(1) [A Quick Guide to Spring @Value | Baeldung.](https://www.baeldung.com/spring-value-annotation)
(2) [Using @Value :: Spring Framework.](https://docs.spring.io/spring-framework/reference/core/beans/annotation-config/value-annotations.html)
(3) [How to Use @Value Annotation in Spring - Apps Developer Blog](https://www.appsdeveloperblog.com/how-to-use-value-annotation-in-spring/)
(4) [Spring @Value Annotation Example - Java Guides.](https://www.javaguides.net/2023/02/spring-value-annotation-example.html)
(5) [Spring Boot @Value Annotation - Dan Vega.](https://www.danvega.dev/blog/spring-boot-value-annotation)

