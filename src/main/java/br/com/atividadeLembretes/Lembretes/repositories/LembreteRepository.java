package br.com.atividadeLembretes.Lembretes.repositories;

import br.com.atividadeLembretes.Lembretes.entities.Lembrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete,Long> {
}
