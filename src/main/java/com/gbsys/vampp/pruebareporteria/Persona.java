package com.gbsys.vampp.pruebareporteria;

import java.util.Date;

/**
 * Modelo de Persona para efectos de la DEMO.
 *
 * @author Herman Barrantes
 */
public class Persona {

    private final String nombre;
    private final String empresa;
    private final double salario;
    private final Date fechaNacimiento;
    private final boolean soltero;

    public Persona(String nombre, String empresa, double salario, Date fechaNacimiento, boolean soltero) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.soltero = soltero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public double getSalario() {
        return salario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isSoltero() {
        return soltero;
    }
    
}
