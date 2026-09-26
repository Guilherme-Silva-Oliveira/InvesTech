package com.web.investech.application.domain.enums.tipo;

public enum TipoAtivo {
    CRIPTOMOEDAS(1,"CRIPTOMOEDAS");

    private final Integer codigo;
    private final String descricao;
    TipoAtivo(Integer codigo, String descricao) {
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
