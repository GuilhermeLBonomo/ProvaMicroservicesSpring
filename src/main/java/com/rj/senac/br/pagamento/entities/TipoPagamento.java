package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
@Entity
@Table(name="TipoPagamento")
public class TipoPagamento {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="idTipoPagamento", nullable = false)
    private Integer idTipoPagamento;
    @Column(name="metodoPagamento", nullable = false)
    private String metodoPagamento;
    @Column(name="status", nullable = false)
    private Integer status;

    public Integer getIdTipoPagamento() {
        return this.idTipoPagamento;
    }

    public void setIdTipoPagamento(@NotNull Integer idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getMetodoPagamento() {
        return this.metodoPagamento;
    }

    public void setMetodoPagamento(@NotNull String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(@NotNull Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TipoPagamento{" +
                "idTipoPagamento=" + idTipoPagamento +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPagamento that)) return false;
        return Objects.equals(getIdTipoPagamento(), that.getIdTipoPagamento()) && Objects.equals(getMetodoPagamento(), that.getMetodoPagamento()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTipoPagamento(), getMetodoPagamento(), getStatus());
    }

    public TipoPagamento(@NotNull Integer idTipoPagamento, @NotNull String metodoPagamento, @NotNull Integer status) {
        this.idTipoPagamento = idTipoPagamento;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
    }
}
