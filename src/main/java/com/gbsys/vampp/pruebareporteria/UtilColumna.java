package com.gbsys.vampp.pruebareporteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Utilitario de manejo de columnas.
 *
 * @author Herman Barrantes
 */
public class UtilColumna {

    /**
     * Convierte una lista de definiciones de columna en una lista de columnas
     * de tabla para JavaFX.
     *
     * @param <S> Clase del Tipo
     * @param <T> Clase del Atributo
     * @param columnas Definiciones de columna
     * @return Lista de columnas de tabla para JavaFX
     */
    public <S, T> List<TableColumn<S, T>> convertirTableColumns(List<Columna> columnas) {
        List<TableColumn<S, T>> columnasTabla = new ArrayList<>();
        for (Columna columna : columnas) {
            columnasTabla.add(convertirTableColumn(columna));
        }
        return columnasTabla;
    }

    /**
     * Convierte una definición de columna en una columna de tabla para JavaFX.
     *
     * @param <S> Clase del Tipo
     * @param <T> Clase del Atributo
     * @param columna Definición de columna
     * @return Columna de tabla para JavaFX
     */
    public <S, T> TableColumn<S, T> convertirTableColumn(Columna columna) {
        TableColumn columnaTabla = new TableColumn(columna.getDescripcion());
        columnaTabla.setId(columna.getNombre());
        columnaTabla.setPrefWidth(columna.getAncho());
        columnaTabla.setCellValueFactory(new PropertyValueFactory<>(columna.getNombre()));
        if (Date.class.isAssignableFrom(columna.getClase())) {
            columnaTabla.setCellFactory((column) -> new DateTableCell<>(columna.getPatron()));
        } else if (Number.class.isAssignableFrom(columna.getClase())) {
            columnaTabla.setCellFactory((column) -> new NumberTableCell<>(columna.getPatron()));
            columnaTabla.setStyle("-fx-alignment: center-right;");
        }
        return columnaTabla;
    }

    /**
     * Obtiene la lista de tamaños de las columnas de una tabla.
     *
     * @param columnasTabla Lista de columnas de la tabla
     * @param columnas Lista de definición de columnas
     * @return lista de tamaños de las columnas
     */
    public List<Columna> convertirColumna(ObservableList<TableColumn> columnasTabla, List<Columna> columnas) {
        List<Columna> nuevaDefinicion = new ArrayList<>();
        for (TableColumn columnaTabla : columnasTabla) {
            Double ancho = columnaTabla.getWidth();
            String nombre = columnaTabla.getId();
            for (Columna columna : columnas) {
                if (columna.getNombre().equals(nombre)) {
                    Columna nuevaColumna = columna.withAncho(ancho.intValue());
                    nuevaDefinicion.add(nuevaColumna);
                }
            }
        }
        return nuevaDefinicion;
    }
}
