package br.com.atividadeLembretes.Lembretes.repositories;

import br.com.atividadeLembretes.Lembretes.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Pessoa findByNome(String nome);
}
