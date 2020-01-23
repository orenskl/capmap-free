package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CapOutputStream {

    private final static Logger logger = LoggerFactory.getLogger(CapOutputStream.class);
    private final DataOutputStream out;

    public CapOutputStream(OutputStream outputStream) {
        this.out = new DataOutputStream(outputStream);
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void writeShort(short val) throws UnableToWriteCapFileException {
        try {
            out.writeShort(val);
        } catch (IOException e) {
            logger.error("Cannot write short in CAP file", e);
            throw new UnableToWriteCapFileException("cannot write short in CAP file", e);
        }
    }

    public void writeByte(byte b) throws UnableToWriteCapFileException {
        try {
            out.writeByte(b);
        } catch (IOException e) {
            logger.error("Cannot write byte in CAP file", e);
            throw new UnableToWriteCapFileException("cannot write byte in CAP file", e);
        }
    }

    public void writeInt(int i) throws UnableToWriteCapFileException {
        try {
            out.writeInt(i);
        } catch (IOException e) {
            logger.error("Cannot write int in CAP file", e);
            throw new UnableToWriteCapFileException("cannot write int in CAP file", e);
        }
    }

    public void close() throws UnableToWriteCapFileException {
        try {
            out.close();
        } catch (IOException e) {
            logger.error("Cannot close CAP file", e);
            throw new UnableToWriteCapFileException("cannot close CAP file", e);
        }
    }
}
