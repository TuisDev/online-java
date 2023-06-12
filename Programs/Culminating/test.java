import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class test {
    // Methods
    public static String [] append(String [] array, String item) {
        String [] tempArray = new String [array.length + 1];
        int i = 0;
        for (String element : array ) {
            tempArray[i] = element;
            i ++;
        }

        tempArray[tempArray.length - 1] = item;

        return tempArray;

    }
    public static void main(String [] args) throws Exception {

        // Instantiate the scanner
        Scanner keyedInput = new Scanner (System.in);

        // Variables
        int input;

        // Constants
        String path = "test.csv";
        String line;
        String [] values;

        while (true) {
            // Database
            String [] names = {};
            String [] imgPaths = {};
            String [] ingredientLists = {};
            String [] directionLists = {};

            try {
                // Instantiate the file reader
                FileReader file = new FileReader(path);
                
                // Instantiate the buffer
                BufferedReader csvReader = new BufferedReader(file);

                    while ((line = csvReader.readLine()) != null) {   
                        values = line.split(",");
                        names = append(names, values[0]);
                        imgPaths = append(imgPaths, values[1]);
                        ingredientLists = append(ingredientLists, values[2]);
                        directionLists = append(directionLists, values[3]);
                    }

                csvReader.close();
            } catch (Exception e) {
                System.out.println("File not found!");
            }

            System.out.println("Select an option: ");
            System.out.println("1. Add a new recipe");
            System.out.println("2. Display recipes");
            System.out.println("3. Search for a recipe");
            
            do {
                input = keyedInput.nextInt();
            } while (input < 1 || input > 3);

            switch (input) {
                case 1:
                    // Instantiate the file writer
                    FileWriter csvWriter = new FileWriter(path);

                    keyedInput.nextLine();

                    String nameInput = keyedInput.nextLine();
                    String imgInput = keyedInput.nextLine();
                    String ingredientsInput = keyedInput.nextLine();
                    String directionsInput = keyedInput.nextLine();

                    csvWriter.append(nameInput + ",");
                    csvWriter.append(imgInput + ",");
                    csvWriter.append(ingredientsInput + ",");
                    csvWriter.append(directionsInput + "\n");

                    for (int i = 0; i < names.length; i ++) {
                        csvWriter.append(names[i] + ",");
                        csvWriter.append(imgPaths[i] + ",");
                        csvWriter.append(ingredientLists[i] + ",");
                        csvWriter.append(directionLists[i] + "\n");
                    }

                    csvWriter.flush();
                    csvWriter.close();
                    break;


                case 2:
                    for (int i = 0; i < names.length; i ++) {
                        System.out.println(names[i]);
                        System.out.println(imgPaths[i]);
                        System.out.println(ingredientLists[i]);
                        System.out.println(directionLists[i]);
                    }
                    break;
                case 3:
                    keyedInput.nextLine();

                    String search = keyedInput.nextLine();

                    for (int i = 0; i < names.length; i++) {
                        if (names[i].toLowerCase().contains(search.toLowerCase())) {
                            System.out.println(names[i]);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid response!");
            }

        }
    }
}
