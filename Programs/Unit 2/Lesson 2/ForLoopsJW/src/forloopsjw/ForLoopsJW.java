/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package forloopsjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class ForLoopsJW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int choice;
        
        // Header
        System.out.println("----Crazy Counting Contraption----");
        System.out.println("");
        
        // Ask the user for their choice
        System.out.println("Please enter your choice");
        System.out.println("Enter 1 to count from 0 to 10 by 1s");
        System.out.println("Enter 2 to count from 100 to 0 by 10s");
        System.out.println("Press 3 to count from 50 to 500 by 50s");
        System.out.println("Press 4 to count from 6000 to 1000 by 1000s");
        System.out.println("Please enter you choice: ");
        
        // Get valid user input
        do {
        choice = keyedInput.nextInt();
        } while ((choice < 1) || (choice > 4));
        
        // Dividing Line
        System.out.println("");
        System.out.println("----------------------------------");
        
        // Select the for loop based on the users choice
        switch (choice) {
            case 1:
                System.out.println("You have chosen to count from 0 to 10 by 1s");
                
                for (int i = 0; i <= 10; i++) {
                    System.out.println(i);
                }
                break;
            case 2:
                System.out.println("You have chosen to count from 100 to 0 by 10s");
                
                for (int i = 100; i >= 0; i -= 10) {
                    System.out.println(i);
                }
                break;
            case 3: 
                System.out.println("You have chosen to count from 50 to 500 by 50s");
                
                for (int i = 50; i <= 500; i += 50) {
                    System.out.println(i);
                }
                break;
            case 4:
                System.out.println("You have chosen to count from 6000 to 1000 by 1000s");
                
                for (int i = 6000; i >= 1000; i -= 1000) {
                    System.out.println(i);
                }
                break;
            default:
                System.out.println("Invalid Response");
                break;
                
       
        }
    }
    
}
