package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.mapper.PropostaMapper;
import com.web.investech.adapter.input.dto.mq.PropostaMessage;
import com.web.investech.application.domain.enums.tipo.TipoAtivo;
import com.web.investech.application.domain.enums.tipo.TipoOperacao;
import com.web.investech.application.domain.model.Proposta;
import com.web.investech.application.port.PropostaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropostaService {
    private final PropostaPort propostaPort;

    public Proposta processarProposta(PropostaMessage message) {
        try {
            String tipoAtivo = TipoAtivo.valueOf(message.tipoAtivo()).getDescricao();
            String tipoOperacao = TipoOperacao.valueOf(message.tipoOperacao()).getDescricao();
            Proposta p = PropostaMapper.newProposta(message,tipoAtivo,tipoOperacao);
            return propostaPort.registrarProposta(p);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }
}
