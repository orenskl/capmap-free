/**
 * ClassInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.ClassComponent;
import fr.xlim.ssd.capmanipulator.library.ClassInfo;
import fr.xlim.ssd.capmanipulator.library.ImplementedInterfaceInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class ClassInfoRead {

    /**
     * read the values of a ClassInfo from a cap file and set this values
     *
     * @param in Cap File Stream
     * @throws java.io.IOException
     */

    public ClassInfo load(byte bitfield, int offset, CapInputStream in) throws UnableToReadCapFileException {

        ClassInfo classInfo = new ClassInfo();

        classInfo.setOffset(offset);

        classInfo.setFlags(bitfield);

        // superClassRef loading
        classInfo.setSuperClassRef(new ClassRefRead().load(in));

        // declaredInstancedSize reading
        classInfo.setDeclaredInstanceSize(in.readByte());

        // firstRefToken reading
        classInfo.setFirstReferenceToken(in.readByte());

        // refCount reading
        classInfo.setReferenceCount(in.readByte());

        // publicMethodTableBase reading
        classInfo.setPublicMethodTableBase(in.readByte());

        // publicMethodTableCount reading
        classInfo.setPublicMethodTableCount(in.readByte());

        // packageMethodTableBase reading
        classInfo.setPackageMethodTableBase(in.readByte());

        // packageMethodTableCount reading
        classInfo.setPackageMethodTableCount(in.readByte());

        // publicVirtualMethodTable reading
        classInfo.getPublicVirtualMethodTable().clear();

        for (int i = 0; i < classInfo.getPublicMethodTableCount(); i++) {
            classInfo.getPublicVirtualMethodTable().add(in.readShort());

        }

        // packageVirtualMethodTable reading
        classInfo.getPackageVirtualMethodTable().clear();

        for (int i = 0; i < classInfo.getPackageMethodTableCount(); i++) {
            classInfo.getPackageVirtualMethodTable().add(in.readShort());
        }

        // interfaces reading
        classInfo.getInterfaces().clear();

        // the number of entries entries in the interfaces array
        // is in the second nibble of the bitField
        byte interfaceCount = (byte) (bitfield & 0x0F);

        for (int i = 0; i < interfaceCount; i++) {
            ImplementedInterfaceInfo impInt = new ImplementedInterfaceInfoRead().load(in);
            classInfo.getInterfaces().add(impInt);
        }

        // remoteInterfaces reading
        // only if the ACC_REMOTE flag has the value 0


        if ((bitfield & ClassComponent.ACC_REMOTE) == ClassComponent.ACC_REMOTE) {
            classInfo.setRemoteInterfacesInfo(new RemoteInterfaceInfoRead().load(in));
        } else {
            classInfo.setRemoteInterfacesInfo(null);
        }

        return classInfo;
    }
}