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
import vo.Estudiante;

/**
 *
 * @author Carlos
 */
public class EstudianteDAO {
    private RandomAccessFile estudianteDB;
    public TreeEstudiante treeEstudiante;
    public EstudianteDAO() throws FileNotFoundException{
      this.treeEstudiante=new TreeEstudiante();
      this.estudianteDB = new RandomAccessFile("estudiante.txt", "rw");
      //this.estudianteDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\estudiante.txt", "rw");
      File f =new File("estudiante.txt");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Estudiante estudiante) throws IOException{
        long posicionMemoria = this.estudianteDB.length();
        this.estudianteDB.seek(posicionMemoria);
        this.estudianteDB.writeInt(estudiante.getId()); //id
        treeEstudiante.insertar(estudiante.getId(), (int)posicionMemoria);
        for(int i = 0;i < 20; i++){
            
            if (i<estudiante.getNombre().length) {
                    char letra = estudiante.getNombre()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 20; i++){
          if (i<estudiante.getApellido().length) {
                    char letra = estudiante.getApellido()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
        }
      
        this.estudianteDB.writeInt(estudiante.getTelefono());
        
        return true;
    }
    
    public boolean actualizar(Estudiante estudiante){
        
    
      return false;
    }
    
    public boolean borrar(Estudiante estudiante){
      return false;
    }
    
    public ArrayList<Estudiante> listarTodo() throws IOException{
       for(long i = 0; i< this.estudianteDB.length();i= i + 88){//char 20*2 char 20*2 int 4 int 4 
           this.estudianteDB.seek(i);
           System.out.print(this.estudianteDB.readInt());
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.estudianteDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.estudianteDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           System.out.println(this.estudianteDB.readInt());
           System.out.println("");
       }
       return null;
    }
    
    public void destructor() throws IOException{
      this.estudianteDB.close();
    }
}
