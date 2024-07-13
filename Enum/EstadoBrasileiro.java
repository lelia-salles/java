// Criando o enum EstadoBrasileiro para ser usado em toda a aplicação.
public enum EstadoBrasileiro {
	SAO_PAULO ("SP","São Paulo", 11),
	RIO_DE_JANEIRO ("RJ", "Rio de Janeiro", 22),
	PIAUI ("PI", "Piauí", 26),
	RIO_GRANDE_DO_SUL ("RS", "Rio Grande do Sul", 43),
	MARANHAO ("MA","Maranhão", 21),
	PARA ("PA","Pará", 15 ),
    CEARA("CE","Ceará", 20),
    PERNAMBUCO("PE","Pernambuco", 25), 
    RIO_GRANDE_DO_NORTE("RN","Rio Grande do Norte", 24),
    PARAIBA("PB","Paraíba", 19),
    PERU("PR","Pernambuco", 25),
    PARAN("PR","Paraná", 11),
  ;

	
	private String nome; // não tem acesso de fora
	private String sigla;
    private int ibge;
	
	private EstadoBrasileiro(String sigla, String nome, int ibge) {
		this.sigla = sigla;
		this.nome = nome;
        this.ibge = ibge;
	}
    public int getIbge() {
        return ibge;
    }
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}
	
}

