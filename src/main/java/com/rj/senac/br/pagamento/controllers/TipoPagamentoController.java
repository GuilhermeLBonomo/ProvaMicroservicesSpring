package com.rj.senac.br.pagamento.controllers;

import com.rj.senac.br.pagamento.entities.TipoPagamento;
import com.rj.senac.br.pagamento.entities.dto.TipoPagamentoDTO;
import com.rj.senac.br.pagamento.services.TipoPagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-pagamento")
public class TipoPagamentoController {
    private final TipoPagamentoService tipoPagamentoService;

    public TipoPagamentoController(final TipoPagamentoService tipoPagamentoService) {
        this.tipoPagamentoService = tipoPagamentoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoPagamento>> listarTiposPagamento() {
        List<TipoPagamento> tiposPagamento = tipoPagamentoService.listarTiposPagamento();
        return ResponseEntity.ok(tiposPagamento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPagamento> buscarTipoPagamentoPorId(@PathVariable("id") Long id) {
        return tipoPagamentoService.buscarTipoPagamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoPagamentoDTO> adicionarTipoPagamento(@RequestBody TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamentoDTO novoTipoPagamento = tipoPagamentoService.adicionarTipoPagamento(tipoPagamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagamentoDTO> atualizarTipoPagamento(
            @PathVariable("id") Long id,
            @RequestBody TipoPagamentoDTO tipoPagamentoAtualizado) {
        TipoPagamentoDTO tipoPagamento = tipoPagamentoService.atualizarTipoPagamento(id, tipoPagamentoAtualizado);
        return ResponseEntity.ok(tipoPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTipoPagamento(@PathVariable("id") Long id) {
        tipoPagamentoService.deletarTipoPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
