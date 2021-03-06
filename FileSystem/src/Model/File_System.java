/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adán
 */
public class File_System {
    private static Carpeta root;
    private static Disco_Virtual disco;
    private static Carpeta path_Actual;

    public File_System() {}
    
    public boolean CRT(String root, int tam_Sector, int cant_Sector){
        this.root = new Carpeta(root, null);
        this.root.setPadre(this.root);
        this.disco = new Disco_Virtual(root, tam_Sector, cant_Sector);
        this.path_Actual = this.root;
        return true;
    }
    
    public boolean FLE(String nombre, String extension, String contenido) {
        try {
            if (disco.hayEspacio(contenido)){
                ArrayList<Integer> sectores = disco.insertarArchivo(nombre, extension, contenido);
                path_Actual.insertar_Archivo(nombre, extension, contenido.length(), sectores);
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(File_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean MKDIR(String nombre){
        try {
            path_Actual.insertar_Carpeta(nombre);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(File_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean CHDIR(String carpeta){
        try {
            path_Actual = path_Actual.getCarpeta(carpeta);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(File_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean MFLE(String archivo, String contenido){
        try {
            Archivo temp = path_Actual.getArchivo(archivo);
            ArrayList<Integer> sectores = temp.sectores;
            sectores = disco.sobre_escribir(sectores, contenido);
            temp.set_Sectores(sectores);
            
            temp.setFecha_Modificacion(new Date());
            temp.setTamanio(contenido.length());
            
            return true;
        } catch (Exception ex) {
            Logger.getLogger(File_System.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public ArrayList<String> LDIR(){
        return path_Actual.getLista();
    }
    
    public ArrayList<String> PPT(String archivo){
        return path_Actual.getArchivo(archivo).get_Propiedades();
    }
    

    public String get_PathActual() {
        return path_Actual.getNombre();
    }
    
}
