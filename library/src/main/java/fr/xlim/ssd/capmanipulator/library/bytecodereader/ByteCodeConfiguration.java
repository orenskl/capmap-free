/**
 * ByteCodeConfiguration.java
 * <p>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * Xlim - Université de Limoges
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

package fr.xlim.ssd.capmanipulator.library.bytecodereader;

import fr.xlim.ssd.capmanipulator.library.exceptions.*;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ByteCodeConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(ByteCodeConfiguration.class);

    private org.jdom.Document document;
    private Map<Byte, OpCode> mBytecode = new HashMap<Byte, OpCode>();

    /**
     * Constructor of ByteCodeReader
     *
     * @throws IOException
     * @throws JDOMException
     * @throws IllegalAttributeException
     * @throws TypeNotFoundException
     * @throws IllegalDestinationValue
     * @throws NumberFormatException
     * @throws IllegalValueException
     */
    public ByteCodeConfiguration() {
        this.parseXML();
    }

    /**
     * Parse XML file and load
     */
    private void parseXML() {
        try {
            SAXBuilder sxb = new SAXBuilder();
            this.document = sxb.build(ByteCodeConfiguration.class.getResourceAsStream("/bytecode.xml"));

            // Get the root tag
            Element root = this.document.getRootElement();

            // XML OpCodes List
            List listOpCode = root.getChildren("opcode");
            Iterator iT = listOpCode.iterator();

            while (iT.hasNext()) {
                Element current = (Element) iT.next();
                byte value = (byte) Integer.parseInt(current.getChildText("value"), 16);
                String name = FilterXMLData(current.getChildText("name"));
                ArrayList<Argument> parameters = new ArrayList<Argument>();

                Element params = current.getChild("parameters");
                if (params != null) {
                    List p = params.getChildren("parameter");
                    Iterator ip = p.iterator();

                    while (ip.hasNext()) {
                        Element e = (Element) ip.next();
                        org.jdom.Attribute aType = e.getAttribute("type");

                        if (aType == null) {
                            throw new TypeNotFoundException("Type not found in XML file for " + name + " value = " + value);
                        }
                        String type = FilterXMLData(aType.getValue());

                        if (type.equals("operand")) {

                            short s = (short) Integer.parseInt(e.getChild("size").getText());
                            boolean b = FilterXMLData(e.getChild("signed").getText()).equals("yes");
                            parameters.add(new Operand(null, s, b));

                        } else if (type.equals("offset")) {

                            short s = (short) Integer.parseInt(e.getChild("size").getText());
                            boolean b = FilterXMLData(e.getChild("signed").getText()).equals("yes");
                            Destination d = getDestination(FilterXMLData(e.getChild("destination").getText()));
                            parameters.add(new Offset(s, b, d));

                        } else if (type.equals("index")) {

                            short s = (short) Integer.parseInt(e.getChild("size").getText());
                            Destination d = getDestination(FilterXMLData(e.getChild("destination").getText()));
                            parameters.add(new Index(s, d));

                        } else if (type.equals("const")) {

                            short s = (short) Integer.parseInt(e.getChild("size").getText());
                            boolean b = FilterXMLData(e.getChild("signed").getText()).equals("yes");
                            String range = e.getChild("range").getText();
                            parameters.add(new Constant(s, b, range));

                        } else {
                            throw new IllegalAttributeException(type);
                        }

                    }
                }
                mBytecode.put(value, new OpCode(value, name, parameters));
            }
        } catch (IOException ex) {
            logger.error("IO error when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        } catch (IllegalAttributeException ex) {
            logger.error("illegal attribute when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        } catch (IllegalDestinationValue ex) {
            logger.error("illegal destination when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        } catch (IllegalValueException ex) {
            logger.error("illegal value when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        } catch (JDOMException ex) {
            logger.error("cannot parse DOM when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        } catch (NumberFormatException ex) {
            logger.error("number format problem when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        } catch (TypeNotFoundException ex) {
            logger.error("cannot found type when reading byte code configuration file", ex);
            throw new UnableToLoadByteConfigurationError(ex);
        }
    }

    /**
     * Filter XML field
     *
     * @param s XML field
     * @return XMLF field filtering
     * @throws IllegalValueException
     */
    private String FilterXMLData(String s) throws IllegalValueException {
        Pattern p = Pattern.compile("[\\w-]+");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return m.group();
        } else {
            throw new IllegalValueException(s + " is not un correct value !");
        }
    }

    private Destination getDestination(String s) throws IllegalDestinationValue {
        if (s.equals("current-frame")) {
            return Destination.CURRENT_FRAME;
        } else if (s.equals("stack")) {
            return Destination.STACK;
        } else if (s.equals("bytecode")) {
            return Destination.BYTECODE;
        } else if (s.equals("constantpool")) {
            return Destination.CONSTANT_POOL;
        }
        throw new IllegalDestinationValue("Illegal Destination value : (" + s + ")");
    }

    public org.jdom.Document getDocument() {
        return document;
    }

    public void setDocument(org.jdom.Document document) {
        this.document = document;
    }

    public Map<Byte, OpCode> getmBytecode() {
        return mBytecode;
    }

    public void setmBytecode(Map<Byte, OpCode> mBytecode) {
        this.mBytecode = mBytecode;
    }
}