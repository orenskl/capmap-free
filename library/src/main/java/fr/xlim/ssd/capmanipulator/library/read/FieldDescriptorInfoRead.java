/**
 * FieldDescriptorInfoRead.java
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

public class FieldDescriptorInfoRead {


    /**
     * read the Field Descriptor Info a cap file to set the values of the
     * FieldDescriptorInfo Component
     *
     * @param in Cap File to read
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    public FieldDescriptorInfo load(CapInputStream in) throws UnableToReadCapFileException {

        FieldDescriptorInfo fieldDescriptorInfo = new FieldDescriptorInfo();

        fieldDescriptorInfo.setToken(in.readByte()); // Token reading
        fieldDescriptorInfo.setAccesFlags(in.readByte()); // Access flag reading

        if ((fieldDescriptorInfo.getAccessFlags() & FieldDescriptorInfo.ACC_STATIC) >>> 3 == 1) {
            //the field is a Static Field
            StaticField fieldRef = new StaticField();
            fieldDescriptorInfo.setFieldRef(fieldRef);
            StaticFieldRef sFieldRef = new StaticFieldRefRead().load(in);
            ((StaticField) fieldRef).setStaticField(sFieldRef);

        } else {
            //the fied is an instance field
            ClassRef classref = new ClassRefRead().load(in);
            byte tok = in.readByte();

            FieldRef fieldRef = new InstanceField();
            fieldDescriptorInfo.setFieldRef(fieldRef);
            ((InstanceField) fieldRef).setClass_(classref);
            ((InstanceField) fieldRef).setToken(tok);
        }

        fieldDescriptorInfo.setType(in.readShort()); // Type reading

        return fieldDescriptorInfo;
    }
}
