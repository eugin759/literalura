package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    @ManyToOne
    private Persona autor;
    private List<String> generos;
    private List<String> lenguajes;
    private long descargas;


    public Libro() {
    }

    public Libro(DatosLibro datosLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.generos = generos;
        this.lenguajes = lenguajes;
        this.descargas = descargas;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public long getDescargas() {
        return descargas;
    }

    public void setDescargas(long descargas) {
        this.descargas = descargas;
    }
}
