/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package remixedintegerarrayjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class RemixedIntegerArrayJW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instantiate the scanner
        Scanner keyedInput = new Scanner (System.in);
        
        // Variables
        int [ ] numbers = new int [20];
        int total = 0;
        
        // Get integers to be added from user
        System.out.println("Enter twenty integers and they will be added together:");
        for (int i = 0; i < 20; i ++) {
           numbers[i] = keyedInput.nextInt();
        }
        
        // Find the sum of the integers
        for (int i = 0; i < 20; i ++) {
             total = total + numbers[i];
        }
        
        // Output the sum
        System.out.println("The sum of those numbers is:");
        System.out.println(total);
    }
    
}
