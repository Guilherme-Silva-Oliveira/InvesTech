package com.web.investech.adapter.input.dto.mapper;

import com.web.investech.adapter.input.dto.usuario.UsuarioRequest;
import com.web.investech.adapter.input.dto.usuario.UsuarioResponse;
import com.web.investech.application.domain.model.Usuario;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequest request){
        Usuario u = new Usuario();
        u.setNome(request.nome());
        u.setEmail(request.email());
        u.setSenha(request.senha());
        return u;
    }

    public static UsuarioResponse toResponse(Usuario usuario){
        return new UsuarioResponse(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatusUsuario()
        );
    }
}
