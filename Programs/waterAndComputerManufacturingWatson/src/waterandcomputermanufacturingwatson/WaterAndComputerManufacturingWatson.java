/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package waterandcomputermanufacturingwatson;
    import java.util.Scanner;
/**
 *
 * @author jijwa
 */
public class WaterAndComputerManufacturingWatson {
    // Methods
    static double round(double unRounded) {
        return (double)((int)(unRounded * 100 + 0.5)) / 100; // Multiplies by 100, roudns to 0 decimal places, divides by 100. 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        // TODO code application logic here
        Scanner keyedInput = new Scanner(System.in);
        
        double waterUsed;
        double numberOfComputers;

        final double WATER_PER_COMBO = 1.5;
        
        System.out.println("How many computer and monitor combos do you own?: ");
        numberOfComputers = keyedInput.nextDouble();
        
        waterUsed = round(numberOfComputers * WATER_PER_COMBO);
        
        System.out.println(waterUsed + " tons of water were used to make those computers and monitors!");
        
        
        
    }
    
}
