package com.rj.senac.br.pagamento.services;

import com.rj.senac.br.pagamento.entities.NotaFiscal;
import com.rj.senac.br.pagamento.entities.dto.NotaFiscalDTO;
import com.rj.senac.br.pagamento.repositories.NotaFiscalRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService {
    private final NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalService(@NotNull final NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    public List<NotaFiscal> listarNotasFiscais() {
        return this.notaFiscalRepository.findAll();
    }

    public Optional<NotaFiscal> buscarNotaFiscalPorId(@NotNull final Long id) {
        return this.notaFiscalRepository.findById(id);
    }

    @Transactional
    public NotaFiscalDTO adicionarNotaFiscal(@NotNull final NotaFiscalDTO notaFiscalDTO) {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setStatus(notaFiscalDTO.getStatus());
        notaFiscal.setValorTotal(notaFiscalDTO.getValorTotal());
        notaFiscal.setUsuarioId(notaFiscalDTO.getUsuarioId());
        notaFiscal.setTipoPagamentoId(notaFiscalDTO.getTipoPagamentoId());
        notaFiscal.setIdCarrinho(notaFiscalDTO.getIdCarrinho());

        NotaFiscal savedNotaFiscal = this.notaFiscalRepository.save(notaFiscal);
        return toDto(savedNotaFiscal);
    }

    @Transactional
    public NotaFiscalDTO atualizarNotaFiscal(@NotNull final Long id, @NotNull final NotaFiscalDTO notaFiscalAtualizada) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota Fiscal não encontrada com ID: " + id));

        notaFiscal.setStatus(notaFiscalAtualizada.getStatus());
        notaFiscal.setValorTotal(notaFiscalAtualizada.getValorTotal());
        notaFiscal.setUsuarioId(notaFiscalAtualizada.getUsuarioId());
        notaFiscal.setTipoPagamentoId(notaFiscalAtualizada.getTipoPagamentoId());
        notaFiscal.setIdCarrinho(notaFiscalAtualizada.getIdCarrinho());

        NotaFiscal savedNotaFiscal = this.notaFiscalRepository.save(notaFiscal);
        return toDto(savedNotaFiscal);
    }

    @Transactional
    public void finalizarPagamento(@NotNull final Long id) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota Fiscal não encontrada com ID: " + id));

        notaFiscal.setStatus(2); // Muda o status para 2 (finalizado)
        notaFiscalRepository.save(notaFiscal);
    }

    @Transactional
    public void deletarNotaFiscal(@NotNull final Long id) {
        if (!notaFiscalRepository.existsById(id)) {
            throw new RuntimeException("Nota Fiscal não encontrada com ID: " + id);
        }
        notaFiscalRepository.deleteById(id);
    }

    private NotaFiscalDTO toDto(NotaFiscal notaFiscal) {
        return new NotaFiscalDTO(
                notaFiscal.getValorTotal(),
                notaFiscal.getUsuarioId(),
                notaFiscal.getTipoPagamentoId(),
                notaFiscal.getIdCarrinho()
        );
    }
}
