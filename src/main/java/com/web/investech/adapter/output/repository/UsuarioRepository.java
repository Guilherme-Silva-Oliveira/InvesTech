package com.web.investech.adapter.output.repository;

import com.web.investech.application.domain.model.Ativo;
import com.web.investech.application.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
