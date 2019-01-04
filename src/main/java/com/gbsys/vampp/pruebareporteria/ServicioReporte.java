package com.gbsys.vampp.pruebareporteria;

import ar.com.fdvs.dj.core.DJConstants;
import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Servicio para imprimir Reportes.
 *
 * @author Herman Barrantes
 */
public class ServicioReporte {

    /**
     * Crear el reporte dinámico a partir de la definición de columnas.
     *
     * @param titulo Título del reporte
     * @param columnas Definición de columnas
     * @return Reporte dinámico
     * @throws Exception en caso de error en la definición
     */
    private DynamicReport generarPlantilla(String titulo, List<Columna> columnas) throws Exception {
        FastReportBuilder frb = new FastReportBuilder();
        for (Columna columna : columnas) {
            frb.addColumn(
                    columna.getDescripcion(),
                    columna.getNombre(),
                    columna.getClase(),
                    columna.getAncho(),
                    columna.isAjustable(),
                    columna.getPatron());
        }
        DynamicReportBuilder drb = frb
                .setTitle(titulo)
                .setPrintBackgroundOnOddRows(true)
                .setUseFullPageWidth(true)
                .setMargins(5, 5, 5, 5);
        return drb.build();
    }

    /**
     * Crear el reporte dinámico a partir de la lista de subreportes.
     *
     * @param subreportes Lista de subreportes
     * @return Reporte dinámico
     * @throws Exception en caso de error en la definición
     */
    private DynamicReport generarPlantilla(List<Subreporte> subreportes) throws Exception {
        DynamicReportBuilder drb
                = new DynamicReportBuilder()
                        .setUseFullPageWidth(true)
                        .setMargins(5, 5, 5, 5)
                        .setWhenNoDataAllSectionNoDetail();
        for (Subreporte subreporte : subreportes) {
            DynamicReport sub = generarPlantilla(subreporte.getTitulo(), subreporte.getColumnas());
            drb.addConcatenatedReport(
                    sub,
                    new ClassicLayoutManager(),
                    subreporte.getFuente(),
                    DJConstants.SUBREPORT_PARAMETER_MAP_ORIGIN_PARAMETER,
                    DJConstants.DATA_SOURCE_TYPE_COLLECTION);
        }
        return drb.build();
    }

    /**
     * Muestra la venta del reporte con la definición de columnas y la lista de
     * datos.
     *
     * @param titulo Título del reporte
     * @param datos Lista de datos del reporte
     * @param columnas Definición de columnas
     */
    public void generarReporte(String titulo, Collection<?> datos, List<Columna> columnas) {
        try {
            JRDataSource ds = new JRBeanCollectionDataSource(datos);
            JasperPrint jp = DynamicJasperHelper.generateJasperPrint(
                    generarPlantilla(titulo, columnas),
                    new ClassicLayoutManager(),
                    ds);
            JasperViewer.viewReport(jp, false);    //finally display the report report
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Muestra la venta del reporte con la definición de columnas y la lista de
     * datos.
     *
     * @param subreportes Lista de subreportes
     * @param paramentros Lista de parámetros
     */
    public void generarReporteConcatenado(List<Subreporte> subreportes, Map<String, Object> paramentros) {
        try {
            JasperPrint jp = DynamicJasperHelper.generateJasperPrint(
                    generarPlantilla(subreportes),
                    new ClassicLayoutManager(),
                    paramentros);
            JasperViewer.viewReport(jp, false);    //finally display the report report
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}
