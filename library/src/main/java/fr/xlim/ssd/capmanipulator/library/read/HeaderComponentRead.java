/**
 * HeaderComponentRead.java
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

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderComponentRead extends ComponentRead {

    private final static Logger logger = LoggerFactory.getLogger(HeaderComponentRead.class);

    /**
     * read the header of a cap file to set the values of the headerComponent
     *
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        HeaderComponent headerComponent = new HeaderComponent();

        // we first read tag and size
        super.load((byte) ComponentEnum.HEADER_COMPONENT.getValue(), in, headerComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        // magic reading
        int magic = in.readInt();
        logger.trace("magic: {}", magic);
        headerComponent.setMagic(magic);

        // minor_version reading;
        byte minor = in.readByte();
        logger.trace("minor: {}", minor);
        headerComponent.setMinorVersion(minor);

        // major_versionr reading
        byte major = in.readByte();
        logger.trace("major: {}", major);
        headerComponent.setMajorVersion(major);

        // flags reading
        byte flags = in.readByte();
        logger.trace("flags: {}", flags);
        headerComponent.setFlags(flags);

        // package Info reading
        PackageInfo packageInfo = new PackageInfoRead().load(in);
        headerComponent.setThePackage(packageInfo);

        if (headerComponent.getMinorVersion() == 1) {
            checkSize(in, headerComponent);

            PackageNameInfo packageNameInfo = new PackageNameInfo();
            headerComponent.setPackageName(new PackageNameInfo());
        } else {
            PackageNameInfo packageNameInfo = new PackageNameInfoRead().load(in);
            headerComponent.setPackageName(packageNameInfo);
            logger.trace("packageNameInfoRead: {}", Converter.bytes2ascii(packageNameInfo.getName()));

            checkSize(in, headerComponent);
        }


        return headerComponent;
    }
}
