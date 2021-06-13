
package gofo;

/**
 * an abstract class that have many attributes common between
 * class Owner and Player
 * @author youssef adel
 */
public abstract class person {
    protected String name;
    protected String password;
    protected String email;
    protected String phone;
    protected int id;    
    public person (){}
    public person(String pName, String pPassword, String pEmail, String pPhone){
        name = pName;
        password = pPassword;
        email = pEmail;
        phone = pPhone;        
    }        
    public abstract void displayInfo();
    /*
     * setters and getters functions
     */
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhone (String phone){
        this.phone = phone;
    }
    public String getphone (){
        return phone;
    }
    public void setId (int id){
        this.id = id;
    }
    public int getId (){
        return id;
    }
}
