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

/**
 *
 * @author Carlos
 */
public class CursoDAO {
    private RandomAccessFile CursoDB;
    
    public CursoDAO() throws FileNotFoundException{
      this.CursoDB = new RandomAccessFile("curso.txt", "rw");
      //this.CursoDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\curso.txt", "rw");
      File f =new File("curso.txt");
        //System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Curso curso) throws IOException{
        long posicionMemoria = this.CursoDB.length();
        this.CursoDB.seek(posicionMemoria);
        this.CursoDB.writeInt(curso.getCodigo()); //cursoid
    
        for(int i = 0;i < 20; i++){
            
            if (i<curso.getNombre().length) {
                    char letra = curso.getNombre()[i];
                    this.CursoDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.CursoDB.writeChar(letra);
            }
          
        }
        this.CursoDB.writeInt(curso.getDuracion());//duracion
      
        this.CursoDB.writeInt(curso.getIdprof());//idprof
        
        return true;
    }
    
    public boolean actualizar(Curso estudiante){
        
    
      return false;
    }
    
    public boolean borrar(Curso estudiante){
      return false;
    }
    
    public ArrayList<Curso> listarTodo() throws IOException{
       for(long i = 0; i< this.CursoDB.length();i= i +52 ){//char 20*2 int 4 int 4 int 4
           this.CursoDB.seek(i);
           System.out.print(this.CursoDB.readInt());
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.CursoDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           System.out.print(this.CursoDB.readInt());
           System.out.print(" ");
           System.out.println(this.CursoDB.readInt());
           System.out.println("");
       }
       return null;
    }
    
    public void destructor() throws IOException{
      this.CursoDB.close();
    }
}
