package digitalinnovation.model;

public class Cliente {

    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManytoOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public String getNome() {
       return nome; 
   } 
   public void setNome(String nome) {
       this.nome = nome;
   }
   public Endereco getEndereco() {
       return endereco;
   }
   public void setEndereco(Endereco endereco) {
       this.endereco = endereco;
   }    



}
