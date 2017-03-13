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
import DAO.TreeCurso;
import Arboles.TreeEstudiante;
import DAO.TreeProfesor;
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
            InscripcionesDAO inscripcionesDAO=new InscripcionesDAO();
            /*inscripcionesDAO.insertar(new Inscripciones(1,1015, 101, "10/08/2010".toCharArray(), "26/08/2010".toCharArray(), 3));
            inscripcionesDAO.insertar(new Inscripciones(2,1015, 103, "15/06/2009".toCharArray(), "10/07/2009".toCharArray(), (float) 4.5));
            inscripcionesDAO.insertar(new Inscripciones(3,1029, 101, "10/08/2010".toCharArray(), "26/08/2010".toCharArray(), (float) 3.5));
            inscripcionesDAO.insertar(new Inscripciones(4,1518, 102, "10/08/2010".toCharArray(), "20/08/2010".toCharArray(), 4));
            inscripcionesDAO.insertar(new Inscripciones(5,1518, 103, "15/06/2009".toCharArray(), "10/07/2009".toCharArray(), (float) 4.5));
            inscripcionesDAO.insertar(new Inscripciones(6,1518, 104, "10/02/2010".toCharArray(), "30/05/2010".toCharArray(), 5));
            inscripcionesDAO.insertar(new Inscripciones(7,10, 104, "10/02/2010".toCharArray(), "30/05/2010".toCharArray(), 5));
            */inscripcionesDAO.borrar(1);
            inscripcionesDAO.listarTodo();
            inscripcionesDAO.destructor();
        }catch(IOException e){
            
        }
    }
}
