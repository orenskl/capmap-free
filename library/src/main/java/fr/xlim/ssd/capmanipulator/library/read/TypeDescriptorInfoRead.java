/**
 * TypeDescriptorInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.DescriptorComponent;
import fr.xlim.ssd.capmanipulator.library.TypeDescriptor;
import fr.xlim.ssd.capmanipulator.library.TypeDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.SortedSet;
import java.util.TreeSet;

public class TypeDescriptorInfoRead {

    /**
     * read the Type Descriptor Info of a cap file to set the values of the
     * TypeDescriptorInfo
     *
     * @param in Cap File to read
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    public TypeDescriptorInfo load(CapInputStream in, DescriptorComponent DescComp) throws UnableToReadCapFileException {

        TypeDescriptorInfo typeDescriptorInfo = new TypeDescriptorInfo();

        typeDescriptorInfo.setConstantPoolCount(in.readShort());

        typeDescriptorInfo.getConstantPoolTypes().clear();

        for (int i = 0; i < typeDescriptorInfo.getConstantPoolCount(); i++) {
            typeDescriptorInfo.getConstantPoolTypes().add(in.readShort());
        }

        typeDescriptorInfo.getTypeDesc().clear();


        //we sorted constantPoolTypes in a temp sortedSet
        SortedSet<Short> constantPoolTypes2 = new TreeSet<Short>(typeDescriptorInfo.getConstantPoolTypes());

        short offset = 0;
        if (!constantPoolTypes2.isEmpty()) {
            constantPoolTypes2.remove((short) 0xFFFF);
            //we get the first element of the set
            offset = constantPoolTypes2.first();
        }
        short nbByteRead = (short) in.getByteRead();


        //we will read until the end of the componentTab
        while (in.getByteRead() < DescComp.getSize()) {
            TypeDescriptor t = new TypeDescriptorRead().load(in);
            typeDescriptorInfo.getTypeDesc().put(offset, t);
            offset += (in.getByteRead() - nbByteRead);
            nbByteRead = (short) in.getByteRead();
        }

        return typeDescriptorInfo;
    }
}
