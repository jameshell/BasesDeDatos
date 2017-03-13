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
public class Formulario {
    int IdFormulario;
    int CedulaEstudiante;
    int IdDispositivo;
    char[] fechaEntrada;
    char[] fechaSalida;

    public Formulario(int IdFormulario, int CedulaEstudiante, int IdDispositivo, char[] fechaEntrada, char[] fechaSalida) {
        this.IdFormulario = IdFormulario;
        this.CedulaEstudiante = CedulaEstudiante;
        this.IdDispositivo = IdDispositivo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public int getIdFormulario() {
        return IdFormulario;
    }

    public void setIdFormulario(int IdFormulario) {
        this.IdFormulario = IdFormulario;
    }

    public int getCedulaEstudiante() {
        return CedulaEstudiante;
    }

    public void setCedulaEstudiante(int CedulaEstudiante) {
        this.CedulaEstudiante = CedulaEstudiante;
    }

    public int getIdDispositivo() {
        return IdDispositivo;
    }

    public void setIdDispositivo(int IdDispositivo) {
        this.IdDispositivo = IdDispositivo;
    }

    public char[] getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(char[] fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public char[] getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(char[] fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
}
