/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import vo.Curso;
import vo.Inscripciones;

/**
 *
 * @author Carlos
 */
public class InscripcionesDAO {
        private RandomAccessFile InscripcionesDB;
    public InscripcionesDAO() throws FileNotFoundException{
      this.InscripcionesDB = new RandomAccessFile("inscripcion.txt", "rw");
     // this.InscripcionesDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\inscripcion.txt", "rw");
      File f =new File("inscripcion.txt");
        //System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Inscripciones inscripcion) throws IOException{//int 4 int 4 char 20*2 char 20*2 in 4
        long posicionMemoria = this.InscripcionesDB.length();
        this.InscripcionesDB.seek(posicionMemoria);
        this.InscripcionesDB.writeInt(inscripcion.getIdest()); //idEstudiante
        this.InscripcionesDB.writeInt(inscripcion.getCodigocurso());//cdigo curso
        for(int i = 0;i < 20; i++){
            
            if (i<inscripcion.getFecha_ins().length) {
                    char letra = inscripcion.getFecha_ins()[i];
                    this.InscripcionesDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.InscripcionesDB.writeChar(letra);
            }
          
        }
        for(int i = 0;i < 20; i++){
            
            if (i<inscripcion.getFecha_fin().length) {
                    char letra = inscripcion.getFecha_fin()[i];
                    this.InscripcionesDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.InscripcionesDB.writeChar(letra);
            }
          
        }
        this.InscripcionesDB.writeFloat(inscripcion.getNota());//nota
        
        return true;
    }
    
    public boolean actualizar(Curso estudiante){
        
    
      return false;
    }
    public boolean buscar(Curso estudiante){
        
    
      return false;
    }
    public boolean borrar(Curso estudiante){
        
      return false;
    }
    
    public ArrayList<Curso> listarTodo() throws IOException{
       for(long i = 0; i< this.InscripcionesDB.length();i= i +92 ){
           this.InscripcionesDB.seek(i);
           System.out.print(this.InscripcionesDB.readInt());
           System.out.print(" ");
           System.out.print(this.InscripcionesDB.readInt());
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.InscripcionesDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.InscripcionesDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           System.out.println(this.InscripcionesDB.readFloat());
           System.out.println("");
       }
       return null;
    }
    public void destructor() throws IOException{
      this.InscripcionesDB.close();
    }
}
