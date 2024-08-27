package dio.primeiros_passos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Calculadora calculadora = new Calculadora();
		 * System.out.println("o resultado é: " + soma);
		 * Com Spring Boot não é necessário criar uma nova instancia usando new de forma que o
		 * Springboot possa prover esse mecanismo por causa dos conceitos de invers]ao de controle
		 * e de injeção de dependencias. Isso ficará a encargo de configurações Beans e comandos de i
		 * nicialização da aplicação.
		 * Uma das formas é usar o comando de Comment Line Runner através de uma interface para inicializar
		 * a aplicação com comandos para inicializar objetos que serão disponibilizados pelo container;
		 * */
@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrimeirosPassosApplication.class, args);


	}

}
