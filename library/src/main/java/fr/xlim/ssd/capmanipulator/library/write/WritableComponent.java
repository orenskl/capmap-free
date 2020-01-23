package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public interface WritableComponent {

    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException;
}
