package br.com.atividadeLembretes.Lembretes.controllers;

import br.com.atividadeLembretes.Lembretes.entities.Lembrete;
import br.com.atividadeLembretes.Lembretes.repositories.LembreteRepository;
import br.com.atividadeLembretes.Lembretes.services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lembrete")
public class LembreteController {

    @Autowired
    private LembreteService lembreteService;
    @Autowired
    private LembreteRepository lembreteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id){
        final Lembrete lembrete = this.lembreteRepository.findById(id).orElse(null);
        return lembrete == null
                ? ResponseEntity.badRequest().body("Nenhum lembrete encontrado para o ID = " + id + ".")
                : ResponseEntity.ok(lembrete);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> listaCompleta(){
        return ResponseEntity.ok(this.lembreteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Lembrete lembrete){
        try {
            this.lembreteService.validaLembrete(lembrete);
            return ResponseEntity.ok("Registro lembrete cadastrado com sucesso.");
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getCause().getCause().getMessage());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") final Long id, @RequestBody final Lembrete lembrete){
        try {
            this.lembreteService.validaLembrete(lembrete);
            return ResponseEntity.ok("Registro lembrete atualizado com sucesso. ");
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
    public ResponseEntity<?> delete(@PathVariable("id") final Long id, Lembrete lembrete){
        try {
            this.lembreteService.deletaLembrete(lembrete);
            return ResponseEntity.ok("Registro lembrete excluido com sucesso.");
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
