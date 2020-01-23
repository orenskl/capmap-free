package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ConstantPoolComponent;
import fr.xlim.ssd.capmanipulator.library.ConstantPoolInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ConstantPoolComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof ConstantPoolComponent;
        ConstantPoolComponent constantPoolComponent = (ConstantPoolComponent) component;

        super.write(out, constantPoolComponent);

        out.writeShort(constantPoolComponent.getCount());

        for (ConstantPoolInfo aCp : constantPoolComponent.getConstantPool()) {
            new ConstantPoolInfoWrite().write(out, aCp);
        }
    }
}
