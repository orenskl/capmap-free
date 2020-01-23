/**
 * Instruction.java
 * <p>
 * Author: 2009 Guillaume Bouffard <guillaume.bouffard02@etu.unilim.fr>
 * Author: 2009 Julien Boutet <julien.boutet@etu.unilim.fr>
 * Author: 2012 Tiana Razanfindralambo <aina.razafindralambo@etu.unilim.fr>
 * Author: 2012 Julien Iguchi-Cartigny <julien.cartigny@xlim.fr>
 * <p>
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

import fr.xlim.ssd.capmanipulator.library.bytecodereader.OpCode;

/**
 * Enumerated Java Card Byte Code instructions define by the Java Card
 * Virtual Machinue Specification provides by Orcale.
 *
 * @author Tiana Razanfindralambo <aina.razafindralambo@etu.unilim.fr>
 * @copyright Université de Limoges
 */
public enum Instruction {
    NOP((byte) 0x00, 0, 0),
    AALOAD((byte) 0x24, -2, 1),
    AASTORE((byte) 0x37, -3, 0),
    ACONST_NULL((byte) 0x01, 0, 1),
    ALOAD((byte) 0x15, 0, 1),
    ALOAD_0((byte) 0x18, 0, 1),
    ALOAD_1((byte) 0x19, 0, 1),
    ALOAD_2((byte) 0x1a, 0, 1),
    ALOAD_3((byte) 0x1b, 0, 1),
    ANEWARRAY((byte) 0x91, -1, 1),
    ARETURN((byte) 0x77, -1, 0),
    ARRAYLENGTH((byte) 0x92, -1, 1),
    ASTORE((byte) 0x28, -1, 0),
    ASTORE_0((byte) 0x2b, -1, 0),
    ASTORE_1((byte) 0x2c, -1, 0),
    ASTORE_2((byte) 0x2d, -1, 0),
    ASTORE_3((byte) 0x2e, -1, 0),
    ATHROW((byte) 0x93, -1, 1),
    BALOAD((byte) 0x25, -2, 1),
    BASTORE((byte) 0x38, -3, 0),
    BIPUSH((byte) 0x12, 0, 2),
    BSPUSH((byte) 0x10, 0, 1),
    CHECKCAST((byte) 0x94, -1, 1),
    DUP((byte) 0x3d, -1, 2),
    DUP_X((byte) 0x3f, 0, 0), //REGARDER LA SPEC. COMMENT FAIRE POUR L'ARGUMENT POP/PUSH DE CETTE INSTRUCTION
    DUP2((byte) 0x3e, -2, 4),
    GETFIELD_A((byte) 0x83, -1, 1), // POUR LA SUITE DES GETFIELD_<t> ILS PEUVENT PUSH 1 ou 2...A CHECKER
    GETFIELD_B((byte) 0x84, -1, 1),
    GETFIELD_S((byte) 0x85, -1, 1),
    GETFIELD_I((byte) 0x86, -1, 1),
    GETFIELD_A_THIS((byte) 0xad, 0, 1), //LA MËME CHOSE QUE GETFUEKD_<t>
    GETFIELD_B_THIS((byte) 0xae, 0, 1),
    GETFIELD_S_THIS((byte) 0xaf, 0, 1),
    GETFIELD_I_THIS((byte) 0xb0, 0, 1),
    GETFIELD_A_W((byte) 0xa9, -1, 1), //MLEME  REMARQUE
    GETFIELD_B_W((byte) 0xaa, -1, 1),
    GETFIELD_S_W((byte) 0xab, -1, 1),
    GETFIELD_I_W((byte) 0xac, -1, 1),
    GETSTATIC_A((byte) 0x7b, 0, 1), // MEME REMARQUE
    GETSTATIC_B((byte) 0x7c, 0, 1),
    GETSTATIC_S((byte) 0x7d, 0, 1),
    GETSTATIC_I((byte) 0x7e, 0, 1),
    GOTO((byte) 0x70, 0, 0),
    GOTO_W((byte) 0xa8, 0, 0),
    I2B((byte) 0x5d, -2, 1),
    I2S((byte) 0x5e, -2, 1),
    IADD((byte) 0x42, -4, 2), //CHECK LA SPEC
    IALOAD((byte) 0x27, -2, 2),
    IAND((byte) 0x54, -4, 2),
    IASTORE((byte) 0x3a, -4, 0),
    ICMP((byte) 0x5f, -4, 1),
    ICONST_M1((byte) 0x09, 0, 2),
    ICONST_0((byte) 0x0a, 0, 2), //CHECK SPEC
    ICONST_1((byte) 0x0b, 0, 2),
    ICONST_2((byte) 0x0c, 0, 2),
    ICONST_3((byte) 0x0d, 0, 2),
    ICONST_4((byte) 0x0e, 0, 2),
    ICONST_5((byte) 0x0f, 0, 2),
    IDIV((byte) 0x48, -4, 2),
    IF_ACMPEQ((byte) 0x68, -2, 0),
    IF_ACMPNE((byte) 0x69, -2, 0),
    IF_ACMPEQ_W((byte) 0xa0, -2, 0),
    IF_ACMPNE_W((byte) 0xa1, -2, 0),
    IF_SCMPEQ((byte) 0x6a, -2, 0),
    IF_SCMPNE((byte) 0x6b, -2, 0),
    IF_SCMPLT((byte) 0x6c, -2, 0),
    IF_SCMPGE((byte) 0x6d, -2, 0),
    IF_SCMPGT((byte) 0x6e, -2, 0),
    IF_SCMPLE((byte) 0x6f, -2, 0),
    IF_SCMPEQ_W((byte) 0xa2, -2, 0),
    IF_SCMPNE_W((byte) 0xa3, -2, 0),
    IF_SCMPLT_W((byte) 0xa4, -2, 0),
    IF_SCMPGE_W((byte) 0xa5, -2, 0),
    IF_SCMPGT_W((byte) 0xa6, -2, 0),
    IF_SCMPLE_W((byte) 0xa7, -2, 0),
    IFEQ((byte) 0x60, -1, 0),
    IFNE((byte) 0x61, -1, 0),
    IFLT((byte) 0x62, -1, 0),
    IFGE((byte) 0x63, -1, 0),
    IFGT((byte) 0x64, -1, 0),
    IFLE((byte) 0x65, -1, 0),
    IFEQ_W((byte) 0x98, -1, 0),
    IFNE_W((byte) 0x99, -1, 0),
    IFLT_W((byte) 0x9A, -1, 0),
    IFGE_W((byte) 0x9B, -1, 0),
    IFGT_W((byte) 0x9C, -1, 0),
    IFLE_W((byte) 0x9D, -1, 0),
    IFNONNULL((byte) 0x67, -1, 0),
    IFNONNULL_W((byte) 0x9f, -1, 0),
    IFNULL((byte) 0x66, -1, 0),
    IFNULL_W((byte) 0x9e, -1, 0),
    IINC((byte) 0x5a, 0, 0),
    IINC_W((byte) 0x97, 0, 0),
    IIPUSH((byte) 0x14, 0, 2),
    ILOAD((byte) 0x17, 0, 2),
    ILOAD_0((byte) 0x20, 0, 2),
    ILOAD_1((byte) 0x21, 0, 2),
    ILOAD_2((byte) 0x22, 0, 2),
    ILOAD_3((byte) 0x23, 0, 2),
    ILOOKUPSWITCH((byte) 0x76, -2, 0),
    INEG((byte) 0x4c, -2, 2),
    INSTANCEOF((byte) 0x95, -1, 1),
    INVOKEINTERFACE((byte) 0x8e, -1, 0),
    INVOKESPECIAL((byte) 0x8c, -1, 0),
    INVOKESTATIC((byte) 0x8d, 0, 0),
    INVOKEVIRTUAL((byte) 0x8b, -1, 0),
    IOR((byte) 0x56, -4, 2),
    IREM((byte) 0x4a, -4, 2),
    IRETURN((byte) 0x79, -2, 0),
    ISHL((byte) 0x4e, -4, 2),
    IMUL((byte) 0x46, -4, 2),
    ISHR((byte) 0x50, -4, 2),
    ISTORE((byte) 0x2a, -2, 0),
    ISTORE_0((byte) 0x33, -2, 0),
    ISTORE_1((byte) 0x34, -2, 0),
    ISTORE_2((byte) 0x35, -2, 0),
    ISTORE_3((byte) 0x36, -2, 0),
    ISUB((byte) 0x44, -4, 2),
    ITABLESWITCH((byte) 0x74, -1, 0),
    IUSHR((byte) 0x52, -4, 2),
    IXOR((byte) 0x58, -4, 2),
    JSR((byte) 0x71, 0, 1),
    NEW((byte) 0x8f, 0, 1),
    NEWARRAY((byte) 0x90, -1, 1),
    POP((byte) 0x3b, -1, 0),
    POP2((byte) 0x3c, -2, 0),
    PUTFIELD_A((byte) 0x87, -2, 0),
    PUTFIELD_B((byte) 0x88, -2, 0),
    PUTFIELD_S((byte) 0x89, -2, 0),
    PUTFIELD_I((byte) 0x8a, -2, 0),
    PUTFIELD_A_THIS((byte) 0xb5, -1, 0),
    PUTFIELD_B_THIS((byte) 0xb6, -1, 0),
    PUTFIELD_S_THIS((byte) 0xb7, -1, 0),
    PUTFIELD_I_THIS((byte) 0xb8, -1, 0),
    PUTFIELD_A_W((byte) 0xb1, -2, 0),
    PUTFIELD_B_W((byte) 0xb2, -2, 0),
    PUTFIELD_S_W((byte) 0xb3, -2, 0),
    PUTFIELD_I_W((byte) 0xb4, -2, 0),
    PUTSTATIC_A((byte) 0x7f, -1, 0),
    PUTSTATIC_B((byte) 0x80, -1, 0),
    PUTSTATIC_S((byte) 0x81, -1, 0),
    PUTSTATIC_I((byte) 0x82, -1, 0),
    RET((byte) 0x72, 0, 0),
    RETURN((byte) 0x7a, 0, 0),
    S2B((byte) 0x5b, -1, 1),
    S2I((byte) 0x5c, -1, 2),
    SADD((byte) 0x41, -2, 1),
    SALOAD((byte) 0x26, -2, 1),
    SAND((byte) 0x53, -2, 1),
    SASTORE((byte) 0x39, -3, 0),
    SCONST_M1((byte) 0x02, 0, 1),
    SCONST_0((byte) 0x03, 0, 1),
    SCONST_1((byte) 0x04, 0, 1),
    SCONST_2((byte) 0x05, 0, 1),
    SCONST_3((byte) 0x06, 0, 1),
    SCONST_4((byte) 0x07, 0, 1),
    SCONST_5((byte) 0x08, 0, 1),
    SDIV((byte) 0x47, -2, 1),
    SINC((byte) 0x59, 0, 0),
    SINC_W((byte) 0x96, 0, 0),
    SIPUSH((byte) 0x13, 0, 2),
    SLOAD((byte) 0x16, 0, 1),
    SLOAD_0((byte) 0x1c, 0, 1),
    SLOAD_1((byte) 0x1d, 0, 1),
    SLOAD_2((byte) 0x1e, 0, 1),
    SLOAD_3((byte) 0x1f, 0, 1),
    SLOOKUPSWITCH((byte) 0x75, -1, 0),
    SMUL((byte) 0x45, -2, 1),
    SNEG((byte) 0x4b, -1, 1),
    SOR((byte) 0x55, -2, 1),
    SREM((byte) 0x49, -2, 1),
    SRETURN((byte) 0x78, -1, 0),
    SSHL((byte) 0x4d, -2, 1),
    SSHR((byte) 0x4f, -2, 1),
    SSPUSH((byte) 0x11, 0, 1),
    SSTORE((byte) 0x29, -1, 0),
    SSTORE_0((byte) 0x2f, -1, 0),
    SSTORE_1((byte) 0x30, -1, 0),
    SSTORE_2((byte) 0x31, -1, 0),
    SSTORE_3((byte) 0x32, -1, 0),
    SSUB((byte) 0x43, -2, 1),
    STABLESWITCH((byte) 0x73, -1, 0),
    SUSHR((byte) 0x51, -2, 1),
    SWAP_X((byte) 0x40, 0, 0),
    SXOR((byte) 0x57, -2, 1),
    IMPDEP1((byte) 0xFE, 0, 0),
    IMPDEP2((byte) 0xFF, 0, 0);

    public int pop;
    public int push;
    private byte value;

    private Instruction(byte value, int pop, int push) {
        this.value = value;
        this.pop = pop;
        this.push = push;
    }

    public static Instruction valueOfByOpcode(OpCode opCode) {
        return valueOfByValue(opCode.getValue());
    }

    public static Instruction valueOfByValue(byte bytecode) {
        for (Instruction instruction : values()) {
            if ((instruction.getValue() & 0x00FF) == (bytecode & 0x00FF))
                return instruction;
        }
        return null;
    }

    public byte getValue() {
        return value;
    }
}
