package com.mottu.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class LogMovimentacaoDTO {

    public static class CreateRequest {
        @NotBlank(message = "Descrição é obrigatória")
        public String descricao;

        @NotNull(message = "ID do colaborador é obrigatório")
        public Long colaboradorId;
    }

    public static class Response {
        public Long id;
        public String descricao;
        public LocalDateTime dataHora;
        public String nomeColaborador;

        public Response(Long id, String descricao, LocalDateTime dataHora, String nomeColaborador) {
            this.id = id;
            this.descricao = descricao;
            this.dataHora = dataHora;
            this.nomeColaborador = nomeColaborador;
        }
    }
}