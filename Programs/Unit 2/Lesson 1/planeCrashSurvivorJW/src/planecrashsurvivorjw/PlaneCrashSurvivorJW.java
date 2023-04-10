/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planecrashsurvivorjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class PlaneCrashSurvivorJW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int userInput;
        
        
        System.out.println("Welcome to plane crash choose your own adventure game!");
        System.out.println("Throughout this game, you will be asked to make decisions, either enter 1 or 2 to make your choice.");
        System.out.println("Have Fun!");
        System.out.println("Would you like to drive(1) or fly(2) to your vacation?: ");
        
        userInput = keyedInput.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("As you drive along the 401 to your destination, a drunk driver swerves in front of you.");
                System.out.println("YOU DIED!");
                break;
            case 2:
                break;
            default: 
                System.out.println("Invalid Response");
        }
        
    }
    
}
