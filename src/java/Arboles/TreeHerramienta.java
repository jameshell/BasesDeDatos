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
public class TreeHerramienta {
    private TreeMap<Integer, Integer> treeMap;
    private RandomAccessFile TreeHerramienta;
    public TreeHerramienta() {
        treeMap=new TreeMap<>();
        try {
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeHerramienta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // key=idestudiente value=bytes
    public boolean insertar(int key,int value) throws IOException{
        if (treeMap.isEmpty()) {
            treeMap.put(key, value);
            TreeHerramienta.writeInt(key);
            TreeHerramienta.writeInt(value);
        }else{
            long Tamano=TreeHerramienta.length();
            TreeHerramienta.seek(Tamano);
            TreeHerramienta.writeInt(key);
            TreeHerramienta.writeInt(value);
            treeMap.put(key, value);
        }
        return true;
    }
    public void inicializar() throws FileNotFoundException, IOException{
        this.TreeHerramienta = new RandomAccessFile("TreeHerramienta.txt", "rw");
        //this.TreeHerramienta = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\TreeHerramienta.txt", "rw");
        if (TreeHerramienta.length()!=0) {
            //System.out.println(TreeHerramienta.length());
            for (int i = 0; i < TreeHerramienta.length(); i=i+8) {
                int Key=TreeHerramienta.readInt();
                int Value=TreeHerramienta.readInt();
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
            TreeHerramienta.setLength(0);
            for (Map.Entry<Integer, Integer> entry:treeMap.entrySet()) {
                if (entry.getKey()!=key) {
                    TreeHerramienta.writeInt(entry.getKey());
                    TreeHerramienta.writeInt(entry.getValue());
                }
            }
            System.out.println(TreeHerramienta.length());
            treeMap.clear();
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeHerramienta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public TreeMap<Integer, Integer> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(TreeMap<Integer, Integer> treeMap) {
        this.treeMap = treeMap;
    }
}
