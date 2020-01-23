package capmap.applet003;

import javacard.framework.OwnerPIN;

public class PersoPin extends OwnerPIN{

    PersoPin(byte tryLimit, byte maxPINSize){
        super(tryLimit, maxPINSize);
        super.setValidatedFlag(true);

    }

}