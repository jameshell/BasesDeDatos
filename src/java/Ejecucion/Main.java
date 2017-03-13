/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import DAO.EstudianteDAO;
import Datos.Estudiantes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Labing
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        EstudianteDAO edao=new EstudianteDAO();
        ArrayList<Estudiantes> a=edao.listarTodo();
        System.out.println("Ejecucion.Main.main()");
    }
}
