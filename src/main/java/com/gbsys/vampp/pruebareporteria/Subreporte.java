package com.gbsys.vampp.pruebareporteria;

import java.util.List;

/**
 *
 * @author GBSYS
 */
public class Subreporte {

    private final String titulo;
    private final String fuente;
    private final List<Columna> columnas;

    public Subreporte(String titulo, String fuente, List<Columna> columnas) {
        this.titulo = titulo;
        this.fuente = fuente;
        this.columnas = columnas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFuente() {
        return fuente;
    }

    public List<Columna> getColumnas() {
        return columnas;
    }

    @Override
    public String toString() {
        return "Subreporte{" + "titulo=" + titulo + ", fuente=" + fuente + ", columnas=" + columnas + '}';
    }

}
