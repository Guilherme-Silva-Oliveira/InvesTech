package com.web.investech.application.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Conta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String moedaBase;
    private String centroOperacao;
    private Boolean statusConta;
    private LocalDate dataCriacao;

    @ManyToOne @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
