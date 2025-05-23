package com.mottu.api.controller;

import com.mottu.api.dto.ColaboradorDTO;
import com.mottu.api.service.ColaboradorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService service;

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ColaboradorDTO.CreateRequest dto) {
        return ResponseEntity.ok(service.cadastrar(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid ColaboradorDTO.LoginRequest dto) {
        ColaboradorDTO.Response colaborador = service.login(dto).orElse(null);
        if (colaborador == null) {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }
        return ResponseEntity.ok(colaborador);
    }
}