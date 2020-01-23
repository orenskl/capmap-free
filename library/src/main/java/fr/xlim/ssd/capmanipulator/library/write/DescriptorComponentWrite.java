package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.DescriptorComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class DescriptorComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof DescriptorComponent;
        DescriptorComponent descriptorComponent = (DescriptorComponent) component;

        // write tag and size
        super.write(out, descriptorComponent);

        // class count writing
        out.writeByte(descriptorComponent.getClassCount());

        // classes writing
        for (ClassDescriptorInfo c : descriptorComponent.getClasses()) {
            new ClassDescriptorInfoWrite().write(out, c);
        }

        // types writing
        new TypeDescriptorInfoWrite().write(out, descriptorComponent.getTypes());
    }

}
