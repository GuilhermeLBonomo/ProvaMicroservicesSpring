package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    @Min(0)
    private Long idUsuario;

    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;

    @Column(name = "nome", nullable = false)
    @Size(max = 256)
    private String nome;

    @Column(name = "email", nullable = false)
    @Size(max = 256)
    private String email;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Usuario() {
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario{idUsuario=%d, cpf='%s', nome='%s', email='%s', status=%d}"
                .formatted(this.idUsuario, this.cpf, this.nome, this.email, this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario that)) return false;
        return Objects.equals(this.getIdUsuario(), that.getIdUsuario()) &&
                Objects.equals(this.getCpf(), that.getCpf()) &&
                Objects.equals(this.getNome(), that.getNome()) &&
                Objects.equals(this.getEmail(), that.getEmail()) &&
                Objects.equals(this.getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdUsuario(), this.getCpf(), this.getNome(), this.getEmail(), this.getStatus());
    }

    public Usuario(Long idUsuario, @NotNull String cpf, @NotNull String nome, @NotNull String email, @NotNull Integer status) {
        this.setIdUsuario(idUsuario);
        this.setCpf(cpf);
        this.setNome(nome);
        this.setEmail(email);
        this.setStatus(status);
    }
}
