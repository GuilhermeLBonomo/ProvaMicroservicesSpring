package com.rj.senac.br.pagamento.services;

import com.rj.senac.br.pagamento.entities.Usuario;
import com.rj.senac.br.pagamento.entities.dto.UsuarioDTO;
import com.rj.senac.br.pagamento.repositories.UsuarioRepository;
import org.jetbrains.annotations.NotNull;
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
    public UsuarioDTO adicionarUsuario(@NotNull final UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setStatus(usuarioDTO.getStatus());

        Usuario savedUsuario = this.usuarioRepository.save(usuario);
        return new UsuarioDTO(savedUsuario.getCpf(), savedUsuario.getNome(), savedUsuario.getEmail(), savedUsuario.getStatus());
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(@NotNull final Long id, @NotNull final UsuarioDTO usuarioAtualizado) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(id);
        usuario.setCpf(usuarioAtualizado.getCpf());
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setStatus(usuarioAtualizado.getStatus());

        Usuario savedUsuario = this.usuarioRepository.save(usuario);
        return new UsuarioDTO(savedUsuario.getCpf(), savedUsuario.getNome(), savedUsuario.getEmail(), savedUsuario.getStatus());
    }

    @Transactional
    public void deletarUsuario(@NotNull final Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
