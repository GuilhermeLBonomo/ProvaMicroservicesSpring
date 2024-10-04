package com.rj.senac.br.pagamento.repositories;

import com.rj.senac.br.pagamento.entities.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
}
