
package gofo;

import java.util.ArrayList;


public class Player extends person {
    /**
     * it is an object of database class(UsersList)
     * to manage the player class to access the database
     */
    private UsersList connection = new UsersList();
    private String defLocation;
    private Wallet wallet;
    private ArrayList < Player> favTeam;
    public static int count = 0;    
    public Player(String pName, String pPassword, String pEmail, String pPhone, String pAddress) {
        super(pName, pPassword, pEmail, pPhone);
        defLocation = pAddress;
        id = ++ count;
    }
    public Player (){
        id = ++count;
    }
    /**
     * the register function is to manage the player to register and save it to the database
     * @param name
     * @param password
     * @param email
     * @param phone
     * @param address
     * @return 
     */
    public boolean register (String name, String password, String email, String phone, String address){
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        defLocation = address;                                
        if (connection.getDataBase().addPlayer(this))
            return true;
        else
            return false;
    }
    public boolean book (int id,int hour){
        boolean playgroundExist, availToBook;
        playgroundExist = connection.getDataBase().playgroundIsExist(id);
        availToBook = connection.getDataBase().getPlaygroundList().get(id - 1).canBookAtSlot(hour);
        if (playgroundExist == true)
            System.out.println("hello maaaaaan");
        if (availToBook == true)
            System.out.println("how are you");
        if (playgroundExist && availToBook){                                    
            connection.getDataBase().getPlaygroundList().get(id - 1).getAvailHour()[hour - 1].setBookStatus(true);
            return true;
        }          
        else
            return false;                        
    }
    @Override
    public void displayInfo (){
        System.out.println("player id is " + id + "\n" +
        "name: " + name + "\n" + "email: " + email + "\n" + "phone: " + phone 
        + "\n" + "address: " + defLocation + "\n");
    }
    void setDefaultLoc (String defLoc){
        defLocation = defLoc;
    }
    String getDefaultLoc (){
        return defLocation;
    }            
}
