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
public class Herramientas {
    private int idDispositivo;
    private int idMantenimiento;
    private int idInventario;
    private int No_Serial;
    private char[] nombreHerramienta;
    private char[] descripcionHerramienta;
    private char[] statusHerramienta;
    private int cantArreglos;

    public Herramientas(int idDispositivo, int idMantenimiento, int idInventario, int No_Serial, char[] nombreHerramienta, char[] descripcionHerramienta, char[] statusHerramienta, int cantArreglos) {
        this.idDispositivo = idDispositivo;
        this.idMantenimiento = idMantenimiento;
        this.idInventario = idInventario;
        this.No_Serial = No_Serial;
        this.nombreHerramienta = nombreHerramienta;
        this.descripcionHerramienta = descripcionHerramienta;
        this.statusHerramienta = statusHerramienta;
        this.cantArreglos = cantArreglos;
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getNo_Serial() {
        return No_Serial;
    }

    public void setNo_Serial(int No_Serial) {
        this.No_Serial = No_Serial;
    }

    public char[] getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(char[] nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public char[] getDescripcionHerramienta() {
        return descripcionHerramienta;
    }

    public void setDescripcionHerramienta(char[] descripcionHerramienta) {
        this.descripcionHerramienta = descripcionHerramienta;
    }

    public char[] getStatusHerramienta() {
        return statusHerramienta;
    }

    public void setStatusHerramienta(char[] statusHerramienta) {
        this.statusHerramienta = statusHerramienta;
    }

    public int getCantArreglos() {
        return cantArreglos;
    }

    public void setCantArreglos(int cantArreglos) {
        this.cantArreglos = cantArreglos;
    }

    @Override
    public String toString() {
        return "Herramientas{" + "idDispositivo=" + idDispositivo + ", idMantenimiento=" + idMantenimiento + ", idInventario=" + idInventario + ", No_Serial=" + No_Serial + ", nombreHerramienta=" + String.valueOf(nombreHerramienta) + ", descripcionHerramienta=" + String.valueOf(descripcionHerramienta) + ", statusHerramienta=" + String.valueOf(statusHerramienta) + ", cantArreglos=" + cantArreglos + '}';
    }
    
}
