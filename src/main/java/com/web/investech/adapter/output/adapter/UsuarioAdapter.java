package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.PropostaRepository;
import com.web.investech.adapter.output.repository.UsuarioRepository;
import com.web.investech.application.domain.model.Proposta;
import com.web.investech.application.domain.model.Usuario;
import com.web.investech.application.port.PropostaPort;
import com.web.investech.application.port.UsuarioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UsuarioAdapter implements UsuarioPort {
    private final UsuarioRepository repository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }
}
