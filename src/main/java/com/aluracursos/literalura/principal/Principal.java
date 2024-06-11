package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.LibroRepository;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.*;

public class Principal {
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Optional<Libro> libroOptional;
    private Optional<Autor> autorOptional;
    private LibroRepository repository1;
    private AutorRepository repository2;
    private Scanner scanner = new Scanner(System.in);





    public Principal(LibroRepository repository1, AutorRepository repository2) {
        this.repository1 = repository1;
        this.repository2 = repository2;
    }

    public void muestraMenu(){

        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    1- Buscar Libros
                    2- Mostrar libros listados
                    3- Mostrar Autores registrados
                    4- Mostrar Autores vivos en cierto año
                    5- Listar libros por idioma
                                        
                    0- Salir
                    """;

            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;

                case 2:
                    mostrarLibrosListados();
                    break;

                case 3:
                    mostrarAutoresListados();
                    break;

                case 4:
                    autoresVivosPorAnio();
                    break;

                case 5:
                    librosPorIdioma();
                    break;


                case 0:
                    System.out.println("Cerrando la aplicacion");
                    break;

                default:
                    System.out.println("Opcion invalida");

            }
        }



    }

    /////

  private DatosLibro getDatosLibro(){
        System.out.println("Que libro deseas buscar?");
        var nombreLibro = scanner.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE
        + "search=" + nombreLibro.replace(" ", "%20"));
        System.out.println(json);
        Datos datos = convierteDatos.obtenerDatos(json, Datos.class);
      System.out.println("Punto de control \n" + datos.results().get(0));
        return datos.results().get(0);


    }


    private void buscarLibro(){
        DatosLibro datosLibro = getDatosLibro();//creamos la plantilla de datos para maniobrar
        DatosAutor datosAutor = datosLibro.autor().get(0);//creamos la plantilla de datos para maniobrar
        libroOptional = repository1.findByTitulo(datosLibro.titulo()); //traemos info de la base de datos
        if (libroOptional.isPresent()){
            System.out.println("Libro existente");
        }else {
            autorOptional  = repository2.findByNombreContainsIgnoreCase(datosAutor.nombre());
            if (autorOptional.isPresent()) {
                Autor autor = new Autor(datosAutor);
                Libro libro = new Libro(datosLibro, autor);
                repository1.save(libro);

            }else{
                Autor autor = new Autor(datosAutor);
                Libro libro = new Libro(datosLibro, autor);
                repository2.save(autor);
                repository1.save(libro);

            }
            }

    }

    private void mostrarLibrosListados() {
    }

    private void mostrarAutoresListados() {
    }


    private void autoresVivosPorAnio() {
    }

    private  void librosPorIdioma() {

    }
}
