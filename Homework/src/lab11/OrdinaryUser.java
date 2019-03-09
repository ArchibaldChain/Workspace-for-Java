package lab11;



public class OrdinaryUser extends User {

    private int balance;

    public OrdinaryUser(String username, String password) {
        super(username, password);
        this.balance = 0;
    }

    public void pay(int money){
        if(balance - money >= 0){
            balance -= money;
        }
        else
            System.out.println("balance is not enough ");
    }

    public void recharge(int money){
        balance += money;
    }

    @Override
    public String toString() {
        return "OrdinaryUser [balance="+balance+","+super.toString()+"]";
    }
}
