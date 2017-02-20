/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Inscripciones {
    int noInscripcion;
    private int idest;
    private int codigocurso;
    private char[] Fecha_ins;
    private char[] Fecha_fin;
    private float nota;

    public Inscripciones(int noInscripcion, int idest, int codigocurso, char[] Fecha_ins, char[] Fecha_fin, float nota) {
        this.noInscripcion = noInscripcion;
        this.idest = idest;
        this.codigocurso = codigocurso;
        this.Fecha_ins = Fecha_ins;
        this.Fecha_fin = Fecha_fin;
        this.nota = nota;
    }

    public int getNoInscripcion() {
        return noInscripcion;
    }

    public void setNoInscripcion(int noInscripcion) {
        this.noInscripcion = noInscripcion;
    }
    
    public int getIdest() {
        return idest;
    }

    public void setIdest(int idest) {
        this.idest = idest;
    }

    public int getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(int codigocurso) {
        this.codigocurso = codigocurso;
    }

    public char[] getFecha_ins() {
        return Fecha_ins;
    }

    public void setFecha_ins(char[] Fecha_ins) {
        this.Fecha_ins = Fecha_ins;
    }

    public char[] getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(char[] Fecha_fin) {
        this.Fecha_fin = Fecha_fin;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
