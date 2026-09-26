package com.web.investech.application.port;

import com.web.investech.application.domain.model.Conta;
import com.web.investech.application.domain.model.Usuario;

import java.util.Optional;

public interface ContaPort {
    Conta registrarConta(Conta conta);
    Optional<Conta> findById(Integer id);
}
