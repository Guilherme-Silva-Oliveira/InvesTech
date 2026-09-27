package com.web.investech.application.domain.enums.status;

public enum StatusMovimentacao {
    RECEBIDA(1,"RECEBIDA");

    private final Integer codigo;
    private final String descricao;
    StatusMovimentacao(Integer codigo, String descricao) {
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
