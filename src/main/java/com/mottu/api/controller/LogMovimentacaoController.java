package com.mottu.api.controller;

import com.mottu.api.dto.LogMovimentacaoDTO;
import com.mottu.api.service.LogMovimentacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogMovimentacaoController {

    private final LogMovimentacaoService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid LogMovimentacaoDTO.CreateRequest dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    // Atualização: adicionar @RequestParam(required = false) para permitir filtro por colaborador
@GetMapping
public Page<LogMovimentacaoDTO.Response> listar(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "dataHora") String sortBy,
        @RequestParam(required = false) Long colaboradorId
) {
    return service.listar(page, size, sortBy, colaboradorId);
}
}