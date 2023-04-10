/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package subroutinejw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class SubroutineJW {
    
    // Methods
    public static double round(double unRounded) {
        return (double)Math.round(unRounded * 100) / 100;
    }
    
    public static void factorialAndOut (int n){
        // Variables
        int result = 1;
        
        // Calculate the factorial
        for (int i = 0; i < n; i ++) {
            result = result * (n - i);
        }
        
        // Output the results
        System.out.println("The result of " + n + "! = " + result + ".");
    }
    
    public static void isPrimeAndOut (int n) {
        // Get the square root of n
        int sqrtN = (int)Math.round(Math.sqrt(n));
       
        // Calculate if the number is prime
        for (int i = 2; i <= sqrtN; i ++) {
            if (n % i == 0) {
                // Output that the number isn't prime
                System.out.println("The number " + n + " is not prime.");
                return;
            }
        }
        
        if (n == 1) {
            // Output that the number isn't prime
            System.out.println("The number " + n + " is not prime.");
            return;
        }
        
        // Output that the number is prime
        System.out.println("The number " + n + " is prime.");
    }
    
    public static void slopeAndOut (int x1, int y1, int x2, int y2) {
        // Calculate the slope
        double slope = (double)(y2 - y1)/(double)(x2 - x1);
        
        // Ouput the slope
        System.out.println("The slope of the line is " + round(slope) + ".");
    }
    
    public static void freefallAndOut (int height) {
        // Constants
        final double ACCELERATION = -9.8;
        
        // Calculate the time
        double time = (- Math.sqrt(-2 * ACCELERATION * height)) / ACCELERATION;
        
        // Output the time
        System.out.println("It takes " + round(time) + " seconds to fall from " + height + "m.");
    }
    
    public static void fuelCostAndOut (double distance, double fuelEfficiency) {
        // Constants
        final double FUEL_PRICE = 1.40;

        // Calculate fuel use
        double litres = (distance / 100) * fuelEfficiency;
        
        // Calculate fuel cost
        double fuelCost = litres * FUEL_PRICE;
        
        // Output fuel cost
        System.out.println("It will cost $" + round(fuelCost) + " to go " + distance + "km.");
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int choice;
        int num;
        
        
        // Main loop
        do {
            
            // Header
            System.out.println("----- Subroutine Software -----");
            
            // Menu
            System.out.println("Please enter the corresponding number for your choice: ");
            System.out.println("1: Determine the Factorial of a number");
            System.out.println("2: Determine if a Number is Prime");
            System.out.println("3: Determine the Slope with Two Points");
            System.out.println("4: Determine the Time Until an Object Hits the Ground");
            System.out.println("5: Determine the Cost of Fuel for a Distance");
            System.out.println("6: Exit");
            
            // Get valid input from the user
            do {
                System.out.print(": ");
                choice = keyedInput.nextInt();
            } while ((choice < 1) || (choice > 6));
            
            // Dividing line
            System.out.println("-------------------------------");
            
            switch (choice) {
                case 1:
                    // Ask user for input
                    System.out.println("Please enter a number: ");
                    System.out.print(": ");
                    
                    // Get input from user
                    num = keyedInput.nextInt();
                    
                    // Get results
                    factorialAndOut(num);
                    
                    break;
                case 2:
                    // Ask user for input
                    System.out.println("Please enter a number greater than 0: ");
                    System.out.print(": ");
                    
                    // Get input from user
                    num = keyedInput.nextInt();
                    
                    // Get results
                    isPrimeAndOut(num);
                    
                    break;
                case 3:
                    // Variables
                    int x1;
                    int y1;
                    int x2;
                    int y2;
                    
                    String point;
                    
                    // Ask user for first point
                    System.out.println("Please enter the first point (x, y): ");
                    System.out.print(": ");
                    
                    // Get first point from user
                    keyedInput.nextLine(); // Clears input stream
                    point = keyedInput.nextLine();
                    
                    // Parse first point
                    x1 = Integer.parseInt(point.split(",")[0].replace("(", ""));
                    y1 = Integer.parseInt(point.split(",")[1].replace(")", "").replace(" ", "")); 
                    
                    // Ask user for second point
                    System.out.println("Please enter the second point (x, y): ");
                    System.out.print(": ");
                    
                    // Get second point from user
                    point = keyedInput.nextLine();
                    
                    // Parse second point
                    x2 = Integer.parseInt(point.split(",")[0].replace("(", ""));
                    y2 = Integer.parseInt(point.split(",")[1].replace(")", "").replace(" ", ""));
                    
                    // Get results
                    slopeAndOut(x1, y1, x2, y2);

                    break;
                case 4:
                    // Variables
                    int height;
                    
                    // Ask user for input
                    System.out.println("Please enter the height: ");
                    System.out.print(": ");
                    
                    // Get input from user
                    height = keyedInput.nextInt();
                    
                    // Get results
                    freefallAndOut(height);

                    break;
                case 5:
                    // Variables
                    double fuelEfficiency;
                    double distance;
                    
                    
                    // Ask user for distance
                    System.out.println("How far are you going? (km): ");
                    System.out.print(": ");
                    
                    // Get distance from user
                    distance = keyedInput.nextDouble();
                    
                    // Ask user for efficiency
                    System.out.println("How much fuel does you car use? (L/100km) : ");
                    System.out.print(": ");
                    
                    // Get efficiency from user
                    fuelEfficiency = keyedInput.nextDouble();
                    
                    // Get results
                    fuelCostAndOut(distance, fuelEfficiency);

                    break;
                case 6:
                    System.out.println("Goodbye, have a nice day!");
                    break;
                default:
                    System.out.println("Invalid response");
                   
            }
         
        // Keep going until the user exits
        } while (choice != 6);
        
    }
    
}
