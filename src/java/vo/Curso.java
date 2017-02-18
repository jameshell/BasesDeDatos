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
public class Curso {
    private int codigo;
    private char[] nombre;
    private int duracion;
    private int idprof;

    public Curso(int codigo, char[] nombre, int duracion, int idprof) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.duracion = duracion;
        this.idprof = idprof;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdprof() {
        return idprof;
    }

    public void setIdprof(int idprof) {
        this.idprof = idprof;
    }
    
}
