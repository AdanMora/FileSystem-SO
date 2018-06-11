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
    String nombre;
    ArrayList<Carpeta> carpetas;
    ArrayList<Archivo> archivos;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.carpetas = new ArrayList();
        this.archivos = new ArrayList();
    }

    void insertar_Archivo(String nombre, String extension, int tamanio, ArrayList sectores) {
        Date date = new Date();
        archivos.add(new Archivo(nombre, extension, date, date, tamanio, sectores));
    }
    
    void insertar_Carpeta(String nombre) {
        Date date = new Date();
        carpetas.add(new Carpeta(nombre));
    }
    
}
