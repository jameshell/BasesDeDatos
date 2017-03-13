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
public class Estudiantes {
    private int CedulaEstudiante;
    private char[] NombreEstudiante;
    private char[] ApellidoEstudiante;
    private int SemestreEstudiante;
    private char[] CarreraEstudiante;

    public Estudiantes(int CedulaEstudiante, char[] NombreEstudiante,char [] ApellidoEstudiante, int SemestreEstudiante, char[] CarreraEstudiante) {
        this.CedulaEstudiante = CedulaEstudiante;
        this.ApellidoEstudiante=ApellidoEstudiante;
        this.NombreEstudiante = NombreEstudiante;
        this.SemestreEstudiante = SemestreEstudiante;
        this.CarreraEstudiante = CarreraEstudiante;
    }

    public int getCedulaEstudiante() {
        return CedulaEstudiante;
    }

    public void setCedulaEstudiante(int CedulaEstudiante) {
        this.CedulaEstudiante = CedulaEstudiante;
    }

    public char[] getNombreEstudiante() {
        return NombreEstudiante;
    }

    public void setNombreEstudiante(char[] NombreEstudiante) {
        this.NombreEstudiante = NombreEstudiante;
    }

    public int getSemestreEstudiante() {
        return SemestreEstudiante;
    }

    public void setSemestreEstudiante(int SemestreEstudiante) {
        this.SemestreEstudiante = SemestreEstudiante;
    }

    public char[] getCarreraEstudiante() {
        return CarreraEstudiante;
    }

    public void setCarreraEstudiante(char[] CarreraEstudiante) {
        this.CarreraEstudiante = CarreraEstudiante;
    }
    

    public char[] getApellidoEstudiante() {
        return ApellidoEstudiante;
    }

    public void setApellidoEstudiante(char[] ApellidoEstudiante) {
        this.ApellidoEstudiante = ApellidoEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiantes{" + "CedulaEstudiante=" + CedulaEstudiante + ", NombreEstudiante=" + String.valueOf(NombreEstudiante) + ", ApellidoEstudiante=" + String.valueOf(ApellidoEstudiante) + ", SemestreEstudiante=" + SemestreEstudiante + ", CarreraEstudiante=" + String.valueOf(CarreraEstudiante)+ '}'+"\n";
    }
}
