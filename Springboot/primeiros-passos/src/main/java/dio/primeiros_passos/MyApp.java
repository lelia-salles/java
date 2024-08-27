package dio.primeiros_passos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/*
* classe semelhante ao método main para implemtar o command Line Runner
* Eliminar a necessidade de new usando o Beans para ser gerenciado pelo SpringBoot usando o @Component
 */
@Component
public class MyApp implements CommandLineRunner{
    @Autowired // injeção de dependencia dos componentes
    private Calculadora calculadora; //precisa da calculadora
    @Override
    public void run(String... args) throws Exception {

    }

}
