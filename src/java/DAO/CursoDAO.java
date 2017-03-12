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
import vo.Curso;

/**
 *
 * @author Carlos
 */
public class CursoDAO {
    private RandomAccessFile CursoDB;
    public TreeCurso treeCurso;
    public CursoDAO() throws FileNotFoundException{
        treeCurso=new TreeCurso();
      this.CursoDB = new RandomAccessFile("curso.txt", "rw");
      //this.CursoDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\curso.txt", "rw");
      File f =new File("curso.txt");
        System.out.println("Ubicacion del archivo Cursos: \n");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Curso curso) throws IOException{
        long posicionMemoria = this.CursoDB.length();
        this.CursoDB.seek(posicionMemoria);
        this.CursoDB.writeInt(curso.getCodigo()); //cursoid
        treeCurso.insertar(curso.getCodigo(), (int)posicionMemoria);
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
    public int buscar(int CodigoCurso){
        int b=treeCurso.buscaribyte(CodigoCurso);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean actualizar(Curso curso) throws IOException{
        if (treeCurso.getTreeMap().containsKey(curso.getCodigo())) {
        int pos=buscar(curso.getCodigo());
        this.CursoDB.seek(pos);
        this.CursoDB.writeInt(curso.getCodigo()); //id
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
      return false;
    }
    
    public boolean borrar(int CodigoCurso){
      if(treeCurso.getTreeMap().containsKey(CodigoCurso)){
            treeCurso.borrar(CodigoCurso);
            return true;
        }
      return false;
    }
    public void Listar(int CodigoCurso) throws IOException{//4
        int pos=buscar(CodigoCurso);
        CursoDB.seek(pos);
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
    public ArrayList<Curso> listarTodo() throws IOException{
        ArrayList<Curso> al=new ArrayList<>();
       for (Map.Entry<Integer, Integer> entry:treeCurso.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            int codigo=this.CursoDB.readInt();
            System.out.print(codigo);
           System.out.print(" ");
           String Nombre=new String();
           for(int j = 0;j<20;j++){
               char c=this.CursoDB.readChar();
               if (c==' ') {
               }else{
                   Nombre=Nombre+c;
                   System.out.print(c);
               }
           }
           System.out.print(" ");
           int Duracion=this.CursoDB.readInt();
           System.out.print(Duracion);
           System.out.print(" ");
           int IdProf=this.CursoDB.readInt();
           System.out.println(IdProf);
           System.out.println("");
           al.add(new Curso(codigo, Nombre.toCharArray(), Duracion, IdProf));
        }
        return al;
    }
    
    public void destructor() throws IOException{
      this.CursoDB.close();
    }
}
