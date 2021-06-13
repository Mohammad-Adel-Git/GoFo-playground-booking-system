
package gofo;

import java.util.ArrayList;

/**
 *
 * @author youssef adel
 */
public class Playground {
    /**
     * it is an object of database class(UsersList)
     * to manage the Playground class to access the database
     */
    private UsersList connection = new UsersList();
    private String name;
    private String location;
    private float size;
    private Slot availableHour[] = new Slot[24] ;
    //private ArrayList <Slot> availableHour = new ArrayList<>(24);
    private int pricePerHour;
    private int cancelPeriod;
    private boolean isActive;
    private int id;
    public static int count = 0;
    public Playground (){
        for (int i =0; i<24; i++){
            availableHour[i] = new Slot();
            availableHour[i].setAvailble(false);
            availableHour[i].setHour(i+1);
        }
        id = ++count;
    }  
    /**
     * it is a function to register a new playground
     * @param pName
     * @param pLocation
     * @param pSize
     * @param pPricePerHour
     * @param pCancelPeriod
     * @return 
     */
    public boolean register(String pName, String pLocation, float pSize, int pPricePerHour, int pCancelPeriod){
        name = pName;
        location = pLocation;
        size = pSize;
        pricePerHour = pPricePerHour;
        cancelPeriod = pCancelPeriod;
        if (connection.getDataBase().addPlayground(this))
            return true;
        else
            return false;
    }
    public boolean isActive(){
       return isActive;
    }
    /**
     * to change the availability of a praticular slot 
     * @param hour the slot
     * @param status the status : it is true of false
     */
    public void changeAvailHour(int hour, boolean status){
        connection.getDataBase().getPlaygroundList().get( id -1 ).getAvailHour()[hour - 1].setAvailble(true);
    }
    public Slot[] getAvailHour(){                
        return availableHour;
    }
    /**
     * to check if a slot can be booked or not
     * @param slot
     * @return true if we can book the slot and false if it is not
     */
    public boolean canBookAtSlot (int slot){
        Slot targetedSlot = this.getAvailHour()[slot - 1];
        if ( targetedSlot.getAvailability() && ( ! targetedSlot.getBookStatus()))
            return true;
        return false;
    }
    /**
     * function to display the info of the plaground
     */
    public void displayInfo(){
        System.out.println("playground id is " + id + "\n" + "name: " + name + "\n" 
        +"location: " + location + "\n" + "size: " + size + "\n" + "pricePerHour: " + pricePerHour
        + "\n" + "cancellation period: " + cancelPeriod + "\n" );
        System.out.println("The Available hour");
        for (int i=0; i<24; i++){
            if (availableHour[i].getAvailability() == true){
                System.out.print(availableHour[i].getHour());
                if (availableHour[i].getBookStatus() == true)
                    System.out.println(" booked");
                else
                    System.out.print(" availble to be booked \n");                            
            }
        }
    }
    /*
    public boolean isBooked(int slot){
        
    }
    */
    
    /*
     * Setter and getters of playground Class
     */
    
    public void setname (String name){
        this.name = name;
    }
    public String get (){
        return name;
    }
    public void setLocation (String location){
        this.location = location;
    }
    public String getLocation (){
        return location;
    }    
    public void setSize(float size){
        
    }
    public float getSize(){
        return size;
    }
    public void setPricePerHour(int price){
        this.pricePerHour = price;
    }
    public int getPricePerHour (){
        return pricePerHour;
    }
    public void setCancelPeriod (int period){
        this.cancelPeriod = period;
    }
    public int getCancelPeriod (){
        return cancelPeriod;
    }
    public void setId (int id){
        this.id = id;
    }
    public int getId (){
        return id;
    }              
}
