package com.gbsys.vampp.pruebareporteria;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.scene.control.TableCell;

/**
 * TableCell para imprimir los números con formato en las tablas de JavaFX.
 *
 * @param <S> Clase del Tipo
 * @param <T> Clase del Atributo
 *
 * @author Herman Barrantes
 */
public class NumberTableCell<S, T> extends TableCell<S, T> {

    private final NumberFormat formato;

    /**
     * Constructor de la clase con patrón de número.
     *
     * @param patron patrón de número
     */
    public NumberTableCell(String patron) {
        this.formato = new DecimalFormat(patron);
    }

    /**
     * Sobre escribe el método para mostrar el número con el formato
     * establecido.
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
