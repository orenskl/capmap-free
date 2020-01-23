/**
 * Offset.java
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

package fr.xlim.ssd.capmanipulator.library.bytecodereader;

/**
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class Offset extends Argument {

    private Destination destination;

    public Offset(byte[] value, boolean signed, Destination destination) {
        super(value, signed);
        this.destination = destination;
    }

    protected Offset(short expected_short, boolean signed, Destination destination) {
        super(expected_short, signed);
        this.destination = destination;
    }

    /**
     * @return the destination
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    @Override
    public Object clone() {

        Argument a = (Argument) super.clone();
        return new Offset(a.getValue(), a.isSigned(), destination);
    }

    public String toString() {

        String ret = "";

        Integer intValue = 0;

        /*
         * for (int i = 0; i < this.getSize(); i++) { ret +=
         * Integer.toHexString(this.getValue()[i]);
        }
         */

        for (int i = this.getSize() - 1; i >= 0; i--) {
            if (isSigned()) {

                if (i != 0) {
                    intValue += (this.getValue()[i] & 0xff) << ((this.getSize() - 1 - i) * 8);
                } else {
                    intValue += (this.getValue()[i]) << ((this.getSize() - 1 - i) * 8);
                }
            } else {
                intValue += (this.getValue()[i] & 0xff) << ((this.getSize() - 1 - i) * 8);
            }

        }

        ret += "// rel:";
        if (intValue < 0) {
            ret += "-";
        } else {
            ret += "+";
        }
        ret += intValue;


        return ret;
    }
}
