
package gofo;

/**
 *
 * @author youssef adel
 */
public class Slot {
    private int hour;
    private boolean isBooked = false;
    private boolean isAvailable ;
    public void setBookStatus(boolean status){
        isBooked = status;
    }
    public void setAvailble(boolean status){
        isAvailable = status;
    }
    public boolean getBookStatus(){
        return isBooked;
    }
    public boolean getAvailability (){
        return isAvailable;
    }
    public void setHour(int hour){
        this.hour = hour;
    }
    public int getHour (){
        return hour;
    }
}
