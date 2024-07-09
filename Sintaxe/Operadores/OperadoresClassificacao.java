public class OperadoresCalassificacao {
    public static void main(String[] args) throws Exception {

/**cada tipo de dado tem uma forma específica de ser declarado */
String nome = "GLEYSON"; //entre aspas
int idade = 22; //número inteiro
double peso = 68.5; //número decimal
char sexo = 'M'; //um único caractere
boolean doadorOrgao = false; // verdadeiro ou falso
/* Date dataNascimento = new Date(); 
variável é uma classe Date que será um novo objeto 
Date apresenta erro porque não há uma classe Date */

//Variáveis aritméticas

double soma = 10.5 + 15.7;
int subtracao = 113 - 25;
int multiplicacao = 20 * 7;
int divisao = 15 / 3;
int modulo = 18 % 3;
double resultado = (10 * 7) + (20/4);
        
 // não se concatena número com texto assim como no exemplo dado ou se concatena porém sem fazer operações matemáticas

//realizara o teste usando o breakpoint a partir da linha 26
String nomeCompleto = "LINGUAGEM" + "JAVA";
		
//qual o resultado das expressoes abaixo?
String concatenacao ="?"; 

concatenacao = 1+1+1+"1";
    System.out.println(concatenacao);

concatenacao = 1+"1"+1+1;
    System.out.println(concatenacao);

concatenacao = 1+"1"+1+"1";
    System.out.println(concatenacao);

concatenacao = "1"+1+1+1;
    System.out.println(concatenacao);

concatenacao = "1"+(1+1+1);
System.out.println(concatenacao);

    } 
    
   //operadores unários
int numero = 5;
		
//Imprimindo o numero negativo
System.out.println(- numero);

//incrementando numero em mais 1 numero, imprime 6
numero ++;
System.out.println(numero);

//incrementando numero em mais 1 numero, imprime 7
System.out.println(numero ++);// ops algo de errado não está certo

System.out.println(numero);// agora sim, numero virou 7

//ordem de precedencia conta aqui
System.out.println(++ numero);

boolean verdadeiro = true;

System.out.println("Inverteu " + !verdadeiro);

// operador ternário
int a, b;

a = 5;
b = 6;

/* EXEMPLO DE CONDICIONAL UTILIZANDO UMA ESTRUTURA IF/ELSE
if(a==b)
   resultado = "verdadeiro";
else
   resultado = "falso";
*/

//MESMA CONDICIONAL, MAS DESSA VEZ, UTILIZANDO O OPERADOR CONDICIONAL TERNÁRIO
String resultado = (a==b) ? "verdadeiro" : "false";

System.out.println(valor);

// Operadores lógicos
boolean condicao1=true;

boolean condicao2=false;

/* Aqui estamos utilizando o operador lógico E para fazer a união de duas 
expressões. 
É como se estivesse escrito:
 "Se Condicao1 e Condicao2 forem verdadeiras, executar código"
*/

if(condicao1 && condicao2)
	System.out.print("Os dois valores precisam ser verdadeiros");;

//Se condicao1 OU condicao2 for verdadeira, executar código.
if(condicao1 || condicao2)
	System.out.print("Um dos valores precisa ser verdadeiro");
}

// Relacionais
//classe Operadores.java
int numero1 = 1;
int numero2 = 2;

if(numero1 > numero2)
	System.out.print("Numero 1 maior que numero 2");

if(numero1 < numero2)
	System.out.print("Numero 1 menor que numero 2");

if(numero1 >= numero2)
	System.out.print("Numero 1 maior ou igual que numero 2");

if(numero1 <= numero2)
	System.out.print("Numero 1 menor ou igual que numero 2");

if(numero1 != numero2)
	System.out.print("Numero 1 é diferente de numero 2");

//comparadores acançãdos
// ComparacaoAvancada.java
public static void main(String[] args) {

    String nome1 = "JAVA";
    String nome2 = "JAVA";
    
    System.out.println(nome1 == nome2); //true

// ComparacaoAvancada.java
public static void main(String[] args) {
        
    int numero1 = 130;
    int numero2 = 130;
    System.out.println(numero1 == numero2); //true
    
    Integer numero1 = 130;
    Integer numero2 = 130;

    System.out.println(numero1 == numero2); //false
    
    // A razão pela qual o resultado é false, é devido o Java tratar os valores
    // Como objetos a partir de agora.
    // Qual a solução ?
    // Quando queremos comparar objetos, usamos o método equals
    
     System.out.println(numero1.equals(numero2)); 
}

    String nome3 = new String("JAVA");
    
    System.out.println(nome1 == nome3); //false

    String nome4 = nome3;

    System.out.println(nome3 == nome4); //true
    
    //equals na parada
    System.out.println(nome1.equals(nome2)); //??
    System.out.println(nome2.equals(nome3)); //??
    System.out.println(nome3.equals(nome4)); //??

}


