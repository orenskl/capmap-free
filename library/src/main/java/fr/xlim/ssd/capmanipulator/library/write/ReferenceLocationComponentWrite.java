package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ReferenceLocationComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class ReferenceLocationComponentWrite extends ComponentWrite {

    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert component instanceof ReferenceLocationComponent;
        ReferenceLocationComponent referenceLocationComponent = (ReferenceLocationComponent) component;

        // tag and size writing
        super.write(out, referenceLocationComponent);

        // byte index count writing
        out.writeShort(referenceLocationComponent.getByteIndexCount());

        // offsets to byte indices writing
        for (byte b : referenceLocationComponent.getOffsetsToByteIndices()) {
            out.writeByte(b);
        }

        // byte 2 index count writing
        out.writeShort(referenceLocationComponent.getByte2IndexCount());

        // offsets to byte 2 indices writing
        for (byte b : referenceLocationComponent.getOffsetsToByte2Indices()) {
            out.writeByte(b);
        }
    }
}
