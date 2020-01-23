/**
 * ImportComponent.java
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

import org.apache.tools.ant.taskdefs.Pack;

import java.util.ArrayList;

/**
 * ImportComponent class
 * <p/>
 * contains an entry for each of the applets defined in this package
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class ImportComponent extends Component {

    //number of items in the package
    private byte count;

    //table of variable-length package_info (defined in Header_Component)
    private ArrayList<PackageInfo> packages;

    /**
     * Get the value of count
     *
     * @return the value of count
     */
    public byte getCount() {
        return count;
    }

    /**
     * Set the value of count
     *
     * @param newVar the new value of count
     */
    public void setCount(byte newVar) {
        count = newVar;
    }

    /**
     * Get the value of packages
     *
     * @return the value of packages
     */
    public ArrayList<PackageInfo> getPackages() {
        return packages;
    }

    /**
     * Set the value of packages
     *
     * @param newVar the new value of packages
     */
    public void setPackages(ArrayList<PackageInfo> newVar) {
        packages = newVar;
    }

    /*
     * (non-Javadoc) @see
     * fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append("\n\n.ImportComponent = {").append(rl);

        //ret.append(super.toString()).append(rl);
        ret.append("count : ").append(count);

        for (int i = 0; i < count; i++) {
            ret.append(rl).append("package_info = {").append(rl + '\t');
            ret.append(packages.get(i).toString().replaceAll("\t", "\t\t").replaceAll("pkg_", ""));
            ret.append("\t}");
        }

        ret.append("\n}\n");

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImportComponent that = (ImportComponent) o;

        if (count != that.count) return false;
        if (!packages.equals(that.packages)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ImportComponent out = new ImportComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setCount(this.getCount());

        ArrayList<PackageInfo> packages = new ArrayList<PackageInfo>();
        for (PackageInfo p : this.getPackages()) {
            packages.add((PackageInfo) p.clone());
        }
        out.setPackages(packages);

        return out;
    }
}
