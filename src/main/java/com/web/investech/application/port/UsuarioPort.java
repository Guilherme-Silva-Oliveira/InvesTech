package com.web.investech.application.port;

import com.web.investech.application.domain.model.Proposta;
import com.web.investech.application.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioPort {
    Usuario registrarUsuario(Usuario usuario);
    Optional<Usuario> findById(Integer id);
}
