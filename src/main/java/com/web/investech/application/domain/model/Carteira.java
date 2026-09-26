package com.web.investech.application.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Carteira {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double saldoDisponivel;
    private Double saldoInvestido;
    private Double saldoTotal;
    private Double lucroRegistrado;
    private Double prejuizoRegistrado;
    private LocalDateTime dataAtualizacao;

    @ManyToOne @JoinColumn(name = "conta_id")
    private Conta conta;
}
