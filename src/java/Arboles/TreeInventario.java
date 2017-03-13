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
public class TreeInventario {
    private TreeMap<Integer, Integer> treeMap;
    private RandomAccessFile TreeInventario;
    public TreeInventario() {
        treeMap=new TreeMap<>();
        try {
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // key=idestudiente value=bytes
    public boolean insertar(int key,int value) throws IOException{
        if (treeMap.isEmpty()) {
            treeMap.put(key, value);
            TreeInventario.writeInt(key);
            TreeInventario.writeInt(value);
        }else{
            long Tamano=TreeInventario.length();
            TreeInventario.seek(Tamano);
            TreeInventario.writeInt(key);
            TreeInventario.writeInt(value);
            treeMap.put(key, value);
        }
        return true;
    }
    public void inicializar() throws FileNotFoundException, IOException{
        this.TreeInventario = new RandomAccessFile("TreeInventario.txt", "rw");
        //this.TreeInventario = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\TreeInventario.txt", "rw");
        if (TreeInventario.length()!=0) {
            //System.out.println(TreeInventario.length());
            for (int i = 0; i < TreeInventario.length(); i=i+8) {
                int Key=TreeInventario.readInt();
                int Value=TreeInventario.readInt();
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
            TreeInventario.setLength(0);
            for (Map.Entry<Integer, Integer> entry:treeMap.entrySet()) {
                if (entry.getKey()!=key) {
                    TreeInventario.writeInt(entry.getKey());
                    TreeInventario.writeInt(entry.getValue());
                }
            }
            System.out.println(TreeInventario.length());
            treeMap.clear();
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public TreeMap<Integer, Integer> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(TreeMap<Integer, Integer> treeMap) {
        this.treeMap = treeMap;
    }
}
