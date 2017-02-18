/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import DAO.CursoDAO;
import DAO.EstudianteDAO;
import DAO.InscripcionesDAO;
import DAO.ProfesorDAO;
import DAO.TreeEstudiante;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.Curso;
import vo.Estudiante;
import vo.Inscripciones;
import vo.Profesor;
/**
 *
 * @author Labing
 */
public class Main {
    public static void main(String[] args) {
        try {
            EstudianteDAO estudianteDAO=new EstudianteDAO();
            estudianteDAO.listarTodo();
            estudianteDAO.destructor();
            estudianteDAO.treeEstudiante.Listar();
            RandomAccessFile TreeEstudiante = new RandomAccessFile("TreeEstudiante.txt", "rw");
            TreeEstudiante.skipBytes(16);
            System.out.println(TreeEstudiante.readInt());
            System.out.println(TreeEstudiante.readInt());
        }catch(IOException e){
            
        }
    }
}
