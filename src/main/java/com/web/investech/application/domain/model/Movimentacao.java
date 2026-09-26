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
public class Movimentacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valor;
    private String statusMovimentacao;
    private String descricao;
    private LocalDateTime dataMovimentacao;

    @ManyToOne @JoinColumn(name = "carteira_id")
    private Carteira carteira;
}
