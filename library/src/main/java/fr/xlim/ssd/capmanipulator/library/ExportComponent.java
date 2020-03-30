/**
 * ExportComponent.java
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
 * Export_Component
 * <p/>
 * the Export_Component lists all static elements in this package that may be
 * imported by classes in other packages. Instance fields and virtual methods
 * are not represented in the Export Component
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ExportComponent extends Component {

    private byte classCount; // number of entries in the class_exports table
    private ArrayList<ClassExportsInfo> classExports;


    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer(".ExportComponent = {").append(rl);

        //ret.append(super.toString()).append(rl);

        ret.append("count : ").append(this.getClassCount()).append("\n");

        int i = 0;

        for (ClassExportsInfo c : this.getClassExports()) {
            ret.append("\tclass_export_info[").append(i).append("] = {    ").append(rl).append(c).append(rl).append("}\n");
        }

        ret.append("}");

        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ExportComponent out = new ExportComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setClassCount(this.getClassCount());

        ArrayList<ClassExportsInfo> exportsInfos = new ArrayList<>();
        for (ClassExportsInfo classExportsInfo : this.getClassExports()) {
            exportsInfos.add((ClassExportsInfo) classExportsInfo.clone());
        }
        out.setClassExports(exportsInfos);

        return out;
    }

    /**
     * Get the value of class_count
     *
     * @return the value of class_count
     */
    public byte getClassCount() {
        return classCount;
    }

    /**
     * Set the value of class_count
     *
     * @param newVar the new value of class_count
     */
    public void setClassCount(byte newVar) {
        classCount = newVar;
    }

    /**
     * Get Class Exports
     *
     * @return Class Exports values
     */
    public ArrayList<ClassExportsInfo> getClassExports() {
        return classExports;
    }

    /**
     * Set Class Exports
     *
     * @param classExports set Class Exports values
     */
    public void setClassExports(ArrayList<ClassExportsInfo> classExports) {
        this.classExports = classExports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportComponent that = (ExportComponent) o;

        if (classCount != that.classCount) return false;
        return classExports.equals(that.classExports);

    }
}
