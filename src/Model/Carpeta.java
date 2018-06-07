/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

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
    
}
