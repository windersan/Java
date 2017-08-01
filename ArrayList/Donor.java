/*
 * This class is for a donor.
 */
package cs310salemi;

import java.util.Objects;

/**
 *
 * @author Devin Andres Salemi
 */
public class Donor {
    
    
    private int myID;
    private String myFirstName;
    private String myLastName;
    private String myPhoneNumber;
    private String myEmailAddress;
    
    private String myGoldStar;
   

    
    public Donor() {
        
    }

    public Donor(int myID, String myFirstName, String myLastName, String 
            myPhoneNumber, String myEmailAddress) {
        this.myID = myID;
        this.myFirstName = myFirstName;
        this.myLastName = myLastName;
        this.myPhoneNumber = myPhoneNumber;
        this.myEmailAddress = myEmailAddress;
        this.myGoldStar = " ";
    }

    
    public String getGoldStar(){
        return myGoldStar;
    }
    
    public int getID() {
        return myID;
    }

    public String getFirstName() {
        return myFirstName;
    }

    public String getLastName() {
        return myLastName;
    }

    public String getPhoneNumber() {
        return myPhoneNumber;
    }

    public String getEmailAddress() {
        return myEmailAddress;
    }

    public void setID(int myID) {
        this.myID = myID;
    }

    public void setFirstName(String myFirstName) {
        this.myFirstName = myFirstName;
    }

    public void setLastName(String myLastName) {
        this.myLastName = myLastName;
    }

    public void setPhoneNumber(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    public void setEmailAddress(String myEmailAddress) {
        this.myEmailAddress = myEmailAddress;
    }
    
    public void setGoldStar(String goldStar){
        this.myGoldStar = goldStar;
    }

    /**
     * Compare two donors
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
        final Donor other = (Donor) obj;
        if (this.myID != other.myID) {
            return false;
        }
        if (!Objects.equals(this.myFirstName, other.myFirstName)) {
            return false;
        }
        if (!Objects.equals(this.myLastName, other.myLastName)) {
            return false;
        }
        if (!Objects.equals(this.myPhoneNumber, other.myPhoneNumber)) {
            return false;
        }
        if (!Objects.equals(this.myEmailAddress, other.myEmailAddress)) {
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
        return "Donor{" + "myID=" + myID + ", myFirstName=" + myFirstName + 
                ", myLastName=" + myLastName + ", myPhoneNumber=" + 
                myPhoneNumber + ", myEmailAddress=" + myEmailAddress + '}';
    }
    
    
    /**
     * Check if the donor email address contains the "@" character
     * @return hasAt 
     */
    public Boolean validateEmail(){
        Boolean hasAtSign = myEmailAddress.contains("@");
        return hasAtSign;
    }
    
    
    
    
    
}
