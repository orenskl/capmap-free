/**
 * ExceptionHandlerInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.ExceptionHandlerInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

public class ExceptionHandlerInfoRead {

    /**
     * read the ExceptionHandlerInfo a cap file to set the values of the
     * Exception Handler Info
     *
     * @param in Cap File to read
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    public ExceptionHandlerInfo load(CapInputStream in) throws UnableToReadCapFileException {
        ExceptionHandlerInfo exceptionHandlerInfo = new ExceptionHandlerInfo();
        exceptionHandlerInfo.setStartOffset(in.readShort());
        exceptionHandlerInfo.setBitfield(in.readShort());
        exceptionHandlerInfo.setHandlerOffset(in.readShort());
        exceptionHandlerInfo.setCatchTypeIndex(in.readShort());
        return exceptionHandlerInfo;
    }
}
