/**
 * StaticFieldComponent.java
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

package fr.xlim.ssd.capmanipulator.library;

import java.util.ArrayList;


/**
 * StaticFieldComponent this componentTab contains all of the information required
 * to create and initialize an image of all of the static fields defined in this
 * package, refered to as the static field image
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class StaticFieldComponent extends Component {


    // number of bytes required to represent the static fields defined in this
    // package, excluding final static field or primitive types. image_size =
    // ref_count * 2 + def_value_count + non_def_value_count
    private short imageSize;

    // number of reference type static fields defined in this package
    private short referenceCount;

    // number of element in the array_init[] array
    private short arrayInitCount;

    // array of structure that specify the initial array values of static fields
    // of array of primitives types
    private ArrayList<ArrayInitInfo> arrayInit;

    // number of byte required to initialize the set of static fields
    // represented in segment 3 of the static field image
    private short defaultValueCount;

    // number of item in the non_default_values array
    private short nonDefaultValueCount;

    // array of byte of non-default initial values
    private ArrayList<Byte> nonDefaultValues;


    /* (non-Javadoc)
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append(".StaticFieldComponent = {").append(rl);

        //ret.append(super.toString()).append(rl);
        ret.append("image_size              : ").append(this.getImageSize()).append(rl);
        ret.append("reference_count         : ").append(this.getReferenceCount()).append(rl);
        ret.append("array_init_count        : ").append(this.getArrayInitCount()).append(rl);
        ret.append("array_init = {").append(rl);

        int i = 0;

        for (ArrayInitInfo a : this.getArrayInit()) {
            ret.append(a);
            i++;
        }

        ret.append("}").append(rl);

        ret.append("default_value_count     : ").append(this.defaultValueCount).append(rl);
        ret.append("non_default_value_count : ").append(this.nonDefaultValueCount).append(rl);
        ret.append("non_default_values = {    ").append(rl);

        for (byte b : nonDefaultValues)
            ret.append("\t").append(b).append(rl);

        ret.append("}");

        ret.append("\n}\n");

        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StaticFieldComponent out = new StaticFieldComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setImageSize(this.getImageSize());
        out.setReferenceCount(this.getReferenceCount());
        out.setArrayInitCount(this.getArrayInitCount());

        ArrayList<ArrayInitInfo> initInfos = new ArrayList<>();
        for (ArrayInitInfo aif : this.getArrayInit()) {
            initInfos.add((ArrayInitInfo) aif.clone());
        }
        out.setArrayInit(initInfos);

        out.setDefaultValueCount(this.getDefaultValueCount());
        out.setNonDefaultValueCount(this.getNonDefaultValueCount());

        ArrayList<Byte> nonDefaultValues = new ArrayList<>();
        for (Byte b : this.getNonDefaultValues()) {
            nonDefaultValues.add(b.byteValue());
        }
        out.setNonDefaultValues(nonDefaultValues);

        return out;
    }

    /**
     * Get the value of imageSize number of bytes required to represent the
     * static fields defined in this package,
     *
     * @return the value of imageSize
     */
    public short getImageSize() {
        return this.imageSize;
    }

    /**
     * Set the value of imageSize number of bytes required to represent the
     * static fields defined in this package,
     *
     * @param imageSize the new value of imageSize
     */
    public void setImageSize(short imageSize) {
        this.imageSize = imageSize;
    }

    /**
     * Get Reference count
     *
     * @return the referenceCount
     */
    public short getReferenceCount() {
        return referenceCount;
    }

    /**
     * Set Reference count
     *
     * @param referenceCount the referenceCount to set
     */
    public void setReferenceCount(short referenceCount) {
        this.referenceCount = referenceCount;
    }

    /**
     * Get Array Int Count
     *
     * @return the arrayIntCount
     */
    public short getArrayInitCount() {
        return arrayInitCount;
    }

    /**
     * Set Array Int Count
     *
     * @param arrayInitCount the arrayIntCount to set
     */
    public void setArrayInitCount(short arrayInitCount) {
        this.arrayInitCount = arrayInitCount;
    }

    /**
     * Get Array Init
     *
     * @return the arrayInit
     */
    public ArrayList<ArrayInitInfo> getArrayInit() {
        return arrayInit;
    }

    /**
     * Set array init
     *
     * @param arrayInit the arrayInit to set
     */
    public void setArrayInit(ArrayList<ArrayInitInfo> arrayInit) {
        this.arrayInit = arrayInit;
    }

    /**
     * Get Default value count
     *
     * @return the defaultValueCount
     */
    public short getDefaultValueCount() {
        return defaultValueCount;
    }

    /**
     * Set Default value count
     *
     * @param defaultValueCount the defaultValueCount to set
     */
    public void setDefaultValueCount(short defaultValueCount) {
        this.defaultValueCount = defaultValueCount;
    }

    /**
     * Get Non default value count
     *
     * @return the nonDefaultValueCount
     */
    public short getNonDefaultValueCount() {
        return nonDefaultValueCount;
    }

    /**
     * Set Non default value count
     *
     * @param nonDefaultValueCount the nonDefaultValueCount to set
     */
    public void setNonDefaultValueCount(short nonDefaultValueCount) {
        this.nonDefaultValueCount = nonDefaultValueCount;
    }

    /**
     * Get Non default values
     *
     * @return the nonDefaultValues
     */
    public ArrayList<Byte> getNonDefaultValues() {
        return nonDefaultValues;
    }

    /**
     * Set Non default values
     *
     * @param nonDefaultValues the nonDefaultValues to set
     */
    public void setNonDefaultValues(ArrayList<Byte> nonDefaultValues) {
        this.nonDefaultValues = nonDefaultValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaticFieldComponent that = (StaticFieldComponent) o;

        if (arrayInitCount != that.arrayInitCount) return false;
        if (defaultValueCount != that.defaultValueCount) return false;
        if (imageSize != that.imageSize) return false;
        if (nonDefaultValueCount != that.nonDefaultValueCount) return false;
        if (referenceCount != that.referenceCount) return false;
        if (!arrayInit.equals(that.arrayInit)) return false;
        return nonDefaultValues.equals(that.nonDefaultValues);

    }
}
