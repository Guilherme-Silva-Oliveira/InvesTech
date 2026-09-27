package com.web.investech.application.domain.enums.status;

public enum StatusOperacao {
    RECEBIDA(1,"RECEBIDA"),
    ACEITA(2,"ACEITA"),
    REJEITADA(3,"REJEITADA");

    private final Integer codigo;
    private final String descricao;
    StatusOperacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
