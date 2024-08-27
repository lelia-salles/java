package dio.primeiros_passos;

import org.springframework.stereotype.Component;

@Component // elimina a necessidade do new
public class Calculadora {
    public int somar(int num1, int num2) {
        return num1 + num2;
    }
}
