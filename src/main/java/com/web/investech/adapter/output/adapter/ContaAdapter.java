package com.web.investech.adapter.output.adapter;

import com.web.investech.adapter.output.repository.ContaRepository;
import com.web.investech.adapter.output.repository.UsuarioRepository;
import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.domain.model.Usuario;
import com.web.investech.application.port.ContaPort;
import com.web.investech.application.port.UsuarioPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ContaAdapter implements ContaPort {
    private final ContaRepository repository;

    @Override
    public Conta registrarConta(Conta conta) {
        return repository.save(conta);
    }

    @Override
    public Optional<Conta> findById(Integer id) {
        return repository.findById(id);
    }
}
