/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Arboles.TreeInventario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import Datos.Inventario;

/**
 *
 * @author Carlos
 */
public class InventarioDAO {
    private RandomAccessFile inventarioDB;
    public TreeInventario treeInventario;
    public InventarioDAO() throws FileNotFoundException{
      this.treeInventario=new TreeInventario();
      this.inventarioDB = new RandomAccessFile("inventario.txt", "rw");
      //this.inventarioDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\inventario.txt", "rw");
      File f =new File("inventario.txt");
        System.out.println("Ubicacion del archivo de Inventario: \n");
        System.out.println(f.getAbsolutePath());
    }
    public boolean insertar(Inventario inventario) throws IOException{
        long posicionMemoria = this.inventarioDB.length();
        this.inventarioDB.seek(posicionMemoria);
        this.inventarioDB.writeInt(inventario.getIdInventario()); //id
        treeInventario.insertar(inventario.getIdInventario(), (int)posicionMemoria);
        for(int i = 0;i < 20; i++){
            if (i<inventario.getNombreInventario().length) {
                    char letra = inventario.getNombreInventario()[i];
                    this.inventarioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.inventarioDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 100; i++){
          if (i<inventario.getDescripcionInventario().length) {
                    char letra = inventario.getDescripcionInventario()[i];
                    this.inventarioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.inventarioDB.writeChar(letra);
            }
        }
      
        this.inventarioDB.writeInt(inventario.getCant_Disponible());
        this.inventarioDB.writeInt(inventario.getCant_EnUso());
        this.inventarioDB.writeInt(inventario.getCant_Danados());
        return true;
    }
    
    public boolean actualizar(Inventario Inventario) throws IOException{
        if (treeInventario.getTreeMap().containsKey(Inventario.getIdInventario())) {
        int pos=buscar(Inventario.getIdInventario());
        this.inventarioDB.seek(pos);
        this.inventarioDB.writeInt(Inventario.getIdInventario()); //id
        for(int i = 0;i < 20; i++){
            
            if (i<Inventario.getNombreInventario().length) {
                    char letra = Inventario.getNombreInventario()[i];
                    this.inventarioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.inventarioDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 100; i++){
          if (i<Inventario.getDescripcionInventario().length) {
                    char letra = Inventario.getDescripcionInventario()[i];
                    this.inventarioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.inventarioDB.writeChar(letra);
            }
        }
      
        this.inventarioDB.writeInt(Inventario.getCant_Disponible());
        this.inventarioDB.writeInt(Inventario.getCant_EnUso());
        this.inventarioDB.writeInt(Inventario.getCant_Danados());
        return true;
        }
      return false;
    }
    public int buscar(int Inventar){
        int b=treeInventario.buscaribyte(Inventar);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean borrar(int Inventar) throws IOException{
        if(treeInventario.getTreeMap().containsKey(Inventar)){
            treeInventario.borrar(Inventar);
            //treeInventario.inicializar();
            return true;
        }
      return false;
    }
    public Inventario Listar(int Inventar) throws IOException{
        int pos=buscar(Inventar);
            inventarioDB.seek(pos);
            int idInventario=this.inventarioDB.readInt();
            String nombreInventario=new String();
            for(int j = 0;j<20;j++){
               char c=this.inventarioDB.readChar();
               if (c==' ') {
                   
               }else{
                   nombreInventario=nombreInventario+c;
               }
           }
           String descripcion=new String();
           for(int j = 0;j<100;j++){
               char c=this.inventarioDB.readChar();
                   descripcion=descripcion+c;
           }
           int Cant_Disponible=this.inventarioDB.readInt();
           int Cant_Uso=this.inventarioDB.readInt();
           int Cant_Danado=this.inventarioDB.readInt();
           return new Inventario(idInventario, nombreInventario.toCharArray(), descripcion.toCharArray(), Cant_Disponible, Cant_Uso, Cant_Danado);
    }
    public ArrayList<Inventario> listarTodo() throws IOException{
        ArrayList<Inventario> al=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:treeInventario.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            inventarioDB.seek(pos);
            int idInventario=this.inventarioDB.readInt();
            String nombreInventario=new String();
            for(int j = 0;j<20;j++){
               char c=this.inventarioDB.readChar();
               if (c==' ') {
                   
               }else{
                   nombreInventario=nombreInventario+c;
               }
           }
           String descripcion=new String();
           for(int j = 0;j<100;j++){
               char c=this.inventarioDB.readChar();
                   descripcion=descripcion+c;
           }
           int Cant_Disponible=this.inventarioDB.readInt();
           int Cant_Uso=this.inventarioDB.readInt();
           int Cant_Danado=this.inventarioDB.readInt();
           al.add(new Inventario(idInventario, nombreInventario.toCharArray(), descripcion.toCharArray(), Cant_Disponible, Cant_Uso, Cant_Danado));
        }
        
       return al;
    }
    
    public void destructor() throws IOException{
      this.inventarioDB.close();
    }
}