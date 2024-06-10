package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
