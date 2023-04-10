/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quadraticfunctionwatson;
    import java.util.Scanner;
/**
 *
 * @author jijwa
 */
public class QuadraticFunctionWatson {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyedInput = new Scanner(System.in);
        
        int quadraticCoefficient;
        int linearCoefficient;
        int constantCoefficient;
        
        double firstAnswer;
        double secondAnswer;
        
        System.out.println("What is the quadratic coefficient(a)?: ");
        quadraticCoefficient = keyedInput.nextInt();
        System.out.println("What is the linear coefficient(b)?: ");
        linearCoefficient = keyedInput.nextInt();
        System.out.println("What is the constant coefficient(c)?: ");
        constantCoefficient = keyedInput.nextInt();
        
        firstAnswer = (-1 * linearCoefficient + Math.sqrt(Math.pow(linearCoefficient, 2) - 4 * quadraticCoefficient * constantCoefficient))/(2 * quadraticCoefficient);
        secondAnswer = (-1 * linearCoefficient - Math.sqrt(Math.pow(linearCoefficient, 2) - 4 * quadraticCoefficient * constantCoefficient))/(2 * quadraticCoefficient);
        
        System.out.println("The factor of " + quadraticCoefficient + "x^2 + (" + linearCoefficient + ")x + (" + constantCoefficient + ") are x=" + firstAnswer + ", " + secondAnswer + ".");
              
    }
    
}
