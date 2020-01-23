/**
 * CustomComponent.java
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

import java.util.ArrayList;

/**
 * CustomComponent
 * <p/>
 * This class is used to describe a custom componentTab
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class CustomComponent extends Component {

    private ArrayList<Byte> bytes;

    /**
     * Get the value of bytes
     *
     * @return the value of bytes
     */
    public ArrayList<Byte> getBytes() {
        return bytes;
    }

    /**
     * Set the value of bytes
     *
     * @param bytes the new value of bytes
     */
    public void setBytes(ArrayList<Byte> bytes) {
        this.bytes = bytes;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CustomComponent out = new CustomComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());

        ArrayList<Byte> bytes = new ArrayList<Byte>();
        for (Byte b : this.getBytes()) {
            bytes.add(b.byteValue());
        }
        out.setBytes(bytes);

        return out;
    }
}
