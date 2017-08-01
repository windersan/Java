/*
 * Implement an ArrayList of Donations
 */
package cs310salemi;
import java.util.*;

/**
 *
 * @author Devin Andres Salemi
 */
public class DonationLogImpl {
    private ArrayList <Donation> donations;
    
    public DonationLogImpl(){
        donations = new ArrayList <Donation>();
    }
    
    
/**
 * Obtain the ArrayList 
 * @return donations
 */     
public ArrayList<Donation> getDonationList(){

    return donations;
}
    
/**
 * Add donation to list 
 * @param donation
 * @return true if successful
 */   
public Boolean add(Donation donation){


    donations.add(donation);
    return true;
}


/**
 * Remove donations with donorID from list
 * @param donorID
 * @return true if any donations deleted
 */
public Boolean remove(int donorID){

   Boolean removed = false;
  
    int index = 0;
  
    for(int i = 0; i < donations.size(); i++){
        if(donations.get(i).getDonorID() == donorID){
        index = i;
        } 
    }
    
    donations.remove(index);
    removed = true;
    return removed;
}


/**
 * Remove donations with donorID and donationID from list
 * @param donorID
 * @param donationID
 * @return true if any donations deleted
 */
public Boolean remove(int donorID, int donationID){
    Boolean removed = false;
  
    int index = 0;
  
    for(int i = 0; i < donations.size(); i++){
        if(donations.get(i).getID() == donationID){
        index = i;
        } 
    }
    
    donations.remove(index);
    removed = true;
    return removed;
}


/**
 * Test if donation with ID exists in list
 * @param donationID
 * @return true if donation with ID exists in list
 */
public Boolean isIDUnique(int donationID){

    for(Donation donation : donations){
        if(donation.getID() == donationID) return false;
    }
    return true;
}







/**
 * Obtain count of all donations
 * @return total count of donations
 */
public int numberOfDonations(){
    
    return donations.size();
    

}


/**
 * Obtain count of donations with donorID
 * @param donorID
 * @return count of donations
 */
public int numberOfDonations(int donorID){

    int count = 0;
    for(Donation donation : donations){
        if(donation.getDonorID() == donorID) count += 1;
    }
    return count;
}


/**
 * Obtain sum of all donations
 * @return total sum of all donations
 */
public double totalDonationAmount(){
    double total = 0;
    for(Donation donation : donations)
        total += donation.getAmount();
    return total;
}


/**
 * Obtain sum of donations with donorID
 * @param donorID
 * @return total sum of donations
 */
public double totalDonationAmount(int donorID){
    double total = 0;
    for(Donation donation : donations){
        if(donation.getDonorID() == donorID) total += donation.getAmount();
    }
    return total;
}
  

    
    
}
