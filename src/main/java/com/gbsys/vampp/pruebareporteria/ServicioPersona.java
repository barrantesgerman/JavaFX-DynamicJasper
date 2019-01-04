package com.gbsys.vampp.pruebareporteria;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Persona para efectos de la DEMO.
 *
 * @author Herman Barrantes
 */
public class ServicioPersona {

    private static final Faker FAKER = new Faker();

    /**
     * Obtiene una lista de personas con datos aleatorios.
     *
     * @param cantidad cantidad de personas generadas
     * @return lista de personas con datos aleatorios
     */
    public static List<Persona> llenarDatos(int cantidad) {
        List<Persona> personas = new ArrayList<>(cantidad);
        for (int i = 0; i < cantidad; i++) {
            Persona persona = new Persona(
                    FAKER.name().name(),
                    FAKER.company().name(),
                    FAKER.number().randomDouble(2, 10_000L, 50_000L),
                    FAKER.date().birthday(),
                    FAKER.bool().bool());
            personas.add(persona);
        }
        return personas;
    }

}
