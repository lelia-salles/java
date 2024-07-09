import java.util.*;
import java.lang.System;
import java.io.*;
import reactor.core.publisher.Flux;

public class Sample1{
    public static void main(String[] args) {

        FlexfromIterable(List.of(1,,2,3,4,5,6)) //imprime um a um
        .map(n -> n * 10) // multiplica um a um em cada linha
        .collectList() // imprime como em um array [10, 20 etc]

        .doOnNext(System.out::println)
        .doOnSuccess();


    }
}
