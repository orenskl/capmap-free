/**
 * CapAppletRead.java
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

package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.CapApplet;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class CapAppletRead {

    /**
     * read an applets section of a cap file to set the values of an applets
     *
     * @throws java.io.IOException
     */
    public CapApplet load(CapInputStream in) throws UnableToReadCapFileException {

        CapApplet capApplet = new CapApplet();

        // AIDLength reading
        capApplet.setAidLength(in.readByte());

        // aid reading
        // first we clear the arrayList
        capApplet.getAid().clear();

        // and then we read every entries of the arrayList
        for (int i = 0; i < capApplet.getAidLength(); i++) {
            capApplet.getAid().add(in.readByte());
        }

        capApplet.setInstallMethodOffset(in.readShort());

        return capApplet;
    }
}
