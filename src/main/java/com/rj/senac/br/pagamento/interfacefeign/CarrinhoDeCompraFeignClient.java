package com.rj.senac.br.pagamento.interfacefeign;

import com.rj.senac.br.pagamento.entities.dto.ItemCarrinhoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(name="grupo.carrinhodecompra", url="10.136.65.178:8080", path="/carts")
public interface CarrinhoDeCompraFeignClient {
    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<ItemCarrinhoDTO>> getItemsByCartId(@PathVariable long cartId);
}
