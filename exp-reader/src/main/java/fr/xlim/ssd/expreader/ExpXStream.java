package fr.xlim.ssd.expreader;

import com.thoughtworks.xstream.*;
import java.io.*;

/**
 * Class allowing serialization and de-serialization of a object to/from a XML file.
 */
public class ExpXStream {

    XStream xstream;
    String xml;

    public ExpXStream() {
        xstream = new XStream();
    }

    /**
     * Creates a new ExpXStream and load a serialized object from a XML file.
     *
     * @param fileName  the path to an XML file containing a object.
     * @throws IOException
     */
    public ExpXStream(String fileName) throws IOException {
        xstream = new XStream();
        this.loadFromFile(fileName);
    }

    /**
     * Loads a serialized object from a XML file.
     *
     * @param   fileName  the path to an XML file containing a object.
     * @throws  IOException
     */
    public void loadFromFile(String fileName) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
        StringWriter out = new StringWriter();
        int b;
        while ((b=in.read()) != -1)
           out.write(b);
        out.flush();
        out.close();
        in.close();
        xml = out.toString();
    }

    /**
     * Saves a serialized object into a XML file.
     *
     * @param   fileName    the path to an XML file.
     * @throws  IOException
     */
    public void saveIntoFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(xml.getBytes());
        outputStream.close();
    }

    /**
     * De-serializes an object from a XML string.
     *
     * @return  the object previoulsy loaded from a file
     */
    public Object fromXML() {
        return xstream.fromXML(xml);
    }

    /**
     * Serializes an object into a XML string.
     *
     * @param object
     */
    public void toXML(Object object) {
        xml = xstream.toXML(object);
    }
}
