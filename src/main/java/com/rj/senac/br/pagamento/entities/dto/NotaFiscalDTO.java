package com.rj.senac.br.pagamento.entities.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class NotaFiscalDTO {
    @NotNull(message = "O status não pode ser nulo.")
    private Integer status;

    @NotNull(message = "O valor total não pode ser nulo.")
    @Min(value = 0, message = "O valor total deve ser maior ou igual a zero.")
    private Double valorTotal;

    @NotNull(message = "O ID do usuário não pode ser nulo.")
    @Min(value = 0, message = "O ID do usuário deve ser maior ou igual a zero.")
    private Long usuarioId;

    @NotNull(message = "O ID do tipo de pagamento não pode ser nulo.")
    @Min(value = 0, message = "O ID do tipo de pagamento deve ser maior ou igual a zero.")
    private Long tipoPagamentoId;

    @NotNull(message = "O ID do carrinho não pode ser nulo.")
    @Min(value = 0, message = "O ID do carrinho deve ser maior ou igual a zero.")
    private Long idCarrinho;

    @Override
    public String toString() {
        return "NotaFiscalDTO{" +
                "status=" + status +
                ", valorTotal=" + valorTotal +
                ", usuarioId=" + usuarioId +
                ", tipoPagamentoId=" + tipoPagamentoId +
                ", idCarrinho=" + idCarrinho +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getTipoPagamentoId() {
        return tipoPagamentoId;
    }

    public void setTipoPagamentoId(Long tipoPagamentoId) {
        this.tipoPagamentoId = tipoPagamentoId;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public NotaFiscalDTO(@NotNull Integer status, @NotNull Double valorTotal, @NotNull Long usuarioId, @NotNull Long tipoPagamentoId, @NotNull Long idCarrinho) {
        this.setStatus(status);
        this.setValorTotal(valorTotal);
        this.setUsuarioId(usuarioId);
        this.setTipoPagamentoId(tipoPagamentoId);
        this.setIdCarrinho(idCarrinho);
    }
}
