package capmap.bcel.applet001;

import javacard.framework.APDU;
import javacard.framework.ISOException;


public class FirstApplet extends javacard.framework.Applet {


    public FirstApplet() {
        super();
        register();
    }


    public static void install(byte[] aid, short s, byte b) {
        new FirstApplet();
    }

    public boolean select() {
        return true;
    }

    public void deselect() {

    }

    public void process(APDU apdu) throws ISOException {
    }

    public short meule(byte hellYeah){

        return 0x0042;
    }

    private APDU mEUSe(short[] epicTable){

        return null;
    }
}
