package com.mottu.api.service;

import com.mottu.api.dto.LogMovimentacaoDTO;
import com.mottu.api.model.LogMovimentacao;
import com.mottu.api.repository.LogMovimentacaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogMovimentacaoService {

    private final LogMovimentacaoRepository repository;
    private final ColaboradorService colaboradorService;

    @Transactional
    public LogMovimentacaoDTO.Response criar(LogMovimentacaoDTO.CreateRequest dto) {
        var colaborador = colaboradorService.buscarPorId(dto.colaboradorId)
                .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));

        LogMovimentacao log = LogMovimentacao.builder()
                .descricao(dto.descricao)
                .dataHora(LocalDateTime.now())
                .colaborador(colaborador)
                .build();

        LogMovimentacao salvo = repository.save(log);

        return new LogMovimentacaoDTO.Response(
                salvo.getId(),
                salvo.getDescricao(),
                salvo.getDataHora(),
                colaborador.getNome()
        );
    }

    public Page<LogMovimentacaoDTO.Response> listar(int page, int size, String sortBy, Long colaboradorId) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());

        Page<LogMovimentacao> logs;
        if (colaboradorId != null) {
            logs = repository.findAllByColaboradorId(colaboradorId, pageable);
        } else {
            logs = repository.findAll(pageable);
        }

        return logs.map(log -> new LogMovimentacaoDTO.Response(
                log.getId(),
                log.getDescricao(),
                log.getDataHora(),
                log.getColaborador().getNome()
        ));
    }

}