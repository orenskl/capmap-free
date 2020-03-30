/**
 * RemoteInterfaceInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.RemoteInterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.RemoteMethodInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class RemoteInterfaceInfoRead {

    /**
     * read the values of a RemoteInterfaceInfo from a cap file and set this
     * values
     *
     * @param in Cap File Stream
     * @throws java.io.IOException
     */
    public RemoteInterfaceInfo load(CapInputStream in) throws UnableToReadCapFileException {

        RemoteInterfaceInfo remoteInterfaceInfo = new RemoteInterfaceInfo();

        // remoteMethodsCount reading
        remoteInterfaceInfo.setRemoteMethodsCount(in.readByte());

        // remoteMethods reading
        remoteInterfaceInfo.getRemoteMethods().clear();

        for (int i = 0; i < remoteInterfaceInfo.getRemoteMethodsCount(); i++) {

            RemoteMethodInfo rmi = new RemoteMethodInfoRead().load(in);
            remoteInterfaceInfo.getRemoteMethods().add(rmi);
        }

        // hashModifierLength reading
        remoteInterfaceInfo.setHashModifierLength(in.readByte());

        // hashModifier reading
        remoteInterfaceInfo.getHashModifier().clear();

        for (int i = 0; i < remoteInterfaceInfo.getHashModifierLength(); i++) {
            remoteInterfaceInfo.getHashModifier().add(in.readByte());

        }

        // classNameLenght reading
        remoteInterfaceInfo.setClassNameLength(in.readByte());

        // className reading
        remoteInterfaceInfo.getClassName().clear();

        for (int i = 0; i < remoteInterfaceInfo.getClassNameLength(); i++) {
            remoteInterfaceInfo.getClassName().add(in.readByte());

        }

        // remoteInterfaceCount reading
        remoteInterfaceInfo.setRemoteInterfacesCount(in.readByte());

        // remoteInterfaces reading
        remoteInterfaceInfo.getRemoteInterfaces().clear();

        for (int i = 0; i < remoteInterfaceInfo.getRemoteInterfacesCount(); i++) {
            remoteInterfaceInfo.getRemoteInterfaces().add(new ClassRefRead().load(in));

        }

        return remoteInterfaceInfo;
    }
}
