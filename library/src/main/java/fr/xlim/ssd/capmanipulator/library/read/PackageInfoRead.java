/**
 * PackageInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.PackageInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackageInfoRead {

    private final static Logger logger = LoggerFactory.getLogger(PackageInfoRead.class);

    /**
     * read the PackageInfo part of a cap file set the values of PackageInfo
     */
    public PackageInfo load(CapInputStream in) throws UnableToReadCapFileException {

        PackageInfo packageInfo = new PackageInfo();

        // minorVersion reading;
        byte minorVersion = in.readByte();
        logger.trace("minor version: {}", minorVersion);
        packageInfo.setMinorVersion(minorVersion);

        // majorVersion reading
        byte majorVersion = in.readByte();
        logger.trace("major version: {}", majorVersion);
        packageInfo.setMajorVersion(majorVersion);

        // AID length reading
        byte aidLength = in.readByte();
        logger.trace("AID length: {}", aidLength);
        packageInfo.setAIDLength(aidLength);

        // AID reading
        packageInfo.getAID().clear();

        for (byte i = 0; i < aidLength; i++) {
            packageInfo.getAID().add(in.readByte());
        }

        return packageInfo;
    }
}
