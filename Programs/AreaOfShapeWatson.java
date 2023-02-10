/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package areaofshapewatson;
    import java.util.Scanner;
/**
 *
 * @author jijwa
 * Calculates the volume of a rectangular
 */
public class AreaOfShapeWatson {    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyedInput = new Scanner(System.in);
        
        double length;
        double width;
        double height;
        
        double volume;
        
        System.out.println("What is the length of the rectangle prism?: ");
        length = keyedInput.nextDouble();
        System.out.println("What is the width of the rectangular prism?: ");
        width = keyedInput.nextDouble();
        System.out.println("What is the height of the rectangular prism?: ");
        height = keyedInput.nextDouble();
        
        volume = length * width * height;
        
        System.out.println("The rectangular prism has a volume of " + volume + "!");
    }
    
}
