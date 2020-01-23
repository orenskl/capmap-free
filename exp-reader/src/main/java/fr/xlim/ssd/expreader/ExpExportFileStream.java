package fr.xlim.ssd.expreader;


import java.io.*;

public class ExpExportFileStream {

    /// how many bytes have been read
    private int byteRead;
    private int totalByteRead;

    private String exportFileName;
    private File exportFile;

    private DataInputStream stream;

    public ExpExportFileStream(String filename) throws FileNotFoundException {
        exportFileName = filename;
		load();
    }

    public void load() throws FileNotFoundException {
		exportFile = new File(exportFileName);
        stream = new DataInputStream(getStream());
        totalByteRead = 0;
        byteRead = 0;
    }

    private InputStream getStream() throws FileNotFoundException {
        return new FileInputStream(exportFile);
    }

    /**
     * Read byte from stream
     *
     * @return byte reading
     */
    public byte readByte() throws IOException {
        byteRead += 1;
        totalByteRead += 1;
        return stream.readByte();
    }

    /**
     * Read Short from stream
     *
     * @return short reading
     */
    public short readShort() throws IOException {
        byteRead += 2;
        totalByteRead += 2;
        return stream.readShort();
    }

    /**
     * Read Int from stream
     *
     * @return int reading
     */
    public int readInt() throws IOException {
        byteRead += 4;
        totalByteRead += 4;
        return stream.readInt();
    }

    /**
     * Close File
     *
     */
    public void close() throws IOException {
        stream.close();
    }

    /**
     * Skip n byte
     *
     * @param size number of skip byte
     *
     */
    public void skipBytes(int size) throws IOException {
        totalByteRead += size;
        stream.skipBytes(size);
    }

    /**
     * method used to reset the values of number of byte read to zero.
     */
    public void resetCount() {
        byteRead = 0;
    }
    /**
     * method used to reset the values of number of total byte read to zero.
     */
    public void resetTotalCount() {
        byteRead = 0;
    }

    /**
     * Get number of byte read
     *
     * @return number byte read
     */
    public int getByteRead() {
        return byteRead;
    }

    /**
     * Get total number of byte read
     *
     * @return total number byte read
     */
    public int getTotalByteRead() {
        return totalByteRead;
    }
}