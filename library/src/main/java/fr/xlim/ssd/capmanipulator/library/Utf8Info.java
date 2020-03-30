/**
 * UTF8_info.java
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

package fr.xlim.ssd.capmanipulator.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Utf8Info
 *
 * @author Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 */
public class Utf8Info implements Cloneable {
    // logger stream
    private final static Logger logger = LoggerFactory.getLogger(Utf8Info.class);
    // number of bytes in the string
    private short length;
    // byte of the string in the UTF8 format
    private ArrayList<Byte> bytes = new ArrayList<Byte>();

    /**
     * Getter on UTF8 String Length
     *
     * @return UTF8 String Length
     */
    public short getLength() {
        return length;
    }

    /**
     * Setter on UTF8 String Length
     *
     * @param length UTF8 String Length
     */
    public void setLength(short length) {
        this.length = length;
    }

    /**
     * Getter on the UTF8 bytes
     *
     * @return the UTF8 String bytes
     */
    public ArrayList<Byte> getBytes() {
        return bytes;
    }

    /**
     * Setter on the UTF8 String Bytes
     *
     * @param bytes The UTF8 String Bytes
     */
    public void setBytes(ArrayList<Byte> bytes) {
        this.bytes = bytes;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Utf8Info out = new Utf8Info();

        out.length = this.length;

        ArrayList<Byte> bytes = new ArrayList<Byte>();
        for(byte b: this.bytes) {
            bytes.add(b);
        }
        out.bytes = bytes;

        return out;
    }
}
