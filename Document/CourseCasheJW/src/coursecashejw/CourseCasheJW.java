/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package coursecashejw;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author jijwa
 */
public class CourseCasheJW {

    /**
     * @param args the command line arguments
     */
    
    // Global Variables
    String [] name = new String [10];
    String [] type = new String [10];
    int [] grade = new int [10];
    String [] level = new String [10];
    int [] marks = new int [10];
    int [] population = new int [10];
    
    // Global Constants
    final String [] COMMANDS = {"mark", "population", "name"};
    final String [][] SELECTORS = {{"12", "11"}, {"university", "college", "workplace"}, {"math", "english"}};

    
    // Methods
    
    /* readDatabase
    This method gets data from the data base and puts in into parallel arrays
    
    Parameters: String
    
    Returns: none
    */
    public void readDatabase(String path) {
        try {
            // Instantiate the file reader
            FileReader file = new FileReader(path);
            
            // Instantiate the buffer
            BufferedReader buffer = new BufferedReader(file);
            for (int i = 0; i < 10; i ++) {
                name[i] = buffer.readLine();
                type[i] = buffer.readLine();
                grade[i] = Integer.parseInt(buffer.readLine());
                level[i] = buffer.readLine();
                marks[i] = Integer.parseInt(buffer.readLine());
                population[i] = Integer.parseInt(buffer.readLine());   
            }
            buffer.close();
        } catch (IOException e){
            System.out.println("File not found! Error code 01");
        }
    }
    
    /* outputInstructions
    This method outputs the instructions for this program
    
    Parameters: none
    
    Returns: none
    */
    public static void outputInstructions() {
        System.out.println("-------- The Cavernous Course Cashe --------");
        System.out.println("Welcome to The Cavernous Course Cashe!");
        System.out.println("This database has some of the information you'd want to know about some of the grade 11 and 12 courses.");
    }
    
    /* replaceLast
    This method replaces the last occurance of a substring within a string
    
    Parameters: String, String, String
    
    Returns: String
    */
    public static String replaceLast(String str, String oldString, String newString) {
        // Variables
        int index = str.lastIndexOf(oldString);
        
        // Replace the oldString if it is found in str
        if (index != -1) {
            str = str.substring(0, index) + str.substring(index, str.length()).replace(oldString, newString);
        }
        return str;
    }
    
    /* firstToUpperCase
    This method makes the first character of a string uppercase
    
    Parameters: String
    
    Returns: String
    */
    public static String firstToUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
    }
    
    /* getOperation
    This method gets the operation from the user
    
    Parameters: Scanner
    
    Returns: int
    */
    public int getOperation(Scanner keyedInput) {
        // Variables
        int operation = -1;
        String input;
        
        // Repeat until a valid operation is given
        while (operation < 0) {
            // Ask user for input
            System.out.println("What type of information are you looking for?(marks, population, name): ");

            // Get input from user
            input = keyedInput.nextLine();

            // Process Input
            input = input.toLowerCase();

            for (int i = 0; i < 3; i ++) {
                if (input.contains(COMMANDS[i])) {
                    operation = i;
                }
            }
           
            // Output an error message if an invalid operation is given
            if (operation < 0) {
                System.out.println("Invalid response! Try again!");
            }
        }
        
        return operation;
    }
    
    
    /* getSelectors
    This method gets the selectors from the user
    
    Parameters: Scanner
    
    Returns: String []
    */
    public String [] getSelectors(Scanner keyedInput) {
        // Variables
        String [] selectors = new String [3];
        String input;
        
        // Ask user for input
        System.out.println("What selectors are you looking for? Select up to one from each category.(Math or English; University, College or Workplace; Grade 11 or 12): ");
        
        // Get input from user
        input = keyedInput.nextLine();
        
        // Proccess input
        input = input.toLowerCase();
        
        for (int i = 0; i < 3; i ++) {
            for (String selector : SELECTORS[i]) {
                if (input.contains(selector)) {
                    selectors[i] = selector;
                }
            }
        }
        
        return selectors;
    }
    
    /* getData
    This method gets data from the database based on the operation and selectors
    
    Parameters: int, String []
    
    Returns: String []
    */
    public String [] getData(int operation, String [] selectors) {
        // Variables
        int num = 0;
        int total = 0;
        int average;
        
        String list = "";
        
        // Get Data
        for (int i = 0; i < 10; i ++) {
            if (
                    (selectors[0] == null || selectors[0].equals(String.valueOf(grade[i])))
                    && (selectors[1] == null || selectors[1].equals(level[i]))
                    && (selectors[2] == null || selectors[2].equals(type[i]))
            ) {
                switch (operation) {
                    case 0:
                        total = total + marks[i];
                        list = list + "\u001B[1m" + String.valueOf(marks[i]) + "\u001B[2m, ";
                        break;
                    case 1:
                        total = total + population[i];
                        list = list + "\u001B[1m" + String.valueOf(population[i]) + "\u001B[2m, ";
                        break;
                    case 2:
                        list = list + "\u001B[1m" + String.valueOf(name[i]) + "\u001B[2m, ";
                        break;
                    default:
                        System.out.println("Invalid Operation! Error code 02");
                }
                num ++;
                
            }
        }
        
        // Compute average only if a course is found
        if (num != 0) {
            average = (int)Math.round((double)total / (double)num);
        } else {
            // Output message if no course is found
            System.out.println("No Course Found.");
            average = -1;
        }
        String [] data = {String.valueOf(average), list}; 
        
        return data;
    }
    
    /* format
    This method formats the selectors to make them more readible when outputted
    
    Parameters: String []
    
    Returns: String
    */
    public static String format(String [] selectors) {
        // Variables
        String formatedSelector = "";
        
        // Format selectors string
        for (int i = 0; i < 3; i ++) {
            if (selectors[i] != null) {
               switch (i) {
                   case 0:
                       formatedSelector += "Grade " + selectors[i] + " ";
                       break;
                   case 1:
                       formatedSelector += selectors[i] + " level ";
                       break;
                   case 2:
                       formatedSelector += firstToUpperCase(selectors[i]) + " ";
                       break;
                   default:
                       System.out.println("Invalid Selector! Error code 03!");
               }
            }
        }
        
        if (!formatedSelector.equals("")) {
            formatedSelector = formatedSelector.substring(0, formatedSelector.length() - 1);
            formatedSelector = " for " + formatedSelector;
        }
        
        return formatedSelector;
        
        
    }
    
    /* outputResults
    This method outputs the data
    
    Parameters: String [], int, String []
    
    Returns: none
    */
    public void outputResults(String [] data, int operation, String [] selectors) {
        // Variables
        String average = data[0];
        String list = data[1];
        String formatedSelector;
        
        // Exit if there is no courses found
        if (average.equals("-1")) {
            return;
        }
        
        // Format the list of values
        list = list.substring(0, list.length() - 2);
        list = replaceLast(list, ", ", " & ");
 
        // Format the selectors
        formatedSelector = format(selectors);
        
        // Output data
        System.out.println("The course " + COMMANDS[operation] + "s" + formatedSelector + " are " + list);
        if (!average.equals("0")) {
            System.out.println("The average " + COMMANDS[operation] + formatedSelector + " is \u001B[1m" + average + "\u001B[2m");
        }
    }
    
    /* askToContinue
    This method asks the user if they would like to continue searching the database
    
    Parameters: Scanner
    
    Returns: boolean
    */        
    public static boolean askToContinue(Scanner keyedInput) {
        // Output dividing line
        System.out.println("--------------------------------------------");
        
        // Repeat until valid data is provided
        while (true) {
            // Ask user if they want to continue
            System.out.println("Do you want to continue?(y, n): ");
            
            // Get response from user
            String response = keyedInput.nextLine();
            
            // Output false if the user wants to continue, and true if they want to stop
            if (response.equals("y")) {
                return false;
            } else if (response.equals("n")) {
                return true;
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here

        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Instatiate the class (allows me to use global variables in static context)
        CourseCasheJW mainProg = new CourseCasheJW();
        
        // Variables
        int operation;
        String [] selectors;
        String [] data;
        boolean done = false;
        
        // Read the database and output the instructions
        mainProg.readDatabase("CourseDataJW.dat");
        outputInstructions();
        
        // Main loop
        while (!done) {
            // Get operation and selectors from user
            operation = mainProg.getOperation(keyedInput);
            selectors = mainProg.getSelectors(keyedInput);
            
            // get data using the provided operation and selectors
            data = mainProg.getData(operation, selectors);
            
            // Output data
            mainProg.outputResults(data, operation, selectors);
            
            // Ask the user if they want to continue
            done = askToContinue(keyedInput);
        }  
        
    }

}

