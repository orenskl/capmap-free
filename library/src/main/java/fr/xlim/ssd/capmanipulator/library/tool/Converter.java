/**
 * Converter.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
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

package fr.xlim.ssd.capmanipulator.library.tool;

import java.util.ArrayList;
import java.util.List;

/**
 * Convertion fonction
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 * @version 20090825
 */
public class Converter {

    /**
     * Convert Array of Byte to ASCII value
     *
     * @param bin Array of Byte
     * @return ASCII value
     */
    public static String bytes2ascii(ArrayList<Byte> bin) {

        if (bin == null) {
            return "";
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < bin.size(); ++i) {

            short nb = bin.get(i).byteValue();

            ret.append((char) (nb));

        }

        return ret.toString();

    }

    /**
     * Convert Array of Short to ASCII value
     *
     * @param s Array of Short
     * @return ASCII value
     */
    public static String shorts2ascii(ArrayList<Short> s) {

        if (s == null) {
            return "";
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < s.size(); ++i) {

            short nb = s.get(i).shortValue();

            if (nb >= 0x20) {
                ret.append((char) ((nb & 0xFF00) >> 8));
                ret.append((char) ((nb & 0x00FF)));
            } else {
                ret.append('.');
            }

        }

        return ret.toString();

    }

    /**
     * Convert String to Array Byte
     *
     * @param data ASCII value
     * @return Array of Byte
     */
    public static ArrayList<Byte> ascii2bytes(String data) {

        if (data == null) {
            return new ArrayList<Byte>();
        }

        ArrayList<Byte> a = new ArrayList<Byte>();
        byte[] b = data.getBytes();

        for (byte by : b) {
            a.add(by);
        }
        return a;
    }

    /**
     * Convert String to Array Byte
     *
     * @param data ASCII value
     * @return Array of Short
     */
    public static ArrayList<Short> ascii2shorts(String data) {

        if (data == null) {
            return new ArrayList<Short>();
        }

        ArrayList<Short> a = new ArrayList<Short>();
        byte[] b = data.getBytes();

        for (int i = 0; i < data.length(); ++i) {
            short s = (short) ((b[i] << 4) | b[++i]);
            a.add(s);
        }

        return a;
    }

    /**
     * Representation to Byte ArrayList
     *
     * @param bytes Array List
     * @return String representation in Hexa
     */
    public static String StringRepresentation(ArrayList<Byte> bytes) {

        if (bytes == null) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        int size = bytes.size();

        if (size == 0) {
            return "";
        }

        for (int i = 0; i < size - 1; ++i) {
            s.append("0x" + Integer.toHexString(bytes.get(i) & 0xff));
            s.append('.');
        }
        s.append("0x" + Integer.toHexString(bytes.get(size - 1) & 0xff));
        return s.toString();
    }

    /**
     * Representation to Short ArrayList
     *
     * @param shorts Array List
     * @return String representation in Hexa
     */
    public static String shortStringRepresentation(ArrayList<Short> shorts) {

        if (shorts == null) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        int size = shorts.size();

        if (size == 0) {
            return "";
        }

        for (int i = 0; i < size - 1; ++i) {
            s.append(Integer.toHexString(shorts.get(i) & 0xFFFF));
            s.append('.');
        }
        s.append(Integer.toHexString(shorts.get(size - 1) & 0xFFFF));
        return s.toString();
    }

    public static void addShortToArray(List<Short> array, Short shortValue) {

        if (array == null) {
            array = new ArrayList<Short>(shortValue);
        }

        if (shortValue == null) {
            return;
        }

        if (!array.contains(shortValue)) {
            array.add(shortValue);
        }
    }

    public static void addArrayToArray(List<Short> from, List<Short> to) {

        if (from == null) {
            return;
        }

        for (Short shortValue : from) {
            addShortToArray(to, shortValue);
        }
    }
}