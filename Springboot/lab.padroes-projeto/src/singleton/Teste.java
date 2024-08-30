package singleton;

public class Teste {
    public static void main(String[] args) {

        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy); //retorna endereço de memória memória

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

    }
}