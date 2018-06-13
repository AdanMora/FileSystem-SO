/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Adán
 */
public class Carpeta {
    private String nombre;
    private ArrayList<Carpeta> carpetas;
    private ArrayList<Archivo> archivos;
    private Carpeta padre;

    public Carpeta(String nombre, Carpeta padre) {
        this.nombre = nombre;
        this.carpetas = new ArrayList();
        this.archivos = new ArrayList();
        this.padre = padre;
    }

    public void setPadre(Carpeta padre) {
        this.padre = padre;
    }

    public void insertar_Archivo(String nombre, String extension, int tamanio, ArrayList sectores) {
        Date date = new Date();
        archivos.add(new Archivo(nombre, extension, date, date, tamanio, sectores));
    }
    
    public void insertar_Carpeta(String nombre) {
        carpetas.add(new Carpeta(nombre, this));
    }

    public Carpeta getCarpeta(String carpeta) {
        for (Carpeta c : carpetas) {
            if (c.nombre.equals(carpeta)){
                return c;
            }
        }
        return null;
    }
    
    public Archivo getArchivo(String archivo) {
        for (Archivo a : archivos) {
            if (a.nombre.equals(archivo)){
                return a;
            }
        }
        return null;
    }

    public ArrayList<String> getLista() {
        ArrayList<String> lista = new ArrayList();
        carpetas.forEach((c) -> {
            lista.add(c.nombre);
        });
        
        archivos.forEach((a) -> {
            lista.add(a.nombre + a.extension);
        });
        
        return lista;
    }

    public String getNombre() {
        return this.nombre;
    }
    
}
