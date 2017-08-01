/*
 * This class is for a donation
 */
package cs310salemi;

import java.util.Objects;

/**
 *
 * @author Devin Andres Salemi
 */
public class Donation {

    private int myID;
    private int myDonorID;
    private String myDescription;
    private double myAmount;
    private String myDate;
    private Boolean isDeductible;
    private int myCheckNumber;
    
   
    
    
    
    public Donation() {
        isDeductible = true;
    }

    public Donation(int myID, int myDonorID, String myDescription, double 
            myAmount, String myDate, Boolean isDeductible, int myCheckNumber) {
        this.myID = myID;
        this.myDonorID = myDonorID;
        this.myDescription = myDescription;
        this.myAmount = myAmount;
        this.myDate = myDate;
        this.isDeductible = isDeductible;
        this.myCheckNumber = myCheckNumber;
    }

    public int getID() {
        return myID;
    }

    public int getDonorID() {
        return myDonorID;
    }

    public String getDescription() {
        return myDescription;
    }

    public double getAmount() {
        return myAmount;
    }

    public String getDate() {
        return myDate;
    }

    public Boolean getIsDeductible() {
        return isDeductible;
    }

    public int getCheckNumber() {
        return myCheckNumber;
    }

    public void setID(int myID) {
        this.myID = myID;
    }

    public void setDonorID(int myDonorID) {
        this.myDonorID = myDonorID;
    }

    public void setDescription(String myDescription) {
        this.myDescription = myDescription;
    }

    public void setAmount(double myAmount) {
        this.myAmount = myAmount;
    }

    public void setDate(String myDate) {
        this.myDate = myDate;
    }

    public void setIsDeductible(Boolean isDeductible) {
        this.isDeductible = isDeductible;
    }

    public void setCheckNumber(int myCheckNumber) {
        this.myCheckNumber = myCheckNumber;
    }

  
    /**
     * Compare two donations
     * @param obj
     * @return true if equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Donation other = (Donation) obj;
        if (this.myID != other.myID) {
            return false;
        }
        if (this.myDonorID != other.myDonorID) {
            return false;
        }
        if (Double.doubleToLongBits(this.myAmount) != Double.doubleToLongBits(
                other.myAmount)) {
            return false;
        }
        if (this.myCheckNumber != other.myCheckNumber) {
            return false;
        }
        if (!Objects.equals(this.myDescription, other.myDescription)) {
            return false;
        }
        if (!Objects.equals(this.myDate, other.myDate)) {
            return false;
        }
        if (!Objects.equals(this.isDeductible, other.isDeductible)) {
            return false;
        }
        return true;
    }

    /**
     * Create a string with all attributes
     * @return 
     */
    @Override
    public String toString() {
        return "Donation{" + "myID=" + myID + ", myDonorID=" + myDonorID + 
                ", myDescription=" + myDescription + ", myAmount=" + myAmount +
                ", myDate=" + myDate + ", isDeductible=" + isDeductible + ", "
                + "myCheckNumber=" + myCheckNumber + '}';
    }
 
    
     /**
     * Check if the check number is between 100 and 5000 exclusive
     * @return rangeIsCorrect - true if the check number is in the proper range
     */
    public Boolean checkNumberRange(){
       Boolean rangeIsCorrect = true;
       
       if(myCheckNumber <= 100 || myCheckNumber >= 5000)
           rangeIsCorrect = false;
       
       return rangeIsCorrect;
    }
    
    
    
    
    
}
