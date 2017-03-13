/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Arboles.TreeHerramienta;
import Datos.Herramientas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class HerramientaDAO {
    private RandomAccessFile herramientasDB;
    public TreeHerramienta treeHerramientas;
    public HerramientaDAO() throws FileNotFoundException{
      this.treeHerramientas=new TreeHerramienta();
      this.herramientasDB = new RandomAccessFile("herramienta.txt", "rw");
      //this.herramientasDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\herramienta.txt", "rw");
      File f =new File("herramienta.txt");
    }
    public boolean insertar(Herramientas herramienta) throws IOException{
        long posicionMemoria = this.herramientasDB.length();
        this.herramientasDB.seek(posicionMemoria);
        this.herramientasDB.writeInt(herramienta.getIdDispositivo()); //id
        treeHerramientas.insertar(herramienta.getIdDispositivo(), (int)posicionMemoria);
        this.herramientasDB.writeInt(herramienta.getIdMantenimiento());
        this.herramientasDB.writeInt(herramienta.getIdInventario());//
        this.herramientasDB.writeInt(herramienta.getNo_Serial());//
        for(int i = 0;i < 20; i++){
            if (i<herramienta.getNombreHerramienta().length) {
                    char letra = herramienta.getNombreHerramienta()[i];
                    this.herramientasDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.herramientasDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 100; i++){
          if (i<herramienta.getDescripcionHerramienta().length) {
                    char letra = herramienta.getDescripcionHerramienta()[i];
                    this.herramientasDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.herramientasDB.writeChar(letra);
            }
        }
        for(int i = 0;i < 10; i++){
          if (i<herramienta.getStatusHerramienta().length) {
                    char letra = herramienta.getStatusHerramienta()[i];
                    this.herramientasDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.herramientasDB.writeChar(letra);
            }
        }
        this.herramientasDB.writeInt(herramienta.getCantArreglos());
        return true;
    }
    
    public boolean actualizar(Herramientas herramienta) throws IOException{
        if (treeHerramientas.getTreeMap().containsKey(herramienta.getIdDispositivo())) {
        int pos=buscar(herramienta.getIdDispositivo());
        this.herramientasDB.seek(pos);
        this.herramientasDB.writeInt(herramienta.getIdDispositivo());
        this.herramientasDB.writeInt(herramienta.getIdMantenimiento()); //id
        this.herramientasDB.writeInt(herramienta.getIdInventario());
        this.herramientasDB.writeInt(herramienta.getNo_Serial());
        for(int i = 0;i < 20; i++){
            
            if (i<herramienta.getNombreHerramienta().length) {
                    char letra = herramienta.getNombreHerramienta()[i];
                    this.herramientasDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.herramientasDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 100; i++){
          if (i<herramienta.getDescripcionHerramienta().length) {
                    char letra = herramienta.getDescripcionHerramienta()[i];
                    this.herramientasDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.herramientasDB.writeChar(letra);
            }
        }
        for(int i = 0;i < 10; i++){
          if (i<herramienta.getStatusHerramienta().length) {
                    char letra = herramienta.getStatusHerramienta()[i];
                    this.herramientasDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.herramientasDB.writeChar(letra);
            }
        }
        this.herramientasDB.writeInt(herramienta.getCantArreglos());
        return true;
        }
      return false;
    }
    public int buscar(int herramienta){
        int b=treeHerramientas.buscaribyte(herramienta);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean borrar(int herramienta) throws IOException{
        if(treeHerramientas.getTreeMap().containsKey(herramienta)){
            treeHerramientas.borrar(herramienta);
            //treeHerramientas.inicializar();
            return true;
        }
      return false;
    }
    public Herramientas Listar(int herramienta) throws IOException{
        int pos=buscar(herramienta);
            herramientasDB.seek(pos);
            int idDispositivo=this.herramientasDB.readInt();
            int idMantenimiento=this.herramientasDB.readInt();
            int idInventario=this.herramientasDB.readInt();
            int No_Serial=this.herramientasDB.readInt();
            String NombreHerramienta=new String();
            for(int j = 0;j<20;j++){
                char c=this.herramientasDB.readChar();
               if (c==' ') {
                   
               }else{
                   NombreHerramienta=NombreHerramienta+c;
               }
           }
           String descripcionHerramienta=new String();
           for(int j = 0;j<100;j++){
               char c=this.herramientasDB.readChar();
                   descripcionHerramienta=descripcionHerramienta+c;
               
           }
           String Status=new String();
           for(int j = 0;j<10;j++){
               char c=this.herramientasDB.readChar();
               if (c==' ') {
                   
               }else{
                   Status=Status+c;
               }
           }
        int cant_arr=this.herramientasDB.readInt();
        return new Herramientas(idDispositivo, idMantenimiento, idInventario, No_Serial, NombreHerramienta.toCharArray(), descripcionHerramienta.toCharArray(), Status.toCharArray(), cant_arr);
    }
    public ArrayList<Herramientas> listarTodo() throws IOException{
        ArrayList<Herramientas> al=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:treeHerramientas.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            herramientasDB.seek(pos);
            int idDispositivo=this.herramientasDB.readInt();
            int idMantenimiento=this.herramientasDB.readInt();
            int idInventario=this.herramientasDB.readInt();
            int No_Serial=this.herramientasDB.readInt();
            String NombreHerramienta=new String();
            for(int j = 0;j<20;j++){
               char c=this.herramientasDB.readChar();
               if (c==' ') {
                   
               }else{
                   NombreHerramienta=NombreHerramienta+c;
               }
           }
           String descripcionHerramienta=new String();
           for(int j = 0;j<100;j++){
               char c=this.herramientasDB.readChar();
                   descripcionHerramienta=descripcionHerramienta+c;
               
           }
           String Status=new String();
           for(int j = 0;j<10;j++){
               char c=this.herramientasDB.readChar();
               if (c==' ') {
                   
               }else{
                   Status=Status+c;
               }
           }
        int cant_arr=this.herramientasDB.readInt();
           
           al.add(new Herramientas(idDispositivo, idMantenimiento, idInventario, No_Serial, NombreHerramienta.toCharArray(), descripcionHerramienta.toCharArray(), Status.toCharArray(), cant_arr));
        }
        
       return al;
    }
    
    public void destructor() throws IOException{
      this.herramientasDB.close();
    }
}