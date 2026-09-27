package com.web.investech.application.service;

import com.web.investech.adapter.input.dto.mapper.UsuarioMapper;
import com.web.investech.adapter.input.dto.usuario.UsuarioRequest;
import com.web.investech.application.domain.model.Usuario;
import com.web.investech.application.exception.EntidadeInvalidaException;
import com.web.investech.application.port.UsuarioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioPort usuarioPort;

    public Usuario registrarUsuario(UsuarioRequest request){
        if (request == null) {throw new EntidadeInvalidaException("Usuario Não Pode ser Null");}
        Usuario u = UsuarioMapper.toEntity(request);
        u.setDataCadastro(LocalDate.now());
        u.setStatusUsuario(true);
        return usuarioPort.registrarUsuario(u);
    }
}
