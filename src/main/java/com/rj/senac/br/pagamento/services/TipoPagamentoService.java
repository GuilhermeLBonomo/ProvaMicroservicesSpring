package com.rj.senac.br.pagamento.services;

import com.rj.senac.br.pagamento.entities.TipoPagamento;
import com.rj.senac.br.pagamento.entities.dto.TipoPagamentoDTO;
import com.rj.senac.br.pagamento.repositories.TipoPagamentoRepository;
import org.jetbrains.annotations.NotNull;
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
    public TipoPagamentoDTO adicionarTipoPagamento(@NotNull final TipoPagamentoDTO tipoPagamentoDTO) {
        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setMetodoPagamento(tipoPagamentoDTO.getMetodoPagamento());
        tipoPagamento.setStatus(tipoPagamentoDTO.getStatus());

        TipoPagamento savedTipoPagamento = this.tipoPagamentoRepository.save(tipoPagamento);
        return new TipoPagamentoDTO(savedTipoPagamento.getMetodoPagamento(), savedTipoPagamento.getStatus());
    }

    @Transactional
    public TipoPagamentoDTO atualizarTipoPagamento(@NotNull final Long id, @NotNull final TipoPagamentoDTO tipoPagamentoAtualizado) {
        if (!tipoPagamentoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de Pagamento não encontrado com ID: " + id);
        }

        TipoPagamento tipoPagamento = new TipoPagamento();
        tipoPagamento.setIdTipoPagamento(id); // Assumindo que você tem um método para definir o ID
        tipoPagamento.setMetodoPagamento(tipoPagamentoAtualizado.getMetodoPagamento());
        tipoPagamento.setStatus(tipoPagamentoAtualizado.getStatus());

        TipoPagamento savedTipoPagamento = this.tipoPagamentoRepository.save(tipoPagamento);
        return new TipoPagamentoDTO(savedTipoPagamento.getMetodoPagamento(), savedTipoPagamento.getStatus());
    }

    @Transactional
    public void deletarTipoPagamento(@NotNull final Long id) {
        if (!tipoPagamentoRepository.existsById(id)) {
            throw new RuntimeException("Tipo de Pagamento não encontrado com ID: " + id);
        }
        tipoPagamentoRepository.deleteById(id);
    }
}
