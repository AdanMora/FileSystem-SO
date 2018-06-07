/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
        this.root = new Carpeta(root);
        this.disco = new Disco_Virtual(root, tam_Sector, cant_Sector);
        this.path_Actual = this.root;
        return true;
    }
    
    public boolean FLE(String nombre, String extension, String contenido){
        if (true){
            
            return true;
        } else {
            return false;
        }
    }
    
    
    
}
