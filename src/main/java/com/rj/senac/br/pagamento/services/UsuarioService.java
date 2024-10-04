package com.rj.senac.br.pagamento.services;

import com.rj.senac.br.pagamento.entities.Usuario;
import com.rj.senac.br.pagamento.repositories.UsuarioRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(@NotNull final UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(@NotNull final Long id) {
        return this.usuarioRepository.findById(id);
    }

    @Transactional
    public Usuario adicionarUsuario(@NotNull final Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario atualizarUsuario(@NotNull final Long id, @NotNull final Usuario usuarioAtualizado) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        usuarioAtualizado.setIdUsuario(id);
        return this.usuarioRepository.save(usuarioAtualizado);
    }

    @Transactional
    public void deletarUsuario(@NotNull final Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
