package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_fiscal", nullable = false)
    private Long idNotaFiscal;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;

    @NotNull
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @NotNull
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "tipo_pagamento_id", nullable = false)
    private Long tipoPagamentoId;

    @NotNull
    @Column(name = "id_produto", nullable = false)
    private Long idProduto;

    public NotaFiscal() {
    }

    public Long getIdNotaFiscal() {
        return this.idNotaFiscal;
    }

    public void setIdNotaFiscal(Long idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTipoPagamentoId() {
        return this.tipoPagamentoId;
    }

    public void setTipoPagamentoId(Long tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    public Long getIdProduto() {
        return this.idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "NotaFiscal{idNotaFiscal=%d, status=%d, valorTotal=%.2f, usuarioId=%d, tipoPagamentoId=%d, idProduto=%d}"
                .formatted(this.idNotaFiscal, this.status, this.valorTotal, this.usuarioId, this.tipoPagamentoId, this.idProduto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaFiscal that)) return false;
        return Objects.equals(this.getIdNotaFiscal(), that.getIdNotaFiscal()) &&
                Objects.equals(this.getStatus(), that.getStatus()) &&
                Objects.equals(this.getValorTotal(), that.getValorTotal()) &&
                Objects.equals(this.getUsuarioId(), that.getUsuarioId()) &&
                Objects.equals(this.getTipoPagamentoId(), that.getTipoPagamentoId()) &&
                Objects.equals(this.getIdProduto(), that.getIdProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdNotaFiscal(), this.getStatus(), this.getValorTotal(), this.getUsuarioId(), this.getTipoPagamentoId(), this.getIdProduto());
    }

    public NotaFiscal(@NotNull Long idNotaFiscal, @NotNull Integer status, @NotNull Double valorTotal, @NotNull Long usuarioId, @NotNull Long tipoPagamentoId, @NotNull Long idProduto) {
        this.setIdNotaFiscal(idNotaFiscal);
        this.setStatus(status);
        this.setValorTotal(valorTotal);
        this.setUsuarioId(usuarioId);
        this.setTipoPagamentoId(tipoPagamentoId);
        this.setIdProduto(idProduto);
    }
}
