
package gofo;

import java.util.ArrayList;


public class UsersList {
    private ArrayList <Player> playerList = new ArrayList<Player> ();
    private ArrayList <Owner> ownerList = new ArrayList<Owner> ();
    private ArrayList <Playground> playgroundList = new ArrayList<Playground> ();
    private int playerCount = 0;
    private int ownerCount = 0;
    private int playgroundCount = 0;
    /**
     * it is static member that manage the other classes to access the dataBase
     */
    public static UsersList DataBase = new UsersList();
    public boolean addPlayer(Player player){
        boolean status = playerList.add(player);
        playerCount++;
        return true;
    }
    public boolean addOwner(Owner owner){
        ownerList.add(owner);
        ownerCount++;
        return true;
    }
    public boolean addPlayground(Playground playground){
        playgroundList.add(playground);
        playgroundCount++;
        return true;
    }
    /**
     * it is a function to show us the playgrounds 
     * near specific city
     * @param city
     * @return true if there is playground near in this city
     */
    public boolean showPlaygroundByLoc(String city){
        boolean status = false;
        for (int i = 0; i<playgroundCount; i++){
            if (playgroundList.get(i).getLocation().compareToIgnoreCase(city) == 0){
                playgroundList.get(i).displayInfo();
                status = true;
            }
        }
        return status;
    }
    /**
     * by Id we now if the playground is exist or not
     * @param id
     * @return true if the id is exist and false if not
     */
    public boolean playgroundIsExist(int id){        
        for (int i = 0; i<DataBase.playgroundCount;i++){            
            if (DataBase.playgroundList.get(i).getId() == id)
                return true;
        }
        return false;
    }
    public ArrayList<Playground> getPlaygroundList(){
        return playgroundList;
    }
    public ArrayList<Owner> getOwnerList(){
        return ownerList;
    }
    public void displayPlayerList (){
        for (int i =0; i < playerCount; i++){
            playerList.get(i).displayInfo();
        }
    }
    public void displayOwnerList (){
        for (int i = 0; i<ownerCount;i++){
            ownerList.get(i).displayInfo();
        }
    }
    public void displayPlayground (){
        for (int i = 0; i<playgroundCount;i++){
            playgroundList.get(i).displayInfo();
        }
    }
    /**
     * it is used to access the static member DataBase
     * @return the DataBase to manage other classes to access dataBase
     */
    public UsersList getDataBase (){
    return DataBase;
    }
}
