package lanchonete;
import lanchonete.cozinha;

public class Almoxarife {
	private void controlarEntrada() {
		System.out.println("CONTROLANDO A ENTRADA DOS ITENS");
	}
	private void controlarSaida() {
		System.out.println("CONTROLANDO A SAIDA DOS ITENS");
	}
	void entregarIngredientes() {
		System.out.println("ENTREGANDO INGREDIENTES");
		//método acessado apenas para o almoxarife
		//void permite que o cozinheiro acesse esse método
		controlarSaida();
	}
	void trocarGas() {
		System.out.println("ALMOXARIFE TROCANDO O GÁS");
	}
}