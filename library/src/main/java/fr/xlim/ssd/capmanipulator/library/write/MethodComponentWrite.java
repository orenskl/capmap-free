package fr.xlim.ssd.capmanipulator.library.write;

import fr.xlim.ssd.capmanipulator.library.Component;
import fr.xlim.ssd.capmanipulator.library.ExceptionHandlerInfo;
import fr.xlim.ssd.capmanipulator.library.MethodComponent;
import fr.xlim.ssd.capmanipulator.library.MethodInfo;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException;

public class MethodComponentWrite extends ComponentWrite {


    /**
     * Write the Method Component in a cap file
     *
     * @param out Cap File to write
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToWriteCapFileException
     */
    @Override
    public void write(CapOutputStream out, Component component) throws UnableToWriteCapFileException {

        assert out != null;
        assert component != null;
        assert component instanceof MethodComponent;

        MethodComponent methodComponent = (MethodComponent) component;

        // write tag and size
        super.write(out, methodComponent);

        // handler count writing
        out.writeByte(methodComponent.getHandlerCount());

        // exception handlers writing
        for (ExceptionHandlerInfo e : methodComponent.getExceptionHandlers()) {
            new ExceptionHandlerInfoWrite().write(out, e);
        }

        // methods writing
        for (MethodInfo m : methodComponent.getMethods()) {
            new MethodInfoWrite().write(out, m);
        }
    }

}
