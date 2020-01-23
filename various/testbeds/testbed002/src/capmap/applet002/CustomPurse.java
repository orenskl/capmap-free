package capmap.applet002;

public class CustomPurse implements Purse{

    private short balance;

    public CustomPurse() {
        balance = 0;
    }

    public void setBalance(short Value) {
        balance = Value;
    }

    public short getBalance() {
        return balance;
    }

}
