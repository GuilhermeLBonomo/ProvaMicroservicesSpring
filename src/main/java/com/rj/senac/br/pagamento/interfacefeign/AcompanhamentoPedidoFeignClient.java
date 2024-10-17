package com.rj.senac.br.pagamento.interfacefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient (name="Av1", url="10.136.65.160:8080", path="/acompanhamento")
public interface AcompanhamentoPedidoFeignClient {
    @PostMapping("/{userId}/{cartId}/atualizar")
    ResponseEntity<Void> createAcompanhamentoPedido(@PathVariable("userId") long userId, @PathVariable("cartId") int cartId, @RequestParam("status") String status);
}