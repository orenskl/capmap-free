package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassComponent;
import fr.xlim.ssd.capmanipulator.library.ClassInfo;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.InterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ClassComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof ClassComponent;
        ClassComponent classComponent = (ClassComponent) component;

        super.write(out, classComponent);

        // TODO: idem que pour le load, comprend pourquoi pas de signature
        // PoolLength
        /*
         * out.writeShort(signaturePoolLength);
         *
         * for(TypeDescriptor td : signaturePool){ td.write(out); }
         */

        for (InterfaceInfo iInf : classComponent.getInterfaces()) {
            new InterfaceInfoWrite().write(out, iInf);
        }

        for (ClassInfo cInf : classComponent.getClasses()) {
            new ClassInfoWrite().write(out, cInf);
        }
    }
}
