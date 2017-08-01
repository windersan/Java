/*
 * Implement an ArrayList of Donors
 */
package cs310salemi;
import java.util.*;

/**
 *
 * @author Devin Andres Salemi
 */
public class DonorLogImpl {
    private ArrayList<Donor> donors;
    
   public int size(){return donors.size();}
        
    
    public DonorLogImpl(){
       
        
        donors = new ArrayList <Donor>();
    }
    
/**
 * Obtain the ArrayList attribute
 * @return donors array
 */     
    public ArrayList<Donor> getDonorList(){
        return donors;
    }
     
        
        
/**
 * Add donor to ordered list
 * @param i index of the array in front of where we will add the donor
 * @param donor
 */   
    public void add(int i, Donor donor){
        donors.add(i, donor);
    }
    
/**
 * Add donor to ordered list
 * @param donor
 */   
    public void add(Donor donor){
        donors.add(donor);
    }


/**
 * Remove donor with donorID from list
 * @param ID
 * @return true if successful
 */   
    public Boolean remove(int ID){
    Boolean removed = false;
  
    int index = 0;
  
    for(int i = 0; i < donors.size(); i++){
        if(donors.get(i).getID() == ID){
        index = i;
        } 
    }
    
    donors.remove(index);
    removed = true;
    return removed;
    }


/**
 * Test if donor with ID exists in list
 * @param ID
 * @return true if donorID exists in list
 */   
    public Boolean isIDUnique(int ID){
        
        for(Donor donor : donors){
            if(donor.getID() == ID) return false;
        }
        return true;
    }

        
  


}
