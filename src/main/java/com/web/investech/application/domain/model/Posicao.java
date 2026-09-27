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
public class Posicao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double quantidade;
    private Double valorMontante;
    private LocalDateTime ultimaCompra;

    @ManyToOne @JoinColumn(name = "carteira_id")
    private Carteira carteira;

    @ManyToOne @JoinColumn(name = "ativo_id")
    private Ativo ativo;
}
