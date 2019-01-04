package com.gbsys.vampp.pruebareporteria;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Archivo para efectos de la DEMO.
 *
 * @author Herman Barrantes
 */
public class ServicioArchivo {

    private static final Faker FAKER = new Faker();

    /**
     * Obtiene una lista de archivos con datos aleatorios.
     *
     * @param cantidad cantidad de archivos generadas
     * @return lista de archivos con datos aleatorios
     */
    public static List<Archivo> llenarDatos(int cantidad) {
        List<Archivo> archivos = new ArrayList<>(cantidad);
        for (int i = 0; i < cantidad; i++) {
            File file = FAKER.file();
            Archivo archivo = new Archivo(
                    file.fileName("D:\\Importante", null, null, null),
                    file.extension(),
                    file.mimeType());
            archivos.add(archivo);
        }
        return archivos;
    }

}
