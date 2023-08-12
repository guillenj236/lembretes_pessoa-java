package br.com.atividadeLembretes.Lembretes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_lembretes",schema = "public")
public class Lembrete extends Abstract {

    @ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
    @Column(name = "nome_lembrete")
    private String nomeLembrete;
    @Column(name = "descricao_lembrete")
    private String descricaoLembrete;
}
