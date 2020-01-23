package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ImportComponent;
import fr.xlim.ssd.capmanipulator.library.PackageInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ImportComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof ImportComponent;
        ImportComponent importComponent = (ImportComponent) component;

        super.write(out, importComponent);

        out.writeByte(importComponent.getCount());

        for (PackageInfo aPackage : importComponent.getPackages()) {
            new PackageInfoWrite().write(out, aPackage);
        }
    }
}
