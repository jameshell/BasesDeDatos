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
    int Serial;
    char[]tituloMantenimiento;
    char[]descripcionMantenimiento;

    public int getIdMantenimiento() {
        return IdMantenimiento;
    }

    public void setIdMantenimiento(int IdMantenimiento) {
        this.IdMantenimiento = IdMantenimiento;
    }

    public int getSerial() {
        return Serial;
    }

    public void setSerial(int Serial) {
        this.Serial = Serial;
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
    
}
