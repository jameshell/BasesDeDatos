/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author Carlos
 */
public class Estudiante {
    private int id;
    private char[] Nombre;
    private char[] Apellido;
    private int Telefono;
    public Estudiante(int id, char[] Nombre, char[] Apellido, int Telefono) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getNombre() {
        return Nombre;
    }

    public void setNombre(char[] Nombre) {
        this.Nombre = Nombre;
    }

    public char[] getApellido() {
        return Apellido;
    }

    public void setApellido(char[] Apellido) {
        this.Apellido = Apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
}
