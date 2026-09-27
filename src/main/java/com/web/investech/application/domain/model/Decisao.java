package com.web.investech.application.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Decisao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String retornoProposta;
    private String motivo;
    private Double valorAprovado;
    private Double quantidadeAprovada;
    private String tipoOperacao;
    private LocalDateTime dataDecisao;

    @ManyToOne
    @JoinColumn(name = "proposta_id")
    private Proposta proposta;

    @ManyToOne @JoinColumn(name = "carteira_id")
    private Carteira carteira;
}
