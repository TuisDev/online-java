/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package variableswatson;

/**
 *
 * @author jijwa
 */
public class VariablesWatson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int heightASL = 5000; //(ft)
        String location = "Whistler Mountain";
        boolean coldOut = true;
        
        double temperature; //(degrees C)
        temperature = 15 + 5000 / 1000 * -1.98; //Standard temperature deviation with altitude
        
        System.out.println("The temperature is approixmately " + temperature + " degrees Celsuis at " + location + ".");
        System.out.println("Is it cold out?: " + coldOut + ".");
    }
    
}
