/**
 * StaticFieldComponentRead.java
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

import fr.xlim.ssd.capmanipulator.library.ArrayInitInfo;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ComponentEnum;
import fr.xlim.ssd.capmanipulator.library.StaticFieldComponent;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.ArrayList;

public class StaticFieldComponentRead extends ComponentRead {

    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        StaticFieldComponent staticFieldComponent = new StaticFieldComponent();

        super.load((byte) ComponentEnum.STATIC_FIELD_COMPONENT.getValue(), in, staticFieldComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        staticFieldComponent.setImageSize(in.readShort());
        staticFieldComponent.setReferenceCount(in.readShort());
        staticFieldComponent.setArrayInitCount(in.readShort());

        staticFieldComponent.setArrayInit(new ArrayList<ArrayInitInfo>(staticFieldComponent.getArrayInitCount()));

        for (int i = 0; i < staticFieldComponent.getArrayInitCount(); i++) {

            ArrayInitInfo ar = new ArrayInitInfoRead().load(in);
            staticFieldComponent.getArrayInit().add(ar);
        }

        staticFieldComponent.setDefaultValueCount(in.readShort());
        staticFieldComponent.setNonDefaultValueCount(in.readShort());

        staticFieldComponent.setNonDefaultValues(new ArrayList<Byte>(staticFieldComponent.getNonDefaultValueCount()));

        for (int i = 0; i < staticFieldComponent.getNonDefaultValueCount(); i++) {
            staticFieldComponent.getNonDefaultValues().add(in.readByte());
        }

        checkSize(in, staticFieldComponent);

        return staticFieldComponent;
    }
}
