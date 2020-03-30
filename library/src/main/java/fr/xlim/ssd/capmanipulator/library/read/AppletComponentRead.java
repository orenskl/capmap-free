/**
 * AppletComponentRead.java
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

import fr.xlim.ssd.capmanipulator.library.AppletComponent;
import fr.xlim.ssd.capmanipulator.library.CapApplet;
import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ComponentEnum;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.LinkedList;

public class AppletComponentRead extends ComponentRead {

    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        AppletComponent appletComponent = new AppletComponent();

        // we first read tag and size
        super.load((byte) ComponentEnum.APPLET_COMPONENT.getValue(), in, appletComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        // count reading
        appletComponent.setCount(in.readByte());

        appletComponent.setApplets(new LinkedList<CapApplet>());

        for (int i = 0; i < appletComponent.getCount(); i++) {
            CapApplet ap = new CapAppletRead().load(in);
            appletComponent.getApplets().add(ap);
        }

        checkSize(in, appletComponent);

        return appletComponent;
    }
}
