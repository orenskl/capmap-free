package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.library.*;

import java.util.ArrayList;

public class CapInterface extends CapClassOrInterface {

    InterfaceInfo interfaceInfo;

    public CapInterface(InterfaceInfo interfaceInfo) {
        this.interfaceInfo = interfaceInfo;
    }

    public ArrayList<Byte> getName(){

        if (!this.isRemote()){
            return null;
        }
        return interfaceInfo.getInterfaceNameInfo().getInterfaceName();
    }

    public boolean isShareable(){

        return ((interfaceInfo.getBitfield() & ClassComponent.ACC_SHAREABLE) > 0);
    }

    public boolean isRemote(){

        return ((interfaceInfo.getBitfield() & ClassComponent.ACC_REMOTE) > 0);
    }

    public ArrayList getSuperInterfaces(){

        return interfaceInfo.getSuperInterfaces();
    }
}
