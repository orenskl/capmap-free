package fr.xlim.ssd.capmanipulator.library.read;

import fr.xlim.ssd.capmanipulator.library.*;
import fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException;

import java.util.ArrayList;
import java.util.Collections;

public class MethodComponentRead extends ComponentRead {

    private ArrayList<Short> offsets;

    /**
     * read the MethodComponent a cap file to set the values of the Method
     * Component
     *
     * @param in Cap File to read
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnableToReadCapFileException
     * @throws fr.xlim.ssd.capmanipulator.library.exceptions.UnknownFlagException
     */
    @Override
    public Component load(CapInputStream in) throws UnableToReadCapFileException {

        assert offsets != null;

        MethodComponent methodComponent = new MethodComponent();

        // we first read tag and size
        super.load((byte) ComponentEnum.METHOD_COMPONENT.getValue(), in, methodComponent);

        // we reset the count of byte read to zero
        in.resetCount();

        methodComponent.setOffsets(offsets);

        methodComponent.getOffsets().remove((short) 0xffff);
        Collections.sort(methodComponent.getOffsets());


        methodComponent.setHandlerCount(in.readByte());

        methodComponent.setExceptionHandlers(new ArrayList<ExceptionHandlerInfo>(methodComponent.getHandlerCount()));

        for (int i = 0; i < methodComponent.getHandlerCount(); i++) {
            ExceptionHandlerInfo exceptionHandlerInfo = new ExceptionHandlerInfoRead().load(in);
            methodComponent.getExceptionHandlers().add(exceptionHandlerInfo);
        }

        methodComponent.setMethods(new ArrayList<MethodInfo>(methodComponent.getOffsets().size()));

        if (!methodComponent.getOffsets().isEmpty() && (methodComponent.getSize() > in.getByteRead())) {

            // TODO: Rustine :s
            if (methodComponent.getOffsets().get(0) != in.getByteRead()) {

                MethodInfo m = null;

                // TODO: Rustinev2 after 2 years old :s
                if (methodComponent.getOffsets().get(1) <= in.getByteRead()) {
                    m = new MethodInfoRead().load(in, (short) (in.getByteRead()), (short) (methodComponent.getOffsets().get(2)));
                    methodComponent.getOffsets().remove(0);
                    methodComponent.getOffsets().remove(0);
                } else {
                    m = new MethodInfoRead().load(in, (short) (in.getByteRead()), (short) (methodComponent.getOffsets().get(0)));
                }

                methodComponent.getMethods().add(m);

            }

            // XXX: Regarding to {see MethodComponent.getOffsets} implementation, the results depend on the parsed method.
            // To prevent any reading error, the offset obtained by parsing CAP file components is stored in a final variable.
            final ArrayList<Short> methods_offset_before_load = (ArrayList<Short>) methodComponent.getOffsets().clone();

            // Read methods
            for (int i = 0; i < (methods_offset_before_load.size() - 1); i++) {
                MethodInfo m = new MethodInfoRead().load(in, methods_offset_before_load.get(i), methods_offset_before_load.get(i + 1));
                methodComponent.getMethods().add(m);
            }

            // Read Last method
            MethodInfo m = new MethodInfoRead().load(in, methods_offset_before_load.get(methods_offset_before_load.size() - 1), methodComponent.getSize());
            methodComponent.getMethods().add(m);

        }

        checkSize(in, methodComponent);

        return methodComponent;
    }

    public void setOffsets(ArrayList<Short> offsets) {
        this.offsets = offsets;
    }
}
