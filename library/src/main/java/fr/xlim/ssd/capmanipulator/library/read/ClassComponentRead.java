/**
 * ClassComponentRead.java
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

import java.util.ArrayList;

public class ClassComponentRead extends ComponentRead {


    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        ClassComponent classComponent = new ClassComponent();

        // we first read tag and size
        super.load((byte) ComponentEnum.CLASS_COMPONENT.getValue(), in, classComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        // TODO: signaturePoolLength only on Java Card 2.2
        /*
         * //signaturePoolLength reading
         * //this.setSignaturePoolLength(in.readShort());
         * this.setSignaturePoolLength(in.readShort()); nbByteRead += 2;
         *
         * //we first clear the signaturePool signaturePool.clear(); for(int
         * i=0; i<signaturePoolLength; i++){ signaturePool.add(new
         * TypeDescriptor(in)); }
         */

        classComponent.setSignaturePool(new ArrayList<TypeDescriptor>());
        classComponent.setClasses(new ArrayList<ClassInfo>());
        classComponent.setInterfaces(new ArrayList<InterfaceInfo>());


        while (in.getByteRead() < classComponent.getSize()) {

            // we'll have to check the first nibble to know if it's a
            // classInfo or
            // interfaceInfo structure
            byte buf = in.readByte();

            // if the most significant bit of buf is 1 it's an interfaceInfo
            // else it's a classInfo
            if ((buf & ClassComponent.ACC_INTERFACE) != 0) {
                InterfaceInfo intInf = new InterfaceInfoRead().load(buf, in.getByteRead() - 1, in);
                classComponent.getInterfaces().add(intInf);
            } else {
                ClassInfo classInf = new ClassInfoRead().load(buf, in.getByteRead() - 1, in);
                classComponent.getClasses().add(classInf);
            }
        }


        checkSize(in, classComponent);

        return classComponent;
    }
}
