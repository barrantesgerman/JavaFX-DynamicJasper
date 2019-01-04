package com.gbsys.vampp.pruebareporteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Servicio para la creación de columnas.
 *
 * @author Herman Barrantes
 */
public class ServicioColumna {

    /**
     * Obtiene la lista de definición de columnas.
     *
     * @param reporte ID del reporte
     * @return Lista de definición de columnas
     * @TODO obtener los valores de BD, actualmente quemado para DEMO.
     */
    public List<Columna> consultarPorReporte(String reporte) {
        List<Columna> columnas = new ArrayList<>();
        if ("personas".equals(reporte)) {
            columnas.add(new Columna("nombre", "Nombre", String.class, 150, null, true));
            columnas.add(new Columna("empresa", "Empresa", String.class, 150, null, true));
            columnas.add(new Columna("salario", "Salario", Double.class, 100, "#,##0.00", true));
            columnas.add(new Columna("fechaNacimiento", "Fecha de Nacimiento", Date.class, 150, "dd/MM/yyyy", true));
            columnas.add(new Columna("soltero", "Soltero", Boolean.class, 70, null, true));
        } else if ("libros".equals(reporte)) {
            columnas.add(new Columna("titulo", "Título", String.class, 150, null, true));
            columnas.add(new Columna("autor", "Autor", String.class, 150, null, true));
            columnas.add(new Columna("genero", "Género", String.class, 150, null, true));
        } else if ("archivos".equals(reporte)) {
            columnas.add(new Columna("nombre", "Nombre", String.class, 150, null, true));
            columnas.add(new Columna("extension", "Extensión", String.class, 150, null, true));
            columnas.add(new Columna("mimeType", "Mime Type", String.class, 150, null, true));
        }
        return columnas;
    }
}
