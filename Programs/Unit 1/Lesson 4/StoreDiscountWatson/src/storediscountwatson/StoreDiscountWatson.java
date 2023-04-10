/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package storediscountwatson;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class StoreDiscountWatson {
    // Methods
    static double round(double unRoundedNumber)
    {
        double roundedNumber = (double)((int)(unRoundedNumber * 100 + 0.5)) / 100;
        return  roundedNumber;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        //Variables
        double amountSpent;
        double discount = 0;
        double amountSaved;
        double total;
        
        // Constants
        final double TEN_OFF = 0;
        final double TWENTY_OFF = 40;
        final double THRITY_OFF = 80;
        final double FORTY_OFF = 120;
        
        // Collect the amount spent from the user
        System.out.println("How much money did you spend at the store?: ");
        amountSpent = keyedInput.nextDouble();
        
        // Calculate the discount
        if (amountSpent > FORTY_OFF)
        {
            discount = 0.4;
        }
        else if (amountSpent > THRITY_OFF)
        {
            discount = 0.3;
        }
        else if (amountSpent > TWENTY_OFF)
        {
            discount = 0.2;
        }
        else if (amountSpent > TEN_OFF)
        {
            discount = 0.1;
        }
        
        // Calculate the amount saved
        amountSaved = round(amountSpent * discount);
        
        //Calculate the total
        total = round(amountSpent - amountSaved);
        
        //Output the results
        System.out.println("Congralutions! because you spent " + amountSpent + ", you got a " + discount * 100 + "% discount!");
        System.out.println("You saved " + amountSaved + "!");
        System.out.println("Your new total is " + total + "!");
    }
    
}
