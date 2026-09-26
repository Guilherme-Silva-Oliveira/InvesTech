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
public class Parametro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean statusParametro;
    private Double quantidadeMaxima;
    private Double precoMinimo;
    private Double precoMaximo;
    private LocalDateTime dataEnviado;
    private String ativoNome;
    private String tipoAtivo;

    @ManyToOne @JoinColumn(name = "carteira_id")
    private Carteira carteira;
}
