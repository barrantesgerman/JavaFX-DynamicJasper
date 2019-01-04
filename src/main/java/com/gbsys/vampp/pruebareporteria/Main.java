package com.gbsys.vampp.pruebareporteria;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Clase principal para la creación de la ventana de JavaFX.
 *
 * @author Herman Barrantes
 */
public class Main extends Application {

    private static final String TITULO = "Reporte de Personas";
    //Servicio
    private final ServicioColumna servicioColumna = new ServicioColumna();
    private final ServicioReporte servicioReporte = new ServicioReporte();
    private final UtilColumna utilColumna = new UtilColumna();
    //Atributos
    private final TableView tabla = new TableView();
    private final ObservableList<Persona> personas = FXCollections.observableArrayList(ServicioPersona.llenarDatos(50));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle(TITULO);
        stage.setWidth(650);
        stage.setHeight(510);
        stage.setScene(crearEscena());
        stage.show();
    }

    private Scene crearEscena() {
        List<Columna> columnas = servicioColumna.consultarPorReporte("personas");
        Group grupo = new Group();
        Scene escena = new Scene(grupo);

        final Label etiqueta = new Label(TITULO);
        etiqueta.setFont(new Font("Arial", 20));

        tabla.setEditable(true);
        tabla.setItems(personas);
        tabla.getColumns().addAll(utilColumna.convertirTableColumns(columnas));

        final Button imprimir = new Button("Imprimir");
        imprimir.setOnAction((evento) -> {
            List<Columna> nuevaDefinicion = utilColumna.convertirColumna(tabla.getColumns(), columnas);
            servicioReporte.generarReporte(TITULO, personas, nuevaDefinicion);
        });
        
        final Button imprimir2 = new Button("Imprimir Concatenado");
        imprimir2.setOnAction((evento) -> {
            //Se pasan los datos de los subreporte por parametro
            Map<String, Object> parametros = new HashMap<>();
            List<Libro> libros = ServicioLibro.llenarDatos(50);
            List<Archivo> archivos = ServicioArchivo.llenarDatos(50);
            parametros.put("personas", personas);
            parametros.put("libros", libros);
            parametros.put("archivos", archivos);
            servicioReporte.generarReporteConcatenado(obtenerSubreportes(columnas), parametros);
        });

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.getChildren().addAll(imprimir, imprimir2);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(etiqueta, tabla, hbox);

        grupo.getChildren().addAll(vbox);

        return escena;
    }

    private List<Subreporte> obtenerSubreportes(List<Columna> columnas) {
        //Se crean los subreportes
        List<Columna> nuevaDefinicion = utilColumna.convertirColumna(tabla.getColumns(), columnas);
        Subreporte subpersonas = new Subreporte(
                TITULO,
                "personas",
                nuevaDefinicion);
        Subreporte librosMasVendidos = new Subreporte(
                "Libros más vendidos",//Titulo del reporte
                "libros",//igual al nombre del parametro
                servicioColumna.consultarPorReporte("libros"));//definicion de columnas del reporte
        Subreporte archivosImportantes = new Subreporte(
                "Archivos Importantes",
                "archivos",
                servicioColumna.consultarPorReporte("archivos"));
        return Arrays.asList(subpersonas, librosMasVendidos, archivosImportantes);
    }

}
