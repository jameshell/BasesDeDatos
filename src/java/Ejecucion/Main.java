/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import DAO.ProfesorDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.Profesor;
/**
 *
 * @author Labing
 */
public class Main {
    public static void main(String[] args) {
        try {
            ProfesorDAO profesordao = new ProfesorDAO();
            ArrayList<Profesor> profesores =new ArrayList<Profesor>();
            int codigo = 1;
            //char[] nombre = {'f','a','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
            //char[] apellido={'g','i','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
            int ext = 15;
            Profesor Juan=new Profesor(0, "Juanma".toCharArray(), "Perez".toCharArray(), 315);
            Profesor Pedro=new Profesor(1, "Carlos".toCharArray(), "LOL".toCharArray(), 310);
            /*for(int i =0 ;i<10;i++){
                
               Profesor profesor=new Profesor(i, nombre, apellido ,ext);
               profesordao.insertar(profesor);
            }*/
            profesordao.insertar(Juan);
            profesordao.insertar(Pedro);
            profesordao.listarTodo();
            profesordao.destructor();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
