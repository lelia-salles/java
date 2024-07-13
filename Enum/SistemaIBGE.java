public class SistemaIBGE {
    public static void main(String[] args) {
        //quais estados cadastrads no app. 
        // Dentro enum, consegue percorrer todas as opções do enum
        for (EstadoBrasileiro e : EstadoBrasileiro.values()) {
            System.out.println(e.getSigla() + " - " + e.getNome());
        }

        // estado específico

        EstadoBrasileiro eb = EstadoBrasileiro.PIAUI;
        System.out.println(eb.getNome());
        System.out.println(eb.getSigla());
        System.out.println(eb.getNomeMaiusculo());
        System.out.println(eb.getIbge());
        
     

    }

}
