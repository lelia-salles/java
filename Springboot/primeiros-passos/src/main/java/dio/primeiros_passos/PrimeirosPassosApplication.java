package dio.primeiros_passos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {

		//cria o objeto scanner para ler a entrada do usuário
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite um número inteiro: ");
		int num1 = scanner.nextInt();
		System.out.println("Digite o segundo número inteiro: ");
		int num2 = scanner.nextInt();

		int soma = num1 + num2;

		SpringApplication.run(PrimeirosPassosApplication.class, args);

		Calculadora calculadora = new Calculadora();

		System.out.println("o resultado é: " + soma);
	}

}
