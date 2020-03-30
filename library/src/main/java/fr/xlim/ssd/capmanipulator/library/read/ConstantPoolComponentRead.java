/**
 * ConstantPoolComponentComponentRead.java
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

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnknownTagException;

import java.util.ArrayList;

public class ConstantPoolComponentRead extends ComponentRead {

    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        ConstantPoolComponent constantPoolComponent = new ConstantPoolComponent();

        try {
            // we first read tag and size
            super.load((byte) ComponentEnum.CONSTANT_POOL_COMPONENT.getValue(), in, constantPoolComponent);

            // we reset the count of byte read to zero
            in.resetCount();

            constantPoolComponent.setConstantPool(new ArrayList<ConstantPoolInfo>());
            constantPoolComponent.setOffsetMethodList(new ArrayList<Short>());

            // count reading
            constantPoolComponent.setCount(in.readShort());

            for (int i = 0; i < constantPoolComponent.getCount(); i++) {
                // we will read the first byte, it represents the tag of the
                // cpInfo
                byte cpTag = in.readByte();

                // we will create and add the object corresponding to the cpTag
                switch (cpTag) {
                    case ConstantPoolComponent.TAG_CLASS_REF:
                        ConstantClassRef cClass = new ConstantClassRefRead().load(in);
                        constantPoolComponent.getConstantPool().add(cClass);
                        break;

                    case ConstantPoolComponent.TAG_INSTANCE_FIELD_REF:
                        ConstantInstanceFieldRef cInstF = new ConstantInstanceFieldRefRead().load(in);
                        constantPoolComponent.getConstantPool().add(cInstF);
                        break;

                    case ConstantPoolComponent.TAG_VIRTUAL_METHOD_REF:
                        ConstantVirtualMethodRef cVirtMet = new ConstantVirtualMethodRefRead().load(in);
                        constantPoolComponent.getConstantPool().add(cVirtMet);
                        break;

                    case ConstantPoolComponent.TAG_SUPER_METHOD_REF:
                        ConstantSuperMethodRef cSupMet = new ConstantSuperMethodRefRead().load(in);
                        constantPoolComponent.getConstantPool().add(cSupMet);
                        break;

                    case ConstantPoolComponent.TAG_STATIC_FIELD_REF:
                        ConstantStaticFieldRef cStatF = new ConstantStaticFieldRefRead().load(in);
                        constantPoolComponent.getConstantPool().add(cStatF);
                        break;

                    case ConstantPoolComponent.TAG_STATIC_METHOD_REF:
                        ConstantStaticMethodRef cStatMet = new ConstantStaticMethodRefRead().load(in);
                        constantPoolComponent.getConstantPool().add(cStatMet);
                        break;

                    default:
                        throw new UnknownTagException(
                                "an error has occured while loading constant pool, tag "
                                        + cpTag + " unknow");

                }

            }

            // we'll get the offset to method componentTab into a list which will
            // be used when loading method componentTab
            for (ConstantPoolInfo elem : constantPoolComponent.getConstantPool()) {

                // we have offset to method componentTab only for
                // InternalStaticMethodRef which are contained in Constant
                // static method ref
                if (elem instanceof ConstantStaticMethodRef) {

                    ConstantStaticMethodRef tmp = (ConstantStaticMethodRef) elem;

                    if (tmp.getStaticMethodRef() instanceof InternalStaticMethodRef) {
                        InternalStaticMethodRef tmp2 = (InternalStaticMethodRef) tmp.getStaticMethodRef();

                        constantPoolComponent.getOffsetMethodList().add(tmp2.getOffset());
                    }

                }
            }

            checkSize(in, constantPoolComponent);

        } catch (UnknownTagException e) {
            throw new UnableToReadCapFileException("unknow tag found", e);
        }

        return constantPoolComponent;
    }
}
