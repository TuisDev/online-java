/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package returningdatajw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class ReturningDataJW {

    // Methods
    
    /* round
        
    This method receives a double and rounds it to two decimal places
    
    Parameters: double
    
    Returns: double
    
    */
    public static double round(double unRounded) {
        // Round and return the rounded number
        return (double)Math.round(unRounded * 100) / 100;
    }
    
    /* ouputMenu
        
    This method outputs a menu
    
    Parameters: none
    
    Returns: none
    
    */
    public static void outputMenu() {
        // Output header
        System.out.println("----- Super Subroutine Software -----");
        
        // Output the menu
        System.out.println("Please enter the corresponding number for your choice: ");
        System.out.println("1: Determine the Area of a Triangle");
        System.out.println("2: Determine the Area of a Circle");
        System.out.println("3: Determine the Average of Three Numbers");
        System.out.println("4: Determine the Hypotenuse of a Triangle");
        System.out.println("5: Determine the Volume of a Sphere");
        System.out.println("6: Determine the Factorial of a number");
        System.out.println("7: Determine if a Number is Prime");
        System.out.println("8: Determine the Slope with Two Points");
        System.out.println("9: Determine the Time Until an Object Hits the Ground");
        System.out.println("10: Determine the Cost of Fuel for a Distance");
        System.out.println("11: Exit");
    }
    
    /* getUserChoice
        
    This method gets the user's selection from a menu
    
    Parameters: Scanner
    
    Returns: int
    
    */
    public static int getUserChoice (Scanner keyedInput) {
        // Variables
        int choice;
        
        // Get valid user input
        do {
            System.out.print(": ");
            choice = keyedInput.nextInt();
            
        } while ((choice < 1) || (choice > 11));
        
        // Output input
        return choice;
    }
  
    /* getArguments
        
    This method gets the arguments from the user
    
    Parameters: int, Scanner
    
    Returns: int []
    
    */
    public static int [] getArguments (int choice, Scanner keyedInput) {
        // Variables
        
        switch (choice) {
            case 1:
                // Get base from user
                System.out.println("What is the base of the triangle?: ");
                System.out.print(": ");
                int base = keyedInput.nextInt();
                
                // Get height from user
                System.out.println("What is the height of the triangle?: ");
                System.out.print(": ");
                int height = keyedInput.nextInt();
                
                // Return base and height
                int [] triangleArgs = {base, height};
                return triangleArgs;
                
            case 2:     
                // Get radius from user
                System.out.println("What is the radius of the circle?: ");
                System.out.print(": ");
                int radius = keyedInput.nextInt();
                
                // Return radius
                int [] circleArgs = {radius};
                return circleArgs;
                
            case 3:
                // Get first number from user
                System.out.println("What is the first number?: ");
                System.out.print(": ");
                int num1 = keyedInput.nextInt();
                
                // Get second number from user
                System.out.println("What is the second number?: ");
                System.out.print(": ");
                int num2 = keyedInput.nextInt();
                
                // Get third number from user
                System.out.println("What is the third number?: ");
                System.out.print(": ");
                int num3 = keyedInput.nextInt();
                
                // Return num1, num2 and num3;
                int [] averageArgs = {num1, num2, num3};
                return averageArgs;
            
            case 4:
                // Get side a from user
                System.out.println("What is the first side of the triangle?: ");
                System.out.print(": ");
                int sideA = keyedInput.nextInt();
                
                // Get side b from user
                System.out.println("What is the second side of the triangle?: ");
                System.out.print(": ");
                int sideB = keyedInput.nextInt();
                
                // Return side a and side b
                int [] HypotArgs = {sideA, sideB};
                return HypotArgs;

            case 5:
                // Get radius from user
                System.out.println("What is the radius of the sphere?: ");
                System.out.print(": ");
                int sphereRad = keyedInput.nextInt();
                
                // Return radius
                int [] sphereArgs = {sphereRad};
                return sphereArgs;                
                
            case 6:
                // Get number from user
                System.out.println("Enter a number: ");
                System.out.print(": ");
                int n = keyedInput.nextInt();
                
                // Return number
                int [] factorialArgs = {n};
                return factorialArgs;     
            
            case 7:
                // Get number from user
                System.out.println("Enter a number greater than 0: ");
                System.out.print(": ");
                int num = keyedInput.nextInt();
                
                // Return number
                int [] primeArgs = {num};
                return primeArgs;   
                
            case 8:
                // Get first point from user
                System.out.println("Please enter the first point (x, y): ");
                System.out.print(": ");
                
                keyedInput.nextLine(); // Clears input stream
                String point = keyedInput.nextLine();
                
                // Parse first point
                int x1 = Integer.parseInt(point.split(",")[0].replace("(", ""));
                int y1 = Integer.parseInt(point.split(",")[1].replace(")", "").replace(" ", ""));
                    
                // Get second point from user
                System.out.println("Please enter the second point (x, y): ");
                System.out.print(": ");
                
                point = keyedInput.nextLine();
                    
                // Parse second point
                int x2 = Integer.parseInt(point.split(",")[0].replace("(", ""));
                int y2 = Integer.parseInt(point.split(",")[1].replace(")", "").replace(" ", ""));
                    
                // Return points
                int [] slopeArgs = {x1, y1, x2, y2};
                return slopeArgs; 

            case 9:
                // Get height from user
                System.out.println("What is the height? (m): ");
                System.out.print(": ");
                int displacement = keyedInput.nextInt();
                
                // Return height
                int [] freefallArgs = {displacement};
                return freefallArgs;  
                
            case 10:
                // Get distance from user
                System.out.println("How far are you going (km) ?: ");
                System.out.print(": ");
                int distance = keyedInput.nextInt();
                
                // Get efficiency from user
                System.out.println("How much fuel does your vehicle use (L/100km)?: ");
                System.out.print(": ");
                int fuelEfficiency = keyedInput.nextInt();
                
                // Return distance and fuel efficiency
                int [] fuelCostArgs = {distance, fuelEfficiency};
                return fuelCostArgs; 
            default:
                return new int[0];
        }
    }
    
    /* areaOfTriangle
        
    This method gets the area of a triangle
    
    Parameters: int, int
    
    Returns: double
    
    */
    public static double areaOfTriangle (int base, int height) {
        // Calculate the area
        double area = base * height / 2;
        
        // Return the area
        return round(area);
    }
    
    /* areaOfCirlce
        
    This method gets the area of a circle
    
    Parameters: int
    
    Returns: double
    
    */
    public static double areaOfCircle (int radius) {
        // Calculate area
        double area = Math.PI * Math.pow(radius, 2);
        
        // Return area
        return round(area);
    }
    
    /* average
        
    This method gets the average of three integers
    
    Parameters: int. int, int
    
    Returns: double
    
    */
    public static double average (int num1, int num2, int num3) {
        // Calculate the average
        double average = (double)(num1 + num2 + num3) / 3.0;
        
        // Return the average
        return round(average);
    }
    
    /* hypot
        
    This method gets the hypotenuse of a triangle
    
    Parameters: int, int
    
    Returns: double
    
    */
    public static double hypot (int sideA, int sideB) {
        // Calculate the hypotenuse
        double Hypot = Math.hypot(sideA, sideB);
        
        // Return the hypotenuse
        return round(Hypot);
    }
    
    /* volumeOfSphere
        
    This method gets the volume of a sphere
    
    Parameters: int
    
    Returns: double
    
    */
    public static double volumeOfSphere (int radius) {
        // Calculate the volume
        double volume = 4 * Math.PI * Math.pow(radius, 3) / 3;
        
        // Return the volume
        return round(volume);
    }
    
    /* factorial
        
    This method gets the factorial of a number
    
    Parameters: int
    
    Returns: int
    
    */
    public static int factorial (int n){
        // Variables
        int result = 1;
        
        // Calculate the factorial
        for (int i = 0; i < n; i ++) {
            result = result * (n - i);
        }
        
        // Return the results
        return result;
    }
    
    /* isPrime
        
    This method determines if a number is prime
    
    Parameters: int
    
    Returns: boolean
    
    */
    public static boolean isPrime (int n) {
        // Calculate square root of the number
        int sqrtN = (int)Math.round(Math.sqrt(n));
       
        // Calculate if the number is prime
        for (int i = 2; i <= sqrtN; i ++) {
            if (n % i == 0) {
                // Return that the number isn't prime
                return false;
            }
        }
        
        // Return that the number is prime, if it isn't 1
        return n != 1;
    }
    
    /* slope
        
    This method gets the slope from two points
    
    Parameters: int, int, int, int
    
    Returns: double
    
    */
    public static double slope (int x1, int y1, int x2, int y2) {
        // Calculate the slope
        double slope = (double)(y2 - y1)/(double)(x2 - x1);
        
        // Return the slope
        return round(slope);
    }
    
    /* freefall
        
    This method gets the time it would take an object to fall a certain height
    
    Parameters: int
    
    Returns: double
    
    */
    public static double freefall (int height) {
        // Constants
        final double ACCLERERATION = -9.8;
        
        // Calculate the time
        double time = (- Math.sqrt(-2 * ACCLERERATION * height)) / ACCLERERATION;
        
        // Return the time
        return round(time);
    }
    
    /* fuelCost
        
    This method gets the cost of fuel from a distance and a cars efficiency
    
    Parameters: int, int
    
    Returns: double
    
    */
    public static double fuelCost (int distance, int fuelEfficiency) {
        // Constants
        final double FUEL_PRICE = 1.40;

        // Calculate fuel use
        double litres = ((double)distance / 100.0) * fuelEfficiency;
        
        // Calculate fuel cost
        double fuelCost = litres * FUEL_PRICE;
        
        // Return fuel cost
        return round(fuelCost);
    }
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int choice;
        int input [];
        double result;
        
        // Main loop
        do {
            
            // Output the menu
            outputMenu();
            
            // Get user input
            choice = getUserChoice(keyedInput);

            // Output a dividing line
            System.out.println("-------------------------------------");

            // Get the arguments to be passed to the functions
            input = getArguments(choice, keyedInput);
            
            // Pass the arguments to the function depending on user choice
            switch (choice) {
                case 1:
                    // Output area of triangle
                    result = areaOfTriangle(input[0], input[1]);
                    System.out.println("The area of the triangle is " + result + ".");
                    break;
                case 2:
                    // Output area of the circle
                    result = areaOfCircle(input[0]);
                    System.out.println("The area of the circle is " + result + ".");
                    break;
                case 3:
                    // Output average
                    result = average(input[0], input[1], input[2]);
                    System.out.println("The average is " + result + ".");
                    break;
                case 4:
                    // Output hypotenuse of the triangle
                    result = hypot(input[0], input[1]);
                    System.out.println("The hypotenuse of the triangle is " + result + ".");
                    break;
                case 5:
                    // Output volume of the sphere
                    result = volumeOfSphere(input[0]);
                    System.out.println("The volume of the sphere is " + result + ".");
                    break;
                case 6:
                    // Output factorial
                    result = factorial(input[0]);
                    System.out.println("" + input[0] + "! = " + result + ".");
                    break;
                case 7:
                    // Output if the number is prime or not
                    if (isPrime(input[0])) {
                        System.out.println("The number " + input[0] + " is prime");
                    } else {
                        System.out.println("The number " + input[0] + " isn't prime");
                    }
                    break;
                case 8:
                    // Output slope
                    result = slope(input[0], input[1], input[2], input[3]);
                    System.out.println("The slope is " + result + ".");
                    break;
                case 9:
                    // Output time until the object hits the ground
                    result = freefall(input[0]);
                    System.out.println("The time until the object hits the ground is " + result + " seconds .");
                    break;
                case 10:
                    // Output cost of fuel
                    result = fuelCost(input[0], input[1]);
                    System.out.println("The cost of fuel is $" + result + ".");
                    break;
                case 11:
                    // Output a farewell message
                    System.out.println("Goodbye, have a nice day!");
                    break;
                default:
                    System.out.println("Invalid Input!");
             }
            
        // Repeat until the user chooses to exit
        } while (choice != 11);
        
        
    }
    
}
