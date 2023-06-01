/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package typecastingjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class TypeCastingJW {

    /**
     * @param args the command line arguments
     */
    
    // Methods
    
    /* toDouble
    These methods take in either a string or a int, and convert it to a double
    
    parameters: string or int
    
    returns: double
    */
    public static double toDouble (int num) {
        return (double)num;
    }
    public static double toDouble (String num) {
        return Double.parseDouble(num);
    }
    
    /* toInt
    These methods take in either a string or a double, and convert it to an int
    
    parameters: string or double
    
    returns: int
    */
    public static int toInt (double num) {
        return (int)num;
    }
    public static int toInt(String num) {
        return Integer.parseInt(num);
    }
    
    /* toString
    This method takes in a char, and converts it to a string
    
    parameters: char
    
    returns: string
    */
    public static String toString(char character) {
        return String.valueOf(character);
    }

    /* toChar
    This method takes in a string, and converts it to a char
    
    parameters: string
    
    returns: char
    */
    public static char toChar(String string, int index) {
        return string.charAt(index);
    }
    
    /* outputData
    This method outputs two doubles, two ints, a char and a string
    
    parameters: double, int, string, char, int, double
    
    returns: none
    */
    
    public static void main(String[] args) {
        // TODO code application logic here

        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int anInt;
        double aDouble;
        char aChar;
        String name;
        String wholeNum;
        String deciNum;

        // Output header
        System.out.println("-------- Crazy Casting Computer --------");
        
        // Get input
        System.out.println("Please enter a whole number: ");
        anInt = keyedInput.nextInt();
        
        System.out.println("Please enter a decimal number: ");
        aDouble = keyedInput.nextDouble();
                
        // Clear input stream
        keyedInput.nextLine();
        
        System.out.println("Please enter a single character: ");
        aChar = keyedInput.nextLine().charAt(0);
        
        System.out.println("Please enter your name: ");
        name = keyedInput.nextLine();
        
        System.out.println("Please enter another whole number: ");
        wholeNum = keyedInput.nextLine();
        
        System.out.println("Please enter another decimal number: ");
        deciNum = keyedInput.nextLine();
        
        // Dividing Line
        System.out.println("----------------------------------------");
        
        // Output data
        System.out.println("An int becomes a double!");
        System.out.println(anInt + " -> " + toDouble(anInt));
        
        System.out.println("A double becomes an int!");
        System.out.println(aDouble + " -> " + toInt(aDouble));
        
        System.out.println("A char becomes a string!");
        System.out.println(aChar + " -> " + toString(aChar));
        
        System.out.println("A string becomes a char!");
        System.out.println(name + " -> " + toChar(name, 0));
        
        System.out.println("A string becomes a int!");
        System.out.println(wholeNum + " -> " + toInt(wholeNum));
        
        System.out.println("A string becomes a double!");
        System.out.println(deciNum + " -> " + toDouble(deciNum));
        
        

    }

}
