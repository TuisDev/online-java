/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datavalidationjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class DataValidationJW {
    /**
     * @param args the command line arguments
     */
    
    /* outputInst
    
    This method outputs the instructions for the game
    
    Parameters: none
    
    Returns: none
    
    */
    public static void outputInst() {
        // Output game title
        System.out.println("------------- Data Valildator 1000 -------------");
        
        // Output Instructions
        System.out.println("Welcome to the Data Validator 1000!");
        System.out.println("There are six levels of increasing difficulty,");
        System.out.println("Enter the correct data on each level to move on!");
    }
    
    /* getInput
    
    This method asks and gets input from the user
    
    Parameters: Scanner, int
    
    Returns: String
    */
    public static String getInput(Scanner keyedInput, int round) {
        // Output level header
        System.out.println("------------- LEVEL " + round + " -------------");
        
        // Ask for the correct input
        switch (round) {
            case 1:
                System.out.println("Enter a string longer than 6 characters: ");
                break;
            case 2:
                System.out.println("Enter a string that contains the letter \"a\": ");
                break;
            case 3:
                System.out.println("Enter a string between 5 and 15 characters, that does not contain the letter \"z\": ");
                break;
            case 4:
                System.out.println("Enter a integer between 5 and 500: ");
                break;
            case 5:
                System.out.println("Enter a negative integer: ");
                break;
            case 6:
                System.out.println("Enter a positive, odd integer: ");
                break;
            default:
                break;
        }
        
        // Return the input
        return keyedInput.nextLine();
    }
    
    /* validateInput
    
    This method checks to see if the input is valid
    
    Parameters: String, int
    
    Returns: boolean
    */
    public static boolean validateInput (String input, int round) {
        
        // Variables
        int intInput;
        
        // Validate the input
        switch (round) {
            case 1:
                // Return true if the input is long than 6 characters
                return input.length() > 6;
            case 2:
                // Return true if the input contains "a"
                return input.contains("a");
            case 3:
                // Return true if the input is between 5 & 15 characters and does not contain "z"
                return (!input.contains("z")) && input.length() >= 5 && input.length() <= 15;
            case 4:
                // Convert input to integer
                try {
                   intInput = Integer.parseInt(input);
                   
                   // Return true if the input is between 5 and 500
                   return intInput <= 500 && intInput >= 5; 
                } catch (NumberFormatException e) {
                    return false;
                }
            case 5:
                // Convert input to integer
                try {
                   intInput = Integer.parseInt(input);
                   
                   // Return true if the input is less than 0
                   return intInput < 0; 
                } catch (NumberFormatException e) {
                    return false;
                }
            case 6:
                // Convert input to integer
                try {
                   intInput = Integer.parseInt(input);
                   
                   // Return true is the input is positive and odd
                   return intInput >= 0 && intInput % 2 == 1; 
                } catch (NumberFormatException e) {
                    return false;
                }
            default:
                return false;
        }
    }
    
    /* outputResults
    
    This method outputs the results of the data validation
    
    Parameters: boolean, int
    
    Returns: none
    
    */
    public static void outputResults(boolean result, int round) {
        if (result) {
            if (round == 6) {
                // Output message for beating the game
                System.out.println("Congratulations, you beat the game!");
            } else {
                // Output message for beating a level
                System.out.println("Correct! You can now move on to the next level!");
            }
        } else {
            // Output message for incorrect input
            System.out.println("Not quite, read the instructions carefully and try again.");
        }
    }
    
    /* incrementRound
    
    This method increments the round if the data is valid
    
    Parameters: boolean, int
    
    Returns: int
    
    */
    public static int incrementRound(boolean result, int round) {
        if (result) {
            // Increment the round
            round ++;
            return round;
        } else {
            return round;
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int round = 1;
        String input;
        boolean result;
        
        // Output the instructions
        outputInst();
        
        // Main loop
        while (round != 7) {
            // Get input from the user
            input = getInput(keyedInput, round);
            
            // Validate the input
            result = validateInput(input, round);
            
            // Output the results of the validation
            outputResults(result, round);
            
            // Increment the round if the data is valid
            round = incrementRound(result, round);
        }
    }
    
}
