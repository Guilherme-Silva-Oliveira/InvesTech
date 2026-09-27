package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.mq.PropostaMessage;
import com.web.investech.application.domain.enums.status.StatusOperacao;
import com.web.investech.application.domain.model.Proposta;

import java.time.LocalDateTime;

public class PropostaMapper {
    public static Proposta newProposta(PropostaMessage message, String tipoAtivo, String tipoOperacao){
        Proposta p = new Proposta();
        p.setTipoAtivo(tipoAtivo);
        p.setNomeAtivo(message.nomeAtivo());
        p.setTipoOperacao(tipoOperacao);
        p.setQuantidadeSugerida(message.quantidadeSugerida());
        p.setValorSugerido(message.valorSugerido());
        p.setDescricaoProposta(message.descricaoProposta());
        p.setNivelRisco(message.nivelRisco());
        p.setDataProposta(LocalDateTime.now());
        p.setStatusProposta(StatusOperacao.RECEBIDA.getDescricao());
        return p;
    }
}
