
package gofo;

/**
 *
 * @author youssef adel
 */
public class Wallet {
    private float balance;
    public boolean withdraw(int amount){
        if (balance - amount < 0)
            return false;
        balance -= amount;
        return true;
    }
    public boolean deposit(int amount){
        if (amount <= 0)
            return false;
        balance +=amount;
        return true;
    }
}
