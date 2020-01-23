package fr.xlim.ssd.capmanipulator.bcel.instructions;

public interface 	Constants {


    /* List of Java Card OpCodes */
    public static final short NOP			    = 0x00;
    public static final short ACONST_NULL   	= 0x01;
    public static final short SCONST_M1	    	= 0x02;
    public static final short SCONST_0	    	= 0x03;
    public static final short SCONST_1	    	= 0x04;
    public static final short SCONST_2	    	= 0x05;
    public static final short SCONST_3	    	= 0x06;
    public static final short SCONST_4	    	= 0x07;
    public static final short SCONST_5	    	= 0x08;
    public static final short ICONST_M1	    	= 0x09;
    public static final short ICONST_0	    	= 0x0A;
    public static final short ICONST_1	    	= 0x0B;
    public static final short ICONST_2	    	= 0x0C;
    public static final short ICONST_3	    	= 0x0D;
    public static final short ICONST_4	    	= 0x0E;
    public static final short ICONST_5	    	= 0x0F;
    public static final short BSPUSH	    	= 0x10;
    public static final short SSPUSH	    	= 0x11;
    public static final short BIPUSH	    	= 0x12;
    public static final short SIPUSH	    	= 0x13;
    public static final short IIPUSH	    	= 0x14;
    public static final short ALOAD		    	= 0x15;
    public static final short SLOAD		    	= 0x16;
    public static final short ILOAD		    	= 0x17;
    public static final short ALOAD_0	    	= 0x18;
    public static final short ALOAD_1	    	= 0x19;
    public static final short ALOAD_2	    	= 0x1A;
    public static final short ALOAD_3	    	= 0x1B;
    public static final short SLOAD_0	    	= 0x1C;
    public static final short SLOAD_1	    	= 0x1D;
    public static final short SLOAD_2	    	= 0x1E;
    public static final short SLOAD_3	    	= 0x1F;
    public static final short ILOAD_0	    	= 0x20;
    public static final short ILOAD_1	    	= 0x21;
    public static final short ILOAD_2	    	= 0x22;
    public static final short ILOAD_3	    	= 0x23;
    public static final short AALOAD	    	= 0x24;
    public static final short BALOAD	    	= 0x25;
    public static final short SALOAD	    	= 0x26;
    public static final short IALOAD	    	= 0x27;
    public static final short ASTORE	    	= 0x28;
    public static final short SSTORE	    	= 0x29;
    public static final short ISTORE	    	= 0x2A;
    public static final short ASTORE_0	    	= 0x2B;
    public static final short ASTORE_1	    	= 0x2C;
    public static final short ASTORE_2	    	= 0x2D;
    public static final short ASTORE_3	    	= 0x2E;
    public static final short SSTORE_0	    	= 0x2F;
    public static final short SSTORE_1	    	= 0x30;
    public static final short SSTORE_2	    	= 0x31;
    public static final short SSTORE_3	    	= 0x32;
    public static final short ISTORE_0	    	= 0x33;
    public static final short ISTORE_1	    	= 0x34;
    public static final short ISTORE_2	    	= 0x35;
    public static final short ISTORE_3	    	= 0x36;
    public static final short AASTORE	    	= 0x37;
    public static final short BASTORE	    	= 0x38;
    public static final short SASTORE	    	= 0x39;
    public static final short IASTORE	    	= 0x3A;
    public static final short POP		    	= 0x3B;
    public static final short POP2		    	= 0x3C;
    public static final short DUP		    	= 0x3D;
    public static final short DUP2		    	= 0x3E;
    public static final short DUP_X		    	= 0x3F;
    public static final short SWAP_X	    	= 0x40;
    public static final short SADD		    	= 0x41;
    public static final short IADD		    	= 0x42;
    public static final short SSUB		    	= 0x43;
    public static final short ISUB		    	= 0x44;
    public static final short SMUL		    	= 0x45;
    public static final short IMUL		    	= 0x46;
    public static final short SDIV		    	= 0x47;
    public static final short IDIV		    	= 0x48;
    public static final short SREM		    	= 0x49;
    public static final short IREM		    	= 0x4A;
    public static final short SNEG		    	= 0x4B;
    public static final short INEG		    	= 0x4C;
    public static final short SSHL		    	= 0x4D;
    public static final short ISHL		    	= 0x4E;
    public static final short SSHR		    	= 0x4F;
    public static final short ISHR		    	= 0x50;
    public static final short SUSHR		    	= 0x51;
    public static final short IUSHR		    	= 0x52;
    public static final short SAND		    	= 0x53;
    public static final short IAND		    	= 0x54;
    public static final short SOR		    	= 0x55;
    public static final short IOR		    	= 0x56;
    public static final short SXOR		    	= 0x57;
    public static final short IXOR		    	= 0x58;
    public static final short SINC		    	= 0x59;
    public static final short IINC		    	= 0x5A;
    public static final short S2B		    	= 0x5B;
    public static final short S2I		    	= 0x5C;
    public static final short I2B		    	= 0x5D;
    public static final short I2S		    	= 0x5E;
    public static final short ICMP		    	= 0x5F;
    public static final short IFEQ		    	= 0x60;
    public static final short IFNE		    	= 0x61;
    public static final short IFLT		    	= 0x62;
    public static final short IFGE		    	= 0x63;
    public static final short IFGT	    		= 0x64;
    public static final short IFLE	    		= 0x65;
    public static final short IFNULL	    	= 0x66;
    public static final short IFNONNULL	    	= 0x67;
    public static final short IF_ACMPEQ		    = 0x68;
    public static final short IF_ACMPNE		    = 0x69;
    public static final short IF_SCMPEQ		    = 0x6A;
    public static final short IF_SCMPNE		    = 0x6B;
    public static final short IF_SCMPLT		    = 0x6C;
    public static final short IF_SCMPGE		    = 0x6D;
    public static final short IF_SCMPGT		    = 0x6E;
    public static final short IF_SCMPLE		    = 0x6F;
    public static final short GOTO			    = 0x70;
    public static final short JSR		    	= 0x71;
    public static final short RET		    	= 0x72;
    public static final short STABLESWITCH		= 0x73;
    public static final short ITABLESWITCH		= 0x74;
    public static final short SLOOKUPSWITCH		= 0x75;
    public static final short ILOOKUPSWITCH		= 0x76;
    public static final short ARETURN		    = 0x77;
    public static final short SRETURN	    	= 0x78;
    public static final short IRETURN	    	= 0x79;
    public static final short RETURN	    	= 0x7A;
    public static final short GETSTATIC_A		= 0x7B;
    public static final short GETSTATIC_B		= 0x7C;
    public static final short GETSTATIC_S		= 0x7D;
    public static final short GETSTATIC_I		= 0x7E;
    public static final short PUTSTATIC_A		= 0x7F;
    public static final short PUTSTATIC_B		= 0x80;
    public static final short PUTSTATIC_S		= 0x81;
    public static final short PUTSTATIC_I		= 0x82;
    public static final short GETFIELD_A		= 0x83;
    public static final short GETFIELD_B		= 0x84;
    public static final short GETFIELD_S		= 0x85;
    public static final short GETFIELD_I		= 0x86;
    public static final short PUTFIELD_A		= 0x87;
    public static final short PUTFIELD_B		= 0x88;
    public static final short PUTFIELD_S		= 0x89;
    public static final short PUTFIELD_I		= 0x8A;
    public static final short INVOKEVIRTUAL		= 0x8B;
    public static final short INVOKESPECIAL		= 0x8C;
    public static final short INVOKESTATIC		= 0x8D;
    public static final short INVOKEINTERFACE	= 0x8E;
    public static final short NEW			    = 0x8F;
    public static final short NEWARRAY		    = 0x90;
    public static final short ANEWARRAY		    = 0x91;
    public static final short ARRAYLENGTH		= 0x92;
    public static final short ATHROW		    = 0x93;
    public static final short CHECKCAST		    = 0x94;
    public static final short INSTANCEOF		= 0x95;
    public static final short SINC_W		    = 0x96;
    public static final short IINC_W		    = 0x97;
    public static final short IFEQ_W		    = 0x98;
    public static final short IFNE_W		    = 0x99;
    public static final short IFLT_W		    = 0x9A;
    public static final short IFGE_W		    = 0x9B;
    public static final short IFGT_W		    = 0x9C;
    public static final short IFLE_W		    = 0x9D;
    public static final short IFNULL_W		    = 0x9E;
    public static final short IFNONNULL_W		= 0x9F;
    public static final short IF_ACMPEQ_W		= 0xA0;
    public static final short IF_ACMPNE_W		= 0xA1;
    public static final short IF_SCMPEQ_W		= 0xA2;
    public static final short IF_SCMPNE_W		= 0xA3;
    public static final short IF_SCMPLT_W		= 0xA4;
    public static final short IF_SCMPGE_W		= 0xA5;
    public static final short IF_SCMPGT_W		= 0xA6;
    public static final short IF_SCMPLE_W		= 0xA7;
    public static final short GOTO_W		    = 0xA8;
    public static final short GETFIELD_A_W		= 0xA9;
    public static final short GETFIELD_B_W		= 0xAA;
    public static final short GETFIELD_S_W		= 0xAB;
    public static final short GETFIELD_I_W		= 0xAC;
    public static final short GETFIELD_A_THIS	= 0xAD;
    public static final short GETFIELD_B_THIS	= 0xAE;
    public static final short GETFIELD_S_THIS	= 0xAF;
    public static final short GETFIELD_I_THIS	= 0xB0;
    public static final short PUTFIELD_A_W		= 0xB1;
    public static final short PUTFIELD_B_W		= 0xB2;
    public static final short PUTFIELD_S_W		= 0xB3;
    public static final short PUTFIELD_I_W		= 0xB4;
    public static final short PUTFIELD_A_THIS	= 0xB5;
    public static final short PUTFIELD_B_THIS	= 0xB6;
    public static final short PUTFIELD_S_THIS	= 0xB7;
    public static final short PUTFIELD_I_THIS	= 0xB8;
    public static final short IMPDEP1		    = 0xFE;
    public static final short IMPDEP2		    = 0xFF;


    public static final short  UNDEFINED      = -1;
    public static final short  UNPREDICTABLE  = -2;


    public static final String[] INSTRUCTION_NAME = {
            "NOP", "ACONST_NULL", "SCONST_M1", "SCONST_0", "SCONST_1", "SCONST_2", "SCONST_3", "SCONST_4", "SCONST_5",
            "ICONST_M1", "ICONST_0", "ICONST_1", "ICONST_2", "ICONST_3", "ICONST_4", "ICONST_5", "BSPUSH", "SSPUSH",
            "BIPUSH", "SIPUSH", "IIPUSH", "ALOAD", "SLOAD", "ILOAD", "ALOAD_0", "ALOAD_1", "ALOAD_2", "ALOAD_3",
            "SLOAD_0", "SLOAD_1", "SLOAD_2", "SLOAD_3", "ILOAD_0", "ILOAD_1", "ILOAD_2", "ILOAD_3", "AALOAD", "BALOAD",
            "SALOAD", "IALOAD", "ASTORE", "SSTORE", "ISTORE", "ASTORE_0", "ASTORE_1", "ASTORE_2", "ASTORE_3",
            "SSTORE_0", "SSTORE_1", "SSTORE_2", "SSTORE_3", "ISTORE_0", "ISTORE_1", "ISTORE_2", "ISTORE_3", "AASTORE",
            "BASTORE", "SASTORE", "IASTORE", "POP", "POP2", "DUP", "DUP2", "DUP_X", "SWAP_X", "SADD", "IADD", "SSUB",
            "ISUB", "SMUL", "IMUL", "SDIV", "IDIV", "SREM", "IREM", "SNEG", "INEG", "SSHL", "ISHL", "SSHR", "ISHR",
            "SUSHR", "IUSHR", "SAND", "IAND", "SOR", "IOR", "SXOR", "IXOR", "SINC", "IINC", "S2B", "S2I", "I2B", "I2S",
            "ICMP", "IFEQ", "IFNE", "IFLT", "IFGE", "IFGT", "IFLE", "IFNULL", "IFNONNULL", "IF_ACMPEQ", "IF_ACMPNE",
            "IF_SCMPEQ", "IF_SCMPNE", "IF_SCMPLT", "IF_SCMPGE", "IF_SCMPGT", "IF_SCMPLE", "GOTO", "JSR", "RET",
            "STABLESWITCH", "ITABLESWITCH", "SLOOKUPSWITCH", "ILOOKUPSWITCH", "ARETURN", "SRETURN", "IRETURN",
            "RETURN", "GETSTATIC_A", "GETSTATIC_B", "GETSTATIC_S", "GETSTATIC_I", "PUTSTATIC_A", "PUTSTATIC_B",
            "PUTSTATIC_S", "PUTSTATIC_I", "GETFIELD_A", "GETFIELD_B", "GETFIELD_S", "GETFIELD_I", "PUTFIELD_A",
            "PUTFIELD_B", "PUTFIELD_S", "PUTFIELD_I", "INVOKEVIRTUAL", "INVOKESPECIAL", "INVOKESTATIC",
            "INVOKEINTERFACE", "NEW", "NEWARRAY", "ANEWARRAY", "ARRAYLENGTH", "ATHROW", "CHECKCAST", "INSTANCEOF",
            "SINC_W", "IINC_W", "IFEQ_W", "IFNE_W", "IFLT_W", "IFGE_W", "IFGT_W", "IFLE_W", "IFNULL_W", "IFNONNULL_W",
            "IF_ACMPEQ_W", "IF_ACMPNE_W", "IF_SCMPEQ_W", "IF_SCMPNE_W", "IF_SCMPLT_W", "IF_SCMPGE_W", "IF_SCMPGT_W",
            "IF_SCMPLE_W", "GOTO_W", "GETFIELD_A_W", "GETFIELD_B_W", "GETFIELD_S_W", "GETFIELD_I_W", "GETFIELD_A_THIS",
            "GETFIELD_B_THIS", "GETFIELD_S_THIS", "GETFIELD_I_THIS", "PUTFIELD_A_W", "PUTFIELD_B_W", "PUTFIELD_S_W",
            "PUTFIELD_I_W", "PUTFIELD_A_THIS", "PUTFIELD_B_THIS", "PUTFIELD_S_THIS", "PUTFIELD_I_THIS",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION", "ILLEGAL INSTRUCTION",
            "IMPDEP1", "IMPDEP2"
    };
    
    
    public static final int[] INSTRUCTION_LENGTH = {
            1/*NOP*/, 1/*ACONST_NULL*/, 1/*SCONST_M1*/, 1/*SCONST_0*/, 1/*SCONST_1*/, 1/*SCONST_2*/, 1/*SCONST_3*/,
            1/*SCONST_4*/, 1/*SCONST_5*/, 1/*ICONST_M1*/, 1/*ICONST_0*/, 1/*ICONST_1*/, 1/*ICONST_2*/, 1/*ICONST_3*/,
            1/*ICONST_4*/, 1/*ICONST_5*/, 2/*BSPUSH*/, 3/*SSPUSH*/, 2/*BIPUSH*/, 3/*SIPUSH*/, 5/*IIPUSH*/, 2/*ALOAD*/,
            2/*SLOAD*/, 2/*ILOAD*/, 1/*ALOAD_0*/, 1/*ALOAD_1*/, 1/*ALOAD_2*/, 1/*ALOAD_3*/, 1/*SLOAD_0*/, 1/*SLOAD_1*/,
            1/*SLOAD_2*/, 1/*SLOAD_3*/, 1/*ILOAD_0*/, 1/*ILOAD_1*/, 1/*ILOAD_2*/, 1/*ILOAD_3*/, 1/*AALOAD*/,
            1/*BALOAD*/, 1/*SALOAD*/, 1/*IALOAD*/, 2/*ASTORE*/, 2/*SSTORE*/, 2/*ISTORE*/, 1/*ASTORE_0*/, 1/*ASTORE_1*/,
            1/*ASTORE_2*/, 1/*ASTORE_3*/, 1/*SSTORE_0*/, 1/*SSTORE_1*/, 1/*SSTORE_2*/, 1/*SSTORE_3*/, 1/*ISTORE_0*/,
            1/*ISTORE_1*/, 1/*ISTORE_2*/, 1/*ISTORE_3*/, 1/*AASTORE*/, 1/*BASTORE*/, 1/*SASTORE*/, 1/*IASTORE*/,
            1/*POP*/, 1/*POP2*/, 1/*DUP*/, 1/*DUP2*/, 2/*DUP_X*/, 2/*SWAP_X*/, 1/*SADD*/, 1/*IADD*/, 1/*SSUB*/,
            1/*ISUB*/, 1/*SMUL*/, 1/*IMUL*/, 1/*SDIV*/, 1/*IDIV*/, 1/*SREM*/, 1/*IREM*/, 1/*SNEG*/, 1/*INEG*/,
            1/*SSHL*/, 1/*ISHL*/, 1/*SSHR*/, 1/*ISHR*/, 1/*SUSHR*/, 1/*IUSHR*/, 1/*SAND*/, 1/*IAND*/, 1/*SOR*/,
            1/*IOR*/, 1/*SXOR*/, 1/*IXOR*/, 3/*SINC*/, 3/*IINC*/, 1/*S2B*/, 1/*S2I*/, 1/*I2B*/, 1/*I2S*/, 1/*ICMP*/,
            2/*IFEQ*/, 2/*IFNE*/, 2/*IFLT*/, 2/*IFGE*/, 2/*IFGT*/, 2/*IFLE*/, 2/*IFNULL*/, 2/*IFNONNULL*/,
            2/*IF_ACMPEQ*/, 2/*IF_ACMPNE*/, 2/*IF_SCMPEQ*/, 2/*IF_SCMPNE*/, 2/*IF_SCMPLT*/, 2/*IF_SCMPGE*/,
            2/*IF_SCMPGT*/, 2/*IF_SCMPLE*/, 2/*GOTO*/, 3/*JSR*/, 2/*RET*/, UNDEFINED/*STABLESWITCH*/,
            UNDEFINED/*ITABLESWITCH*/, UNDEFINED/*SLOOKUPSWITCH*/, UNDEFINED/*ILOOKUPSWITCH*/, 1/*ARETURN*/,
            1/*SRETURN*/, 1/*IRETURN*/, 1/*RETURN*/, 3/*GETSTATIC_A*/, 3/*GETSTATIC_B*/, 3/*GETSTATIC_S*/,
            3/*GETSTATIC_I*/, 3/*PUTSTATIC_A*/, 3/*PUTSTATIC_B*/, 3/*PUTSTATIC_S*/, 3/*PUTSTATIC_I*/, 2/*GETFIELD_A*/,
            2/*GETFIELD_B*/, 2/*GETFIELD_S*/, 2/*GETFIELD_I*/, 2/*PUTFIELD_A*/, 2/*PUTFIELD_B*/, 2/*PUTFIELD_S*/,
            2/*PUTFIELD_I*/, 3/*INVOKEVIRTUAL*/, 3/*INVOKESPECIAL*/, 3/*INVOKESTATIC*/, 5/*INVOKEINTERFACE*/, 3/*NEW*/,
            2/*NEWARRAY*/, 3/*ANEWARRAY*/, 1/*ARRAYLENGTH*/, 1/*ATHROW*/, 4/*CHECKCAST*/, 4/*INSTANCEOF*/, 4/*SINC_W*/,
            4/*IINC_W*/, 3/*IFEQ_W*/, 3/*IFNE_W*/, 3/*IFLT_W*/, 3/*IFGE_W*/, 3/*IFGT_W*/, 3/*IFLE_W*/, 3/*IFNULL_W*/,
            3/*IFNONNULL_W*/, 3/*IF_ACMPEQ_W*/, 3/*IF_ACMPNE_W*/, 3/*IF_SCMPEQ_W*/, 3/*IF_SCMPNE_W*/, 3/*IF_SCMPLT_W*/,
            3/*IF_SCMPGE_W*/, 3/*IF_SCMPGT_W*/, 3/*IF_SCMPLE_W*/, 3/*GOTO_W*/, 3/*GETFIELD_A_W*/, 3/*GETFIELD_B_W*/,
            3/*GETFIELD_S_W*/, 3/*GETFIELD_I_W*/, 2/*GETFIELD_A_THIS*/, 2/*GETFIELD_B_THIS*/, 2/*GETFIELD_S_THIS*/,
            2/*GETFIELD_I_THIS*/, 3/*PUTFIELD_A_W*/, 3/*PUTFIELD_B_W*/, 3/*PUTFIELD_S_W*/, 3/*PUTFIELD_I_W*/,
            2/*PUTFIELD_A_THIS*/, 2/*PUTFIELD_B_THIS*/, 2/*PUTFIELD_S_THIS*/, 2/*PUTFIELD_I_THIS*/, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, 1/*IMPDEP1*/, 1/*IMPDEP2*/,
    };

    public static final int[] CONSUME_STACK = {
        0/*NOP*/, 0/*ACONST_NULL*/, 0/*SCONST_M1*/, 0/*SCONST_0*/, 0/*SCONST_1*/, 0/*SCONST_2*/,
        0/*SCONST_3*/, 0/*SCONST_4*/, 0/*SCONST_5*/, 0/*ICONST_M1*/, 0/*ICONST_0*/, 0/*ICONST_1*/,
        0/*ICONST_2*/, 0/*ICONST_3*/, 0/*ICONST_4*/, 0/*ICONST_5*/, 0/*BSPUSH*/, 0/*SSPUSH*/,
        0/*BIPUSH*/, 0/*SIPUSH*/, 0/*IIPUSH*/, 0/*ALOAD*/, 0/*SLOAD*/, 0/*ILOAD*/,
        0/*ALOAD_0*/, 0/*ALOAD_1*/, 0/*ALOAD_2*/, 0/*ALOAD_3*/, 0/*SLOAD_0*/, 0/*SLOAD_1*/,
        0/*SLOAD_2*/, 0/*SLOAD_3*/, 0/*ILOAD_0*/, 0/*ILOAD_1*/, 0/*ILOAD_2*/, 0/*ILOAD_3*/,
        2/*AALOAD*/, 2/*BALOAD*/, 2/*SALOAD*/, 2/*IALOAD*/, 1/*ASTORE*/, 1/*SSTORE*/,
        2/*ISTORE*/, 1/*ASTORE_0*/, 1/*ASTORE_1*/, 1/*ASTORE_2*/, 1/*ASTORE_3*/, 1/*SSTORE_0*/,
        1/*SSTORE_1*/, 1/*SSTORE_2*/, 1/*SSTORE_3*/, 2/*ISTORE_0*/, 2/*ISTORE_1*/, 2/*ISTORE_2*/,
        2/*ISTORE_3*/, 3/*AASTORE*/, 3/*BASTORE*/, 3/*SASTORE*/, 4/*IASTORE*/, 1/*POP*/,
        2/*POP2*/, 1/*DUP*/, 2/*DUP2*/, UNPREDICTABLE/*DUP_X*/, UNPREDICTABLE/*SWAP_X*/, 2/*SADD*/,
        4/*IADD*/, 2/*SSUB*/, 4/*ISUB*/, 2/*SMUL*/, 4/*IMUL*/, 2/*SDIV*/,
        4/*IDIV*/, 2/*SREM*/, 4/*IREM*/, 1/*SNEG*/, 2/*INEG*/, 2/*SSHL*/,
        4/*ISHL*/, 2/*SSHR*/, 4/*ISHR*/, 2/*SUSHR*/, 4/*IUSHR*/, 2/*SAND*/,
        4/*IAND*/, 2/*SOR*/, 4/*IOR*/, 2/*SXOR*/, 4/*IXOR*/, 0/*SINC*/,
        0/*IINC*/, 1/*S2B*/, 1/*S2I*/, 2/*I2B*/, 2/*I2S*/, 4/*ICMP*/,
        1/*IFEQ*/, 1/*IFNE*/, 1/*IFLT*/, 1/*IFGE*/, 1/*IFGT*/, 1/*IFLE*/,
        1/*IFNULL*/, 1/*IFNONNULL*/, 2/*IF_ACMPEQ*/, 2/*IF_ACMPNE*/, 2/*IF_SCMPEQ*/, 2/*IF_SCMPNE*/,
        2/*IF_SCMPLT*/, 2/*IF_SCMPGE*/, 2/*IF_SCMPGT*/, 2/*IF_SCMPLE*/, 0/*GOTO*/, 0/*JSR*/,
        0/*RET*/, 1/*STABLESWITCH*/, 1/*ITABLESWITCH*/, 1/*SLOOKUPSWITCH*/, 2/*ILOOKUPSWITCH*/, 1/*ARETURN*/,
        1/*SRETURN*/, 2/*IRETURN*/, 0/*RETURN*/, 0/*GETSTATIC_A*/, 0/*GETSTATIC_B*/, 0/*GETSTATIC_S*/,
        0/*GETSTATIC_I*/, 1/*PUTSTATIC_A*/, 1/*PUTSTATIC_B*/, 1/*PUTSTATIC_S*/,
        2/*PUTSTATIC_I*/, 1/*GETFIELD_A*/, 1/*GETFIELD_B*/, 1/*GETFIELD_S*/, 1/*GETFIELD_I*/,
        2/*PUTFIELD_A*/, 2/*PUTFIELD_B*/, 2/*PUTFIELD_S*/,
        3/*PUTFIELD_I*/, UNPREDICTABLE/*INVOKEVIRTUAL*/, UNPREDICTABLE/*INVOKESPECIAL*/,
        UNPREDICTABLE/*INVOKESTATIC*/, UNPREDICTABLE/*INVOKEINTERFACE*/, 0/*NEW*/, 1/*NEWARRAY*/, 1/*ANEWARRAY*/,
        1/*ARRAYLENGTH*/, 1/*ATHROW*/, 1/*CHECKCAST*/, 1/*INSTANCEOF*/, 0/*SINC_W*/, 0/*IINC_W*/, 1/*IFEQ_W*/,
        1/*IFNE_W*/, 1/*IFLT_W*/, 1/*IFGE_W*/, 1/*IFGT_W*/, 1/*IFLE_W*/, 1/*IFNULL_W*/,
        1/*IFNONNULL_W*/, 2/*IF_ACMPEQ_W*/, 2/*IF_ACMPNE_W*/, 2/*IF_SCMPEQ_W*/, 2/*IF_SCMPNE_W*/, 2/*IF_SCMPLT_W*/,
        2/*IF_SCMPGE_W*/, 2/*IF_SCMPGT_W*/, 2/*IF_SCMPLE_W*/, 0/*GOTO_W*/, 1/*GETFIELD_A_W*/, 1/*GETFIELD_B_W*/,
        1/*GETFIELD_S_W*/, 1/*GETFIELD_I_W*/, 0/*GETFIELD_A_THIS*/, 0/*GETFIELD_B_THIS*/, 0/*GETFIELD_S_THIS*/,
        0/*GETFIELD_I_THIS*/, 2/*PUTFIELD_A_W*/, 2/*PUTFIELD_B_W*/,
        2/*PUTFIELD_S_W*/, 3/*PUTFIELD_I_W*/, 1/*PUTFIELD_A_THIS*/, 1/*PUTFIELD_B_THIS*/,
        1/*PUTFIELD_S_THIS*/, 2/*PUTFIELD_I_THIS*/, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
        UNPREDICTABLE/*IMPDEP1*/, UNPREDICTABLE/*IMPDEP2*/
    };
    
    public static final int[] PRODUCE_STACK = {
            0/*NOP*/, 1/*ACONST_NULL*/, 1/*SCONST_M1*/, 1/*SCONST_0*/, 1/*SCONST_1*/, 1/*SCONST_2*/, 1/*SCONST_3*/,
            1/*SCONST_4*/, 1/*SCONST_5*/, 2/*ICONST_M1*/, 2/*ICONST_0*/, 2/*ICONST_1*/, 2/*ICONST_2*/, 2/*ICONST_3*/,
            2/*ICONST_4*/, 2/*ICONST_5*/, 1/*BSPUSH*/, 1/*SSPUSH*/, 2/*BIPUSH*/, 2/*SIPUSH*/, 2/*IIPUSH*/, 1/*ALOAD*/,
            1/*SLOAD*/, 2/*ILOAD*/, 1/*ALOAD_0*/, 1/*ALOAD_1*/, 1/*ALOAD_2*/, 1/*ALOAD_3*/, 1/*SLOAD_0*/, 1/*SLOAD_1*/,
            1/*SLOAD_2*/, 1/*SLOAD_3*/, 2/*ILOAD_0*/, 2/*ILOAD_1*/, 2/*ILOAD_2*/, 2/*ILOAD_3*/, 1/*AALOAD*/,
            1/*BALOAD*/, 1/*SALOAD*/, 2/*IALOAD*/, 0/*ASTORE*/, 0/*SSTORE*/, 0/*ISTORE*/, 0/*ASTORE_0*/, 0/*ASTORE_1*/,
            0/*ASTORE_2*/, 0/*ASTORE_3*/, 0/*SSTORE_0*/, 0/*SSTORE_1*/, 0/*SSTORE_2*/, 0/*SSTORE_3*/, 0/*ISTORE_0*/,
            0/*ISTORE_1*/, 0/*ISTORE_2*/, 0/*ISTORE_3*/, 0/*AASTORE*/, 0/*BASTORE*/, 0/*SASTORE*/, 0/*IASTORE*/,
            0/*POP*/, 0/*POP2*/, 2/*DUP*/, 4/*DUP2*/, UNPREDICTABLE/*DUP_X*/, UNPREDICTABLE/*SWAP_X*/, 1/*SADD*/,
            2/*IADD*/, 1/*SSUB*/, 2/*ISUB*/, 1/*SMUL*/, 2/*IMUL*/, 1/*SDIV*/, 2/*IDIV*/, 1/*SREM*/, 2/*IREM*/,
            1/*SNEG*/, 2/*INEG*/, 1/*SSHL*/, 2/*ISHL*/, 1/*SSHR*/, 2/*ISHR*/, 1/*SUSHR*/, 2/*IUSHR*/, 1/*SAND*/,
            2/*IAND*/, 1/*SOR*/, 2/*IOR*/, 1/*SXOR*/, 2/*IXOR*/, 0/*SINC*/, 0/*IINC*/, 1/*S2B*/, 2/*S2I*/, 1/*I2B*/,
            1/*I2S*/, 1/*ICMP*/, 0/*IFEQ*/, 0/*IFNE*/, 0/*IFLT*/, 0/*IFGE*/, 0/*IFGT*/, 0/*IFLE*/, 0/*IFNULL*/,
            0/*IFNONNULL*/, 0/*IF_ACMPEQ*/, 0/*IF_ACMPNE*/, 0/*IF_SCMPEQ*/, 0/*IF_SCMPNE*/, 0/*IF_SCMPLT*/,
            0/*IF_SCMPGE*/, 0/*IF_SCMPGT*/, 0/*IF_SCMPLE*/, 0/*GOTO*/, 1/*JSR*/, 0/*RET*/, 0/*STABLESWITCH*/,
            0/*ITABLESWITCH*/, 0/*SLOOKUPSWITCH*/, 0/*ILOOKUPSWITCH*/, UNPREDICTABLE/*ARETURN*/, UNPREDICTABLE/*SRETURN*/,
			UNPREDICTABLE/*IRETURN*/, UNPREDICTABLE/*RETURN*/, 1/*GETSTATIC_A*/, 1/*GETSTATIC_B*/, 1/*GETSTATIC_S*/, 2/*GETSTATIC_I*/,
            0/*PUTSTATIC_A*/, 0/*PUTSTATIC_B*/, 0/*PUTSTATIC_S*/, 0/*PUTSTATIC_I*/, 1/*GETFIELD_A*/, 1/*GETFIELD_B*/,
            1/*GETFIELD_S*/, 2/*GETFIELD_I*/, 0/*PUTFIELD_A*/, 0/*PUTFIELD_B*/, 0/*PUTFIELD_S*/, 0/*PUTFIELD_I*/,
            0/*INVOKEVIRTUAL*/, 0/*INVOKESPECIAL*/, 0/*INVOKESTATIC*/, 0/*INVOKEINTERFACE*/, 1/*NEW*/, 1/*NEWARRAY*/,
            1/*ANEWARRAY*/, 1/*ARRAYLENGTH*/, 1/*ATHROW*/, 1/*CHECKCAST*/, 1/*INSTANCEOF*/, 0/*SINC_W*/, 0/*IINC_W*/,
            0/*IFEQ_W*/, 0/*IFNE_W*/, 0/*IFLT_W*/, 0/*IFGE_W*/, 0/*IFGT_W*/, 0/*IFLE_W*/, 0/*IFNULL_W*/,
            0/*IFNONNULL_W*/, 0/*IF_ACMPEQ_W*/, 0/*IF_ACMPNE_W*/, 0/*IF_SCMPEQ_W*/, 0/*IF_SCMPNE_W*/, 0/*IF_SCMPLT_W*/,
            0/*IF_SCMPGE_W*/, 0/*IF_SCMPGT_W*/, 0/*IF_SCMPLE_W*/, 0/*GOTO_W*/, 1/*GETFIELD_A_W*/, 1/*GETFIELD_B_W*/,
            1/*GETFIELD_S_W*/, 2/*GETFIELD_I_W*/, 1/*GETFIELD_A_THIS*/, 1/*GETFIELD_B_THIS*/, 1/*GETFIELD_S_THIS*/,
            2/*GETFIELD_I_THIS*/, 0/*PUTFIELD_A_W*/, 0/*PUTFIELD_B_W*/, 0/*PUTFIELD_S_W*/, 0/*PUTFIELD_I_W*/,
            0/*PUTFIELD_A_THIS*/, 0/*PUTFIELD_B_THIS*/, 0/*PUTFIELD_S_THIS*/, 0/*PUTFIELD_I_THIS*/, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED,
            UNDEFINED, UNDEFINED, UNDEFINED, UNDEFINED, UNPREDICTABLE/*IMPDEP1*/, UNPREDICTABLE/*IMPDEP2*/
    };

}
