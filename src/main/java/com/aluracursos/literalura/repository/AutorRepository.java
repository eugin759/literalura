package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    //Optional<Autor> findByNombre(String name); //no estoy tan seguro
    Optional<Autor> findByNombreContainsIgnoreCase(String nombre);
}
