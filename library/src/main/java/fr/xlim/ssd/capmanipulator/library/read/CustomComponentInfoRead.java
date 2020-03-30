/**
 * CustomComponentInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.CustomComponentInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class CustomComponentInfoRead {

    /**
     * read the Custom Component info part of a cap file to set the values of
     * the StaticFieldSizeInfo
     *
     * @throws java.io.IOException
     */
    public CustomComponentInfo load(CapInputStream in) throws UnableToReadCapFileException {

        CustomComponentInfo customComponentInfo = new CustomComponentInfo();

        // component_tag reading
        customComponentInfo.setComponentTag(in.readByte());

        // size reading
        customComponentInfo.setSize(in.readShort());

        // Aid length reading
        customComponentInfo.setAidLength(in.readByte());

        // aid reading
        customComponentInfo.getAid().clear();

        for (byte i = 0; i < customComponentInfo.getAidLength(); i++) {
            customComponentInfo.getAid().add(in.readByte());
        }

        return customComponentInfo;
    }
}
