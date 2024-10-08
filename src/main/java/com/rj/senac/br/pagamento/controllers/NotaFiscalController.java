package com.rj.senac.br.pagamento.controllers;

import com.rj.senac.br.pagamento.entities.NotaFiscal;
import com.rj.senac.br.pagamento.services.NotaFiscalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {
    private final NotaFiscalService notaFiscalService;

    public NotaFiscalController(final NotaFiscalService notaFiscalService) {
        this.notaFiscalService = notaFiscalService;
    }

    @GetMapping
    public ResponseEntity<List<NotaFiscal>> listarNotasFiscais() {
        List<NotaFiscal> notasFiscais = notaFiscalService.listarNotasFiscais();
        return ResponseEntity.ok(notasFiscais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscal> buscarNotaFiscalPorId(@PathVariable("id") Long id) {
        return notaFiscalService.buscarNotaFiscalPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotaFiscal> adicionarNotaFiscal(@RequestBody NotaFiscal notaFiscal) {
        NotaFiscal novaNotaFiscal = notaFiscalService.adicionarNotaFiscal(notaFiscal);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNotaFiscal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaFiscal> atualizarNotaFiscal(
            @PathVariable("id") Long id,
            @RequestBody NotaFiscal notaFiscalAtualizada) {
        NotaFiscal notaFiscal = notaFiscalService.atualizarNotaFiscal(id, notaFiscalAtualizada);
        return ResponseEntity.ok(notaFiscal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNotaFiscal(@PathVariable("id") Long id) {
        notaFiscalService.deletarNotaFiscal(id);
        return ResponseEntity.noContent().build();
    }
}
