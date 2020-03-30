/**
 * DescriptorComponentEditable.java
 * <p>
 * Copyright (C) 2014 Guillaume Bouffard <guillaume.bouffard@unilim.fr>
 * <p>
 * Université de Limoges
 */

package fr.xlim.ssd.capmanipulator.library.editable;

import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.ClassDescriptorInfo;
import fr.xlim.ssd.capmanipulator.library.DescriptorComponent;
import fr.xlim.ssd.capmanipulator.library.MethodDescriptorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple component to modify the Descriptor Component with the interdependency updates
 *
 * @author Guillaume Bouffard <guillaume.bouffard@unilim.fr>
 */
public class DescriptorComponentEditable {


    private final static Logger logger = LoggerFactory.getLogger(DescriptorComponentEditable.class);
    private CapFile capFile;
    private DescriptorComponent descriptorComponent;

    /**
     * Default constructor
     *
     * @param capFile reference to the CapFile to update
     */
    public DescriptorComponentEditable(CapFile capFile) {
        this.capFile = capFile;
        this.descriptorComponent = this.capFile.getDescriptorComponent();
    }

    /**
     * Removing a method from the descriptor component
     *
     * @param methodOffset Method offset to remove
     */
    public void removeMethod(short methodOffset) {

        logger.trace("Searching method @{} to remove ... ", Integer.toHexString(methodOffset & 0x00FFFF));

        for (ClassDescriptorInfo classDescriptorInfo : this.descriptorComponent.getClasses()) {
            for (MethodDescriptorInfo methodDescriptorInfo : classDescriptorInfo.getMethods()) {
                if (methodDescriptorInfo.getMethodOffset() == methodOffset) {
                    logger.trace("Method found!");
                    classDescriptorInfo.getMethods().remove(methodDescriptorInfo);
                    // Updating size
                    classDescriptorInfo.setMethodCount((short) (classDescriptorInfo.getMethodCount() - 1));
                    this.descriptorComponent.setSize((short) (this.descriptorComponent.getSize() - 12));
                    this.capFile.getDirectoryComponent().setDescriptorComponentSize(this.descriptorComponent.getSize());
                    logger.trace("Method removed!");
                    return;
                }
            }
        }
        logger.trace("Method not found!");
    }

    /**
     * Correcting the method descriptor info
     */
    private void correctingMethods() {

        short method_num = 0;

        for (ClassDescriptorInfo classDescriptorInfo : this.descriptorComponent.getClasses()) {
            for (MethodDescriptorInfo methodDescriptorInfo : classDescriptorInfo.getMethods()) {
                methodDescriptorInfo.setMethodOffset(this.capFile.getMethodComponent().getMethods().get(method_num).getMethodInfoOffset());
                methodDescriptorInfo.setBytecodeCount((short) this.capFile.getMethodComponent().getMethods().get(method_num).getBytecodes().size());
                method_num++;
            }
        }
    }
}