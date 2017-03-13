/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Arboles.TreeMantenimiento;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datos.Mantenimientos;

/**
 *
 * @author Carlos
 */
public class MantenimientoDAO {
    private RandomAccessFile MantenimientoDB;
    public TreeMantenimiento TreeMantenimiento;
    public MantenimientoDAO() throws FileNotFoundException{
      this.TreeMantenimiento=new TreeMantenimiento();
      this.MantenimientoDB = new RandomAccessFile("Mantenimiento.txt", "rw");
      //this.MantenimientoDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\estudiante.txt", "rw");
      File f =new File("Mantenimiento.txt");
        System.out.println("Ubicacion del archivo de Estudiantes: \n");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Mantenimientos Mantenimiento) throws IOException{
        long posicionMemoria = this.MantenimientoDB.length();
        this.MantenimientoDB.seek(posicionMemoria);
        this.MantenimientoDB.writeInt(Mantenimiento.getIdMantenimiento()); //id
        TreeMantenimiento.insertar(Mantenimiento.getIdMantenimiento(), (int)posicionMemoria);
        this.MantenimientoDB.writeInt(Mantenimiento.getIdDispositivo());
        for(int i = 0;i < 20; i++){
            if (i<Mantenimiento.getTituloMantenimiento().length) {
                    char letra = Mantenimiento.getTituloMantenimiento()[i];
                    this.MantenimientoDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.MantenimientoDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 200; i++){
          if (i<Mantenimiento.getDescripcionMantenimiento().length) {
                    char letra = Mantenimiento.getDescripcionMantenimiento()[i];
                    this.MantenimientoDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.MantenimientoDB.writeChar(letra);
            }
        }
        
        return true;
    }
    
    public boolean actualizar(Mantenimientos Mantenimiento) throws IOException{
        if (TreeMantenimiento.getTreeMap().containsKey(Mantenimiento.getIdMantenimiento())) {
        int pos=buscar(Mantenimiento.getIdMantenimiento());
        this.MantenimientoDB.seek(pos);
        this.MantenimientoDB.writeInt(Mantenimiento.getIdMantenimiento()); //id
                this.MantenimientoDB.writeInt(Mantenimiento.getIdDispositivo());
        for(int i = 0;i < 20; i++){
            if (i<Mantenimiento.getTituloMantenimiento().length) {
                    char letra = Mantenimiento.getTituloMantenimiento()[i];
                    this.MantenimientoDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.MantenimientoDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 200; i++){
          if (i<Mantenimiento.getDescripcionMantenimiento().length) {
                    char letra = Mantenimiento.getDescripcionMantenimiento()[i];
                    this.MantenimientoDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.MantenimientoDB.writeChar(letra);
            }
        }
        return true;
        }
      return false;
    }
    public int buscar(int idMantenimiento){
        int b=TreeMantenimiento.buscaribyte(idMantenimiento);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean borrar(int idMantenimiento) throws IOException{
        if(TreeMantenimiento.getTreeMap().containsKey(idMantenimiento)){
            TreeMantenimiento.borrar(idMantenimiento);
            //TreeMantenimiento.inicializar();
            return true;
        }
      return false;
    }
    public Mantenimientos Listar(int idMantenimiento) throws IOException{
        int pos=buscar(idMantenimiento);
        MantenimientoDB.seek(pos);
            int IdMantenimiento=MantenimientoDB.readInt();
            int IdDispositivo=MantenimientoDB.readInt();
            String Titulo=new String();
            for(int j = 0;j<20;j++){
               char c=this.MantenimientoDB.readChar();
               if (c==' ') {
                   
               }else{
                   Titulo=Titulo+c;
               }
           }
           String Detalles=new String();
           for(int j = 0;j<200;j++){
               char c=this.MantenimientoDB.readChar();
               Detalles=Detalles+c;
           }
           return new Mantenimientos(IdMantenimiento, IdDispositivo, Titulo.toCharArray(), Detalles.toCharArray());
    }
    public ArrayList<Mantenimientos> listarTodo() throws IOException{
        ArrayList<Mantenimientos> al=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:TreeMantenimiento.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            MantenimientoDB.seek(pos);
            int IdMantenimiento=this.MantenimientoDB.readInt();
            int IdDispositivo=this.MantenimientoDB.readInt();
            String Titulo=new String();
            for(int j = 0;j<20;j++){
               char c=this.MantenimientoDB.readChar();
               if (c==' ') {
                   
               }else{
                   Titulo=Titulo+c;
               }
            }
            String Detalle=new String();
           for(int j = 0;j<200;j++){
               char c=this.MantenimientoDB.readChar();
                   Detalle=Detalle+c;
           }
           al.add(new Mantenimientos(IdMantenimiento, IdDispositivo, Titulo.toCharArray(), Detalle.toCharArray()));
        }
        
       return al;
    }
    
    public void destructor() throws IOException{
      this.MantenimientoDB.close();
    }
}