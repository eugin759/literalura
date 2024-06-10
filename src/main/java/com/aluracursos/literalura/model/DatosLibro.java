package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors")List<Persona> authores,
        @JsonAlias("subjects") List<String> generos,
        @JsonAlias("languages") List<String> lenguajes,
        @JsonAlias("download_count") Long descargas
        ) {
}
