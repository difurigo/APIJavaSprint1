package com.mottu.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs_movimentacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição da movimentação é obrigatória")
    private String descricao;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;
}