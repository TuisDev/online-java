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
    static double round(double unRounded) {
        return (double)((int)(unRounded * 100 + 0.5)) / 100; // Multiplies by 100, roudns to 0 decimal places, divides by 100. 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyedInput = new Scanner(System.in);
        
        int numberOfUSBs;
        int numberOfKeyboards;
        int numberOfMice;
        
        final double USB_PRICE = 19.99;
        final double KEYBOARD_PRICE = 49.99;
        final double MOUSE_PRICE = 25.99;
        
        final double TAX_RATE = 0.13;
        
        double subTotal;
        double amountTax;
        double grandTotal;
        
        System.out.println("How many USB storage devices would you like to buy?: ");
        numberOfUSBs= keyedInput.nextInt();
        System.out.println("How many keyboards would you like to buy?: ");
        numberOfKeyboards = keyedInput.nextInt();
        System.out.println("How many computer mice would you like to buy?: ");
        numberOfMice = keyedInput.nextInt();
        
        subTotal = round(numberOfUSBs * USB_PRICE + numberOfKeyboards * KEYBOARD_PRICE + numberOfMice * MOUSE_PRICE);
        amountTax = round(subTotal * TAX_RATE);
        grandTotal = round(subTotal + amountTax);
        
        System.out.println("The subtotal is $" + subTotal + ".");
        System.out.println("There is $" + amountTax + " of tax.");
        System.out.println("The grand total is $" + grandTotal + ".");
    }
    
}
