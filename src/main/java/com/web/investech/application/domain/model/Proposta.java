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
public class Proposta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoAtivo;
    private String nomeAtivo;
    private String tipoOperacao;
    private Double quantidadeSugerida;
    private Double valorSugerido;
    private String descricaoProposta;
    private Integer nivelRisco;
    private LocalDateTime dataProposta;
    private LocalDateTime dataRetorno;
    private String statusProposta;}
