package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    private String nombre;
    @Column(nullable = true)
    private Long fechaNacimineto;
    @Column(nullable = true)
    private Long fechaMuerte;
    @ManyToMany
    @JoinTable(name = "autor_libros",
               joinColumns = @JoinColumn (name = "persona_id"),
               inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;


    public Persona(DatosPersona datosPersona) {
        this.nombre = nombre;
        this.fechaNacimineto = fechaNacimineto;
        this.fechaMuerte = fechaMuerte;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getFechaNacimineto() {
        return fechaNacimineto;
    }

    public void setFechaNacimineto(Long fechaNacimineto) {
        this.fechaNacimineto = fechaNacimineto;
    }

    public Long getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Long fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
