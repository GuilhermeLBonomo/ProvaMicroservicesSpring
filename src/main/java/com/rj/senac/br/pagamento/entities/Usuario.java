package com.rj.senac.br.pagamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
    private Integer idUsuario;
    private String cpf;
    private String nome;
    private String email;
    private Integer status;
}
