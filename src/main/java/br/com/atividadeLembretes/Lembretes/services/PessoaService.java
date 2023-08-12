package br.com.atividadeLembretes.Lembretes.services;

import br.com.atividadeLembretes.Lembretes.entities.Pessoa;
import br.com.atividadeLembretes.Lembretes.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepo;


        public void validaPessoa (Pessoa pessoa){
            Assert.isTrue(!pessoa.getNome().equals(""), "Nome não pode ser nulo");

            pessoaRepo.save(pessoa);
        }

        public void deletaPessoa (Pessoa pessoa){

            pessoaRepo.delete(pessoa);
        }

}
