package com.gbsys.vampp.pruebareporteria;

/**
 *
 * @author GBSYS
 */
public class Archivo {

    private final String nombre;
    private final String extension;
    private final String mimeType;

    public Archivo(String nombre, String extension, String mimeType) {
        this.nombre = nombre;
        this.extension = extension;
        this.mimeType = mimeType;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExtension() {
        return extension;
    }

    public String getMimeType() {
        return mimeType;
    }

}
