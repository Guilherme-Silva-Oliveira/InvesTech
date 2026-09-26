package com.web.investech.adapter.input.dto.conta;

import java.time.LocalDate;

public record ContaRequest(
        String moedaBase,
        String centroOperacao,
        Integer usuarioId
) {
}
