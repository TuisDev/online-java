/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoppingwatson;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class ShoppingWatson {
    // Methods
    static double round(double unRoundedNumber) {
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
        
        // Variables
        int numberOfUSBs;
        int numberOfKeyboards;
        int numberOfMice;
        
        double subTotal;
        double amountTax;
        double grandTotal;        
        
        // Constants
        final double USB_PRICE = 19.99;
        final double KEYBOARD_PRICE = 49.99;
        final double MOUSE_PRICE = 25.99;
        
        final double TAX_RATE = 0.13;
        
        // Welcome the user
        System.out.println("Welcome to the electronics store!");
        
        // Ask for Input
        System.out.println("How many USB storage devices would you like to buy?: ");
        numberOfUSBs= keyedInput.nextInt();
        System.out.println("How many keyboards would you like to buy?: ");
        numberOfKeyboards = keyedInput.nextInt();
        System.out.println("How many computer mice would you like to buy?: ");
        numberOfMice = keyedInput.nextInt();
        
        // Calculations
        subTotal = round(numberOfUSBs * USB_PRICE + numberOfKeyboards * KEYBOARD_PRICE + numberOfMice * MOUSE_PRICE);
        amountTax = round(subTotal * TAX_RATE);
        grandTotal = round(subTotal + amountTax);
        
        // Output
        System.out.println("The subtotal is $" + subTotal + ".");
        System.out.println("There is $" + amountTax + " of tax.");
        System.out.println("The grand total is $" + grandTotal + ".");
    }
    
}
