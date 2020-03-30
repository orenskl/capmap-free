/**
 * AppletComponent.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
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
import java.util.List;

/**
 * AppletComponent
 * <p/>
 * It contains an entry for each of the applets defined in this package.
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class AppletComponent extends Component {

    /// number of applets defined in this package
    private byte count;

    /// table describing each structure defined in this package
    private List<CapApplet> applets;

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
     * Get the value of applets
     *
     * @return the value of applets
     */
    public List<CapApplet> getApplets() {
        return applets;
    }

    /**
     * Set the value of applets
     *
     * @param newVar the new value of applets
     */
    public void setApplets(List<CapApplet> newVar) {
        applets = newVar;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer();

        ret.append(".Applets = {").append("\n");

        //ret.append(super.toString()).append(rl);
        //ret.append("count : ").append(count);

        for (int i = 0; i < count; i++) {
            //ret.append(rl).append(String.format("applets[%-2d]{", i) + applets.get(i) + rl + "}");
            ret.append("\t").append(applets.get(i)).append("\n");
        }

        ret.append("}\n");

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppletComponent that = (AppletComponent) o;

        if (count != that.count) return false;
        if (!applets.equals(that.applets)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        AppletComponent out = new AppletComponent();

        out.setSize(this.getSize());
        out.setTag(this.getTag());
        out.setCount(this.getCount());

        ArrayList<CapApplet> applets = new ArrayList<CapApplet>();
        for(CapApplet applet : this.getApplets()) {
            applets.add((CapApplet) applet.clone());
        }
        out.setApplets(applets);

        return out;
    }
}
