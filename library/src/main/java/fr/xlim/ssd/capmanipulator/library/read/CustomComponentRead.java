/**
 * CustomComponentRead.java
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

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.CustomComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.ArrayList;

public class CustomComponentRead extends ComponentRead {

    private byte tag;

    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        CustomComponent customComponent = new CustomComponent();

        // we first read tag and size
        super.load(tag, in, customComponent);

        customComponent.setBytes(new ArrayList<Byte>());

        for (int i = 0; i < customComponent.getSize(); i++) {

            customComponent.getBytes().add(in.readByte());
        }

        checkSize(in, customComponent);

        return customComponent;
    }

    public byte getTag() {
        return tag;
    }

    public void setTag(byte tag) {
        this.tag = tag;
    }
}
