public class Carro{
           //cria um objeto da Classe Carro

        public static void main(String[] args) {
        // Criação de um objeto "carro1"
        Carro carro1 = new Carro();

        // Configurando as características do objeto
        carro1.cor = "Vermelho";
        carro1.marca = "Ferrari";
        carro1.velocidade = 0;

        // Acelerando o carro é ummétodo
        carro1.acelerar();
        carro1.acelerar();
        carro1.acelerar();

        // Mostrando os detalhes do carro
        carro1.mostrarDetalhes();
    }
}