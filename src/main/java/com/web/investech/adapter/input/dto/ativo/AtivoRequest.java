package com.web.investech.adapter.input.dto.ativo;

public record AtivoRequest(
        String nome,
        String tipoAtivo,
        Double precoAtual
) {}