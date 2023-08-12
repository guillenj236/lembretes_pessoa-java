package br.com.atividadeLembretes.Lembretes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_pessoas",schema = "public")
public class Pessoa extends Abstract {

    @Column (name = "nome_pessoa")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
    private List<Lembrete> lembretes;


}
