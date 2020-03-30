/**
 * CapFileRead.java
 * <p/>
 * Copyright (C) 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Copyright (C) 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Copyright (C) 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p/>
 * Xlim - Université de Limoges
 * <p/>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 */

package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;
import fr.xlim.ssd.capmanipulator.library.logging.LogType;
import fr.xlim.ssd.capmanipulator.library.tool.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CapFileRead {

    private final static Logger logger = LoggerFactory.getLogger(CapFileRead.class);
    public static CapFile capFile;
    private CapInputStream inputStream;

    public CapFileRead(CapInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static CapFile getCapFile() {
        return capFile;
    }

    public CapFile load() throws UnableToReadCapFileException {

        // this list contains offset referencing methods
        // in the method componentTab. It's used to load method componentTab
        List<Short> lOffset = new ArrayList<Short>();

        // this list contains the tags of the custom componentTab
        List<Byte> lCustomTag = new ArrayList<Byte>();

        capFile = new CapFile();

        logger.debug("starting first pass (loading components)");
        inputStream.load();

        while (true) {

            firstPassAnalysis(lOffset, lCustomTag, capFile);

            boolean next = inputStream.getNextComponent();

            if (!next) {
                break;
            }
        }


        // reload cap file
        logger.debug("reload file before second pass (resolving method components)");
        inputStream.load();

        // Now, we read the Method componentTab
        logger.debug("starting second pass (resolving method components)");
        while (true) {

            // we read the tag from the file
            byte tag = inputStream.readByte();

            secondPassAnalysis((ArrayList<Short>) lOffset, lCustomTag, capFile, tag);

            boolean next = inputStream.getNextComponent();

            if (!next) {
                break;
            }
        }

        return capFile;
    }

    private void secondPassAnalysis(ArrayList<Short> lOffset, List<Byte> lCustomTag, CapFile capFile, byte tag)
            throws UnableToReadCapFileException {
        // we read the componentTab corresponding to the tag
        switch (ComponentEnum.get(tag)) {
            // we skip components reading
            case HEADER_COMPONENT:
            case DIRECTORY_COMPONENT:
            case APPLET_COMPONENT:
            case IMPORT_COMPONENT:
            case CONSTANT_POOL_COMPONENT:
            case CLASS_COMPONENT:
            case STATIC_FIELD_COMPONENT:
            case REFERENCE_LOCATION_COMPONENT:
            case EXPORT_COMPONENT:
            case DESCRIPTOR_COMPONENT:
            case DEBUG_COMPONENT:
                inputStream.skipBytes(inputStream.readShort());
                break;

            case METHOD_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Updating Method Component");

                // yet, we have all methods' offsets.
                MethodComponentRead methodComponentRead = new MethodComponentRead();
                methodComponentRead.setOffsets(lOffset);
                MethodComponent methodComponent = (MethodComponent) methodComponentRead.load(inputStream);

                //we fill the offsetMethodToNumber map
                int methodNumber = 0;
                for (MethodInfo mDes : methodComponent.getMethods()) {
                    capFile.getOffsetMethodToNumber().put(mDes.getMethodInfoOffset(), methodNumber++);
                }

                // insert it (look for the null entry in component list)
                int index = capFile.getComponents().indexOf(null);
                assert index != -1;
                capFile.getComponents().set(index, methodComponent);

                break;


            default:
                if (!lCustomTag.contains(tag)) {
                    logger.error("Unknown component tag found: {}", tag);
                    throw new UnableToReadCapFileException("unknown tag :" + tag);
                } else {
                    inputStream.skipBytes(inputStream.readShort());
                }
        }
    }

    private void firstPassAnalysis(List<Short> lOffset, List<Byte> lCustomTag, CapFile capFile) throws UnableToReadCapFileException {

        // we read the tag from the file
        byte tag = inputStream.readByte();

        logger.debug("Component Tag: {} ({})", (tag & 0x0FF), ComponentEnum.get(tag));

        assert tag != 0;

        // we read the componentTab corresponding to the tag
        switch (ComponentEnum.get(tag)) {

            case HEADER_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Header Component");
                HeaderComponent h = (HeaderComponent) new HeaderComponentRead().load(inputStream);
                capFile.getComponents().add(h);
                break;

            case DIRECTORY_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Directory Component");
                DirectoryComponent d = (DirectoryComponent) new DirectoryComponentRead().load(inputStream);
                capFile.getComponents().add(d);

                // we'll get the list of custom componentTab declared
                // in the directory componentTab
                for (int i = 0; i < d.getCustomCount(); i++) {
                    lCustomTag.add(d.getCustomComponent().get(i)
                            .getComponentTag());
                }
                break;


            case APPLET_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Applet Component");
                AppletComponent ap = (AppletComponent) new AppletComponentRead().load(inputStream);
                capFile.getComponents().add(ap);
                // we add the offset to the method componentTab
                // contained in the applet componentTab
                for (CapApplet a : ap.getApplets()) {
                    Converter.addShortToArray(lOffset, a.getInstallMethodOffset());
                }
                break;


            case IMPORT_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Import Component");
                ImportComponent imp = (ImportComponent) new ImportComponentRead().load(inputStream);
                capFile.getComponents().add(imp);
                break;


            case CONSTANT_POOL_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Constant Pool Component");
                ConstantPoolComponent co = (ConstantPoolComponent) new ConstantPoolComponentRead().load(inputStream);
                capFile.getComponents().add(co);
                // we add the offset to the method componentTab
                // contained in the class componentTab
                Converter.addArrayToArray(co.getOffsetMethodList(), lOffset);

                break;

            case CLASS_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Class Component");
                ClassComponent cl = (ClassComponent) new ClassComponentRead().load(inputStream);
                capFile.getComponents().add(cl);
                // we add the offset to the method componentTab
                // contained in the class componentTab
                for (ClassInfo c : cl.getClasses()) {
                    Converter.addArrayToArray(c.getPublicVirtualMethodTable(), lOffset);
                }

                break;

            case METHOD_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Method Component");
                // we can't directly read the method component so
                // we'll have to skip as byte as it contains

                capFile.getComponents().add(null);
                short size = inputStream.readShort();
                inputStream.skipBytes(size);

                break;

            case STATIC_FIELD_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Static Field Component");
                StaticFieldComponent st = (StaticFieldComponent) new StaticFieldComponentRead().load(inputStream);
                capFile.getComponents().add(st);
                break;


            case REFERENCE_LOCATION_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Reference Location Component");
                ReferenceLocationComponent rf = (ReferenceLocationComponent) new ReferenceLocationComponentRead().load(inputStream);
                capFile.getComponents().add(rf);
                break;

            case EXPORT_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Export Component");
                ExportComponent ex = (ExportComponent) new ExportComponentRead().load(inputStream);
                capFile.getComponents().add(ex);
                // we add the offset to the method componentTab
                // contained in the export componentTab
                for (ClassExportsInfo cEx : ex.getClassExports()) {
                    Converter.addArrayToArray(cEx.getStaticMethodOffsets(), lOffset);
                }

                break;

            case DESCRIPTOR_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Descriptor Component");
                DescriptorComponent descr = (DescriptorComponent) new DescriptorComponentRead().load(inputStream);
                capFile.getComponents().add(descr);

                // if we've the descriptor Component we use it
                // to get our offset list
                // it allows us to be sure of having every offsets
                // needed

                // we'll get the offset of each methods defined in
                // each ClassDescriptorInfo
                for (ClassDescriptorInfo c : descr.getClasses()) {

                    for (MethodDescriptorInfo met : c.getMethods()) {
                        Converter.addShortToArray(lOffset, met.getMethodOffset());
                    }
                }

                break;

            case DEBUG_COMPONENT_2_1:
            case DEBUG_COMPONENT:
                logger.debug(LogType.COMPONENT.getMarker(), "Found Debug Component");
                DebugComponent dc = (DebugComponent) new DebugComponentRead().load(inputStream);
                capFile.getComponents().add(dc);
                break;

            default:

                // we look in the customTag list if the tag read is
                // present
                if (lCustomTag.contains(tag)) {
                    logger.debug(LogType.COMPONENT.getMarker(), "Found Custom Component");
                    CustomComponentRead customComponentRead = new CustomComponentRead();
                    customComponentRead.setTag(tag);
                    CustomComponent customComponent = (CustomComponent) customComponentRead.load(inputStream);
                    capFile.getComponents().add(customComponent);
                } else {
                    logger.error("Unknown component tag found: {}", tag);
                    throw new UnableToReadCapFileException("unknown component tag");
                }
        }
    }
}