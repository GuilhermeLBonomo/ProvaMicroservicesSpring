package com.rj.senac.br.pagamento.services;

import com.rj.senac.br.pagamento.entities.TipoPagamento;
import com.rj.senac.br.pagamento.repositories.TipoPagamentoRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagamentoService {
    private final TipoPagamentoRepository tipoPagamentoRepository;

    public TipoPagamentoService(@NotNull final TipoPagamentoRepository tipoPagamentoRepository) {
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    public List<TipoPagamento> listarTiposPagamento() {
        return this.tipoPagamentoRepository.findAll();
    }

    public Optional<TipoPagamento> buscarTipoPagamentoPorId(@NotNull final Long id) {
        return this.tipoPagamentoRepository.findById(id);
    }

    @Transactional
    public TipoPagamento adicionarTipoPagamento(@NotNull final TipoPagamento tipoPagamento) {
        return this.tipoPagamentoRepository.save(tipoPagamento);
    }

    @Transactional
    public TipoPagamento atualizarTipoPagamento(@NotNull final Long id, @NotNull final TipoPagamento tipoPagamentoAtualizado) {
        if (!tipoPagamentoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de Pagamento não encontrado com ID: " + id);
        }
        tipoPagamentoAtualizado.setIdTipoPagamento(id);
        return this.tipoPagamentoRepository.save(tipoPagamentoAtualizado);
    }

    @Transactional
    public void deletarTipoPagamento(@NotNull final Long id) {
        if (!tipoPagamentoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de Pagamento não encontrado com ID: " + id);
        }
        tipoPagamentoRepository.deleteById(id);
    }
}
