package com.mottu.api.repository;

import com.mottu.api.model.LogMovimentacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogMovimentacaoRepository extends JpaRepository<LogMovimentacao, Long> {
    Page<LogMovimentacao> findAllByColaboradorId(Long colaboradorId, Pageable pageable);
}
