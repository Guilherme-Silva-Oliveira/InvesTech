package com.web.investech.adapter.input.controller;

import com.web.investech.adapter.input.dto.conta.ContaRequest;
import com.web.investech.adapter.input.dto.conta.ContaResponse;
import com.web.investech.adapter.input.dto.mapper.ContaMapper;
import com.web.investech.adapter.input.dto.mapper.MovimentacaoMapper;
import com.web.investech.adapter.input.dto.movimentacao.MovimentacaoRequest;
import com.web.investech.adapter.input.dto.movimentacao.MovimentacaoResponse;
import com.web.investech.application.service.ContaService;
import com.web.investech.application.service.MovimentacaoService;
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
@RequestMapping("/v1/movimentacoes")
@AllArgsConstructor
public class MovimentacaoController {
    private final MovimentacaoService service;

    @Operation(summary = "Cadastrar uma Movimentacao")
    @ApiResponses({
            @ApiResponse(responseCode = "400",description = "Corpo para Cadastro Inválido"),
            @ApiResponse(responseCode = "201",description = "Movimentacao Cadastrada")
    })
    @PostMapping
    public ResponseEntity<MovimentacaoResponse> cadastrarMovimentacao(@RequestBody MovimentacaoRequest request){
        var movimentacao = service.registrarMovimentacao(request);
        return ResponseEntity.status(201).body(MovimentacaoMapper.toResponse(movimentacao));
    }
}
