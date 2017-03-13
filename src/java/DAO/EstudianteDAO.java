/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Arboles.TreeEstudiante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datos.Estudiantes;

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
        System.out.println("Ubicacion del archivo de Estudiantes: \n");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Estudiantes estudiante) throws IOException{
        long posicionMemoria = this.estudianteDB.length();
        this.estudianteDB.seek(posicionMemoria);
        this.estudianteDB.writeInt(estudiante.getCedulaEstudiante()); //id
        treeEstudiante.insertar(estudiante.getCedulaEstudiante(), (int)posicionMemoria);
        for(int i = 0;i < 20; i++){
            if (i<estudiante.getNombreEstudiante().length) {
                    char letra = estudiante.getNombreEstudiante()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 20; i++){
          if (i<estudiante.getApellidoEstudiante().length) {
                    char letra = estudiante.getApellidoEstudiante()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
        }
      
        this.estudianteDB.writeInt(estudiante.getSemestreEstudiante());
        for(int i = 0;i <40; i++){
          if (i<estudiante.getCarreraEstudiante().length) {
                    char letra = estudiante.getCarreraEstudiante()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
        }
        
        return true;
    }
    
    public boolean actualizar(Estudiantes estudiante) throws IOException{
        if (treeEstudiante.getTreeMap().containsKey(estudiante.getCedulaEstudiante())) {
        int pos=buscar(estudiante.getCedulaEstudiante());
        this.estudianteDB.seek(pos);
        this.estudianteDB.writeInt(estudiante.getCedulaEstudiante()); //id
        for(int i = 0;i < 20; i++){
            
            if (i<estudiante.getNombreEstudiante().length) {
                    char letra = estudiante.getNombreEstudiante()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 20; i++){
          if (i<estudiante.getApellidoEstudiante().length) {
                    char letra = estudiante.getApellidoEstudiante()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
        }
      
        this.estudianteDB.writeInt(estudiante.getSemestreEstudiante());
        for(int i = 0;i < 40; i++){
          if (i<estudiante.getCarreraEstudiante().length) {
                    char letra = estudiante.getCarreraEstudiante()[i];
                    this.estudianteDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.estudianteDB.writeChar(letra);
            }
        }
        return true;
        }
      return false;
    }
    public int buscar(int idEstudiante){
        int b=treeEstudiante.buscaribyte(idEstudiante);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean borrar(int idEstudiante) throws IOException{
        if(treeEstudiante.getTreeMap().containsKey(idEstudiante)){
            treeEstudiante.borrar(idEstudiante);
            //treeEstudiante.inicializar();
            return true;
        }
      return false;
    }
    public void Listar(int idEstudiante) throws IOException{
        int pos=buscar(idEstudiante);
        estudianteDB.seek(pos);
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
    public ArrayList<Estudiantes> listarTodo() throws IOException{
        ArrayList<Estudiantes> al=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:treeEstudiante.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            estudianteDB.seek(pos);
            int cedula=this.estudianteDB.readInt();
            String Nombre=new String();
            for(int j = 0;j<20;j++){
               char c=this.estudianteDB.readChar();
               if (c==' ') {
                   
               }else{
                   Nombre=Nombre+c;
               }
            }
            String Apellido=new String();
           for(int j = 0;j<20;j++){
               char c=this.estudianteDB.readChar();
               if (c==' ') {
                   
               }else{
                   Apellido=Apellido+c;
               }
           }
           int Semestre=this.estudianteDB.readInt();
           String Carrera=new String();
           for(int j = 0;j<40;j++){
               char c=this.estudianteDB.readChar();
               if (c==' ') {
                   
               }else{
                   Carrera=Carrera+c;
               }
           }
           al.add(new Estudiantes(cedula, Nombre.toCharArray(), Apellido.toCharArray(), Semestre, Carrera.toCharArray()));
        }
        
       return al;
    }
    
    public void destructor() throws IOException{
      this.estudianteDB.close();
    }
}