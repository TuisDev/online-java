/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package remixeddoublearrayjw;

/**
 *
 * @author jijwa
 */
public class RemixedDoubleArrayJW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
 
        // Variables
        double [ ] marks = {34.7, 54.1, 34.8, 99.6, 43.6, 43.2, 65.8, 44.8, 88.6};
        double total = 0;
        double average;
        
        // Output the marks
        System.out.println("These are the marks:");
        for (int i = 0; i < 9; i ++)
        {
           System.out.println(marks[i]);
        }
        
        // Calculate the average
        for (int i = 0; i < 9; i ++)
        {
            total = total + marks[i];
        }
        
        average = total/9;
        
        // Round the average
        average = average * 10;
        average = Math.round(average);
        average = average/10;
        
        // Output the average
        System.out.println("The average mark is:");
        System.out.println(average);
    }
    
}
