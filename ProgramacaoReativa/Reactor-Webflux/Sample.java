import java.util.*;
import java.lang.System;
import java.io.*;
import reactor.core.publisher.Mono;
// criar um mono para pegar e para imprimir, precisa se inscrever no fluxo 
public class Sample{
    public static void main(String[] args) {
    /** Mono.justOrEmpty(2)
        Mono.just(1) // recebe 1 ou 0 dado
         Mono.OptionalOrEmpty(Optional.empty()) //imprime null 
            .default.Empty(1); // se não for vazio retorna o default se estiver vazio ou um dado
            .SwitchIfEmpty(Mono.defer (()-> Mono.error(new Exception()))) // se vazio, o retorno é Excpetion
            .doOnSuccess(System.out::println) //declarou o fluxo 
            .map(n -> n * n); // calor do último método que no caso é 2 
        */

//  "a" é a variável que vai receber a entrara do valor que no caso é "2".
// verifica se o resto é zero então imprime "a", se o resto não for zero, imrpime "6"
       Mono.OptionalOrEmpty(Optional.of(2))
            .filter(a -> a % 2 == 0)
            .defaultEmpty(6)
            //.map(String::valueOf);
            .doOnSuccess(System.out::println)

        //  .doOnSuccess(n -> System.out.println(n));
            .subscribe(); // se inscreveu no fluxo para poder imprimir
 
   
    }
}