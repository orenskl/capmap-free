/**
 * ClassDescriptorInfoRead.java
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

import fr.xlim.ssd.capmanipulator.library.ClassDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.ClassRef;
import fr.xlim.ssd.capmanipulator.library.FieldDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.MethodDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.ArrayList;

public class ClassDescriptorInfoRead {

    /**
     * read the Class Descriptor Info a cap file to set the values of the
     * ClassDescriptorInfo Component
     *
     * @param in Cap File to read
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     *
     */
    public ClassDescriptorInfo load(CapInputStream in) throws UnableToReadCapFileException {

        ClassRefRead classRefRead = new ClassRefRead();

        ClassDescriptorInfo classDescriptorInfo = new ClassDescriptorInfo();

        classDescriptorInfo.setToken(in.readByte());
        classDescriptorInfo.setAccesFlags(in.readByte());

        // This_class_ref reading
        classDescriptorInfo.setThisClassRef(classRefRead.load(in));

        classDescriptorInfo.setInterfaceCount(in.readByte());
        classDescriptorInfo.setFieldCount(in.readShort());
        classDescriptorInfo.setMethodCount(in.readShort());

        //reading of the interfaces
        classDescriptorInfo.setInterfaces(new ArrayList<ClassRef>(classDescriptorInfo.getInterfaceCount()));

        for (int i = 0; i < classDescriptorInfo.getInterfaceCount(); i++) {
            classDescriptorInfo.getInterfaces().add(classRefRead.load(in));
        }

        //reading of the fields
        classDescriptorInfo.setFields(new ArrayList<FieldDescriptorInfo>(classDescriptorInfo.getFieldCount()));

        for (int i = 0; i < classDescriptorInfo.getFieldCount(); i++) {
            FieldDescriptorInfo fDes = new FieldDescriptorInfoRead().load(in);
            classDescriptorInfo.getFields().add(fDes);
        }

        //reading of the methods
        classDescriptorInfo.setMethods(new ArrayList<MethodDescriptorInfo>(classDescriptorInfo.getMethodCount()));

        for (int i = 0; i < classDescriptorInfo.getMethodCount(); i++) {
            MethodDescriptorInfo mDes = new MethodDescriptorInfoRead().load(in);
            classDescriptorInfo.getMethods().add(mDes);
        }

        return classDescriptorInfo;
    }
}
