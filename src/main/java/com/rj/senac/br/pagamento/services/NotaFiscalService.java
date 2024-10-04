package com.rj.senac.br.pagamento.services;

import com.rj.senac.br.pagamento.entities.NotaFiscal;
import com.rj.senac.br.pagamento.repositories.NotaFiscalRepository;
import jakarta.validation.constraints.NotNull;
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
    public NotaFiscal adicionarNotaFiscal(@NotNull final NotaFiscal notaFiscal) {
        return this.notaFiscalRepository.save(notaFiscal);
    }

    @Transactional
    public NotaFiscal atualizarNotaFiscal(@NotNull final Long id, @NotNull final NotaFiscal notaFiscalAtualizada) {
        if (!notaFiscalRepository.existsById(id)) {
            throw new RuntimeException("Nota Fiscal não encontrada com ID: " + id);
        }

        notaFiscalAtualizada.setIdNotaFiscal(id);
        return this.notaFiscalRepository.save(notaFiscalAtualizada);
    }

    @Transactional
    public void deletarNotaFiscal(@NotNull final Long id) {
        if (!notaFiscalRepository.existsById(id)) {
            throw new RuntimeException("Nota Fiscal não encontrada com ID: " + id);
        }
        notaFiscalRepository.deleteById(id);
    }
}
