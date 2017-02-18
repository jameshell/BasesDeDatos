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
import vo.Profesor;

/**
 *
 * @author Labing
 */
public class ProfesorDAO {
    private RandomAccessFile profesorDB;
    
    public ProfesorDAO() throws FileNotFoundException{
      this.profesorDB = new RandomAccessFile("profesor.txt", "rw");
      //this.profesorDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\profesor.txt", "rw");
      File f =new File("profesor.txt");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Profesor profesor) throws IOException{
        long posicionMemoria = this.profesorDB.length();
        this.profesorDB.seek(posicionMemoria);
        this.profesorDB.writeInt(profesor.getId()); //id
    
        for(int i = 0;i < 20; i++){
            
            if (i<profesor.getNombre().length) {
                    char letra = profesor.getNombre()[i];
                    this.profesorDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.profesorDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 20; i++){
          if (i<profesor.getApellido().length) {
                    char letra = profesor.getApellido()[i];
                    this.profesorDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.profesorDB.writeChar(letra);
            }
        }
      
        this.profesorDB.writeInt(profesor.getExt());
        
        return true;
    }
    
    public boolean actualizar(Profesor profesor){
        
    
      return false;
    }
    
    public boolean borrar(Profesor profesor){
      return false;
    }
    
    public ArrayList<Profesor> listarTodo() throws IOException{
       for(long i = 0; i< this.profesorDB.length();i= i + 88){
           this.profesorDB.seek(i);
           System.out.print(this.profesorDB.readInt());
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.profesorDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           for(int j = 0;j<20;j++){
               char c=this.profesorDB.readChar();
               if (c==' ') {
                   
               }else{
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           System.out.println(this.profesorDB.readInt());
           System.out.println("");
       }
       return null;
    }
    
    public void destructor() throws IOException{
      this.profesorDB.close();
    }
}
