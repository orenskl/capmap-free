package fr.xlim.ssd.capmanipulator.bcel;

import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.read.CapFileRead;
import fr.xlim.ssd.capmanipulator.library.read.CapInputStream;

import java.io.File;


public class CapFileFactory {

	private static CapFile capFile;

	public static void loadCapFile(String path) throws UnableToReadCapFileException {
		capFile = (new CapFileRead(new CapInputStream(new File(path))).load());
	}

	public static CapFile getCapFile() {
		return capFile;
	}
}
