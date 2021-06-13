package gofo;

/**
 *
 * @author youssef adel
 */
public class Owner extends person {

    /**
     * it is an object of database class(UsersList) to manage the Owner class to
     * access the database
     */
    private UsersList connection = new UsersList();
    private String defLocation;
    private Wallet wallet;
    private Playground playground = new Playground();

    /**
     *
     */
    public static int count = 0;

    /**
     *
     */
    public Owner() {
        id = ++count;
    }

    /**
     * function register to manage the owner to refister
     *
     * @param name
     * @param password
     * @param email
     * @param phone
     * @param address
     * @return true if the process has been successful and false if not
     */
    public boolean register(String name, String password, String email, String phone, String address) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        defLocation = address;
        if (connection.getDataBase().addOwner(this)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * overriden function that display info of the owner
     */
    @Override
    public void displayInfo() {
        System.out.println("Owner id is " + id + "\n"
                + "name: " + name + "\n" + "email: " + email + "\n" + "phone: " + phone
                + "\n" + "address: " + defLocation + "\n");
    }

    /**
     * add playeground and assign it to this owner
     *
     * @param name
     * @param location
     * @param size
     * @param price
     * @param cancelPeriod
     */
    public void addPlayground(String name, String location, float size, int price, int cancelPeriod) {
        playground = new Playground();
        playground.register(name, location, size, price, cancelPeriod);
    }

    /**
     *
     * @return
     */
    public Playground getPlayground() {
        return playground;
    }
}
