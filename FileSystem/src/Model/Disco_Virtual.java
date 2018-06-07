/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Adán
 */
public class Disco_Virtual {
    String nombre_Disco;
    int tam_Sector;
    int cant_Sectores;

    public Disco_Virtual(String nombre_Disco, int tamanio_Sector, int cant_Sectores) {
        this.nombre_Disco = System.getProperty("user.home") + "/Desktop/" + nombre_Disco + ".txt";
        this.tam_Sector = tamanio_Sector;
        this.cant_Sectores = cant_Sectores;
        init_Archivo();
    }
    
    private boolean init_Archivo(){
        try {
            FileReader fileR = new FileReader(nombre_Disco);
            FileWriter fileW = new FileWriter(nombre_Disco);
            ArrayList<String> buffer = new ArrayList();
            String b;
            for (int i = 0; i < cant_Sectores; i++) {
                b = "";
                for (int j = 0; j < tam_Sector; j++) {
                    b += '0';
                }
                buffer.add(b);
            }
            
            Path path = Paths.get(nombre_Disco);
            
            Files.write(path, buffer, Charset.forName("UTF-8"));

            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    
    
}