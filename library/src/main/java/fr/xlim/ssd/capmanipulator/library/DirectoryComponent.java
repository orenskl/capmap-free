/**
 * DirectoryComponent.java
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

package fr.xlim.ssd.capmanipulator.library;

import fr.xlim.ssd.capmanipulator.library.read.CustomComponentInfoRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


/**
 * Directory_Component class this class lists the size of each of the components
 * defined in this CAP file When an optional componentTab is not included, it is
 * represented with size equal to zero
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class DirectoryComponent extends Component {

    // 11 element in the Java Card 2.1 Specification
    public static final int COMPONENT_NUMBER_21 = 11;
    // 12 element in the Java Card 2.1 Specification
    public static final int COMPONENT_NUMBER_22 = 12;
    private static final Logger logger = LoggerFactory.getLogger(DirectoryComponent.class);
    // number of bytes in each of the 12 components in the CAP file
    private ArrayList<Short> componentSize;
    private StaticFieldSizeInfo staticFieldSize;

    // number of packages imported by classes and interfaces in the package
    private byte importCount;

    // number of applet defined in this package
    private byte appletCount;

    // number of entries in the custom_component table [0-127]
    private byte customCount;
    private ArrayList<CustomComponentInfo> customComponent;

    /**
     * Get the value of componentSize
     *
     * @return the value of componentSize
     */
    public ArrayList<Short> getComponentSize() {
        return componentSize;
    }

    /**
     * Set the value of componentSize
     *
     * @param newVar the new value of componentSize
     */
    public void setComponentSize(ArrayList<Short> newVar) {
        componentSize = newVar;
    }

    /**
     * Get the value of staticFieldSize
     *
     * @return the value of staticFieldSize
     */
    public StaticFieldSizeInfo getStaticFieldSize() {
        return staticFieldSize;
    }

    /**
     * Set the value of staticFieldSize
     *
     * @param newVar the new value of staticFieldSize
     */
    public void setStaticFieldSize(StaticFieldSizeInfo newVar) {
        staticFieldSize = newVar;
    }

    /**
     * Get the value of importCount
     *
     * @return the value of importCount
     */
    public byte getImportCount() {
        return importCount;
    }

    /**
     * Set the value of importCount
     *
     * @param newVar the new value of importCount
     */
    public void setImportCount(byte newVar) {
        importCount = newVar;
    }

    /**
     * Get the value of appletCount
     *
     * @return the value of appletCount
     */
    public byte getAppletCount() {
        return appletCount;
    }

    /**
     * Set the value of appletCount
     *
     * @param newVar the new value of appletCount
     */
    public void setAppletCount(byte newVar) {
        appletCount = newVar;
    }

    /**
     * Get the value of customCount
     *
     * @return the value of customCount
     */
    public byte getCustomCount() {
        return customCount;
    }

    /**
     * Set the value of customCount
     *
     * @param newVar the new value of customCount
     */
    public void setCustomCount(byte newVar) {
        customCount = newVar;
    }

    /**
     * Get the value of customComponent
     *
     * @return the value of customComponent
     */
    public ArrayList<CustomComponentInfo> getCustomComponent() {
        return customComponent;
    }

    /**
     * Set the value of customComponent
     *
     * @param newVar the new value of customComponent
     */
    public void setCustomComponent(ArrayList<CustomComponentInfo> newVar) {
        customComponent = newVar;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        String tab = "\t";
        StringBuffer ret = new StringBuffer(".DirectoryComponent = {").append(rl);

        //ret.append(super.toString()).append(rl);
        ret.append("component_sizes = {").append(rl);

        ret.append(tab).append("Header           : ").append(componentSize.get(0)).append(rl);
        ret.append(tab).append("Directory        : ").append(componentSize.get(1)).append(rl);
        ret.append(tab).append("Applet           : ").append(componentSize.get(2)).append(rl);
        ret.append(tab).append("Import           : ").append(componentSize.get(3)).append(rl);
        ret.append(tab).append("ConstantPool     : ").append(componentSize.get(4)).append(rl);
        ret.append(tab).append("Class            : ").append(componentSize.get(5)).append(rl);
        ret.append(tab).append("Method           : ").append(componentSize.get(6)).append(rl);
        ret.append(tab).append("StaticField      : ").append(componentSize.get(7)).append(rl);
        ret.append(tab).append("ReferenceLocation: ").append(componentSize.get(8)).append(rl);
        ret.append(tab).append("Export           : ").append(componentSize.get(9)).append(rl);
        ret.append(tab).append("Descriptor       : ").append(componentSize.get(10)).append(rl);
        // ret += tab + "Debug            : "+componentSize.get(11) + rl;
        ret.append("}\n");

        ret.append(this.staticFieldSize.toString()).append(rl);

        ret.append("import_count : ").append(this.importCount).append(rl);
        ret.append("applet_count : ").append(this.appletCount).append(rl);
        ret.append("custom_count : ").append(this.customCount).append("\n");

        if (this.customCount != 0) {
            ret.append(tab).append("custom_component_info : {");

            for (CustomComponentInfo cc : this.customComponent) {
                ret.append("\n\t\t").append(cc.toString());
            }

            ret.append("}\n");
        }

        ret.append("}\n");

        return ret.toString();
    }

    public short getHeaderComponentSize() {
        return this.getComponentSize().get(ComponentEnum.HEADER_COMPONENT.getValue() - 1);
    }

    public void setHeaderComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.HEADER_COMPONENT.getValue() - 1, newValue);
    }

    public short getDirectoryComponentSize() {
        return this.getComponentSize().get(ComponentEnum.DIRECTORY_COMPONENT.getValue() - 1);
    }

    public void setDirectoryComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.DIRECTORY_COMPONENT.getValue() - 1, newValue);
    }

    public short getImportComponentSize() {
        return this.getComponentSize().get(ComponentEnum.IMPORT_COMPONENT.getValue() - 1);
    }

    public void setImportComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.IMPORT_COMPONENT.getValue() - 1, newValue);
    }

    public short getAppletComponentSize() {
        return this.getComponentSize().get(ComponentEnum.APPLET_COMPONENT.getValue() - 1);
    }

    public void setAppletComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.APPLET_COMPONENT.getValue() - 1, newValue);
    }

    public short getClassComponentSize() {
        return this.getComponentSize().get(ComponentEnum.CLASS_COMPONENT.getValue() - 1);
    }

    public void setClassComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.CLASS_COMPONENT.getValue() - 1, newValue);
    }

    public short getMethodComponentSize() {
        return this.getComponentSize().get(ComponentEnum.METHOD_COMPONENT.getValue() - 1);
    }

    public void setMethodComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.METHOD_COMPONENT.getValue() - 1, newValue);
    }

    public short getStaticFieldComponentSize() {
        return this.getComponentSize().get(ComponentEnum.STATIC_FIELD_COMPONENT.getValue() - 1);
    }

    public void setStaticFieldComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.STATIC_FIELD_COMPONENT.getValue() - 1, newValue);
    }

    public short getExportComponentSize() {
        return this.getComponentSize().get(ComponentEnum.EXPORT_COMPONENT.getValue() - 1);
    }

    public void setExportComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.EXPORT_COMPONENT.getValue() - 1, newValue);
    }

    public short getConstantPoolComponentSize() {
        return this.getComponentSize().get(ComponentEnum.CONSTANT_POOL_COMPONENT.getValue() - 1);
    }

    public void setConstantPoolComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.CONSTANT_POOL_COMPONENT.getValue() - 1, newValue);
    }

    public short getReferenceLocationComponentSize() {
        return this.getComponentSize().get(ComponentEnum.REFERENCE_LOCATION_COMPONENT.getValue() - 1);
    }

    public void setReferenceLocationComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.REFERENCE_LOCATION_COMPONENT.getValue() - 1, newValue);
    }

    public short getDescriptorComponentSize() {
        return this.getComponentSize().get(ComponentEnum.DESCRIPTOR_COMPONENT.getValue() - 1);
    }

    public void setDescriptorComponentSize(short newValue) {
        this.getComponentSize().set(ComponentEnum.DESCRIPTOR_COMPONENT.getValue() - 1, newValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectoryComponent that = (DirectoryComponent) o;

        if (appletCount != that.appletCount) return false;
        if (customCount != that.customCount) return false;
        if (importCount != that.importCount) return false;
        if (!componentSize.equals(that.componentSize)) return false;
        if (!customComponent.equals(that.customComponent)) return false;
        if (!staticFieldSize.equals(that.staticFieldSize)) return false;

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DirectoryComponent out = new DirectoryComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());

        out.componentSize = new ArrayList<>();
        for(Short s: this.getComponentSize()) {
            out.componentSize.add(s);
        }

        out.setStaticFieldSize((StaticFieldSizeInfo) this.getStaticFieldSize().clone());

        out.setImportCount(this.getImportCount());
        out.setAppletCount(this.getAppletCount());

        ArrayList<CustomComponentInfo> componentInfos = new ArrayList<CustomComponentInfo>();
        for(CustomComponentInfo customComponentInfo : this.getCustomComponent()) {
            componentInfos.add((CustomComponentInfo) customComponentInfo.clone());
        }
        out.setCustomComponent(componentInfos);

        return out;
    }
}
