package strategy;

/*
* Robot é o contexto onde a estratégia será alicada
**/
public class Robo {
    private Comportamento strategy;
    //metodo set para mudar a estrategia de comportamento

    public void setCStrategy(Comportamento strategy) {

        this.strategy = strategy;
    }

    public void mover() {
        /*método que delega a responsibilidade de movimentação para a strategy
        pegando o comportamento atribuido ao robot fazendo com que ele se mova */
        strategy.mover();
    }
}
