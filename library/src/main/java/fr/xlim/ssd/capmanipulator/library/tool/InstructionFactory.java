/**
 * InstructionFactory.java
 * <p>
 * Copyright (C) 2012 Tiana Razanfindralambo <aina.razafindralambo@etu.unilim.fr>n
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
package fr.xlim.ssd.capmanipulator.library.tool;

import fr.xlim.ssd.capmanipulator.library.Instruction;

public class InstructionFactory {

    public static boolean isAValidInstruction(String instruction) {
        for (Instruction ins : Instruction.values()) {
            if (ins.name().equals(instruction)) {
                return true;
            }
        }
        return false;
    }

    public static Instruction getInstruction(String name) {
        for (Instruction ins : Instruction.values()) {
            System.out.println(ins.name() + "___" + name);
            if (ins.name().equals(name)) {
                return ins;
            }
        }

        return null;
    }


}
