package com.gbsys.vampp.pruebareporteria;

import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Libro para efectos de la DEMO.
 *
 * @author Herman Barrantes
 */
public class ServicioLibro {

    private static final Faker FAKER = new Faker();

    /**
     * Obtiene una lista de libros con datos aleatorios.
     *
     * @param cantidad cantidad de libros generadas
     * @return lista de libros con datos aleatorios
     */
    public static List<Libro> llenarDatos(int cantidad) {
        List<Libro> libros = new ArrayList<>(cantidad);
        for (int i = 0; i < cantidad; i++) {
            Book book = FAKER.book();
            Libro libro = new Libro(
                    book.title(),
                    book.author(),
                    book.genre());
            libros.add(libro);
        }
        return libros;
    }

}
