/*
 * Store donor and donation information obtained from a csv file, using an 
 * ArrayList
 */
package cs310salemi;

import java.io.*;
import java.util.Scanner;

import java.util.*;

/**
 *
 * @author Devin Andres Salemi
 * @version 2, project 2
 */
public class CS310Salemi {

    
    
    static DonorLogImpl donorLog = new DonorLogImpl();
    static DonationLogImpl donationLog = new DonationLogImpl();
    
    static PrintImpl printer = new PrintImpl();
    
    
    /**
     * @param args 
     */
    public static void main(String[] args) {
        final String INPUT_FILENAME = "input/assn2input.txt";
        
      
     
        readAndProcess(INPUT_FILENAME);
        
        
       
        
        printer.populate(donorLog, donationLog);
        
       
        
        createReport(printer);
    }
    
    
    
    
    
    
    /**
     * Set donor attributes
     * @param donor
     * @param values 
     */
    static void setDonorAttributes(Donor donor, String [] values ){
        donor.setID(Integer.parseInt(values[2]));
        donor.setFirstName(values[3]);
        donor.setLastName(values[4]);
        donor.setEmailAddress(values[5]);
        donor.setPhoneNumber(values[6]);        
    }
    
    /**
     * Display each attribute of a donor
     * @param donor 
     */
    static void getDonorAttributes(Donor donor){
        System.out.println(donor.getID());
        System.out.println(donor.getFirstName());
        System.out.println(donor.getLastName());
        System.out.println(donor.getEmailAddress());
        System.out.println(donor.getPhoneNumber());    
    }
    
    /**
     * Set donation attributes
     * @param donation
     * @param values 
     */
    static void setDonationAttributes(Donation donation, String [] values ){    
        donation.setID(Integer.parseInt(values[2]));
        donation.setDonorID(Integer.parseInt(values[3]));
        donation.setDescription(values[4]);
        donation.setAmount(Double.parseDouble(values[5]));  
        donation.setDate(values[6]);
        if(values[7].equalsIgnoreCase("N"))
            donation.setIsDeductible(false);
        donation.setCheckNumber(Integer.parseInt(values[8])); 
        
        
        
    }
    
    /**
     * Display each attribute of a donation
     * @param donation 
     */ 
    static void getDonationAttributes(Donation donation){
        System.out.println(donation.getID());
        System.out.println(donation.getDonorID());
        System.out.println(donation.getDescription());
        System.out.println(donation.getAmount());
        System.out.println(donation.getDate());
        System.out.println(donation.getIsDeductible());
        System.out.println(donation.getCheckNumber());
    
    }
    
    /**
     * Read the data file and process each data line
     * @param input data file
     * @param donationLog
     * @param DonorLog
     */
    static void readAndProcess(String input){
        Scanner fin = null;
        try{
            File file = new File(input);
            fin = new Scanner(file);  
            System.out.println("Reading data file: " + input);
          } catch(FileNotFoundException fnfe){
                System.err.println("Failed to open file " + input);
                fnfe.printStackTrace();
            }       
        while(fin.hasNext()){
            String oneLine;
            String [] lineValues;
            oneLine = fin.nextLine();
            lineValues = oneLine.split(",");
            if(lineValues[0].equalsIgnoreCase("DONOR") ){
                if(lineValues[1].equalsIgnoreCase("ADD")){
                    addDonor(lineValues);               
                }
                if(lineValues[1].equalsIgnoreCase("DEL")){
                    deleteDonor(lineValues);              
                }
            }
            if(lineValues[0].equalsIgnoreCase("DONATION")){
                if(lineValues[1].equalsIgnoreCase("ADD")){
                    addDonation(lineValues);             
                }
                if(lineValues[1].equalsIgnoreCase("DEL")){
                    deleteDonation(lineValues);              
                }
            }
        }
    }
    
    
    
    
    /**
     * Process a donor addition to the list
     * @param data
     */
    static void addDonor(String [] data){
       
        Donor donor = new Donor();
        setDonorAttributes(donor, data);
        if(donor.validateEmail() == false) System.err.println("Error: Email " +
                donor.getEmailAddress() + " for Donor " + donor.getID() + 
                " is invalid.");
        
     
        
        if(donorLog.isIDUnique(donor.getID()) == true) {
            
            
            
            if(donorLog.size() > 0){
                
                for(Donor donor_n : donorLog.getDonorList()){
                   
                    if(donor_n.getID() > donor.getID()){
                        int i = donorLog.getDonorList().indexOf(donor_n);
                        
                        donorLog.add(i, donor);
                    
                  
                       
                        return;
                    }   
                }  
                
                donorLog.add(donor);
                
                return;
                
            }
            
            
            else donorLog.add(donor);
         
            return;
            
        }  
        else {
            System.err.println("Error: Donor ID not unique, donor will not be"
                    + " added to the list: " + donor.toString());
        }
        return;
    }
            
    /**
     * Process a donation addition to the list
     * @param data
     */         
    static void addDonation(String [] data){
        Donation donation = new Donation();
        setDonationAttributes(donation, data);
        if(donation.checkNumberRange() == false) System.err.println("Error: "
                + "Invalid check number " + donation.getCheckNumber() + " for "
                + "Donation " + donation.getID());
        
        if(donorLog.isIDUnique(donation.getDonorID()) == false && 
                donationLog.isIDUnique(donation.getID()) == true) {
            donationLog.add(donation);
            return;
        }
        
        
       
       
        
        
        
       
        if(donorLog.isIDUnique(donation.getDonorID()) == true) 
            System.err.println("Error: Donor ID for the donation is unique and"
                    + " the donation will not be added to the list: " +
                    donation.toString());
        
        if(donationLog.isIDUnique(donation.getID()) == false)
            System.err.println("Error: Donation ID for the donation is not"
                    + " unique and the donation will not be added to the list: "
                    + donation.toString()); 
        return;
    }
    
    /**
     * Process a donor deletion
     * @param data
     */
    static void deleteDonor(String [] data){
        int donorID = Integer.parseInt(data[2]);
        
        for(Donor donorx : donorLog.getDonorList()){
            if(donorx.getID() == donorID){
                donorLog.remove(donorID);
                donationLog.remove(donorID);
                System.out.println("Donor " + donorID + " and its donations"
                    + " have been deleted");
                return;
            
            }
        }
        System.err.println("Error: Donor " + donorID + " not found.");        
        return;       
    }
    
    
            
   /**
    * Process a donation deletion
    * @param data
    */    
    static void deleteDonation(String [] data){
        int donationID = Integer.parseInt(data[2]);
        int donorID = Integer.parseInt(data[3]);
       
        for(Donation donationx : donationLog.getDonationList()){
            if(donationx.getID() == donationID){
                donationLog.remove(donorID, donationID);
                    System.out.println("Donation " + donationID + " has"
                            + " been deleted.");
                    return;
            }           
        }
        System.err.println("Error: Donation " + donationID + " not found.");  
        return;  
     }       
            
            
    /**
     * Create a report
     * @param printer
     */       
            
    static void createReport(PrintImpl printer){
        printer.createReport();
    
    }        
            
            
}


   