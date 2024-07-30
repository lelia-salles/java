package estabelecimentos;

import equipamentos.impressora.Deskjet;
import equipamentos.impressora.Impressora;
import equipamentos.impressora.Laserjet;
import equipamentos.impressora.EquipamentoMultifuncional;

public class Fabrica {
    public static void main(String[] args) {
        EquipamentoMultifuncional em = new EquipamentoMultifuncional();
        Deskjet deskjet = new Deskjet();
        //Impressora impressora = new Deskjet();
        //Impressora impressora = new Laserjet();
        Impressora impressora = em;
        Digitalizadora digitalizadora = em;
        Copiadora copiadora = em;



       impressora.imprimir();
       digitalizadora.digitalizar();
       copiadora.copiar();

    }
    }
}