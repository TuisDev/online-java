/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exponentialcalculatorjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class ExponentialCalculatorJW {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int selection;
        int base;
        int result;
        int exponent;
        
        // Header
        System.out.println("--------Exponential Calculator--------");
        System.out.println("");
        
        // Main loop
        do {
            // Explain choices to user
            System.out.println("Enter 1 to square a number");
            System.out.println("Enter 2 to cube a number");
            System.out.println("Enter 3 to put a number to any whole power");
            System.out.println("Enter 4 to exit the program");

            // Get valid user input
            do {
                System.out.print(": ");
                selection = keyedInput.nextInt();
            } while ((selection < 1) || (selection > 4));
        
            //
            switch (selection) {
                case 1:
                    // Ask user for number to be squared
                    System.out.println("What number do you want to square?");
                    
                    // Get input from user
                    System.out.print(": ");
                    base = keyedInput.nextInt();
                    
                    // Square the number
                    result = 1;
                    for(int i = 0; i < 2; i ++) {
                        result = result * base;
                    }
                    
                    // Output the results
                    System.out.println("The result of " + base + "^2 = " + result + ".");
                    break;
                case 2:
                    // Ask user for number to be cubed
                    System.out.println("What number do you want to cube?");
                    
                    // Get input from user
                    System.out.print(": ");
                    base = keyedInput.nextInt();
                    
                    // Cube the number
                    result = 1;
                    for(int i = 0; i < 3; i ++) {
                        result = result * base;
                    }
                    
                    // Output the results
                    System.out.println("The result of " + base + "^3 = " + result + ".");
                    break;
                case 3:
                    // Ask user for base
                    System.out.println("What is the base?");
                    
                    // Get base from user
                    System.out.print(": ");
                    base = keyedInput.nextInt();
                    
                    // Ask user for exponent
                    System.out.println("What is the exponent?");
                    
                    // Get valid exponent from user
                    do {
                        System.out.print(": ");
                        exponent = keyedInput.nextInt();
                    } while (exponent < 0);
                    
                    // Calculate results
                    result = 1;
                    for(int i = 0; i < exponent; i ++) {
                        result = result * base;
                    }
                    
                    // Output the results
                    System.out.println("The result of " + base + "^" + exponent + " = " + result + ".");
                    break;
                case 4:
                    System.out.println("Farewell, thanks for using the Exponential Calculator.");
                default:
                    break;
                                
            }
            
            // Dividing line
            System.out.println("");
            System.out.println("---------------------------------------");
            System.out.println("");
                
        // Repeat until the user enters 4 (exit)
        } while (selection != 4);
    }
    
}
