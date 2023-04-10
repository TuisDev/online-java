/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package remixedstringarrayjw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class RemixedStringArrayJW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instantiate the scanner
        Scanner keyedInput = new Scanner (System.in);
        
        // Variables
        String [ ] friends = new String [10];
        
        // Get five friends from the user
        System.out.println("Enter the names of five friends:");
        for (int i = 0; i < 5; i ++)
        {
            friends[i] = keyedInput.nextLine();
        }
        
        // Tell the user what we are outputting 
        System.out.println("The second, third and fourth names listed were:");
        // Output the second friend
        System.out.println("Second: " + friends[1]);
        // Output the third friend
        System.out.println("Third: " + friends[2]);
        // Output the fourth friend
        System.out.println("Fourth: " + friends[3]);
    }
    
}
