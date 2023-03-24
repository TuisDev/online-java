/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package badmintongamejw;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class BadmintonGameJW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        int userInput;
        
        // Introduce the game
        System.out.println("You are asked to score keep a badminton tournament that is happening at your school. ");
        System.out.println("You will be in charge of recording scores that the players bring to you and posting those scores in the hallway.");
        System.out.println("Throughout this game, you will be asked questions, either respond by entering 1 or 2.");
        System.out.println("Let's get started! Do you agree to score keep (1), or would you rather not (2)?: ");
        
        
        // Get the user input
        userInput = keyedInput.nextInt();
        
        // Repeat until the user input is valid
        while ((userInput != 1) && (userInput != 2)) {
            System.out.println("Invalid response, try again");
            userInput = keyedInput.nextInt();
        }
        
        // If the user agrees to score keep
        if (userInput == 1) {                 
            // Prompt the user
            System.out.println("You get everything set up in the morning, and all appears to be going smoothly, until you notice that you and your partner have different numbers written down.");
            System.out.println("Your partner thinks their answers are right, and you think that your answers are correct, what do you do?");
            System.out.println("Do you keep your partner's answers (1) or do you keep your answers (2)?:");
            
            // Get the user input
            userInput = keyedInput.nextInt();
        
            // Repeat until the user input is valid
            while ((userInput != 1) && (userInput != 2)) {
                System.out.println("Invalid response, try again");
                userInput = keyedInput.nextInt();
            }
            
            // If the user thinks their partners scores are correct
            if (userInput == 1) {                
                // Prompt the user
                System.out.println("Your partner has left to go to the bathroom, and you need to post the scores in the hallway, what do you do?");
                System.out.println("Do you leave the score station unattended (1) or do you wait for your partner (2)?: ");

                // Get the user input
                userInput = keyedInput.nextInt();
        
                // Repeat until the user input is valid
                while ((userInput != 1) && (userInput != 2)) {
                    System.out.println("Invalid response, try again");
                    userInput = keyedInput.nextInt();
                }

                // If the user posts the scores
                if (userInput == 1) {
                    // Prompt the user
                    System.out.println("You post the scores and sit back down at the scoring table.");
                    System.out.println("As you do so, an angry coach starts yelling at you, saying that their players actually won a game, but it was recorded as the opposite, what do you do?");
                    System.out.println("Do you change the numbers (1) or leave them the same (2)?: ");

                    // Get the user input
                    userInput = keyedInput.nextInt();
            
                    // Repeat until the user input is valid
                    while ((userInput != 1) && (userInput != 2)) {
                        System.out.println("Invalid response, try again");
                        userInput = keyedInput.nextInt();
                    }

                    // If the user changes the numbers
                    if (userInput == 1) {
                        // Output the ending
                        System.out.println("When you return from posting the numbers, there is a long line at the scoring table.");
                        System.out.println("Your partner is mad at you for leaving the table unattended, but you’re mad at him for giving you the wrong numbers.");
                        System.out.println("You manage to get through the tournament, but this will be the last time you ever score keep badminton.");       
                        
                    // If the user leaves the numbers the same
                    } else {
                        // Output the ending
                        System.out.println("Everyone is mad at you! Coaches are screaming at you for posting the wrong numbers, your partner is disappointed, your teacher is angry.");
                        System.out.println("It was a mistake to ever let you score keep.");
                    }                    

                // If the user waits for their partner
                } else {                    
                    // Prompt the user
                    System.out.println("As you wait for your partner to return, people begin to crowd around the scorekeeping desk, trying to get information on the scores.");
                    System.out.println("You see people trying to talk to you about their games, but they can't make it through the people checking on their scores, what do you do?");
                    System.out.println("Do you ask a passing teacher to post the scores (1) or do you scream at the people crowding to back off (2)?: ");

                    // Get the user input
                    userInput = keyedInput.nextInt();

                    // Repeat until the user input is valid
                    while ((userInput != 1) && (userInput != 2)) {
                        System.out.println("Invalid response, try again");
                        userInput = keyedInput.nextInt();
                    }

                    // If the user asks a passing teacher
                    if (userInput == 1) {
                        // Output the ending
                        System.out.println("Your teacher posts the scores on the scoreboard, and the tournament goes on, it is only in the quarter-finals when someone finally realizes that your numbers were incorrect.");
                        System.out.println("It is too late to correct it now, and your teacher is quite disappointed in you and your partner.");
                        System.out.println("You are filled with shame, and will never play badminton again.");

                    // If the user screams at the crowding people
                    } else {
                        // Output the ending
                        System.out.println("You shout, \"GET BACK!\" at the top of your lungs, but as people begin to retreat, you hear a quick whoosh and feel a sudden pain in the back of your head.");
                        System.out.println("An angry badminton player has smashed his racket against your head.");
                        System.out.println("You are taken to the hospital for a concussion, and can never play badminton again due to trauma.");
                    }                    
                }                

            // If the user thinks their scores are correct
            } else {                
                // Prompt the user
                System.out.println("After fixing your partner's mistake, you realize that they accidentally replicated numbers, and that your numbers were definitively correct.");
                System.out.println("The day continues to run smoothly, until you realize that someone who you had been informed was forfeit, was actually still playing, what do you do?");
                System.out.println("Do you complain (1) or do you ask the player what scores they had and rewrite them correctly (2)?: ");

                // Get the user input
                userInput = keyedInput.nextInt();

                // Repeat until the user input is valid
                while ((userInput != 1) && (userInput != 2)) {
                    System.out.println("Invalid response, try again");
                    userInput = keyedInput.nextInt();
                }

                // If the user complains
                if (userInput == 1) {
                    // Prompt the user
                    System.out.println("You complain loudly, but while this is happening, the players disappear, and you can no longer get the scores back, what do you do?");
                    System.out.println("Do you try to fix the mistake (1) or do you get mad (2)?: ");

                    // Get the user input
                    userInput = keyedInput.nextInt();

                    // Repeat until the user input is valid
                    while ((userInput != 1) && (userInput != 2)) {
                        System.out.println("Invalid response, try again");
                        userInput = keyedInput.nextInt();
                    }

                    // If the user tries to fix the mistake
                    if (userInput == 1) {
                        // Output the ending
                        System.out.println("You run around looking for the players, and manage to mostly fix the mistake.");
                        System.out.println("The tournament goes on without any further hiccups and all is somewhat well.");
                        System.out.println("The teacher asks you if you would like to score keep the next tournament.");

                    // If the user gets mad
                    } else {
                        // Output the ending
                        System.out.println("You get mad and start hitting people with badminton rackets, you end up destroying seven rackets and severely injuring some players.");
                        System.out.println("Due to this, you are arrested and taken to jail.");
                        System.out.println("After your eventual release, you become a hardened criminal, murder someone, and are sentenced to life imprisonment.");
                    }

                // If the user asks the player for their scores
                } else {
                        // Output the ending
                        System.out.println("You ask the people what their scores were, and fix the messed up numbers.");
                        System.out.println("The tournament finishes, and your coach congratulates you on your problem-solving and your dedication.");
                }
                
            }
            
        // If the user doesn't agree to score keep    
        } else {
            System.out.println("Okay then, have a nice day!");
        }
       
    }
    
}
