package com.web.investech.adapter.input.controller;

import com.web.investech.adapter.input.dto.mapper.UsuarioMapper;
import com.web.investech.adapter.input.dto.usuario.UsuarioRequest;
import com.web.investech.adapter.input.dto.usuario.UsuarioResponse;
import com.web.investech.application.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuarios")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService service;

    @Operation(summary = "Cadastrar um Usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "400",description = "Corpo para Cadastro Inválido"),
            @ApiResponse(responseCode = "201",description = "Usuário Cadastrado")
    })
    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioRequest request){
        var usuario = service.registrarUsuario(request);
        return ResponseEntity.status(201).body(UsuarioMapper.toResponse(usuario));
    }
}
