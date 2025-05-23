package com.mottu.api.service;

import com.mottu.api.dto.ColaboradorDTO;
import com.mottu.api.model.Colaborador;
import com.mottu.api.repository.ColaboradorRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;
    private BCryptPasswordEncoder encoder;

    @PostConstruct
    public void init() {
        encoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public ColaboradorDTO.Response cadastrar(ColaboradorDTO.CreateRequest dto) {
        Colaborador colaborador = Colaborador.builder()
                .nome(dto.nome)
                .email(dto.email)
                .senha(encoder.encode(dto.senha))
                .build();

        Colaborador salvo = repository.save(colaborador);
        return new ColaboradorDTO.Response(salvo.getId(), salvo.getNome(), salvo.getEmail());
    }

    public Optional<ColaboradorDTO.Response> login(ColaboradorDTO.LoginRequest dto) {
        return repository.findByEmail(dto.email)
                .filter(col -> encoder.matches(dto.senha, col.getSenha()))
                .map(col -> new ColaboradorDTO.Response(col.getId(), col.getNome(), col.getEmail()));
    }

    public Optional<Colaborador> buscarPorId(Long id) {
        return repository.findById(id);
    }
}