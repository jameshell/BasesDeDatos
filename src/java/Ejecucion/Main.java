/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import DAO.EstudianteDAO;
import DAO.FormularioDAO;
import DAO.MantenimientoDAO;
import Datos.Estudiantes;
import Datos.Formulario;
import Datos.Mantenimientos;
import java.awt.PageAttributes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Labing
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FormularioDAO fdao=new FormularioDAO();
        ArrayList<Formulario> al=fdao.listarTodo();
        System.out.println(al);
    }
}
