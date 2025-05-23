package com.mottu.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ColaboradorDTO {

    public static class CreateRequest {
        @NotBlank(message = "Nome é obrigatório")
        public String nome;

        @Email(message = "E-mail inválido")
        public String email;

        @NotBlank(message = "Senha é obrigatória")
        public String senha;
    }

    public static class LoginRequest {
        @Email(message = "E-mail inválido")
        public String email;

        @NotBlank(message = "Senha é obrigatória")
        public String senha;
    }

    public static class Response {
        public Long id;
        public String nome;
        public String email;

        public Response(Long id, String nome, String email) {
            this.id = id;
            this.nome = nome;
            this.email = email;
        }
    }
}