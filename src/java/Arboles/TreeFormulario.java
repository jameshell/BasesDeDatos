/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class TreeFormulario {
    private TreeMap<Integer, Integer> treeMap;
    private RandomAccessFile TreeFormulario;
    public TreeFormulario() {
        treeMap=new TreeMap<>();
        try {
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // key=idestudiente value=bytes
    public boolean insertar(int key,int value) throws IOException{
        if (treeMap.isEmpty()) {
            treeMap.put(key, value);
            TreeFormulario.writeInt(key);
            TreeFormulario.writeInt(value);
        }else{
            long Tamano=TreeFormulario.length();
            TreeFormulario.seek(Tamano);
            TreeFormulario.writeInt(key);
            TreeFormulario.writeInt(value);
            treeMap.put(key, value);
        }
        return true;
    }
    public void inicializar() throws FileNotFoundException, IOException{
        this.TreeFormulario = new RandomAccessFile("TreeFormulario.txt", "rw");
        //this.TreeFormulario = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\TreeFormulario.txt", "rw");
        if (TreeFormulario.length()!=0) {
            //System.out.println(TreeFormulario.length());
            for (int i = 0; i < TreeFormulario.length(); i=i+8) {
                int Key=TreeFormulario.readInt();
                int Value=TreeFormulario.readInt();
                treeMap.put(Key, Value);
            }
        }else{
            System.out.println("empty");
        }
    }
    public int buscaribyte(int Key){
        int Byte=treeMap.get(Key);
        return Byte;
    }
    public void Listar(){
        for (Map.Entry<Integer, Integer> entry:treeMap.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.print(entry.getValue());
            System.out.println("");
        }
    }
    public void borrar(int key){
        try {
            TreeFormulario.setLength(0);
            for (Map.Entry<Integer, Integer> entry:treeMap.entrySet()) {
                if (entry.getKey()!=key) {
                    TreeFormulario.writeInt(entry.getKey());
                    TreeFormulario.writeInt(entry.getValue());
                }
            }
            System.out.println(TreeFormulario.length());
            treeMap.clear();
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public TreeMap<Integer, Integer> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(TreeMap<Integer, Integer> treeMap) {
        this.treeMap = treeMap;
    }
}
