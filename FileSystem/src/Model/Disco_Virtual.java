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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public boolean hayEspacio(String contenido) throws IOException {
        ArrayList<String> disco = get_Contenido_Disco();
        float x = (float)contenido.length() / (float)tam_Sector;
        if (x > cant_Sectores){
            System.out.println("Do not fit...");
            return false;
        }
        for (String s : disco) {
            if (s.charAt(0) == '0'){
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> get_Contenido_Disco(){
        ArrayList<String> sb = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombre_Disco));
            
            
            String line = br.readLine();

            while (line != null) {
                sb.add(line);
                line = br.readLine();
            }
            
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return sb;
    }
    
    private boolean init_Archivo(){
        try {
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
    
    private boolean escribir_Archivo(ArrayList<String> contenido){
        Path path = Paths.get(nombre_Disco);
        try {
            Files.write(path, contenido, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(Disco_Virtual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList insertarArchivo(String nombre, String extension, String contenido) {
        ArrayList<Integer> sectores = new ArrayList();
        try {
            if (hayEspacio(contenido)){
                String buffer;
                ArrayList<String> lineas = get_Contenido_Disco();
                for (int i = 0; i < cant_Sectores; i++) {
                    buffer = "";
                    if (lineas.get(i).charAt(0) == '0' && !contenido.isEmpty()){
                        if(contenido.length() >= tam_Sector){
                            buffer = contenido.substring(0, tam_Sector);
                            contenido = contenido.substring(tam_Sector);
                            lineas.set(i, buffer);
                            sectores.add(i);
                        } else {
                            buffer = contenido + lineas.get(i);
                            lineas.set(i, buffer.substring(0, tam_Sector));
                            contenido = "";
                            sectores.add(i);
                        }
                    } 
                }
                
                escribir_Archivo(lineas);
                
                return sectores;
            } else{
                return null;
            }
        } catch (IOException ex) {
            Logger.getLogger(Disco_Virtual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private void printArray(ArrayList<String> lista){
        lista.forEach((x) -> {
            System.out.println(x);
        });
    }

    public ArrayList sobre_escribir(ArrayList<Integer> sectores, String contenido) {
        try {
            String buffer;
            ArrayList<String> lineas = get_Contenido_Disco();
            
            float x = (float)contenido.length() / (float)tam_Sector;
            while (x > sectores.size()){
                for (int i = 0; i < cant_Sectores; i++) {
                    if (lineas.get(i).charAt(0) == '0' && !sectores.contains(i)){
                        sectores.add(i);
                    }
                }
            }
            
            for (Integer i : sectores) {
                buffer = "";
                if (contenido.length() >= tam_Sector){
                    buffer = contenido.substring(0, tam_Sector);
                    contenido = contenido.substring(tam_Sector);
                    lineas.set(i, buffer);
                } else {
                    buffer = contenido + lineas.get(i);
                    lineas.set(i, buffer.substring(0, tam_Sector));
                    contenido = "";
                }
            }
            
            escribir_Archivo(lineas);

            return sectores;
        } catch (Exception ex) {
            Logger.getLogger(Disco_Virtual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
