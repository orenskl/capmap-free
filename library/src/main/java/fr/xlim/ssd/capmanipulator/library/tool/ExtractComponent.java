package fr.xlim.ssd.capmanipulator.library.tool;

import fr.xlim.ssd.capmanipulator.library.ComponentEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

public class ExtractComponent {

    private final static Logger logger = LoggerFactory.getLogger(ExtractComponent.class);

    public byte[] extractComponent(File capFile, ComponentEnum component) throws IOException {

        logger.debug("looking for componentTab {}", component.name());

        JarInputStream jarFile = null;

        DataInputStream dis = null;

        try {

            jarFile = new JarInputStream(new FileInputStream(capFile));

            // we check if the file is a jar file by trying to access to a new entry
            ZipEntry zipEntry = jarFile.getNextEntry();
            if (zipEntry != null) {
                logger.error("this file is a zipped CAP file");
                jarFile.close();
                throw new IllegalArgumentException("cannot accept zipped CAP file");
            }

            dis = new DataInputStream(new FileInputStream(capFile));

            boolean eof = false;

            while (!eof) {
                try {

                    byte tag = dis.readByte();

                    logger.debug("looking for tag {} (componentTab {})", tag, ComponentEnum.get(tag).name());

                    assert tag < ComponentEnum.values().length + 1;
                    assert tag > 0;

                    short size = dis.readShort();

                    logger.debug("componentTab size: {}", size);

                    if (tag == component.getValue()) {
                        logger.debug("found componentTab {} with size: {}", component.name(), size);

                        ByteBuffer bb = ByteBuffer.allocate(size + 2);
                        bb.putShort(size);
                        byte[] tab = new byte[size];
                        int val = dis.read(tab);
                        assert val == size;
                        bb.put(tab);

                        return bb.array();
                    }

                    dis.skipBytes(size);

                } catch (EOFException ex) {
                    eof = true;
                    logger.debug("found EOF");
                }
            }

        } finally {
            if (jarFile != null) {
                jarFile.close();
            }
            if (dis != null) {
                dis.close();
            }
        }

        return null;
    }
}
