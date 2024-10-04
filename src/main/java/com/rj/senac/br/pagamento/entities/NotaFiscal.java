package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.*;

@Entity
@Table(name="notaFiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="idNotaFiscal", nullable = false)
    private Integer idNotaFiscal;
    private Integer status;
    private Integer valorTotalCent;
    private Integer usuarioIdUsuario;
    private Integer TipoPagamentoIdTipoPagamento;
    private Integer idProduto;
}
