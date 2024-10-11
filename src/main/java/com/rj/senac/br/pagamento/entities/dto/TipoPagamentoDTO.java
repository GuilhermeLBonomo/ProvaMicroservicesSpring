package com.rj.senac.br.pagamento.entities.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class TipoPagamentoDTO {

    @Size(max = 256)
    @NotNull
    private String metodoPagamento;

    @NotNull
    private Integer status;

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(@NotNull final String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(@NotNull final Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TipoPagamentoDTO{" +
                "metodoPagamento='" + metodoPagamento + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPagamentoDTO that)) return false;
        return Objects.equals(getMetodoPagamento(), that.getMetodoPagamento()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMetodoPagamento(), getStatus());
    }

    public TipoPagamentoDTO(@NotNull final String metodoPagamento, @NotNull final Integer status) {
        this.setMetodoPagamento(metodoPagamento);
        this.setStatus(status);
    }


}
