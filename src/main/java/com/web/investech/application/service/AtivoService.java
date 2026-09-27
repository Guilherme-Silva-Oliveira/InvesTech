package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.ativo.AtivoRequest;
import com.web.investech.adapter.input.dto.carteira.CarteiraRequest;
import com.web.investech.adapter.input.dto.mapper.AtivoMapper;
import com.web.investech.adapter.input.dto.mapper.CarteiraMapper;
import com.web.investech.application.domain.enums.tipo.TipoAtivo;
import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.AtivoPort;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.ContaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AtivoService {
    private final AtivoPort ativoPort;

    public Ativo registrarAtivo(AtivoRequest request){
        try {
            if (request == null) {throw new EntidadeInvalidaException("Conta Não Pode ser Null");}
            String tipoAtivo = TipoAtivo.valueOf(request.tipoAtivo()).getDescricao();
            Ativo ativo = AtivoMapper.toEntity(request,tipoAtivo);
            ativo.setStatusAtivo(true);
            return ativoPort.registrarAtivo(ativo);

        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de ativo ou operação inválido: " + e.getMessage());
        }
    }
}
