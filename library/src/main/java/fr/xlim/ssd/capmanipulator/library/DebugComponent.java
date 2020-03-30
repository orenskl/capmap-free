/**
 * DebugComponent.java
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

import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * DebugComponent
 * <p/>
 * contains all the metadata necessary for debugging a package on suitably
 * instrumented Java Card virtual machine. It is not required for executing Java
 * Card programs in a non-debug environment
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class DebugComponent extends Component {
    // number of strings in the stringsTable table

    // logger stream
    private final static Logger logger = LoggerFactory.getLogger(DebugComponent.class);
    private short stringCount;
    // table of all the strings used in this componentTab.
    private ArrayList<Utf8Info> stringsTable = new ArrayList<Utf8Info>();
    // index in the stringsTable item. the entry referenced by this index
    // contain the fully qualified name of the package
    private short packageNameIndex;
    // number of classes in the classes table
    private short classCount;
    // contains a single classDebugInfo for each class in this package
    private ArrayList<ClassDebugInfo> classes = new ArrayList<ClassDebugInfo>();

    /**
     * Get the value of stringCount number of strings in the stringsTable table
     *
     * @return the value of stringCount
     */
    public short getStringCount() {
        return stringCount;
    }

    /**
     * Set the value of stringCount number of strings in the stringsTable table
     *
     * @param newVar the new value of stringCount
     */
    public void setStringCount(short newVar) {
        stringCount = newVar;
    }

    /**
     * Get the Strings table array list
     *
     * @return the Strings table array list
     */
    public ArrayList<Utf8Info> getStringsTable() {
        return this.stringsTable;
    }

    /**
     * Get the value of packageNameIndex index in the stringsTable item. the
     * entry referenced by this index contain the fully qualified name of the
     * package
     *
     * @return the value of packageNameIndex
     */
    public short getPackageNameIndex() {
        return packageNameIndex;
    }

    /**
     * Set the value of packageNameIndex index in the stringsTable item. the
     * entry referenced by this index contain the fully qualified name of the
     * package
     *
     * @param newVar the new value of packageNameIndex
     */
    public void setPackageNameIndex(short newVar) {
        packageNameIndex = newVar;
    }

    /**
     * Get the value of classCount number of classes in the classes table
     *
     * @return the value of classCount
     */
    public short getClassCount() {
        return classCount;
    }

    /**
     * Set the value of classCount number of classes in the classes table
     *
     * @param newVar the new value of classCount
     */
    public void setClassCount(short newVar) {
        classCount = newVar;
    }

    /**
     * Get the value of classes
     *
     * @return the value of classes
     */
    public ArrayList<ClassDebugInfo> getClasses() {
        return classes;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer(".DebugComponent = {").append(rl);

        ret.append("string_count : ").append(this.getStringCount()).append(rl);

        int i = 0;
        for (Utf8Info utf8Info : this.getStringsTable()) {
            ret.append("strings_table[").append(i).append("] = {    ").append(rl);

            ret.append("\tlength: ").append(utf8Info.getLength()).append(rl);
            ret.append("\tname: ").append(Converter.bytes2ascii(utf8Info.getBytes())).append(rl);

            ret.append("}").append(rl);
            i++;
        }

        ret.append("package_name_index : ").append(this.getPackageNameIndex()).append(rl);
        ret.append("class_count : ").append(this.getClassCount()).append(rl);

        i = 0;
        for (ClassDebugInfo classDebugInfo : this.getClasses()) {
            ret.append("classes[").append(i).append("] = {    ").append(rl);

            ret.append("\tname_index: ").append(classDebugInfo.getNameIndex()).append(rl);
            // TODO: display the constant value
            ret.append("\taccess_flag: ").append(classDebugInfo.getAccessFlags()).append(rl);
            ret.append("\tlocation: ").append(classDebugInfo.getLocation()).append(rl);
            ret.append("\tsuperclass_name_index: ").append(classDebugInfo.getSuperNameIndex()).append(rl);
            ret.append("\tsource_file_index: ").append(classDebugInfo.getSourceFileIndex()).append(rl);
            ret.append("\tinterface_count: ").append(classDebugInfo.getInterfaceCount()).append(rl);
            ret.append("\tfield_count: ").append(classDebugInfo.getFieldCount()).append(rl);
            ret.append("\tmethod_count: ").append(classDebugInfo.getMethodCount()).append(rl);

            int j = 0;
            for (short interface_names_indexes : classDebugInfo.getInterfaceNamesIndexes()) {

                ret.append(String.format("  %04x", interface_names_indexes));

                j++;
                if (j > 7) {
                    ret.append(rl).append("\t");
                    j = 0;
                }
            }

            j = 0;
            for (FieldDebugInfo fieldDebugInfo : classDebugInfo.getFields()) {
                ret.append("\tfields[").append(j).append("] = {    ").append(rl);
                ret.append("\t\tname_index: ").append(fieldDebugInfo.getNameIndex()).append(rl);
                ret.append("\t\tdescriptor_index: ").append(fieldDebugInfo.getDescriptorIndex()).append(rl);
                // TODO: display the constant value
                ret.append("\t\taccess_flag: ").append(fieldDebugInfo.getAccessFlags()).append(rl);

                Object contents = fieldDebugInfo.getContents();

                if (contents instanceof FieldDebugInfo.TokenVar) {

                    ret.append("\t\tpad1: ").append(((FieldDebugInfo.TokenVar) contents).getPad1()).append(rl);
                    ret.append("\t\tpad2: ").append(((FieldDebugInfo.TokenVar) contents).getPad2()).append(rl);
                    ret.append("\t\tpad3: ").append(((FieldDebugInfo.TokenVar) contents).getPad3()).append(rl);
                    ret.append("\t\ttoken: ").append(((FieldDebugInfo.TokenVar) contents).getToken()).append(rl);

                } else if (contents instanceof FieldDebugInfo.LocationVar) {

                    ret.append("\t\tpad: ").append(((FieldDebugInfo.LocationVar) contents).getPad()).append(rl);
                    ret.append("\t\tlocation: ").append(((FieldDebugInfo.LocationVar) contents).getLocation()).append(rl);

                } else if (contents instanceof Integer) {
                    ret.append("\t\tconst_value: 0x").append(Integer.toHexString((Integer) contents));
                }
                ret.append("\t}").append(rl);
                j++;
            }

            j = 0;
            for (MethodDebugInfo methodDebugInfo : classDebugInfo.getMethods()) {
                ret.append("\tMethods[").append(j).append("] = {    ").append(rl);

                ret.append("\t\tname_index: ").append(methodDebugInfo.getNameIndex()).append(rl);
                ret.append("\t\tdescriptor_index: ").append(methodDebugInfo.getDescriptorIndex()).append(rl);
                // TODO: display the constant value
                ret.append("\t\taccess_flag: ").append(methodDebugInfo.getAccessFlags()).append(rl);
                ret.append("\t\tlocation: ").append(methodDebugInfo.getLocation()).append(rl);
                ret.append("\t\theader_size: ").append(methodDebugInfo.getHeaderSize()).append(rl);
                ret.append("\t\tbody_size: ").append(methodDebugInfo.getBodySize()).append(rl);
                ret.append("\t\tvariable_count: ").append(methodDebugInfo.getVariableCount()).append(rl);
                ret.append("\t\tline_count: ").append(methodDebugInfo.getLineCount()).append(rl);

                int k = 0;
                for (VariableInfo variableInfo : methodDebugInfo.getVariableTable()) {
                    ret.append("\t\tVariable Table[").append(k).append("] = {    ").append(rl);

                    ret.append("\t\t\tindex: ").append(variableInfo.getIndex()).append(rl);
                    ret.append("\t\t\tname_index: ").append(variableInfo.getNameIndex()).append(rl);
                    ret.append("\t\t\tdescriptor_index: ").append(variableInfo.getDescriptorIndex()).append(rl);
                    ret.append("\t\t\tstart_pc: ").append(variableInfo.getStartPc()).append(rl);
                    ret.append("\t\t\tlength: ").append(variableInfo.getLength()).append(rl);

                    ret.append("\t\t}").append(rl);
                    k++;
                }

                for (LineInfo lineInfo : methodDebugInfo.getLineTable()) {
                    ret.append("\t\tLine Table[").append(k).append("] = {    ").append(rl);

                    ret.append("\t\t\tstart_pc: ").append(lineInfo.getStartPc()).append(rl);
                    ret.append("\t\t\tend_pc: ").append(lineInfo.getEndPc()).append(rl);
                    ret.append("\t\t\tsource_line: ").append(lineInfo.getSourceLine()).append(rl);

                    ret.append("\t\t}").append(rl);
                    k++;
                }

                ret.append("\t}").append(rl);
                j++;
            }


            ret.append("}").append(rl);
            i++;
        }

        ret.append("}\n");

        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        DebugComponent out  = new DebugComponent();

        out.stringCount = this.stringCount;

        ArrayList<Utf8Info> stringsTable = new ArrayList<Utf8Info>();
        for(Utf8Info u: this.stringsTable) {
            stringsTable.add((Utf8Info) u.clone());
        }
        out.stringsTable = stringsTable;


        out.packageNameIndex = this.packageNameIndex;
        out.classCount = this.classCount;

        ArrayList<ClassDebugInfo> classes = new ArrayList<ClassDebugInfo>();
        for(ClassDebugInfo c: this.classes) {
            classes.add((ClassDebugInfo) c.clone());
        }
        out.classes = classes;

        return out;
    }
}
