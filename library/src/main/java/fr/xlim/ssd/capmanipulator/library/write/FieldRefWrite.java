package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.FieldRef;
import fr.xlim.ssd.capmanipulator.library.InstanceField;
import fr.xlim.ssd.capmanipulator.library.StaticField;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class FieldRefWrite {

    public void write(CapOutputStream out, FieldRef fieldRef) throws UnableToWriteCapFileException {
        if (fieldRef instanceof InstanceField) {
            InstanceField instanceField = (InstanceField) fieldRef;
            // class writing
            new ClassRefWrite().write(out, instanceField.getClass_());

            // token writing
            out.writeByte(instanceField.getToken());
        } else if (fieldRef instanceof StaticField) {
            StaticField staticField = (StaticField) fieldRef;
            // static field writing
            new StaticFieldRefWrite().write(out, staticField.getStaticFieldRef());
        } else {
            throw new IllegalArgumentException("unexpected field ref");
        }
    }
}
