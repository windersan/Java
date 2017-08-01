/*
 * Implement a display function
 */
package cs310salemi;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author Devin Andres Salemi
 */
public class PrintImpl {
    
    
    PrintImpl(){};
    
    
    void populate(DonorLogImpl donorLog, DonationLogImpl donationLog){
        
        myDonorLog = donorLog;
        myDonationLog = donationLog;
        donorArray = new ArrayList<Donor>();
        donationArray = new ArrayList<Donation>();
        
        for(Donor donor : donorLog.getDonorList()){
        
        
        donorArray.add(donor);
        
        
        }
        
        for(Donation donation : donationLog.getDonationList()){
        
        
        donationArray.add(donation);
        }
    }
    
    final String OUTPUT_FILENAME = "output/assn2report.txt";
    final double GOLD_STAR = 10000.00;
    private DonorLogImpl myDonorLog;
    private DonationLogImpl myDonationLog;
    String goldStar = "";
    
    public ArrayList<Donor>donorArray;
    public ArrayList<Donation>donationArray;
    
    
    
    /**
     * Create report
     */
    public void createReport(){
        
        for(Donation donation : donationArray){
                if(donation.getAmount() > GOLD_STAR){ 
                    for(Donor donor : donorArray){
                        if(donor.getID() == donation.getDonorID()){
                            donor.setGoldStar("GOLDSTAR donor");
                        }
                        else donor.setGoldStar(" ");
                        
                    }
                }         
            }
        
        
        
        File outFile = new File("output/assn2report.txt"); 
       
   
        try {
            File inFile = new File("output/assn2report.txt");
            PrintWriter fout = new PrintWriter(outFile);
            
            
            
            for(Donor donor : donorArray){
            
        
            fout.println(donor.getID() + "    " + donor.getLastName() + 
                    ", " + donor.getFirstName() + "    " + donor.getGoldStar());
            fout.println("     Donations");
        
            for(Donation donation : donationArray){
                if(donation.getDonorID() == donor.getID()){
                    fout.printf("     %7d  ", donation.getID());
                    fout.print(donation.getDate());
                    fout.format("  %-25s", donation.getDescription());
                    fout.printf("%10.2f",donation.getAmount());
                    fout.printf("%6d  ",donation.getCheckNumber());
                    if(donation.getIsDeductible() == true)
                        fout.printf("Tax deductible%n");
                    else fout.printf("%n");
                    fout.println("     Number of donations for donor: " +
                        myDonationLog.numberOfDonations(donor.getID()));
                    fout.println("     Total amount of donations for donor: "
                            + myDonationLog.totalDonationAmount(donor.getID()));
                }
                    
            }   
        }  
        fout.println("Total number of donations (all donors) = " +
                myDonationLog.numberOfDonations());
        fout.println("Total value of donations (all donors) = $" + 
                myDonationLog.totalDonationAmount());
           
            
            
            System.out.println("Report created, check output folder.");
            
            
            
            fout.close();
         }
        catch (Exception e) {
            System.err.println("Cannot open output file " + 
                    "output/assn2report.txt"); 
                 
            
        } 
        
        
        
        
        
        
    }   
        
        
            
        
}
    

