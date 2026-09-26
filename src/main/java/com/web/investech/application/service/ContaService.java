package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.conta.ContaRequest;
import com.web.investech.adapter.input.dto.mapper.ContaMapper;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.domain.model.Usuario;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.ContaPort;
import com.web.investech.application.port.UsuarioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ContaService {
    private final UsuarioPort usuarioPort;
    private final ContaPort contaPort;

    public Conta registrarConta(ContaRequest request){
        if (request == null) {throw new EntidadeInvalidaException("Conta Não Pode ser Null");}
        Usuario usuario = usuarioPort.findById(request.usuarioId()).orElseThrow(()-> new EntidadeInvalidaException("Usuario Não Encontrado"));
        Conta c = ContaMapper.toEntity(request);
        c.setUsuario(usuario);
        c.setDataCriacao(LocalDate.now());
        c.setStatusConta(true);
        return contaPort.registrarConta(c);
    }
}
