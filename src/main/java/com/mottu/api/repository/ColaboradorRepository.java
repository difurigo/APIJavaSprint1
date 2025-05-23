package com.mottu.api.repository;

import com.mottu.api.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Optional<Colaborador> findByEmail(String email);
}