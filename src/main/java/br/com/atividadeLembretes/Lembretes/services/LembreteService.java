package br.com.atividadeLembretes.Lembretes.services;

import br.com.atividadeLembretes.Lembretes.entities.Lembrete;
import br.com.atividadeLembretes.Lembretes.repositories.LembreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
public class LembreteService {
    @Autowired
    private LembreteRepository lembreteRep;

    public void validaLembrete (Lembrete lembrete){
        Assert.isTrue(!lembrete.getNomeLembrete().equals(""), "Nome do lembrete não pode ser nulo");

        lembreteRep.save(lembrete);
    }

    public void deletaLembrete (Lembrete lembrete){
        lembreteRep.delete(lembrete);
    }
}
