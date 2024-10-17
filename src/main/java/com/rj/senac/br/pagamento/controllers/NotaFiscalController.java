package com.rj.senac.br.pagamento.controllers;

import com.rj.senac.br.pagamento.entities.NotaFiscal;
import com.rj.senac.br.pagamento.entities.dto.ItemCarrinhoDTO;
import com.rj.senac.br.pagamento.entities.dto.NotaFiscalDTO;
import com.rj.senac.br.pagamento.interfacefeign.CarrinhoDeCompraFeignClient;
import com.rj.senac.br.pagamento.services.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notas-fiscais")
public class NotaFiscalController {

    @Autowired
    CarrinhoDeCompraFeignClient carrinhoDeCompraFeignClient;

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

    @GetMapping("/{id}/carrinho")
    public ResponseEntity<List<ItemCarrinhoDTO>> buscarCarrinhoPorId(@PathVariable("id") Long id) {
        List<ItemCarrinhoDTO> itemCarrinhos = carrinhoDeCompraFeignClient.getItemsByCartId(id).getBody();
        return ResponseEntity.ok(itemCarrinhos);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<NotaFiscalDTO> adicionarNotaFiscal(@RequestBody NotaFiscalDTO notaFiscalDTO) {
        NotaFiscalDTO novaNotaFiscal = notaFiscalService.adicionarNotaFiscal(notaFiscalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNotaFiscal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaFiscalDTO> atualizarNotaFiscal(
            @PathVariable("id") Long id,
            @RequestBody NotaFiscalDTO notaFiscalAtualizada) {
        NotaFiscalDTO notaFiscal = notaFiscalService.atualizarNotaFiscal(id, notaFiscalAtualizada);
        return ResponseEntity.ok(notaFiscal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNotaFiscal(@PathVariable("id") Long id) {
        notaFiscalService.deletarNotaFiscal(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/finalizar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> finalizarPagamento(@PathVariable("id") Long id) {
        notaFiscalService.finalizarPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
