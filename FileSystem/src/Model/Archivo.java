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
public class Archivo {
    String nombre;
    String extension;
    Date fch_Creacion;
    Date fch_Modificacion;
    int tamanio;
    ArrayList<Integer> sectores;

    public Archivo(String nombre, String extension, Date fch_Creacion, Date fch_Modificacion, int tamanio, ArrayList sectores) {
        this.nombre = nombre;
        this.extension = extension;
        this.fch_Creacion = fch_Creacion;
        this.fch_Modificacion = fch_Modificacion;
        this.tamanio = tamanio;
        this.sectores = sectores;
    }
    
    
    
}
