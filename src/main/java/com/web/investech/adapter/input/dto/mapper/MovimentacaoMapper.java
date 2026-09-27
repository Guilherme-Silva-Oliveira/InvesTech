package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.conta.ContaRequest;
import com.web.investech.adapter.input.dto.conta.ContaResponse;
import com.web.investech.adapter.input.dto.movimentacao.MovimentacaoRequest;
import com.web.investech.adapter.input.dto.movimentacao.MovimentacaoResponse;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.domain.model.Movimentacao;

public class MovimentacaoMapper {
    public static Movimentacao toEntity(MovimentacaoRequest request){
        Movimentacao m = new Movimentacao();
        m.setValor(request.valor());
        m.setDescricao(request.descricao());
        return m;
    }

    public static MovimentacaoResponse toResponse(Movimentacao movimentacao){
        return new MovimentacaoResponse(
                movimentacao.getValor(),
                movimentacao.getStatusMovimentacao(),
                movimentacao.getDescricao(),
                movimentacao.getCarteira()
        );
    }
}
