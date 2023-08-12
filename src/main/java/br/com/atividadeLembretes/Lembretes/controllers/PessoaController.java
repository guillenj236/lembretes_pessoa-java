package br.com.atividadeLembretes.Lembretes.controllers;

import br.com.atividadeLembretes.Lembretes.entities.Pessoa;
import br.com.atividadeLembretes.Lembretes.repositories.PessoaRepository;
import br.com.atividadeLembretes.Lembretes.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Pessoa pessoa = this.pessoaRepository.findById(id).orElse(null);
        return pessoa == null
                ? ResponseEntity.badRequest().body("Nenhuma pessoa encontrada para o ID = " + id + ".")
                : ResponseEntity.ok(pessoa);
    }
    @GetMapping ("/nome/{nome}")
    public ResponseEntity <?> findByName (@PathVariable ("nome") final String nome){
        final Pessoa pessoa = this.pessoaRepository.findByNome(nome);

        return ResponseEntity.ok(this.pessoaRepository.findByNome(nome));
    }
    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
            return ResponseEntity.ok(this.pessoaRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Pessoa pessoa){
        try {
            this.pessoaService.validaPessoa(pessoa);
            return ResponseEntity.ok("Registro pessoa cadastrado com sucesso.");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") final Long id, @RequestBody final Pessoa pessoa){
        try {
            this.pessoaService.validaPessoa(pessoa);
            return ResponseEntity.ok("Registro atualizado com sucesso. ");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") final Long id, Pessoa pessoa){
        try {
            this.pessoaService.deletaPessoa(pessoa);
            return ResponseEntity.ok("Registro excluido com sucesso.");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

}
