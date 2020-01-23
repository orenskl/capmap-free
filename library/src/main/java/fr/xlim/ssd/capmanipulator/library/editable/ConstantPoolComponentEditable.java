/**
 * ConstantPoolComponentEditable.java
 * <p>
 * Author: 2013 Guillaume Bouffard <guillaume.bouffard@unilim.fr>
 * <p>
 * Université de Limoges
 */

package fr.xlim.ssd.capmanipulator.library.editable;

import fr.xlim.ssd.capmanipulator.library.CapFile;
import fr.xlim.ssd.capmanipulator.library.ConstantPoolComponent;
import fr.xlim.ssd.capmanipulator.library.ConstantPoolInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class aims to modify the Constant Pool Component handling the interdependancies.
 *
 * @author Guillaume Bouffard <guillaume.bouffard@unilim.fr>
 */
public class ConstantPoolComponentEditable {


    private final static Logger logger = LoggerFactory.getLogger(ConstantPoolComponentEditable.class);
    private CapFile capFile;
    private ConstantPoolComponent constantPoolComponent;

    /**
     * Default constructor
     *
     * @param capFile reference to the CapFile to update
     */
    public ConstantPoolComponentEditable(CapFile capFile) {
        this.capFile = capFile;
        this.constantPoolComponent = this.capFile.getConstantPoolComponent();
    }

    /**
     * Adding a Constant Pool Element into the Reference Location
     *
     * @param cp Constant Pool Element to add
     */
    public void addingConstantPoolElement(ConstantPoolInfo cp) {

        // Adding the new element into the Constant Pool Component
        this.constantPoolComponent.getConstantPool().add(cp);
        this.constantPoolComponent.setCount((short) (this.constantPoolComponent.getCount() + 1));
        this.constantPoolComponent.setSize((short) (this.constantPoolComponent.getSize() + 4));
        this.capFile.getDirectoryComponent().setConstantPoolComponentSize
                (this.capFile.getConstantPoolComponent().getSize());
    }

    /**
     * Removing a Constant Pool Element into the Reference Location
     *
     * @param cp Constant Pool Element to remove
     */
    public void removingConstantPoolElement(ConstantPoolInfo cp) {

        // Adding the new element into the Constant Pool Component
        this.constantPoolComponent.getConstantPool().remove(cp);
        this.constantPoolComponent.setCount((short) (this.constantPoolComponent.getCount() - 1));
        this.constantPoolComponent.setSize((short) (this.constantPoolComponent.getSize() - 4));
        this.capFile.getDirectoryComponent().setConstantPoolComponentSize
                (this.capFile.getConstantPoolComponent().getSize());
    }


}