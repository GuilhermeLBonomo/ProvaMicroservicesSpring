package com.rj.senac.br.pagamento.repositories;

import com.rj.senac.br.pagamento.entities.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Long> {
}
