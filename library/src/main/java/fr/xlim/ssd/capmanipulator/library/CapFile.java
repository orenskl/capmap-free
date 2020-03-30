/**
 * CapFile.java
 * <p>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard@xlim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
 * University of Limoges - Xlim
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

import java.util.*;

/**
 * CapFile class
 * <p/>
 * this class describes the structure of a cap file. It contains the fourteen
 * components which structure the cap file.
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class CapFile implements Cloneable {

    // Logger stream
    private final static Logger logger = LoggerFactory.getLogger(CapFile.class);

    // fields declaration
    private ArrayList<Component> components;

    private Map<Short, Integer> offsetMethodToNumber = new TreeMap<Short, Integer>();// HashMap<Short, Integer>();

    /**
     * Constructor
     */
    public CapFile() {
        components = new ArrayList<Component>();
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public HeaderComponent getHeaderComponent() {
        for (Component c : components) {
            if (c instanceof HeaderComponent) {
                return (HeaderComponent) c;
            }
        }
        return null;
    }

    public DirectoryComponent getDirectoryComponent() {
        for (Component c : components) {
            if (c instanceof DirectoryComponent) {
                return (DirectoryComponent) c;
            }
        }
        return null;
    }

    public ImportComponent getImportComponent() {
        for (Component c : components) {
            if (c instanceof ImportComponent) {
                return (ImportComponent) c;
            }
        }
        return null;
    }

    public AppletComponent getAppletComponent() {
        for (Component c : components) {
            if (c instanceof AppletComponent) {
                return (AppletComponent) c;
            }
        }
        return null;
    }

    public ClassComponent getClassComponent() {
        for (Component c : components) {
            if (c instanceof ClassComponent) {
                return (ClassComponent) c;
            }
        }
        return null;
    }

    public MethodComponent getMethodComponent() {
        for (Component c : components) {
            if (c instanceof MethodComponent) {
                return (MethodComponent) c;
            }
        }
        return null;
    }

    public StaticFieldComponent getStaticFieldComponent() {
        for (Component c : components) {
            if (c instanceof StaticFieldComponent) {
                return (StaticFieldComponent) c;
            }
        }
        return null;
    }

    public ExportComponent getExportComponent() {
        for (Component c : components) {
            if (c instanceof ExportComponent) {
                return (ExportComponent) c;
            }
        }
        return null;
    }

    public ConstantPoolComponent getConstantPoolComponent() {
        for (Component c : components) {
            if (c instanceof ConstantPoolComponent) {
                return (ConstantPoolComponent) c;
            }
        }
        return null;
    }

    public ReferenceLocationComponent getReferenceLocationComponent() {
        for (Component c : components) {
            if (c instanceof ReferenceLocationComponent) {
                return (ReferenceLocationComponent) c;
            }
        }
        return null;
    }


    public DescriptorComponent getDescriptorComponent() {
        for (Component c : components) {
            if (c instanceof DescriptorComponent) {
                return (DescriptorComponent) c;
            }
        }
        return null;
    }

    public DebugComponent getDebugComponent() {
        for (Component c : components) {
            if (c instanceof DebugComponent) {
                return (DebugComponent) c;
            }
        }
        return null;
    }

    public List<CustomComponent> getCustomComponents() {
        List<CustomComponent> results = new LinkedList<CustomComponent>();
        for (Component c : components) {
            if (c instanceof CustomComponent) {
                results.add((CustomComponent) c);
            }
        }
        return results;
    }

    public Map<Short, Integer> getOffsetMethodToNumber() {
        return offsetMethodToNumber;
    }

    public void setOffsetMethodToNumber(Map<Short, Integer> offsetMethodToNumber) {
        this.offsetMethodToNumber = offsetMethodToNumber;
    }

    /**
     * toString methods
     *
     * @return a string which describe the cap file object
     */
    @Override
    public String toString() {

        StringBuffer str = new StringBuffer();

        for (int i = 0; i < components.size(); i++)
            str.append(components.get(i).toString()).append("\n");

        return str.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CapFile out = new CapFile();
        out.components = new ArrayList<>();

        for(Component c : this.getComponents()) {
            out.components.add((Component) c.clone());
        }

        return out;
    }
}
