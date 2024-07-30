package equipamentos.multifuncional;

public class EquipamentoMultifuncional implements Copiadora, Digitalizadora, Impressora {

    @Override
    public void copiar(){
        System.out.println('Copiando via equipamento multifuncional');

    }

    @Override
    public void digitalizar(){
        System.out.println('digitalizando via equipamento multifuncional');

    }

    @Override
    public void imprimir(){
        System.out.println('Imprimindo via equipamento multifuncional');

    }

    
}