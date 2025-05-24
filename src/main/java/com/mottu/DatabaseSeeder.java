package com.mottu;

import com.mottu.api.model.Colaborador;
import com.mottu.api.model.LogMovimentacao;
import com.mottu.api.repository.ColaboradorRepository;
import com.mottu.api.repository.LogMovimentacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(
            ColaboradorRepository colaboradorRepository,
            LogMovimentacaoRepository logRepository) {
        return args -> {
            if (colaboradorRepository.count() == 0) {
                var colabs = List.of(
                        new Colaborador(1L, "João Silva", "joao@email.com", "123"),
                        new Colaborador(2L, "Maria Souza", "maria@email.com", "abc"),
                        new Colaborador(3L, "Pedro Lima", "pedro@email.com", "senha"),
                        new Colaborador(4L, "Ana Costa", "ana@email.com", "12345"),
                        new Colaborador(5L, "Lucas Rocha", "lucas@email.com", "pass")
                );
                colaboradorRepository.saveAll(colabs);

                var logs = List.of(
                        new LogMovimentacao(null, colabs.get(0), LocalDateTime.now(), "Chegada"),
                        new LogMovimentacao(null, colabs.get(1), LocalDateTime.now(), "Saída"),
                        new LogMovimentacao(null, colabs.get(0), LocalDateTime.now(), "Pausa"),
                        new LogMovimentacao(null, colabs.get(2), LocalDateTime.now(), "Retorno"),
                        new LogMovimentacao(null, colabs.get(3), LocalDateTime.now(), "Almoço")
                );
                logRepository.saveAll(logs);
            }
        };
    }
}
