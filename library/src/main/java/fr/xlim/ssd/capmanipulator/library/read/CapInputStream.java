/**
 * CapInputStream.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * <p>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.jar.JarException;
import java.util.jar.JarInputStream;
import java.util.zip.ZipEntry;

/**
 * @author Guillaume Bouffard
 * @author Julien Boutet
 * @author Julien Iguchi-Cartigny
 */
public class CapInputStream {

    private final static Logger logger = LoggerFactory.getLogger(CapInputStream.class);
    /// how many bytes have been read
    private int byteRead;
    /// is a JAR or a CAP file ?
    private boolean jarFile = false;
    private File capFile;
    private DataInputStream dataInputStream;
    private JarInputStream jarInputStream;
    private long capSize;
    private int totalByteRead;
    private boolean srcIsFile = true;
    private byte[] dataCapFile = null;

    public CapInputStream(File capFile) {
        this.capFile = capFile;
    }

    public CapInputStream(byte[] data) {
        this.dataCapFile = data;
        srcIsFile = false;
    }

    private InputStream getStream() throws UnableToReadCapFileException {
        if (srcIsFile) {
            try {
                capSize = capFile.length();
                return new FileInputStream(capFile);
            } catch (FileNotFoundException e) {
                logger.error("Cannot found CAP file", e);
                throw new UnableToReadCapFileException("cannot found CAP file", e);
            }
        } else {
            capSize = dataCapFile.length;
            return new ByteArrayInputStream(dataCapFile);
        }
    }

    public void load() throws UnableToReadCapFileException {

        try {

            InputStream inputStream = getStream();

            // we create a JarInputStream with this fileInputStream
            jarInputStream = new JarInputStream(inputStream);

            // we check if the file is a jar file by trying to access to a new entry
            ZipEntry zipEntry = jarInputStream.getNextEntry();

            if (zipEntry == null) {
                // if it's not a jar file we consider it as a binary cap file
                logger.debug("Detect binary CAP File");
                inputStream.close();
                logger.debug("Reopening CAP File");
                this.dataInputStream = new DataInputStream(getStream());
            } else {
                logger.debug("Detect JAR file");
                jarFile = true;
                // creation of a CapStream with the jarInputStream
                logger.debug("Reading the file using JAR input stream");
                this.dataInputStream = new DataInputStream(jarInputStream);

                // Give me the next Cap Component!
                while (!isCAPFileComponent(zipEntry)) {
                    zipEntry = jarInputStream.getNextEntry();
                }
            }

            totalByteRead = 0;
            byteRead = 0;

            assert dataInputStream != null;

        } catch (IOException e) {
            logger.error("Cannot read CAP file", e);
            throw new UnableToReadCapFileException("cannot read CAP file", e);
        }
    }

    private boolean isCAPFileComponent(ZipEntry entry) throws JarException {
        boolean found = false;
        try {
            String name = entry.getName();
            found = name.endsWith(".cap");
            logger.debug("checking JAR entry {} ({})", entry, (found ? "correct" : "incorrect"));
        } catch (java.lang.NullPointerException e) {
            logger.debug("checking an empty JAR entry");
            throw new JarException("Empty Entry");
        }
        return found;
    }

    public boolean getNextComponent() throws UnableToReadCapFileException {
        checkLoaded();
        if (jarFile) {
            logger.trace("getting next component in JAR file");
            try {
                ZipEntry zipEntry = jarInputStream.getNextEntry();
                if (zipEntry == null) {
                    logger.trace("no more component in JAR file");
                    return false;
                }
                // Give me the next Cap Component!
                while (!isCAPFileComponent(zipEntry)) {
                    zipEntry = jarInputStream.getNextEntry();
                }
                assert zipEntry != null;
                logger.trace("found next component in JAR file");
                return true;
            } catch (JarException ex) {
                logger.debug("No other component from JAR file");
                return false;
            } catch (IOException ex) {
                logger.error("Cannot get next component from JAR file", ex);
                throw new UnableToReadCapFileException("Cannot get next component from JAR file", ex);
            }
        } else {
            logger.trace("Read {} bytes in CAP file, file size is {}", totalByteRead, capSize);
            assert totalByteRead <= capSize;
            if (totalByteRead == capSize) {
                logger.trace("EOF of the CAP file ");
                return false;
            }
            logger.trace("getting next component in CAP file");
            return true;
        }
    }

    /**
     * Read byte dataInputStream Cap File
     *
     * @return byte reading
     * @throws UnableToReadCapFileException
     */
    public byte readByte() throws UnableToReadCapFileException {
        checkLoaded();
        try {
            byteRead += 1;
            totalByteRead += 1;
            return dataInputStream.readByte();
        } catch (IOException ex) {
            logger.error("Cannot read next byte", ex);
            throw new UnableToReadCapFileException("Cannot read next byte", ex);
        }
    }

    private void checkLoaded() throws UnableToReadCapFileException {
        if (dataInputStream == null) {
            logger.error("cap input stream has not been loaded, please call load() before");
            throw new UnableToReadCapFileException("cap input stream has not been loaded");
        }
    }

    /**
     * Read Short dataInputStream Cap FIle
     *
     * @return short reading
     * @throws UnableToReadCapFileException
     */
    public short readShort() throws UnableToReadCapFileException {
        checkLoaded();
        try {
            byteRead += 2;
            totalByteRead += 2;
            return dataInputStream.readShort();
        } catch (IOException ex) {
            logger.error("Cannot read next short", ex);
            throw new UnableToReadCapFileException("Cannot read next short", ex);
        }

    }

    /**
     * Read Int dataInputStream Cap File
     *
     * @return int reading
     * @throws UnableToReadCapFileException
     */
    public int readInt() throws UnableToReadCapFileException {
        checkLoaded();
        try {
            byteRead += 4;
            totalByteRead += 4;
            return dataInputStream.readInt();
        } catch (IOException ex) {
            logger.error("Cannot read next int", ex);
            throw new UnableToReadCapFileException("Cannot read next int", ex);
        }
    }

    /**
     * Close File
     *
     * @throws UnableToReadCapFileException
     */
    public void close() throws UnableToReadCapFileException {
        checkLoaded();
        try {
            dataInputStream.close();
        } catch (IOException ex) {
            logger.error("Cannot close stream", ex);
            throw new UnableToReadCapFileException("Cannot close stream", ex);
        }
    }

    /**
     * Skip n byte
     *
     * @param size number of skip byte
     * @throws UnableToReadCapFileException
     */
    public void skipBytes(int size) throws UnableToReadCapFileException {
        checkLoaded();
        try {
            totalByteRead += size;
            dataInputStream.skipBytes(size);
        } catch (IOException ex) {
            logger.error("Cannot skip {} bytes", size, ex);
            throw new UnableToReadCapFileException("Cannot skip bytes", ex);
        }
    }

    /**
     * method used to reset the values of number of byte read to zero.
     */
    public void resetCount() {
        byteRead = 0;
    }

    /**
     * Get number byte read
     *
     * @return number byte read
     */
    public int getByteRead() {
        return byteRead;
    }

    public int getTotalByteRead() {
        return totalByteRead;
    }
}
