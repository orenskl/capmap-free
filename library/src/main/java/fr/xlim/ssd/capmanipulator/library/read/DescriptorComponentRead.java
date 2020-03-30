/**
 * DescriptorComponentRead.java
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

public class DescriptorComponentRead extends ComponentRead {

    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        DescriptorComponent descriptorComponent = new DescriptorComponent();

        super.load((byte) ComponentEnum.DESCRIPTOR_COMPONENT.getValue(), in, descriptorComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        descriptorComponent.setClassCount(in.readByte());


        descriptorComponent.setClasses(new ArrayList<ClassDescriptorInfo>(descriptorComponent.getClassCount()));

        for (int i = 0; i < descriptorComponent.getClassCount(); i++) {
            ClassDescriptorInfo cDes = new ClassDescriptorInfoRead().load(in);
            descriptorComponent.getClasses().add(cDes);
        }

        TypeDescriptorInfo typeDescriptorInfo = new TypeDescriptorInfoRead().load(in, descriptorComponent);
        descriptorComponent.setTypes(typeDescriptorInfo);

        checkSize(in, descriptorComponent);

        return descriptorComponent;
    }

}
