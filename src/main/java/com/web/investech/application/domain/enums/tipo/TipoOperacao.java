package com.web.investech.application.domain.enums.tipo;

public enum TipoOperacao {
    COMPRA(1,"COMPRA"),
    VENDA(2,"VENDA");

    private final Integer codigo;
    private final String descricao;
    TipoOperacao(Integer codigo, String descricao) {
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
