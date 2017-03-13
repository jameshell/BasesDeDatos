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
    int idDispositivo;
    int serial;
    char[] nombreHerramienta;
    char[] descripciomHerramienta;
    boolean statusHerramienta;
    int cant_arreglos;

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public char[] getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(char[] nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public char[] getDescripciomHerramienta() {
        return descripciomHerramienta;
    }

    public void setDescripciomHerramienta(char[] descripciomHerramienta) {
        this.descripciomHerramienta = descripciomHerramienta;
    }

    public boolean isStatusHerramienta() {
        return statusHerramienta;
    }

    public void setStatusHerramienta(boolean statusHerramienta) {
        this.statusHerramienta = statusHerramienta;
    }

    public int getCant_arreglos() {
        return cant_arreglos;
    }

    public void setCant_arreglos(int cant_arreglos) {
        this.cant_arreglos = cant_arreglos;
    }
    
}
