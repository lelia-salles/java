package digitalinnovation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManytoOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenerateValue;
import org.springframework.stereotype.Repository;
import digitalinnovation.model.Endereco;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;
import digitalinnovation.model.Endereco;


@Entity
@Table(name = "cliente")


@Repository
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
