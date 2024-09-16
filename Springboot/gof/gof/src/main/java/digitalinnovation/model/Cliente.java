package digitalinnovation.model;

public class Cliente {

    @Id
    @GenerateValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManytoOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

}
