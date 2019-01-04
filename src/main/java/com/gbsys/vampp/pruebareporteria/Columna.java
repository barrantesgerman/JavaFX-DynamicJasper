package com.gbsys.vampp.pruebareporteria;

import java.io.Serializable;
import java.util.Objects;

/**
 * Define los datos de una columna para la tabla de JavaFX y para el Reporte.
 *
 * @author Herman Barrantes
 */
public class Columna implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Nombre del atributo.
     */
    private final String nombre;
    /**
     * Descripción del atributo, se muestra en la columna.
     */
    private final String descripcion;
    /**
     * Clase del atributo.
     */
    private final Class clase;
    /**
     * Ancho de la columna.
     */
    private final int ancho;
    /**
     * Patrón del atributo, es requerido para fechas y números, en caso de no
     * ser fecha o número se puede dejar null.
     */
    private final String patron;
    /**
     * Indicador de ajustable.
     */
    private final boolean ajustable;

    /**
     * Constructor de la clase.
     *
     * @param nombre Nombre del atributo
     * @param descripcion Descripción del atributo
     * @param clase Clase del atributo
     * @param ancho Ancho de la columna
     * @param patron Patrón del atributo
     */
    public Columna(String nombre, String descripcion, Class clase, int ancho, String patron, boolean ajustable) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.clase = clase;
        this.ancho = ancho;
        this.patron = patron;
        this.ajustable = ajustable;
    }

    public Columna withAncho(int nuevoAncho) {
        return new Columna(nombre, descripcion, clase, nuevoAncho, patron, ajustable);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Class getClase() {
        return clase;
    }

    public int getAncho() {
        return ancho;
    }

    public String getPatron() {
        return patron;
    }

    public boolean isAjustable() {
        return ajustable;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Columna other = (Columna) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Columna{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", clase=" + clase + ", ancho=" + ancho + ", patron=" + patron + ", ajustable=" + ajustable + '}';
    }
}
