import facade.Facade;
import singleton.SingletonEager;
import singleton.SingletonLazy;
import singleton.SingletonLazyHolder;
import strategy.ComportamentoAgressivo;
import strategy.ComportamentoDefensivo;
import strategy.ComportamentoNormal;
import strategy.Robo;

public class Teste {

    public static void main(String[] args) {

        //Singleton

        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy); //retorna endereço de memória memória

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);

        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

        //Strategy usa o polimorfismo

        ComportamentoNormal normal = new ComportamentoNormal();
        ComportamentoDefensivo defensivo = new ComportamentoDefensivo();
        ComportamentoAgressivo agressivo = new ComportamentoAgressivo();


        //criando o robo
        Robo robo = new Robo();

        robo.setCStrategy(normal);
        robo.mover();
        robo.mover();
        robo.setCStrategy(defensivo);
        robo.mover();
        robo.mover();
        robo.setCStrategy(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();


    }

    // Facade

    Facade facade = new Facade();

    facade.migrarCliente("Lelia","70000000")

}