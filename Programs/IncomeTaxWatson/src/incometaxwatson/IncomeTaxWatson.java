/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package incometaxwatson;

import java.util.Scanner;

/**
 *
 * @author jijwa
 */
public class IncomeTaxWatson {
    // Methods
    static double round(double unRounded) {
        return (double)((int)(unRounded * 100 + 0.5)) / 100; // Multiplies by 100, roudns to 0 decimal places, divides by 100. 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Instantiate the scanner
        Scanner keyedInput = new Scanner(System.in);
        
        // Variables
        double income;
        double remainingIncome;

        double federalTax = 0;
        double provincialTax = 0;
        double totalTax;
        
        // Constants
        final double[] FEDERAL_TAX_RATES = {0.33, 0.29, 0.26, 0.205, 0.15};
        final double[] PROVINCIAL_TAX_RATES = {0.1316, 0.1216, 0.1116, 0.0915, 0.0505};
        
        final int[] FEDERAL_TAX_BRACKETS = {235675, 165430, 106717, 53359, 0};
        final int[] PROVINCIAL_TAX_BRACKETS = {220000, 150000, 98463, 49231, 0};
        
        // Welcome the user
        System.out.println("Welcome to the Ontario Income Tax Estimator!");
        
        // Ask for input
        System.out.println("How much taxable income will you make this year?: ");
        income = keyedInput.nextDouble();
        
        // Federal Tax Calculations
        int i = 0;
        remainingIncome = income;
        for (double taxRate : FEDERAL_TAX_RATES) {
            int taxBracket = FEDERAL_TAX_BRACKETS[i];
            if (remainingIncome > taxBracket) {
                federalTax += (remainingIncome - taxBracket) * taxRate;
                remainingIncome = taxBracket;
            }
            i++;
        }
        
        // Provincial Tax Calculations
        i = 0;
        remainingIncome = income;
        for (double taxRate : PROVINCIAL_TAX_RATES) {
            int taxBracket = PROVINCIAL_TAX_BRACKETS[i];
            if (remainingIncome > taxBracket) {
                provincialTax += (remainingIncome - taxBracket) * taxRate;
                remainingIncome = taxBracket;
            }
            i++;
        }
        
        // Total Calculations
        totalTax = provincialTax + federalTax;
        
        // Output tax
        System.out.println("The federal portion of the tax is $" + round(federalTax) + ".");
        System.out.println("The provincial portion of the tax is $" + round(provincialTax) + ".");
        System.out.println("The total income tax is $" + round(totalTax) + ".");
    }
    
}
