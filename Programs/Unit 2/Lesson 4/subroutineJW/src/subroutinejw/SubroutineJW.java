/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package subroutinejw;

/**
 *
 * @author jijwa
 */
public class SubroutineJW {

    /**
     * @param args the command line arguments
     */
    public static void factorialAndOut (int n){
        int result = 1;
        for (int i = 0; i < n; i ++) {
            result = result * (n - i);
        }
        
        System.out.println("The result of " + n + "! = " + result + ".");
    }
    
    public static void isPrimeAndOut (int n) {
        int sqrtN = (int)Math.ceil(Math.sqrt(n));
       
        for (int i = 2; i <= sqrtN; i ++) {
            if (n % i == 0) {
                System.out.println("The number " + n + " is not prime.");
                return;
            }
        }
        System.out.println("The number " + n + " is prime.");
    }
    
    public static void slopeAndOut (int x1, int y1, int x2, int y2) {
        double slope = (double)(y2 - y1)/(double)(x2 - x1);
        System.out.println("The slope of the line is " + slope + ".");
    }
    
    public static void freefallAndOut (int height) {
        final double acceleration = -9.8;
        double time = (- Math.sqrt(-2 * acceleration * height)) / acceleration;
        
        System.out.println("It takes " + time + " seconds to fall from " + h + "m.");
    }
    
    public static void fuelCostAndOut (int distance, int fuelEfficiency, int fuelPrice) {
        double litres = (distance / 100) * fuelEfficiency;
        double fuelCost = litres * fuelPrice;
        
        System.out.println("It will cost $" + fuelCost + " to go " + distance + "km.");
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        freefallAndOut(10);
    }
    
}
