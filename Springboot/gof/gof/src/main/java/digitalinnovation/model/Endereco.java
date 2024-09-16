package digitalinnovation.model;

public class Endereco {

    -----------------------------------com.example.Example.java-----------------------------------

    package com.example;
    
    import java.util.LinkedHashMap;
    import java.util.Map;
    import javax.annotation.Generated;
    import javax.validation.Valid;
    
    @Repository
    @Generated("jsonschema2pojo")
    public class Example {
    
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    
    /**
     * @return the cep
     */
    public String getCep() {
    return cep;
    }
    
    /**
     * Altera o CEP do endere o
     * @param cep o novo CEP do endere o
     */
    public void setCep(String cep) {
    this.cep = cep;
    }
    
    public String getLogradouro() {
    return logradouro;
    }
    
    public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
    }
    
    public String getComplemento() {
    return complemento;
    }
    
    public void setComplemento(String complemento) {
    this.complemento = complemento;
    }
    
    public String getUnidade() {
    return unidade;
    }
    
    public void setUnidade(String unidade) {
    this.unidade = unidade;
    }
    
    public String getBairro() {
    return bairro;
    }
    
    public void setBairro(String bairro) {
    this.bairro = bairro;
    }
    
    public String getLocalidade() {
    return localidade;
    }
    
    public void setLocalidade(String localidade) {
    this.localidade = localidade;
    }
    
    public String getUf() {
    return uf;
    }
    
    public void setUf(String uf) {
    this.uf = uf;
    }
    
    public String getEstado() {
    return estado;
    }
    
    public void setEstado(String estado) {
    this.estado = estado;
    }
    
    public String getRegiao() {
    return regiao;
    }
    
    public void setRegiao(String regiao) {
    this.regiao = regiao;
    }
    
    public String getIbge() {
    return ibge;
    }
    
    public void setIbge(String ibge) {
    this.ibge = ibge;
    }
    
    public String getGia() {
    return gia;
    }
    
    public void setGia(String gia) {
    this.gia = gia;
    }
    
    public String getDdd() {
    return ddd;
    }
    
    public void setDdd(String ddd) {
    this.ddd = ddd;
    }
    
    public String getSiafi() {
    return siafi;
    }
    
    public void setSiafi(String siafi) {
    this.siafi = siafi;
    }
    
    public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
    }
    
    public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    }
    
    }
}