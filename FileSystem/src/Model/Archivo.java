/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy hh:mm:ss");

    public Archivo(String nombre, String extension, Date fch_Creacion, Date fch_Modificacion, int tamanio, ArrayList sectores) {
        this.nombre = nombre;
        this.extension = extension;
        this.fch_Creacion = fch_Creacion;
        this.fch_Modificacion = fch_Modificacion;
        this.tamanio = tamanio;
        this.sectores = sectores;
    }

    void set_Sectores(ArrayList<Integer> sectores) {
        this.sectores = sectores;
    }

    public ArrayList<String> get_Propiedades() {
           return new ArrayList<>(Arrays.asList(nombre, extension, format.format(fch_Creacion), format.format(fch_Modificacion), String.valueOf(tamanio)));
    }

    void setFecha_Modificacion(Date date) {
        this.fch_Modificacion = date;
    }

    void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
}
