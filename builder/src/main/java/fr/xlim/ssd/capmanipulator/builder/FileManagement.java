package fr.xlim.ssd.capmanipulator.builder;

import java.io.File;
import java.net.URISyntaxException;

public class FileManagement {

    public static final File getModuleRoot() {
        try {
            File actual = new File(ClassLoader.getSystemResource(".").toURI());
            return new File(actual.getAbsolutePath() + "/../..");
        } catch (URISyntaxException ex) {
            throw new UnsupportedOperationException("wrong URI to module root", ex);
        }
    }

    public static final File getProjectRoot() {
        return new File(getModuleRoot().getAbsolutePath() + File.separator + "..");
    }
}
