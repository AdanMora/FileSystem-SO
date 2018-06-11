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
        
        file_system.CRT("holi", 20, 5);
        file_system.FLE("aaaa", ".txt", "One Ring to rule them all, One ring to find them; One ring to bring them all and in the darkness bind them.");
        
    }
    
}
