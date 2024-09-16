package digitalinnovation.model;

public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia; 
    private String ddd;
    private String siafi;

    /**
     * Retorna o cep do endereo
     * @return o cep do endereo
     */

    public String getCep() {
        return cep;
}

    /**
     * Altera o cep do endereo
     * @param cep o novo cep do endereo
     */
public void setCep(String cep) {
        this.cep = cep;
}   

}
