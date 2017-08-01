/*
 * This class contains all the data we need for a mortgage loan, including
 * an ID, purchase price, down payment percent, loan amount, loan length, and
 * interest rate.  It includes methods to compute the monthly mortgage payment,
 * including taxes, insurance, principle and interest.
 */

package salemimortgagecalculator;

/**
 *
 * @author Devin Andres Salemi
 */

public class MortgageLoan {
    
    private String myLoanID;
    private double myHomeValue;
    private double myDownPayment;    //given as an integer percentage
    private double myLoanAmount;
    private int myLengthOfLoan;    //given in years    
    private double myInterestRate;    //loan annual interest rate, a percentage
    private char myLoanType;  //'C' or 'J'
    
    
    //constructors
    public MortgageLoan(){
        myLoanID = "";
        myHomeValue = 0;
        myDownPayment = 10;   
        myLengthOfLoan = 30;
        myInterestRate = 0;       
    }
   
    public MortgageLoan(String lastName, double homeValue, char choice, int 
            lengthOfLoan){
        myHomeValue = homeValue;    
        myLengthOfLoan = lengthOfLoan;
        setLoanID(lastName);
        setDownPayment(choice);
        setLoanAmount();
        setLoanType();
        setInterestRate();
    } 
    
    //setters
    public void setLoanType(){
        //maximum value for a conforming loan
        final double UPPER_LIMIT = 417000;
        
        //initialize as a conforming loan
        myLoanType = 'C';
        
        //if the loan is too large to be a conforming loan, change to jumbo
        if( myLoanAmount > UPPER_LIMIT ) myLoanType = 'J';     
    }
    
    public void setLoanID(String lastName){
        final int LENGTH = lastName.length();
        final String XX = "XXXXXXXX";
              
        if ( LENGTH < 8 ) {     
            String append = XX.substring(0,(8 - LENGTH));
            lastName = lastName + append;
        }
        
        lastName = lastName.toUpperCase();
        lastName = lastName.substring(0,8);
        myLoanID = lastName; 
    }
    
    public void setHomeValue(double homeValue) {myHomeValue = homeValue;}
            
    public void setLoanAmount(){
        double decimalDownPayment = myDownPayment / 100;
        double loanAmount = (1 - decimalDownPayment) * myHomeValue;
        myLoanAmount = loanAmount;
    }
            
    public void setInterestRate(){
        if (myLoanType == 'C'){
            if (myLengthOfLoan == 30) myInterestRate = 4.5;
            else if (myLengthOfLoan == 20) myInterestRate = 3.85;
        }    
        else if (myLoanType == 'J'){
            if (myLengthOfLoan == 30) myInterestRate = 4.125;
            else if (myLengthOfLoan == 20) myInterestRate = 3.5;
        }
    }        
      
    public void setDownPayment(char choice){
        switch(choice){
            //no down payment
            case 'N':
                myDownPayment = 0;
                break;
            //low down payment
            case 'L':
                myDownPayment = 10;
                break;
            //standard down payment
            case 'S':
                myDownPayment = 20;
                break;
            //high down payment    
            case 'H':
                myDownPayment = 30;
                break;
            default:
                myDownPayment = 0;
                System.out.println("Invalid choice - no down payment will be "
                        + "applied");       
        }
    }
          
               
    //miscellaneous instance methods
           
    /**
     * Compute the monthly property tax
     * @return monthlyTaxPayment
     */
    public double computeMonthlyPropertyTax(){
       
        //We use the following percentage of the purchase price, given as a 
        //decimal, to compute the home's assessed value
        final double PURCHASE_PRICE_FACTOR = 0.85;  
               
        //We use the following percentage of the home's assessed value, given as
        //a decimal, to compute the property tax
        final double ASSESSED_VALUE_FACTOR = 0.0063;
                       
        final double ADMIN_FEE = 35.00;
        
        double monthlyTaxPayment = (ASSESSED_VALUE_FACTOR  
                * PURCHASE_PRICE_FACTOR * myHomeValue + ADMIN_FEE) / 12;
   
        return monthlyTaxPayment;
    }
    
    /**
     * Compute the monthly insurance premium
     * @return monthlyInsurancePremium
     */
    public double computeMonthlyInsurance(){
        
        //We use the following percentage of the purchase price to compute the 
        //insurance premium
        double purchasePriceFactor = 0;
        //We must set the above factor based upon our down payment percent
        if(myDownPayment <= 10) purchasePriceFactor = 0.0052;
            else if(myDownPayment > 10 && myDownPayment <= 20)
                purchasePriceFactor = 0.0049;
            else if(myDownPayment > 20) purchasePriceFactor = 0.0047;
        
        double monthlyInsurancePremium = Math.round(purchasePriceFactor
                * myHomeValue / 12);
        
        return monthlyInsurancePremium;
    }
       
    /**
     * Compute the monthly principle and interest loan payment
     * @return monthlyLoanPayment
     */
    public double computeMonthlyLoanPayment(){
        
        //We use the following to represent the number of months in the loan
        //period
        double numberOfMonths = myLengthOfLoan * 12;
        
        //Note we divide by 100 to create a decimal
        double monthlyInterestRate = (myInterestRate / 12) / 100;
        
        double factor = Math.exp(numberOfMonths * Math.log(1 
                + monthlyInterestRate));
        
        double monthlyLoanPayment = factor * monthlyInterestRate * myLoanAmount
                / (factor - 1);
                
        return monthlyLoanPayment;
    }   
    
    /**
     * Display the loan details 
     */
    
    public void test(){System.out.println(myLoanID);}
    
    public void displayLoanDetails(){
         System.out.println("Loan identifier                   " 
            + myLoanID);
        System.out.printf("Loan amount                      %9.2f", 
            myLoanAmount);
        System.out.println();
        
        if(myLoanType == 'C')
            System.out.println("Loan type                       conforming");
            else System.out.println("Loan type                            "
                    + "jumbo");
        
        System.out.println();
        
    }
    
    /**
     * Calculate and display the results for the monthly mortgage payment
     */
    public void displayResults(){
        
        //calculate all our output values
       double monthlyTaxPayment = computeMonthlyPropertyTax();
       double monthlyInsurancePremium = computeMonthlyInsurance();
       double monthlyLoanPayment = computeMonthlyLoanPayment();
       double totalMonthlyMortgagePayment = monthlyTaxPayment 
            + monthlyInsurancePremium + monthlyLoanPayment; 
            
       //print our output values     
         System.out.println("  Loan length                     " 
            + myLengthOfLoan + " years");
        System.out.printf("  Annual interest rate              %5.3f%%", 
            myInterestRate);
        System.out.println();
        System.out.printf("  Monthly Taxes                   %8.2f",
                monthlyTaxPayment);
        System.out.printf("%n  Monthly Insurance               %8.2f",
                monthlyInsurancePremium);
        System.out.printf("%n  Monthly Principle & Interest    %8.2f%n",
                monthlyLoanPayment);      
        System.out.println("                                  --------");
        System.out.printf("  Total Monthly Mortgage Payment  %8.2f",
                totalMonthlyMortgagePayment);
    }    
    
}

