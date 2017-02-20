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
import java.util.Map;
import vo.Estudiante;
import vo.Profesor;

/**
 *
 * @author Labing
 */
public class ProfesorDAO {
    private RandomAccessFile profesorDB;
    TreeProfesor treeprofesor;
    public ProfesorDAO() throws FileNotFoundException{
        treeprofesor=new TreeProfesor();
      this.profesorDB = new RandomAccessFile("profesor.txt", "rw");
      //this.profesorDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\profesor.txt", "rw");
      File f =new File("profesor.txt");
        System.out.println("Ubicacion del archivo de Profesores:  \n");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Profesor profesor) throws IOException{
        treeprofesor=new TreeProfesor();
        long posicionMemoria = this.profesorDB.length();
        this.profesorDB.seek(posicionMemoria);
        this.profesorDB.writeInt(profesor.getId()); //id
        treeprofesor.insertar(profesor.getId(),(int)posicionMemoria);
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
    public int buscar(int idProfesor){
        int b=treeprofesor.buscaribyte(idProfesor);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean actualizar(Profesor profesor) throws IOException{
        if (treeprofesor.getTreeMap().containsKey(profesor.getId())) {
        int pos=buscar(profesor.getId());
        this.profesorDB.seek(pos);
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
      return false;
    }
    
    public boolean borrar(int idprofesor){
        if(treeprofesor.getTreeMap().containsKey(idprofesor)){
            treeprofesor.borrar(idprofesor);
            //treeEstudiante.inicializar();
            return true;
        }
      return false;
    }
    public void Listar(int idProfesor) throws IOException{//4
        int pos=buscar(idProfesor);
        profesorDB.seek(pos);
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
    public ArrayList<Estudiante> listarTodo() throws IOException{//
        for (Map.Entry<Integer, Integer> entry:treeprofesor.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            profesorDB.seek(pos);
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
