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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File_System file_system = new File_System();
        
        String contenido = "One Ring to rule them all, One ring to find them; One ring to bring them all and in the darkness bind them.";
        
        file_system.CRT("root", 20, 20);
        file_system.FLE("lotr", ".txt", contenido);
        
        file_system.MKDIR("Tareas");
        
        file_system.MKDIR("Proyectos");
        
        file_system.LDIR().forEach((s) -> {
            System.out.println(s);
        });
        
        file_system.MFLE("lotr", contenido + " In the Land of Mordor where the Shadows lie.");
        
        //file_system.CHDIR("Proyectos");
        
        //file_system.MKDIR("Proyecto 1");
        
        //System.out.println(file_system.get_PathActual());
        
        //file_system.FLE("lotr", ".txt", contenido);
        
        file_system.PPT("lotr").forEach((s) -> {
            System.out.println(s);
        });
        
        
    }
    
}
