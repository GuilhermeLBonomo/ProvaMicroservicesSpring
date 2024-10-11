package com.rj.senac.br.pagamento.entities.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class UsuarioDTO {

    @NotNull
    @Size(min = 11, max = 11)
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas dígitos numéricos.")
    private String cpf;

    @NotNull
    @Size(max = 256)
    private String nome;

    @NotNull
    @Size(max = 256)
    private String email;

    @NotNull
    @PositiveOrZero(message = "O status não pode ser negativo.")
    private Integer status;

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UsuarioDTO(@NotNull final String cpf, @NotNull final String nome, @NotNull final String email, @NotNull final Integer status) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setEmail(email);
        this.setStatus(status);
    }
}
