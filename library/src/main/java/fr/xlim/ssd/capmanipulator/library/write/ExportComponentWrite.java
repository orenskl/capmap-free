package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.ClassExportsInfo;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ExportComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ExportComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof ExportComponent;
        ExportComponent exportComponent = (ExportComponent) component;

        //tag and size writing
        super.write(out, exportComponent);

        //class count writing
        out.writeByte(exportComponent.getClassCount());

        //class exports writing
        for (ClassExportsInfo c : exportComponent.getClassExports()) {
            new ClassExportsInfoWrite().write(out, c);
        }
    }
}
