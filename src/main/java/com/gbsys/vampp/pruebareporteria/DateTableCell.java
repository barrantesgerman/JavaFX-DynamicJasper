package com.gbsys.vampp.pruebareporteria;

import java.text.SimpleDateFormat;
import javafx.scene.control.TableCell;

/**
 * TableCell para imprimir las fechas con formato en las tablas de JavaFX.
 *
 * @param <S> Clase del Tipo
 * @param <T> Clase del Atributo
 *
 * @author Herman Barrantes
 */
public class DateTableCell<S, T> extends TableCell<S, T> {

    private final SimpleDateFormat formato;

    /**
     * Constructor de la clase con patrón de fecha.
     *
     * @param patron patrón de fecha
     */
    public DateTableCell(String patron) {
        this.formato = new SimpleDateFormat(patron);
    }

    /**
     * Sobre escribe el método para mostrar la fecha con el formato establecido.
     *
     * @param item Elemento de la tabla
     * @param empty Indica si esta vacío
     */
    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);
        } else {
            setText(formato.format(item));
        }
    }
}
