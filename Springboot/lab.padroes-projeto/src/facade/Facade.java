public class Facade {

    public void migrarCliente(String nome, String CEP) {

        // recupera estado e cidade por meio dos subsitemas criados que são singletons

        String cidade = CepApi.getInstancia().recuperarCidade(CEP);
        String estado = CepApi.getInstancia().recuperarEstado(CEP);

        CrmService.gravarCliente(nome, CEP, cidade, estado);
    }

}
