/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Arboles.TreeFormulario;
import Datos.Formulario;
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
public class FormularioDAO {
    private RandomAccessFile formularioDB;
    public TreeFormulario treeFormulario;
    public FormularioDAO() throws FileNotFoundException{
      this.treeFormulario=new TreeFormulario();
      this.formularioDB = new RandomAccessFile("formulario.txt", "rw");
      //this.formularioDB = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\formulario.txt", "rw");
      File f =new File("formulario.txt");
    }
    public boolean insertar(Formulario formulario) throws IOException{
        long posicionMemoria = this.formularioDB.length();
        this.formularioDB.seek(posicionMemoria);
        this.formularioDB.writeInt(formulario.getIdTransaccion()); //id
        treeFormulario.insertar(formulario.getIdTransaccion(), (int)posicionMemoria);
        this.formularioDB.writeInt(formulario.getIdFormulario());
        this.formularioDB.writeInt(formulario.getCedulaEstudiante());//
        this.formularioDB.writeInt(formulario.getIdDispositivo());//
        for(int i = 0;i < 8; i++){
            if (i<formulario.getFechaEntrada().length) {
                    char letra = formulario.getFechaEntrada()[i];
                    this.formularioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.formularioDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 8; i++){
          if (i<formulario.getFechaSalida().length) {
                    char letra = formulario.getFechaSalida()[i];
                    this.formularioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.formularioDB.writeChar(letra);
            }
        }
        return true;
    }
    
    public boolean actualizar(Formulario formulario) throws IOException{
        if (treeFormulario.getTreeMap().containsKey(formulario.getCedulaEstudiante())) {
        int pos=buscar(formulario.getCedulaEstudiante());
        this.formularioDB.seek(pos);
        this.formularioDB.writeInt(formulario.getIdTransaccion());
        this.formularioDB.writeInt(formulario.getIdFormulario()); //id
        this.formularioDB.writeInt(formulario.getCedulaEstudiante());
        this.formularioDB.writeInt(formulario.getIdDispositivo());
        for(int i = 0;i < 8; i++){
            
            if (i<formulario.getFechaEntrada().length) {
                    char letra = formulario.getFechaEntrada()[i];
                    this.formularioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.formularioDB.writeChar(letra);
            }
          
        }
        
        for(int i = 0;i < 8; i++){
          if (i<formulario.getFechaSalida().length) {
                    char letra = formulario.getFechaSalida()[i];
                    this.formularioDB.writeChar(letra);
                }else{
                    char letra = ' ';
                    this.formularioDB.writeChar(letra);
            }
        }
        return true;
        }
      return false;
    }
    public int buscar(int idEstudiante){
        int b=treeFormulario.buscaribyte(idEstudiante);
        if (b!=-1) {
            return b;
        }else{
      return -1;
        }
    }
    public boolean borrar(int idEstudiante) throws IOException{
        if(treeFormulario.getTreeMap().containsKey(idEstudiante)){
            treeFormulario.borrar(idEstudiante);
            //treeFormulario.inicializar();
            return true;
        }
      return false;
    }
    public Formulario Listar(int idEstudiante) throws IOException{
        int pos=buscar(idEstudiante);
            formularioDB.seek(pos);
            int idTransaccion=this.formularioDB.readInt();
            int idFormulario=this.formularioDB.readInt();
            int CedulaEstudiante=this.formularioDB.readInt();
            int idDispositivo=this.formularioDB.readInt();
            String FechaEntrada=new String();
            for(int j = 0;j<8;j++){
               char c=this.formularioDB.readChar();
               if (c==' ') {
                   
               }else{
                   FechaEntrada=FechaEntrada+c;
               }
           }
           String FechaSalida=new String();
           for(int j = 0;j<8;j++){
               char c=this.formularioDB.readChar();
               if (c==' ') {
                   
               }else{
                   FechaSalida=FechaSalida+c;
               }
           }
           return new Formulario(idTransaccion,idFormulario, CedulaEstudiante, idDispositivo, FechaEntrada.toCharArray(), FechaSalida.toCharArray());
    }
    public ArrayList<Formulario> listarTodo() throws IOException{
        ArrayList<Formulario> al=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:treeFormulario.getTreeMap().entrySet()){
            int pos=buscar(entry.getKey());
            formularioDB.seek(pos);
            int idTransaccion=this.formularioDB.readInt();
            int idFormulario=this.formularioDB.readInt();
            int CedulaEstudiante=this.formularioDB.readInt();
            int idDispositivo=this.formularioDB.readInt();
            String FechaEntrada=new String();
            for(int j = 0;j<8;j++){
               char c=this.formularioDB.readChar();
               if (c==' ') {
                   
               }else{
                   FechaEntrada=FechaEntrada+c;
               }
           }
           String FechaSalida=new String();
           for(int j = 0;j<8;j++){
               char c=this.formularioDB.readChar();
               if (c==' ') {
                   
               }else{
                   FechaSalida=FechaSalida+c;
               }
           }
           
           al.add(new Formulario(idTransaccion,idFormulario, CedulaEstudiante, idDispositivo, FechaEntrada.toCharArray(), FechaSalida.toCharArray()));
        }
        
       return al;
    }
    
    public void destructor() throws IOException{
      this.formularioDB.close();
    }
}