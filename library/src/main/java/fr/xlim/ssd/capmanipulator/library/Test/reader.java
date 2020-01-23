package fr.xlim.ssd.capmanipulator.library.Test;

import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.read.CapFileRead;
import fr.xlim.ssd.capmanipulator.library.read.CapInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class reader {

    // Logger stream
    private final static Logger logger = LoggerFactory.getLogger(reader.class);

    public static void main(String[] args) {
        File f = new File("CAP FILE TO OPEN");
        CapInputStream cis = new CapInputStream(f);
        CapFileRead cfr = new CapFileRead(cis);
        CapFile cap = null;
        try {
            cap = cfr.load();
        } catch (UnableToReadCapFileException e) {
            logger.error("Erreur in loading?", e);
        }

        logger.info(cap.toString());

    }

}
