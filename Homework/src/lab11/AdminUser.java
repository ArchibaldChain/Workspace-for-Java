package lab11;



public class AdminUser extends User {
    public AdminUser(String username, String passoword) {
        super(username, passoword);
    }

    public void resetPassword(OrdinaryUser ordinaryUser){
        ordinaryUser.setPassword("13456");
    }

    @Override
    public String toString() {
        return "AdminUser "+super.toString();
    }
}