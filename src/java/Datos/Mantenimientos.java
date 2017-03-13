/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Carlos
 */
public class Mantenimientos {
    int IdMantenimiento;
    int IdDispositivo;
    char[]tituloMantenimiento;
    char[]descripcionMantenimiento;

    public Mantenimientos(int IdMantenimiento, int IdDispositivo, char[] tituloMantenimiento, char[] descripcionMantenimiento) {
        this.IdMantenimiento = IdMantenimiento;
        this.IdDispositivo = IdDispositivo;
        this.tituloMantenimiento = tituloMantenimiento;
        this.descripcionMantenimiento = descripcionMantenimiento;
    }

    public int getIdMantenimiento() {
        return IdMantenimiento;
    }

    public void setIdMantenimiento(int IdMantenimiento) {
        this.IdMantenimiento = IdMantenimiento;
    }

    public int getIdDispositivo() {
        return IdDispositivo;
    }

    public void setIdDispositivo(int IdDispositivo) {
        this.IdDispositivo = IdDispositivo;
    }

    public char[] getTituloMantenimiento() {
        return tituloMantenimiento;
    }

    public void setTituloMantenimiento(char[] tituloMantenimiento) {
        this.tituloMantenimiento = tituloMantenimiento;
    }

    public char[] getDescripcionMantenimiento() {
        return descripcionMantenimiento;
    }

    public void setDescripcionMantenimiento(char[] descripcionMantenimiento) {
        this.descripcionMantenimiento = descripcionMantenimiento;
    }

    @Override
    public String toString() {
        return "Mantenimientos{" + "IdMantenimiento=" + IdMantenimiento + ", IdDispositivo=" + IdDispositivo + ", tituloMantenimiento=" + String.valueOf(tituloMantenimiento) + ", descripcionMantenimiento=" + String.valueOf(descripcionMantenimiento) + '}';
    }
    
}
