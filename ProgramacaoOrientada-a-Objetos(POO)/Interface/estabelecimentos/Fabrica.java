package estabelecimentos;

import equipamentos.impressora.Deskjet;
import equipamentos.impressora.Impressora;
import equipamentos.impressora.Laserjet;
import equipamentos.impressora.EquipamentoMultifuncional;
import equipamentos.digitalizadora.Scanner;
import equipamentos.digitalizadora.Digitalizadora;

public class Fabrica {
    public static void main(String[] args) {

        //reusabilidade 
        EquipamentoMultifuncional em = new EquipamentoMultifuncional();
        Deskjet deskjet = new Deskjet();
        Scanner scanner = new Scanner();
        //Impressora impressora = new Deskjet();
        //Impressora impressora = new Laserjet();
        Impressora impressora = em;
        Impressora impressora = scanner;
        Digitalizadora digitalizadora = em;
        Digitalizadora digitalizadora = scanner;
        Copiadora copiadora = em;
        Copiadora copiadora = scanner



       impressora.imprimir();
       digitalizadora.digitalizar();
       copiadora.copiar();

    }
    }
}