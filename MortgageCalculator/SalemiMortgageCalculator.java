/*
 * This class is an implementation of a Mortgage Payment Calculator
 */

package salemimortgagecalculator;
import java.util.Scanner;
import java.lang.Math;


/**
 *
 * @author Devin Andres Salemi
 * @version 3, Java Assn #5
 */

public class SalemiMortgageCalculator {

    /**
     * Given an initial purchase price for a home and an annual interest rate 
     * for a loan, this class will compute the monthly mortgage payment,
     * including taxes, insurance, principle and interest.
     */
    
// ~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);  
               
        //Here we display the program description to the user
        displayIntroduction();
        
        //Create an object of the MortgageLoan class type
        //MortgageLoan loan = new MortgageLoan();
        
        System.out.println("Please enter the home buyer's last name: ");
        String name = keyboard.next();
        System.out.println("Please enter the home's initial purchase "
                  + "price:  ");
        double purchasePrice = keyboard.nextDouble();  
        System.out.println("Down Payment Options:");
        System.out.println("  N - Nothing down");
        System.out.println("  L - Low down payment");
        System.out.println("  S - Standard down payment");
        System.out.println("  H - High down payment");  
        System.out.println("Enter your choice: ");
        String choice_str = keyboard.next();
        char choice = choice_str.charAt(0);
        System.out.println("Your choice: " + choice);
        
        //Create two instances of the MortgageLoan class
        MortgageLoan loan1 = new MortgageLoan(name, purchasePrice, choice, 20);
        MortgageLoan loan2 = new MortgageLoan(name, purchasePrice, choice, 30);
                             
        System.out.println();
        System.out.println();
        
        //Perform all calculations and display all results
        loan1.displayLoanDetails();
        System.out.println("Loan Option 1:");
        loan1.displayResults();       
        System.out.println();
        System.out.println("Loan Option 2:");
        loan2.displayResults();
                   
    }
    
    /**
     * Output an explanation of what the program will do
     */
    public static void displayIntroduction(){
        System.out.println("This program implements a Mortgage Payment"
                + " Calculator");
        System.out.println();
        System.out.println("If we input the home's purchase price and "
                + "the loan's annual interest rate, our output will");
        System.out.println("then be total monthly mortgage payment, which "
                + "consists of three components: taxes, insurance, ");
        System.out.println("and principle coupled with interest.");
        System.out.println();
    }
   

    
    
}
