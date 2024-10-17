package com.rj.senac.br.pagamento.interfacefeign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CarrinhoDeCompraFeignClient {
    @RequestMapping("/carts")
    @GetMapping("/{cartId}/items")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ItemCarrinho>> getItemsByCartId(@PathVariable int cartId) {
        List<ItemCarrinho> items = itemCarrinhoService.getItemsByCartId(cartId);
        return ResponseEntity.ok(items);
    }
}
