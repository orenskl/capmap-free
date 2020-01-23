import fr.xlim.ssd.expreader.ExpExportFile;
import fr.xlim.ssd.expreader.ExpExportFileStream;

import java.io.IOException;

/**
 * ${FILE_NAME}.java
 * <p/>
 * Author: Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 * Date: 7/17/13 2:44 PM
 * <p/>
 * TODO
 */
public class Main {

    public static void main(String args[]) throws IOException {

        ExpExportFileStream expExportFileStream = new ExpExportFileStream("/home/stroumph/works/repos/ssd-jcvm/samples/classes/javacard/framework/javacard/framework.exp");
        // ExpExportFileStream expExportFileStream = new ExpExportFileStream("/home/stroumph/works/projects/Attacks/Man_in_the_middle/crypto/javacard/security/javacard/security.exp");
        ExpExportFile expExportFile = new ExpExportFile(expExportFileStream);

        System.out.print(expExportFile.toString());
    }
}
