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
    private int SemestreEstudiante;
    private char[] CarreraEstudiante;

    public Estudiantes(int CedulaEstudiante, char[] NombreEstudiante, int SemestreEstudiante, char[] CarreraEstudiante) {
        this.CedulaEstudiante = CedulaEstudiante;
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
    
}
