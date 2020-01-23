/**
 * StaticFieldSizeInfo.java
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticFieldSizeInfo implements Cloneable {

    private static final Logger logger = LoggerFactory.getLogger(StaticFieldSizeInfo.class);

    // number of bytes in the static fields defined in this package
    private short imageSize;
    // number of arrays initialized in all of the <clinit> methods in this
    // package
    private short arrayInitCount;
    // number of bytes in all of the array initialized in all of the
    // <clinit> methods in this package
    private short arrayInitSize;

    /**
     * Get the value of imageSize
     *
     * @return the value of imageSize
     */
    public short getImageSize() {
        return imageSize;
    }

    /**
     * Set the value of imageSize
     *
     * @param newVar the new value of imageSize
     */
    public void setImageSize(short newVar) {
        imageSize = newVar;
    }

    /**
     * Get the value of arrayInitCount
     *
     * @return the value of arrayInitCount
     */
    public short getArrayInitCount() {
        return arrayInitCount;
    }

    /**
     * Set the value of arrayInitCount
     *
     * @param newVar the new value of arrayInitCount
     */
    public void setArrayInitCount(short newVar) {
        arrayInitCount = newVar;
    }

    /**
     * Get the value of arrayInitSize
     *
     * @return the value of arrayInitSize
     */
    public short getArrayInitSize() {
        return arrayInitSize;
    }

    /**
     * Set the value of arrayInitSize
     *
     * @param newVar the new value of iarrayInitSize
     */
    public void setArrayInitSize(short newVar) {
        arrayInitSize = newVar;
    }

    /*
     * (non-Javadoc) @see java.lang.Object#toString()
     */
    public String toString() {
        String rl = "\n\t";
        StringBuffer res = new StringBuffer("\tstatic_field_size_info = {").append(rl);
        res.append("\timage_size       : ").append(this.imageSize).append(rl);
        res.append("\tarray_init_count : ").append(this.arrayInitCount).append(rl);
        res.append("\tarray_init_size  : ").append(this.arrayInitSize).append(rl);
        res.append("}");

        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaticFieldSizeInfo that = (StaticFieldSizeInfo) o;

        if (arrayInitCount != that.arrayInitCount) return false;
        if (arrayInitSize != that.arrayInitSize) return false;
        if (imageSize != that.imageSize) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StaticFieldSizeInfo out = new StaticFieldSizeInfo();

        out.setImageSize(this.getImageSize());
        out.setArrayInitCount(this.getArrayInitCount());
        out.setArrayInitSize(this.getArrayInitSize());

        return super.clone();
    }
}
