package br.com.atividadeLembretes.Lembretes.entities;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass
public abstract class Abstract {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
}
