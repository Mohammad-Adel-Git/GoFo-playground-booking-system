
package gofo;
import java.util.ArrayList;
import java.util.Scanner;
public class GoFo {
    
    public static byte choice (){
        Scanner input = new Scanner(System.in);
        byte choice;
        choice = input.nextByte();
        return choice;
    }
    public static void main(String[] args) {
        UsersList dataBase = new UsersList();
        Scanner input =new Scanner(System.in);
        boolean registrationFlag = true;
        while(registrationFlag){
            System.out.println("you want to register as: \n 1-player \n 2-owner \n 3- Exit");
            int choice = input.nextInt();        
            String name, password, email, phone, address; 
            System.out.println("enter the name-password-email-phone-address in this oreder \n");
            name = input.next();
            password = input.next();
            email = input.next();
            phone = input.next();
            address = input.next();        
            switch(choice){
                ///////////   Player  /////////////
                case 1:          
                    Player player = new Player(); 
                    if (player.register(name, password, email, phone, address))                    
                        System.out.println("you registered successfuly");
                    else
                        System.out.println("you registered failed");
                    dataBase.getDataBase().displayPlayerList();
                    
                        System.out.println("choose from the list below \n"
                                + "1- book a playground \n"                  
                                + "2- go back to the registration page menu");
                        boolean bookingFlag = true;
                        while(bookingFlag){
                            switch (choice()){
                                case 1:     //book playground
                                    System.out.println("choose your city like 'giza cairo alex...'"
                                        + "and we will show you the playground near you ");
                                    String city = input.next();
                                    if(dataBase.getDataBase().showPlaygroundByLoc(city));
                                    else
                                        System.out.println("Sorry there is no playgrounds near you");
                                    System.out.println
                                        ("if you want to book a palyground enter its id and the slot you want \n" 
                                        + "and if you want to go back enter 0");
                                    int playgroundId, slot;
                                    playgroundId =input.nextInt();
                                    slot = input.nextInt();
                                    if ( playgroundId == 0 ){
                                        bookingFlag = false;
                                    }

                                    if (player.book(playgroundId, slot)){                                    
                                        System.out.println("the booking process has been completed successfully");
                                    }
                                    dataBase.getDataBase().displayPlayground();
                                    break;
                                case 2:
                                    bookingFlag = false;
                                    break;
                            }
                        } 
                ////// Owner    ///////////
                case 2:
                    Owner owner = new Owner();
                    
                    if (owner.register(name, password, email, phone, address))
                        System.out.println("you registered successfuly");
                    else
                        System.out.println("you registered failed");
                    dataBase.getDataBase().displayOwnerList();
                    System.out.println("adding a playground......!");
                    String pgName,pgLocation;
                    float size;
                    int pgCancelPeriod, pgPrice;
                    System.out.println("enter the name, location, size, price and cancelationPeriod "
                            + "with hours of your playground with the pervious order");
                    pgName = input.next();
                    pgLocation = input.next();
                    size = input.nextFloat();
                    pgPrice = input.nextInt();                
                    pgCancelPeriod = input.nextInt();
                    if (owner.getPlayground().register(pgName, pgLocation, size, pgPrice, pgCancelPeriod))
                        System.out.println("the info of the playgroun is added");
                    else
                        System.out.println("an erroe ocuured while registration try again");
                    System.out.println("now you need to enter the availble hours"
                            + "you have max 24 slots so enter at max 24 hour or when you finish enter zero or higher than 24");
                    for (int i = 0; i<24; i++){
                        Slot slot = new Slot();
                        int hour = input.nextInt();
                        if (hour == 0 || hour >24)
                            break;
                        else{
                              owner.getPlayground().changeAvailHour(hour, true);                              
                        }                    
                    }                                                            
                    dataBase.getDataBase().displayPlayground();
                    System.out.println("Congratulation your playground has been added to our system" );
                    break;
                    //////////    Exit    //////
                case 3:     
                    registrationFlag =false;
                    break;
            }
        }    
    }    
}



