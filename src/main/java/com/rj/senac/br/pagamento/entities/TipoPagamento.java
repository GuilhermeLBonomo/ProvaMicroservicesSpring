package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pagamento", nullable = false)
    private Long idTipoPagamento;

    @NotNull
    @Column(name = "metodo_pagamento", nullable = false)
    private String metodoPagamento;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;

    public TipoPagamento() {
    }

    public Long getIdTipoPagamento() {
        return this.idTipoPagamento;
    }

    public void setIdTipoPagamento(Long idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TipoPagamento{idTipoPagamento=%d, metodoPagamento='%s', status=%d}".formatted(idTipoPagamento, metodoPagamento, status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPagamento that)) return false;
        return Objects.equals(getIdTipoPagamento(), that.getIdTipoPagamento()) &&
                Objects.equals(getMetodoPagamento(), that.getMetodoPagamento()) &&
                Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTipoPagamento(), getMetodoPagamento(), getStatus());
    }

    public TipoPagamento(Long idTipoPagamento, @NotNull String metodoPagamento, @NotNull Integer status) {
        this.setIdTipoPagamento(idTipoPagamento);
        this.setStatus(status);
        this.setMetodoPagamento(metodoPagamento);
    }
}
