package com.web.investech.adapter.input.controller;

import com.web.investech.adapter.input.dto.carteira.CarteiraRequest;
import com.web.investech.adapter.input.dto.carteira.CarteiraResponse;
import com.web.investech.adapter.input.dto.mapper.CarteiraMapper;
import com.web.investech.adapter.input.dto.mapper.UsuarioMapper;
import com.web.investech.adapter.input.dto.usuario.UsuarioRequest;
import com.web.investech.adapter.input.dto.usuario.UsuarioResponse;
import com.web.investech.application.service.CarteiraService;
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
@RequestMapping("/v1/carteiras")
@AllArgsConstructor
public class CarteiraController {
    private final CarteiraService service;

    @Operation(summary = "Cadastrar uma Carteira")
    @ApiResponses({
            @ApiResponse(responseCode = "400",description = "Corpo para Cadastro Inválido"),
            @ApiResponse(responseCode = "201",description = "Carteira Cadastrada")
    })
    @PostMapping
    public ResponseEntity<CarteiraResponse> cadastrarCarteira(@RequestBody CarteiraRequest request){
        var carteira = service.registrarCarteira(request);
        return ResponseEntity.status(201).body(CarteiraMapper.toResponse(carteira));
    }
}
