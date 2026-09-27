package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.ParametroMapper;
import com.web.investech.adapter.input.dto.parametro.ParametroRequest;
import com.web.investech.adapter.output.mq.ParametroProducer;
import com.web.investech.application.domain.enums.tipo.TipoAtivo;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Parametro;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.ParametroPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ParametroService {
    private final ParametroPort parametroPort;
    private final CarteiraPort carteiraPort;
    private final AtivoPort ativoPort;
    private final ParametroProducer producer;

    public Parametro registrarParametro(ParametroRequest request){
        try {
            if (request == null) {throw new EntidadeInvalidaException("Conta Não Pode ser Null");}
            String tipoAtivo = TipoAtivo.valueOf(request.tipoAtivo()).getDescricao();
            Carteira carteira = carteiraPort.findById(request.carteiraId()).orElseThrow(()-> new EntidadeInvalidaException("Carteira Não Encontrada"));
            Parametro p = ParametroMapper.toEntity(request, tipoAtivo);
            p.setCarteira(carteira);
            p.setDataEnviado(LocalDateTime.now());
            Parametro saved = parametroPort.registrarParametro(p);
            producer.send(saved);
            return saved;

        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }
}
