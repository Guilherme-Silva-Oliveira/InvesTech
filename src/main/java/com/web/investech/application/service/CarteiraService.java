package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.carteira.CarteiraRequest;
import com.web.investech.adapter.input.dto.conta.ContaRequest;
import com.web.investech.adapter.input.dto.mapper.CarteiraMapper;
import com.web.investech.adapter.input.dto.mapper.ContaMapper;
import com.web.investech.application.domain.model.Carteira;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.domain.model.Usuario;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.CarteiraPort;
import com.web.investech.application.port.ContaPort;
import com.web.investech.application.port.UsuarioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CarteiraService {
    private final ContaPort contaPort;
    private final CarteiraPort carteiraPort;

    public Carteira registrarCarteira(CarteiraRequest request){
        if (request == null) {throw new EntidadeInvalidaException("Conta Não Pode ser Null");}
        Conta conta = contaPort.findById(request.contaId()).orElseThrow(()-> new EntidadeInvalidaException("Usuario Não Encontrado"));
        Carteira c = CarteiraMapper.toEntity(request);
        c.setConta(conta);
        c.setDataAtualizacao(LocalDateTime.now());
        return carteiraPort.registrarCarteira(c);
    }
}
