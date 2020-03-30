/**
 * MethodComponent.java
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

import fr.xlim.ssd.capmanipulator.library.bytecodereader.Argument;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.Offset;
import fr.xlim.ssd.capmanipulator.library.bytecodereader.OpCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * MethodComponent
 * <p/>
 * It describes each of the methods declared in this package, excluding <clinit>
 * methods and interface method declarations. Abstract method defined by classes
 * (not interfaces) are included
 *
 * @author Guillaume Bouffard
 * @author Julien Boutet
 */
public class MethodComponent extends Component {

    // Constants
    public static final byte ACC_PUBLIC = (byte) 0x01;
    public static final byte ACC_PRIVATE = (byte) 0x02;
    public static final byte ACC_PROTECTED = (byte) 0x04;
    public static final byte ACC_STATIC = (byte) 0x08;
    public static final byte ACC_FINAL = (byte) 0x10;
    public static final byte ACC_ABSTRACT = (byte) 0x40;
    public static final byte ACC_EXTENDED = (byte) 0x80;
    public static final byte ACC_INIT = (byte) 0x80;
    // number of entries in the exception_handlers array (valid values between 0
    // and 255)
    private byte handlerCount;
    // array of structures representing a catch or finally block defined in a
    // method of this package
    private ArrayList<ExceptionHandlerInfo> exceptionHandlers;
    // table listing the methods
    private ArrayList<MethodInfo> methods;
    private ArrayList<Short> offsets = new ArrayList<>();

    /*
     * (non-Javadoc) @see
     * fr.xlim.ssd.capmanipulator.library.Component#toString()
     */
    @Override
    public String toString() {
        String rl = "\n\t";
        StringBuffer ret = new StringBuffer(".method {").append(rl);
        int last_num = 0;

        //ret.append(super.toString()).append(rl);
        if (this.getHandlerCount() != 0) {
            ret.append("handler_count : ").append(this.getHandlerCount()).append(rl);

            for (int i = 0; i < this.getHandlerCount(); i++) {
                ret.append("exception_handler[")
                        .append(i).append("]{")
                        .append(this.getExceptionHandlers().get(i))
                        .append("\t}")
                        .append(rl);
            }
        }

        for (int i = 0; i < this.getMethods().size(); i++) {
            ret.append("method_info[").append(i).append("] // @");
            int num;
            String hex;

            // abstract method case => no bytecode
            if ((this.getMethods().get(i).getMethodHeader().getFlags() << 4) == (ACC_ABSTRACT & 0xFF))
                num = last_num + 1;
                // extended method header info case
            else if ((this.getMethods().get(i).getMethodHeader().getFlags() << 4) == (ACC_EXTENDED & 0xFF))
                num = this.getMethods().get(i).getOpcodeMap().entrySet().iterator().next().getKey() - 4;
                // method header info case
            else
                num = this.getMethods().get(i).getOpcodeMap().entrySet().iterator().next().getKey() - 2;

            hex = Integer.toHexString(num);
            for (int j = hex.length(); j < 4; j++)
                ret.append("0");
            String rl2 = "\n\t\t";
            ret.append(hex).append("= {").append(rl2);
            MethodInfo mi = this.getMethods().get(i);
            ret.append(mi.getMethodHeader()).append(rl);

            // in case of abstract method, the bytecodes array is empty
            if ((this.getMethods().get(i).getMethodHeader().getFlags() << 4) == ACC_ABSTRACT) {
                // no bytecode
                last_num += 2;
                ret.append('}' + rl + rl);
                continue;
            }

            // Computing label
            TreeSet<Short> labels = new TreeSet<Short>();
            labels.add(this.getMethods().get(i).getOpcodeMap().entrySet().iterator().next().getKey());
            for (Map.Entry<Short, OpCode> CurrentEntry : mi.getOpcodeMap().entrySet()) {
                ArrayList<Argument> arguments = CurrentEntry.getValue().getArguments();
                String name = CurrentEntry.getValue().getName();
                if (name.equals("slookupswitch") || name.equals("stableswitch")) {
                    short lab = (short) (CurrentEntry.getKey() + getValue(arguments.get(0)));
                    labels.add(lab);
                }
                for (int j = 0; j < arguments.size(); j++) {
                    if (arguments.get(j) instanceof Offset) {
                        Offset of = (Offset) arguments.get(j);
                        short lab = (short) (CurrentEntry.getKey() + getValue(of));
                        labels.add(lab);
                    }
                }
            }

            for (Map.Entry<Short, OpCode> CurrentEntry : mi.getOpcodeMap().entrySet()) {
                ret.append(String.format("\t/*%04x*/", CurrentEntry.getKey())).append(" ");
                last_num = CurrentEntry.getKey();
                int j = 0;
                int size = 0;
                for (Iterator<Short> it = labels.iterator(); it.hasNext() && size == 0; j++) {
                    short s = it.next();
                    if (s == CurrentEntry.getKey()) {
                        ret.append("L").append(j).append(":");
                        size = 3 + (j > 9 ? 1 : 0);
                    }
                }
                for (j = size; j < 6; j++)
                    ret.append(" ");
                //ret.append(CurrentEntry.getValue());
                OpCode op = CurrentEntry.getValue();
                ret.append(String.format("%-16s", op.getName()));
                if (op.getName().equals("checkcast")) {
                    Argument a = op.getArguments().get(0);
                    int val = getValue(a);
                    switch (val) {
                        case 10:
                            ret.append("T_BOOLEAN");
                            break;
                        case 11:
                            ret.append("T_BYTE");
                            break;
                        case 12:
                            ret.append("T_SHORT");
                            break;
                        case 13:
                            ret.append("T_INT");
                            break;
                        case 14:
                            ret.append("T_REFERENCE");
                            break;
                        default:
                            ret.append("unknown");
                            break;
                    }
                    ret.append(" , index: ").append(op.getArguments().get(1));
                } else if (op.getName().equals("invokeinterface")) {
                    ret.append(" nargs: ").append(op.getArguments().get(0)).append(", index: ");
                    ret.append(op.getArguments().get(1)).append(", method: ").append(op.getArguments().get(2));
                } else if (op.getName().equals("newarray")) {
                    Argument a = op.getArguments().get(0);
                    int val = getValue(a);
                    switch (val) {
                        case 10:
                            ret.append("boolean ");
                            break;
                        case 11:
                            ret.append("byte    ");
                            break;
                        case 12:
                            ret.append("short   ");
                            break;
                        case 13:
                            ret.append("int     ");
                            break;
                    }
                } else if (op.getName().equals("slookupswitch")) {
                    ret.append("\n//   default: goto ").append(calculateGoto(CurrentEntry.getKey(), getValue(op.getArguments().get(0)), labels));
                    ret.append("\n//   npairs : ").append(op.getArguments().get(1));
                    for (j = 2; j < op.getArguments().size() - 1; j += 2) {
                        ret.append("\n//   case ").append(op.getArguments().get(j)).append(": goto ");
                        ret.append(calculateGoto(CurrentEntry.getKey(), getValue(op.getArguments().get(j + 1)), labels));
                    }
                } else if (op.getName().equals("stableswitch")) {
                    ret.append("\n//   default: goto ").append(calculateGoto(CurrentEntry.getKey(), getValue(op.getArguments().get(0)), labels));
                    int low = getValue(op.getArguments().get(1));
                    int high = getValue(op.getArguments().get(2));
                    ret.append("\n//   low    : 0x").append(Integer.toHexString(low)).append(" //").append(low);
                    ret.append("\n//   high   : 0x").append(Integer.toHexString(high)).append(" //").append(high);
                    for (j = 3; low <= high; j++, low++) {
                        ret.append("\n//   case ").append(low).append(" : goto ");
                        ret.append(calculateGoto(CurrentEntry.getKey(), getValue(op.getArguments().get(j)), labels));
                    }
                } else {
                    for (j = 0; j < op.getArguments().size(); j++) {
                        if (j != 0)
                            ret.append(", ");
                        if (op.getArguments().get(j) instanceof Offset) {
                            ret.append(calculateGoto(CurrentEntry.getKey(), getValue(op.getArguments().get(j)), labels));
                        } else
                            ret.append(op.getArguments().get(j));
                    }
                }
                ret.append(rl);
            }
            ret.append("}");
            if (i < this.getMethods().size() - 1)
                ret.append("\n").append(rl);
        }
        ret.append("\n}\n");

        return ret.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MethodComponent out = new MethodComponent();

        out.setTag(this.getTag());
        out.setSize(this.getSize());
        out.setHandlerCount(this.getHandlerCount());

        ArrayList<ExceptionHandlerInfo> exceptionHandlerInfos = new ArrayList<>();
        for (ExceptionHandlerInfo e : this.getExceptionHandlers()) {
            exceptionHandlerInfos.add((ExceptionHandlerInfo) e.clone());
        }
        out.setExceptionHandlers(exceptionHandlerInfos);

        ArrayList<MethodInfo> methodInfos = new ArrayList<>();
        for (MethodInfo m : this.getMethods()) {
            methodInfos.add((MethodInfo) m.clone());
        }
        out.setMethods(methodInfos);

        return out;
    }

    private String calculateGoto(short opcode, short val, TreeSet<Short> labels) {
        StringBuffer ret = new StringBuffer("L");
        //short val = getValue(of);
        short lab = (short) (opcode + val);
        int i = 0;
        for (Iterator<Short> it = labels.iterator(); it.hasNext(); i++) {
            short s = it.next();
            if (s == lab) {
                ret.append(i);
            }
        }
        ret.append(" // rel:").append(val > 0 ? "+" : "").append(val).append(" (@").append(String.format("%04x)", lab));
        return ret.toString();
    }

    private short getValue(Argument a) {
        short val = 0;
        for (int i = a.getSize() - 1; i >= 0; i--) {
            if (a.isSigned()) {
                if (i != 0) {
                    val += (a.getValue()[i] & 0xff) << ((a.getSize() - 1 - i) * 8);
                } else {
                    val += (a.getValue()[i]) << ((a.getSize() - 1 - i) * 8);
                }
            } else {
                val += (a.getValue()[i] & 0xff) << ((a.getSize() - 1 - i) * 8);
            }
        }
        return val;
    }

    /**
     * Get Offsets
     *
     * @return the offsets
     */
    public ArrayList<Short> getOffsets() {

        // During the parsing step, there are no methods there
        if (this.getMethods().size() < this.offsets.size()) {
            return offsets;
        }

        // Ok, parsing was done and you've several methods
        this.offsets.clear();
        for (MethodInfo methodInfo : this.getMethods()) {
            offsets.add(methodInfo.getMethodInfoOffset());
        }
        return offsets;
    }

    /**
     * Set offsets
     *
     * @param offsets the offsets to set
     */
    public void setOffsets(ArrayList<Short> offsets) {
        this.offsets = offsets;
    }

    /**
     * Get the value of handlerCount number of entries in the exception_handlers
     * array (valid values between 0 and 255)
     *
     * @return the value of handlerCount
     */
    public byte getHandlerCount() {
        return handlerCount;
    }

    /**
     * Set the value of handlerCount number of entries in the exception_handlers
     * array (valid values between 0 and 255)
     *
     * @param newVar the new value of handlerCount
     */
    public void setHandlerCount(byte newVar) {
        handlerCount = newVar;
    }

    /**
     * Get Exception Handlers
     *
     * @return the exceptionHandlers
     */
    public ArrayList<ExceptionHandlerInfo> getExceptionHandlers() {
        return exceptionHandlers;
    }

    /**
     * Set Exception Handlers
     *
     * @param exceptionHandlers the exceptionHandlers to set
     */
    public void setExceptionHandlers(
            ArrayList<ExceptionHandlerInfo> exceptionHandlers) {
        this.exceptionHandlers = exceptionHandlers;
    }

    /**
     * Get Methods
     *
     * @return the methods
     */
    public ArrayList<MethodInfo> getMethods() {
        return methods;
    }

    /**
     * Set Methods
     *
     * @param methods the methods to set
     */
    public void setMethods(ArrayList<MethodInfo> methods) {
        this.methods = methods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodComponent that = (MethodComponent) o;

        if (handlerCount != that.handlerCount) return false;
        if (!exceptionHandlers.equals(that.exceptionHandlers)) return false;
        if (!methods.equals(that.methods)) return false;
        return offsets.equals(that.offsets);

    }
}
