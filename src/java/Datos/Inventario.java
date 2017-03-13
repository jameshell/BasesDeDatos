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
public class Inventario {
    int idDispositvo;
    int cant_Disponible;
    int cant_EnUso;
    int cant_Danados;

    public Inventario(int idDispositvo, int cant_Disponible, int cant_EnUso, int cant_Danados) {
        this.idDispositvo = idDispositvo;
        this.cant_Disponible = cant_Disponible;
        this.cant_EnUso = cant_EnUso;
        this.cant_Danados = cant_Danados;
    }

    public int getIdDispositvo() {
        return idDispositvo;
    }

    public void setIdDispositvo(int idDispositvo) {
        this.idDispositvo = idDispositvo;
    }

    public int getCant_Disponible() {
        return cant_Disponible;
    }

    public void setCant_Disponible(int cant_Disponible) {
        this.cant_Disponible = cant_Disponible;
    }

    public int getCant_EnUso() {
        return cant_EnUso;
    }

    public void setCant_EnUso(int cant_EnUso) {
        this.cant_EnUso = cant_EnUso;
    }

    public int getCant_Danados() {
        return cant_Danados;
    }

    public void setCant_Danados(int cant_Danados) {
        this.cant_Danados = cant_Danados;
    }
    
    
}
