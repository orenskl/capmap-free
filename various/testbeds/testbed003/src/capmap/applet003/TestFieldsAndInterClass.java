package capmap.applet003;

import javacard.framework.APDU;
import javacard.framework.ISOException;
import javacard.framework.ISO7816;
import sim.toolkit.EditHandler;

public class TestFieldsAndInterClass extends javacard.framework.Applet{

    //Variables
    private byte meule = 2;
    public boolean aku = true;
    protected short meuse = 0;
    //final int meGusta = 42;
    private final static short staticField = 0x42;  //Static field
    private final static short initBalance = 100;
    public EditHandler editHandlerField;    //usage of SIM API
    private PersoPin PinCode;
    private CustomPurse purse;

    public TestFieldsAndInterClass() {
        super();
        PinCode = new PersoPin((byte) 0x03, (byte) 0x08);
        purse = new CustomPurse();
        register();
    }

    public static void install(byte[] aid, short s, byte b){
        new TestFieldsAndInterClass();
    }

    public boolean select(){
      return true;
    }

    public void deselect(){
    }

    public void process(APDU apdu){

        short var01 = staticField;

        try {
            verify(var01);
        }
        catch (CustomException e) {
            ISOException.throwIt(ISO7816.SW_UNKNOWN);
        }

        purse.setBalance(initBalance);
    }

    public void verify(short value) throws CustomException{
        if(value != staticField)
            throw new CustomException();
    }
}