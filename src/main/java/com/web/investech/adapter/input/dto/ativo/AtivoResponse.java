package com.web.investech.adapter.input.dto.ativo;

public record AtivoResponse(
        String nome,
        String tipoAtivo,
        Double precoAtual
) {}