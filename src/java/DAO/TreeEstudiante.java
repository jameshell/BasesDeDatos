/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class TreeEstudiante {
    private TreeMap<Integer, Integer> treeMap;
    private RandomAccessFile TreeEstudiante;
    public TreeEstudiante() {
        treeMap=new TreeMap<>();
        try {
            inicializar();
        } catch (IOException ex) {
            Logger.getLogger(TreeEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // key=idestudiente value=bytes
    public boolean insertar(int key,int value) throws IOException{
        if (treeMap.isEmpty()) {
            treeMap.put(key, value);
            TreeEstudiante.writeInt(key);
            TreeEstudiante.writeInt(value);
        }else{
            long Tamano=TreeEstudiante.length();
            TreeEstudiante.seek(Tamano);
            TreeEstudiante.writeInt(key);
            TreeEstudiante.writeInt(value);
            treeMap.put(key, value);
        }
        return true;
    }
    public void inicializar() throws FileNotFoundException, IOException{
        this.TreeEstudiante = new RandomAccessFile("TreeEstudiante.txt", "rw");
        //this.TreeEstudiante = new RandomAccessFile("C:\\Users\\Carlos\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\TreeEstudiante.txt", "rw");
        if (TreeEstudiante.length()!=0) {
            //System.out.println(TreeEstudiante.length());
            for (int i = 0; i < TreeEstudiante.length(); i=i+8) {
                int Key=TreeEstudiante.readInt();
                int Value=TreeEstudiante.readInt();
                treeMap.put(Key, Value);
            }
        }else{
            System.out.println("empty");
        }
    }
    public void Listar(){
        for (Map.Entry<Integer, Integer> entry:treeMap.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.print(entry.getValue());
            System.out.println("");
        }
    }
}
