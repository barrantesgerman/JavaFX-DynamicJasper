package com.gbsys.vampp.pruebareporteria;

/**
 *
 * @author GBSYS
 */
public class Libro {

    private final String titulo;
    private final String autor;
    private final String genero;

    public Libro(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

}
