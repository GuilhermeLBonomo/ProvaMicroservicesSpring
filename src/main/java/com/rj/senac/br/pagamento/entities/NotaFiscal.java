package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @Min(0)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_fiscal", nullable = false)
    private Long idNotaFiscal;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "valor_total", nullable = false)
    @Min(0)
    private Double valorTotal;

    @Column(name = "usuario_id", nullable = false)
    @Min(0)
    private Long usuarioId;

    @Column(name = "tipo_pagamento_id", nullable = false)
    @Min(0)
    private Long tipoPagamentoId;

    @Column(name = "id_produto", nullable = false)
    @Min(0)
    private Long idCarrinho;

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
        if (valorTotal < 0) {
            throw new IllegalArgumentException("Valor total não pode ser negativo.");
        }
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

    public Long getIdCarrinho() {
        return this.idCarrinho;
    }

    public void setIdCarrinho(Long idProduto) {
        this.idCarrinho = idCarrinho;
    }

    @Override
    public String toString() {
        return "NotaFiscal{idNotaFiscal=%d, status=%d, valorTotal=%.2f, usuarioId=%d, tipoPagamentoId=%d, idProduto=%d}"
                .formatted(this.idNotaFiscal, this.status, this.valorTotal, this.usuarioId, this.tipoPagamentoId, this.idCarrinho);
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
                Objects.equals(this.getIdCarrinho(), that.getIdCarrinho());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getIdNotaFiscal(), this.getStatus(), this.getValorTotal(), this.getUsuarioId(), this.getTipoPagamentoId(), this.getIdCarrinho());
    }

    public NotaFiscal(@NotNull Long idNotaFiscal, @NotNull Integer status, @NotNull Double valorTotal, @NotNull Long usuarioId, @NotNull Long tipoPagamentoId, @NotNull Long idCarrinho) {
        this.setIdNotaFiscal(idNotaFiscal);
        this.setStatus(status);
        this.setValorTotal(valorTotal);
        this.setUsuarioId(usuarioId);
        this.setTipoPagamentoId(tipoPagamentoId);
        this.setIdCarrinho(idCarrinho);
    }
}
