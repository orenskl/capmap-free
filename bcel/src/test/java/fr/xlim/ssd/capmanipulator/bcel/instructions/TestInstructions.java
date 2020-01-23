package fr.xlim.ssd.capmanipulator.bcel.instructions;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;


public class TestInstructions {



	@Test
	public void TestNOP(){
		NOP instNOP = new NOP(1);

		Assert.assertEquals(instNOP.getOpCode(), 0x00);
		Assert.assertEquals(instNOP.getLength(), 1);
		Assert.assertEquals(instNOP.getName(), "NOP");
		Assert.assertEquals(instNOP.consumeStack(), 0);
		Assert.assertEquals(instNOP.getOffSet(), 1);
		Assert.assertEquals(instNOP.produceStack(), 0);
	}

	@Test
	public void TestACONST_NULL(){
		ACONST_NULL instACONST_NULL = new ACONST_NULL(1);

		Assert.assertEquals(instACONST_NULL.getOpCode(), 0x01);
		Assert.assertEquals(instACONST_NULL.getLength(), 1);
		Assert.assertEquals(instACONST_NULL.getName(), "ACONST_NULL");
		Assert.assertEquals(instACONST_NULL.consumeStack(), 0);
		Assert.assertEquals(instACONST_NULL.getOffSet(), 1);
		Assert.assertEquals(instACONST_NULL.produceStack(), 1);
	}

	@Test
	public void TestSCONST_M1(){
		SCONST_M1 instSCONST_M1 = new SCONST_M1(1);

		Assert.assertEquals(instSCONST_M1.getOpCode(), 0x02);
		Assert.assertEquals(instSCONST_M1.getLength(), 1);
		Assert.assertEquals(instSCONST_M1.getName(), "SCONST_M1");
		Assert.assertEquals(instSCONST_M1.consumeStack(), 0);
		Assert.assertEquals(instSCONST_M1.getOffSet(), 1);
		Assert.assertEquals(instSCONST_M1.produceStack(), 1);
	}

	@Test
	public void TestSCONST_0(){
		SCONST_0 instSCONST_0 = new SCONST_0(1);

		Assert.assertEquals(instSCONST_0.getOpCode(), 0x03);
		Assert.assertEquals(instSCONST_0.getLength(), 1);
		Assert.assertEquals(instSCONST_0.getName(), "SCONST_0");
		Assert.assertEquals(instSCONST_0.consumeStack(), 0);
		Assert.assertEquals(instSCONST_0.getOffSet(), 1);
		Assert.assertEquals(instSCONST_0.produceStack(), 1);
	}

	@Test
	public void TestSCONST_1(){
		SCONST_1 instSCONST_1 = new SCONST_1(1);

		Assert.assertEquals(instSCONST_1.getOpCode(), 0x04);
		Assert.assertEquals(instSCONST_1.getLength(), 1);
		Assert.assertEquals(instSCONST_1.getName(), "SCONST_1");
		Assert.assertEquals(instSCONST_1.consumeStack(), 0);
		Assert.assertEquals(instSCONST_1.getOffSet(), 1);
		Assert.assertEquals(instSCONST_1.produceStack(), 1);
	}

	@Test
	public void TestSCONST_2(){
		SCONST_2 instSCONST_2 = new SCONST_2(1);

		Assert.assertEquals(instSCONST_2.getOpCode(), 0x05);
		Assert.assertEquals(instSCONST_2.getLength(), 1);
		Assert.assertEquals(instSCONST_2.getName(), "SCONST_2");
		Assert.assertEquals(instSCONST_2.consumeStack(), 0);
		Assert.assertEquals(instSCONST_2.getOffSet(), 1);
		Assert.assertEquals(instSCONST_2.produceStack(), 1);
	}

	@Test
	public void TestSCONST_3(){
		SCONST_3 instSCONST_3 = new SCONST_3(1);

		Assert.assertEquals(instSCONST_3.getOpCode(), 0x06);
		Assert.assertEquals(instSCONST_3.getLength(), 1);
		Assert.assertEquals(instSCONST_3.getName(), "SCONST_3");
		Assert.assertEquals(instSCONST_3.consumeStack(), 0);
		Assert.assertEquals(instSCONST_3.getOffSet(), 1);
		Assert.assertEquals(instSCONST_3.produceStack(), 1);
	}

	@Test
	public void TestSCONST_4(){
		SCONST_4 instSCONST_4 = new SCONST_4(1);

		Assert.assertEquals(instSCONST_4.getOpCode(), 0x07);
		Assert.assertEquals(instSCONST_4.getLength(), 1);
		Assert.assertEquals(instSCONST_4.getName(), "SCONST_4");
		Assert.assertEquals(instSCONST_4.consumeStack(), 0);
		Assert.assertEquals(instSCONST_4.getOffSet(), 1);
		Assert.assertEquals(instSCONST_4.produceStack(), 1);
	}

	@Test
	public void TestSCONST_5(){
		SCONST_5 instSCONST_5 = new SCONST_5(1);

		Assert.assertEquals(instSCONST_5.getOpCode(), 0x08);
		Assert.assertEquals(instSCONST_5.getLength(), 1);
		Assert.assertEquals(instSCONST_5.getName(), "SCONST_5");
		Assert.assertEquals(instSCONST_5.consumeStack(), 0);
		Assert.assertEquals(instSCONST_5.getOffSet(), 1);
		Assert.assertEquals(instSCONST_5.produceStack(), 1);
	}

	@Test
	public void TestICONST_M1(){
		ICONST_M1 instICONST_M1 = new ICONST_M1(1);

		Assert.assertEquals(instICONST_M1.getOpCode(), 0x09);
		Assert.assertEquals(instICONST_M1.getLength(), 1);
		Assert.assertEquals(instICONST_M1.getName(), "ICONST_M1");
		Assert.assertEquals(instICONST_M1.consumeStack(), 0);
		Assert.assertEquals(instICONST_M1.getOffSet(), 1);
		Assert.assertEquals(instICONST_M1.produceStack(), 2);
	}

	@Test
	public void TestICONST_0(){
		ICONST_0 instICONST_0 = new ICONST_0(1);

		Assert.assertEquals(instICONST_0.getOpCode(), 0x0a);
		Assert.assertEquals(instICONST_0.getLength(), 1);
		Assert.assertEquals(instICONST_0.getName(), "ICONST_0");
		Assert.assertEquals(instICONST_0.consumeStack(), 0);
		Assert.assertEquals(instICONST_0.getOffSet(), 1);
		Assert.assertEquals(instICONST_0.produceStack(), 2);
	}

	@Test
	public void TestICONST_1(){
		ICONST_1 instICONST_1 = new ICONST_1(1);

		Assert.assertEquals(instICONST_1.getOpCode(), 0x0b);
		Assert.assertEquals(instICONST_1.getLength(), 1);
		Assert.assertEquals(instICONST_1.getName(), "ICONST_1");
		Assert.assertEquals(instICONST_1.consumeStack(), 0);
		Assert.assertEquals(instICONST_1.getOffSet(), 1);
		Assert.assertEquals(instICONST_1.produceStack(), 2);
	}

	@Test
	public void TestICONST_2(){
		ICONST_2 instICONST_2 = new ICONST_2(1);

		Assert.assertEquals(instICONST_2.getOpCode(), 0x0c);
		Assert.assertEquals(instICONST_2.getLength(), 1);
		Assert.assertEquals(instICONST_2.getName(), "ICONST_2");
		Assert.assertEquals(instICONST_2.consumeStack(), 0);
		Assert.assertEquals(instICONST_2.getOffSet(), 1);
		Assert.assertEquals(instICONST_2.produceStack(), 2);
	}

	@Test
	public void TestICONST_3(){
		ICONST_3 instICONST_3 = new ICONST_3(1);

		Assert.assertEquals(instICONST_3.getOpCode(), 0x0d);
		Assert.assertEquals(instICONST_3.getLength(), 1);
		Assert.assertEquals(instICONST_3.getName(), "ICONST_3");
		Assert.assertEquals(instICONST_3.consumeStack(), 0);
		Assert.assertEquals(instICONST_3.getOffSet(), 1);
		Assert.assertEquals(instICONST_3.produceStack(), 2);
	}

	@Test
	public void TestICONST_4(){
		ICONST_4 instICONST_4 = new ICONST_4(1);

		Assert.assertEquals(instICONST_4.getOpCode(), 0x0e);
		Assert.assertEquals(instICONST_4.getLength(), 1);
		Assert.assertEquals(instICONST_4.getName(), "ICONST_4");
		Assert.assertEquals(instICONST_4.consumeStack(), 0);
		Assert.assertEquals(instICONST_4.getOffSet(), 1);
		Assert.assertEquals(instICONST_4.produceStack(), 2);
	}

	@Test
	public void TestICONST_5(){
		ICONST_5 instICONST_5 = new ICONST_5(1);

		Assert.assertEquals(instICONST_5.getOpCode(), 0x0f);
		Assert.assertEquals(instICONST_5.getLength(), 1);
		Assert.assertEquals(instICONST_5.getName(), "ICONST_5");
		Assert.assertEquals(instICONST_5.consumeStack(), 0);
		Assert.assertEquals(instICONST_5.getOffSet(), 1);
		Assert.assertEquals(instICONST_5.produceStack(), 2);
	}

	@Test
	public void TestBSPUSH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		BSPUSH instBSPUSH = new BSPUSH(0, byteArray);

		Assert.assertEquals(instBSPUSH.getOpCode(), 0x10);
		Assert.assertEquals(instBSPUSH.getLength(), 2);
		Assert.assertEquals(instBSPUSH.getName(), "BSPUSH");
		Assert.assertEquals(instBSPUSH.consumeStack(), 0);
		Assert.assertEquals(instBSPUSH.getOffSet(), 0);
		Assert.assertEquals(instBSPUSH.produceStack(), 1);
	}

	@Test
	public void TestSSPUSH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		SSPUSH instSSPUSH = new SSPUSH(0, byteArray);

		Assert.assertEquals(instSSPUSH.getOpCode(), 0x11);
		Assert.assertEquals(instSSPUSH.getLength(), 3);
		Assert.assertEquals(instSSPUSH.getName(), "SSPUSH");
		Assert.assertEquals(instSSPUSH.consumeStack(), 0);
		Assert.assertEquals(instSSPUSH.getOffSet(), 0);
		Assert.assertEquals(instSSPUSH.produceStack(), 1);
	}

	@Test
	public void TestBIPUSH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		BIPUSH instBIPUSH = new BIPUSH(0, byteArray);

		Assert.assertEquals(instBIPUSH.getOpCode(), 0x12);
		Assert.assertEquals(instBIPUSH.getLength(), 2);
		Assert.assertEquals(instBIPUSH.getName(), "BIPUSH");
		Assert.assertEquals(instBIPUSH.consumeStack(), 0);
		Assert.assertEquals(instBIPUSH.getOffSet(), 0);
		Assert.assertEquals(instBIPUSH.produceStack(), 2);
	}

	@Test
	public void TestSIPUSH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		SIPUSH instSIPUSH = new SIPUSH(0, byteArray);

		Assert.assertEquals(instSIPUSH.getOpCode(), 0x13);
		Assert.assertEquals(instSIPUSH.getLength(), 3);
		Assert.assertEquals(instSIPUSH.getName(), "SIPUSH");
		Assert.assertEquals(instSIPUSH.consumeStack(), 0);
		Assert.assertEquals(instSIPUSH.getOffSet(), 0);
		Assert.assertEquals(instSIPUSH.produceStack(), 2);
	}

	@Test
	public void TestIIPUSH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);
		byteArray.add((byte) 0x44);
		byteArray.add((byte) 0x45);

		IIPUSH instIIPUSH = new IIPUSH(0, byteArray);

		Assert.assertEquals(instIIPUSH.getOpCode(), 0x14);
		Assert.assertEquals(instIIPUSH.getLength(), 5);
		Assert.assertEquals(instIIPUSH.getName(), "IIPUSH");
		Assert.assertEquals(instIIPUSH.consumeStack(), 0);
		Assert.assertEquals(instIIPUSH.getOffSet(), 0);
		Assert.assertEquals(instIIPUSH.produceStack(), 2);
	}

	@Test
	public void TestALOAD(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		ALOAD instALOAD = new ALOAD(0, byteArray);

		Assert.assertEquals(instALOAD.getOpCode(), 0x15);
		Assert.assertEquals(instALOAD.getLength(), 2);
		Assert.assertEquals(instALOAD.getName(), "ALOAD");
		Assert.assertEquals(instALOAD.consumeStack(), 0);
		Assert.assertEquals(instALOAD.getOffSet(), 0);
		Assert.assertEquals(instALOAD.produceStack(), 1);
	}

	@Test
	public void TestSLOAD(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		SLOAD instSLOAD = new SLOAD(0, byteArray);

		Assert.assertEquals(instSLOAD.getOpCode(), 0x16);
		Assert.assertEquals(instSLOAD.getLength(), 2);
		Assert.assertEquals(instSLOAD.getName(), "SLOAD");
		Assert.assertEquals(instSLOAD.consumeStack(), 0);
		Assert.assertEquals(instSLOAD.getOffSet(), 0);
		Assert.assertEquals(instSLOAD.produceStack(), 1);
	}

	@Test
	public void TestILOAD(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		ILOAD instILOAD = new ILOAD(0, byteArray);

		Assert.assertEquals(instILOAD.getOpCode(), 0x17);
		Assert.assertEquals(instILOAD.getLength(), 2);
		Assert.assertEquals(instILOAD.getName(), "ILOAD");
		Assert.assertEquals(instILOAD.consumeStack(), 0);
		Assert.assertEquals(instILOAD.getOffSet(), 0);
		Assert.assertEquals(instILOAD.produceStack(), 2);
	}

	@Test
	public void TestALOAD_0(){
		ALOAD_0 instALOAD_0 = new ALOAD_0(1);

		Assert.assertEquals(instALOAD_0.getOpCode(), 0x18);
		Assert.assertEquals(instALOAD_0.getLength(), 1);
		Assert.assertEquals(instALOAD_0.getName(), "ALOAD_0");
		Assert.assertEquals(instALOAD_0.consumeStack(), 0);
		Assert.assertEquals(instALOAD_0.getOffSet(), 1);
		Assert.assertEquals(instALOAD_0.produceStack(), 1);
	}

	@Test
	public void TestALOAD_1(){
		ALOAD_1 instALOAD_1 = new ALOAD_1(1);

		Assert.assertEquals(instALOAD_1.getOpCode(), 0x19);
		Assert.assertEquals(instALOAD_1.getLength(), 1);
		Assert.assertEquals(instALOAD_1.getName(), "ALOAD_1");
		Assert.assertEquals(instALOAD_1.consumeStack(), 0);
		Assert.assertEquals(instALOAD_1.getOffSet(), 1);
		Assert.assertEquals(instALOAD_1.produceStack(), 1);
	}

	@Test
	public void TestALOAD_2(){
		ALOAD_2 instALOAD_2 = new ALOAD_2(1);

		Assert.assertEquals(instALOAD_2.getOpCode(), 0x1A);
		Assert.assertEquals(instALOAD_2.getLength(), 1);
		Assert.assertEquals(instALOAD_2.getName(), "ALOAD_2");
		Assert.assertEquals(instALOAD_2.consumeStack(), 0);
		Assert.assertEquals(instALOAD_2.getOffSet(), 1);
		Assert.assertEquals(instALOAD_2.produceStack(), 1);
	}

	@Test
	public void TestALOAD_3(){
		ALOAD_3 instALOAD_3 = new ALOAD_3(1);

		Assert.assertEquals(instALOAD_3.getOpCode(), 0x1B);
		Assert.assertEquals(instALOAD_3.getLength(), 1);
		Assert.assertEquals(instALOAD_3.getName(), "ALOAD_3");
		Assert.assertEquals(instALOAD_3.consumeStack(), 0);
		Assert.assertEquals(instALOAD_3.getOffSet(), 1);
		Assert.assertEquals(instALOAD_3.produceStack(), 1);
	}

	@Test
	public void TestSLOAD_0(){
		SLOAD_0 instSLOAD_0 = new SLOAD_0(1);

		Assert.assertEquals(instSLOAD_0.getOpCode(), 0x1C);
		Assert.assertEquals(instSLOAD_0.getLength(), 1);
		Assert.assertEquals(instSLOAD_0.getName(), "SLOAD_0");
		Assert.assertEquals(instSLOAD_0.consumeStack(), 0);
		Assert.assertEquals(instSLOAD_0.getOffSet(), 1);
		Assert.assertEquals(instSLOAD_0.produceStack(), 1);
	}

	@Test
	public void TestSLOAD_1(){
		SLOAD_1 instSLOAD_1 = new SLOAD_1(1);

		Assert.assertEquals(instSLOAD_1.getOpCode(), 0x1D);
		Assert.assertEquals(instSLOAD_1.getLength(), 1);
		Assert.assertEquals(instSLOAD_1.getName(), "SLOAD_1");
		Assert.assertEquals(instSLOAD_1.consumeStack(), 0);
		Assert.assertEquals(instSLOAD_1.getOffSet(), 1);
		Assert.assertEquals(instSLOAD_1.produceStack(), 1);
	}

	@Test
	public void TestSLOAD_2(){
		SLOAD_2 instSLOAD_2 = new SLOAD_2(1);

		Assert.assertEquals(instSLOAD_2.getOpCode(), 0x1E);
		Assert.assertEquals(instSLOAD_2.getLength(), 1);
		Assert.assertEquals(instSLOAD_2.getName(), "SLOAD_2");
		Assert.assertEquals(instSLOAD_2.consumeStack(), 0);
		Assert.assertEquals(instSLOAD_2.getOffSet(), 1);
		Assert.assertEquals(instSLOAD_2.produceStack(), 1);
	}

	@Test
	public void TestSLOAD_3(){
		SLOAD_3 instSLOAD_3 = new SLOAD_3(1);

		Assert.assertEquals(instSLOAD_3.getOpCode(), 0x1F);
		Assert.assertEquals(instSLOAD_3.getLength(), 1);
		Assert.assertEquals(instSLOAD_3.getName(), "SLOAD_3");
		Assert.assertEquals(instSLOAD_3.consumeStack(), 0);
		Assert.assertEquals(instSLOAD_3.getOffSet(), 1);
		Assert.assertEquals(instSLOAD_3.produceStack(), 1);
	}

	@Test
	public void TestILOAD_0(){
		ILOAD_0 instILOAD_0 = new ILOAD_0(1);

		Assert.assertEquals(instILOAD_0.getOpCode(), 0x20);
		Assert.assertEquals(instILOAD_0.getLength(), 1);
		Assert.assertEquals(instILOAD_0.getName(), "ILOAD_0");
		Assert.assertEquals(instILOAD_0.consumeStack(), 0);
		Assert.assertEquals(instILOAD_0.getOffSet(), 1);
		Assert.assertEquals(instILOAD_0.produceStack(), 2);
	}

	@Test
	public void TestILOAD_1(){
		ILOAD_1 instILOAD_1 = new ILOAD_1(1);

		Assert.assertEquals(instILOAD_1.getOpCode(), 0x21);
		Assert.assertEquals(instILOAD_1.getLength(), 1);
		Assert.assertEquals(instILOAD_1.getName(), "ILOAD_1");
		Assert.assertEquals(instILOAD_1.consumeStack(), 0);
		Assert.assertEquals(instILOAD_1.getOffSet(), 1);
		Assert.assertEquals(instILOAD_1.produceStack(), 2);
	}

	@Test
	public void TestILOAD_2(){
		ILOAD_2 instILOAD_2 = new ILOAD_2(1);

		Assert.assertEquals(instILOAD_2.getOpCode(), 0x22);
		Assert.assertEquals(instILOAD_2.getLength(), 1);
		Assert.assertEquals(instILOAD_2.getName(), "ILOAD_2");
		Assert.assertEquals(instILOAD_2.consumeStack(), 0);
		Assert.assertEquals(instILOAD_2.getOffSet(), 1);
		Assert.assertEquals(instILOAD_2.produceStack(), 2);
	}

	@Test
	public void TestILOAD_3(){
		ILOAD_3 instILOAD_3 = new ILOAD_3(1);

		Assert.assertEquals(instILOAD_3.getOpCode(), 0x23);
		Assert.assertEquals(instILOAD_3.getLength(), 1);
		Assert.assertEquals(instILOAD_3.getName(), "ILOAD_3");
		Assert.assertEquals(instILOAD_3.consumeStack(), 0);
		Assert.assertEquals(instILOAD_3.getOffSet(), 1);
		Assert.assertEquals(instILOAD_3.produceStack(), 2);
	}

	@Test
	public void TestAALOAD(){
		AALOAD instAALOAD = new AALOAD(1);

		Assert.assertEquals(instAALOAD.getOpCode(), 0x24);
		Assert.assertEquals(instAALOAD.getLength(), 1);
		Assert.assertEquals(instAALOAD.getName(), "AALOAD");
		Assert.assertEquals(instAALOAD.consumeStack(), 2);
		Assert.assertEquals(instAALOAD.getOffSet(), 1);
		Assert.assertEquals(instAALOAD.produceStack(), 1);
	}

	@Test
	public void TestBALOAD(){
		BALOAD instBALOAD = new BALOAD(1);

		Assert.assertEquals(instBALOAD.getOpCode(), 0x25);
		Assert.assertEquals(instBALOAD.getLength(), 1);
		Assert.assertEquals(instBALOAD.getName(), "BALOAD");
		Assert.assertEquals(instBALOAD.consumeStack(), 2);
		Assert.assertEquals(instBALOAD.getOffSet(), 1);
		Assert.assertEquals(instBALOAD.produceStack(), 1);
	}

	@Test
	public void TestSALOAD(){
		SALOAD instSALOAD = new SALOAD(1);

		Assert.assertEquals(instSALOAD.getOpCode(), 0x26);
		Assert.assertEquals(instSALOAD.getLength(), 1);
		Assert.assertEquals(instSALOAD.getName(), "SALOAD");
		Assert.assertEquals(instSALOAD.consumeStack(), 2);
		Assert.assertEquals(instSALOAD.getOffSet(), 1);
		Assert.assertEquals(instSALOAD.produceStack(), 1);
	}

	@Test
	public void TestIALOAD(){
		IALOAD instIALOAD = new IALOAD(1);

		Assert.assertEquals(instIALOAD.getOpCode(), 0x27);
		Assert.assertEquals(instIALOAD.getLength(), 1);
		Assert.assertEquals(instIALOAD.getName(), "IALOAD");
		Assert.assertEquals(instIALOAD.consumeStack(), 2);
		Assert.assertEquals(instIALOAD.getOffSet(), 1);
		Assert.assertEquals(instIALOAD.produceStack(), 2);
	}

	@Test
	public void TestASTORE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		ASTORE instASTORE = new ASTORE(0, byteArray);

		Assert.assertEquals(instASTORE.getOpCode(), 0x28);
		Assert.assertEquals(instASTORE.getLength(), 2);
		Assert.assertEquals(instASTORE.getName(), "ASTORE");
		Assert.assertEquals(instASTORE.consumeStack(), 1);
		Assert.assertEquals(instASTORE.getOffSet(), 0);
		Assert.assertEquals(instASTORE.produceStack(), 0);
	}

	@Test
	public void TestSSTORE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		SSTORE instSSTORE = new SSTORE(0, byteArray);

		Assert.assertEquals(instSSTORE.getOpCode(), 0x29);
		Assert.assertEquals(instSSTORE.getLength(), 2);
		Assert.assertEquals(instSSTORE.getName(), "SSTORE");
		Assert.assertEquals(instSSTORE.consumeStack(), 1);
		Assert.assertEquals(instSSTORE.getOffSet(), 0);
		Assert.assertEquals(instSSTORE.produceStack(), 0);
	}

	@Test
	public void TestISTORE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		ISTORE instISTORE = new ISTORE(0, byteArray);

		Assert.assertEquals(instISTORE.getOpCode(), 0x2A);
		Assert.assertEquals(instISTORE.getLength(), 2);
		Assert.assertEquals(instISTORE.getName(), "ISTORE");
		Assert.assertEquals(instISTORE.consumeStack(), 2);
		Assert.assertEquals(instISTORE.getOffSet(), 0);
		Assert.assertEquals(instISTORE.produceStack(), 0);
	}

	@Test
	public void TestASTORE_0(){
		ASTORE_0 instASTORE_0 = new ASTORE_0(1);

		Assert.assertEquals(instASTORE_0.getOpCode(), 0x2B);
		Assert.assertEquals(instASTORE_0.getLength(), 1);
		Assert.assertEquals(instASTORE_0.getName(), "ASTORE_0");
		Assert.assertEquals(instASTORE_0.consumeStack(), 1);
		Assert.assertEquals(instASTORE_0.getOffSet(), 1);
		Assert.assertEquals(instASTORE_0.produceStack(), 0);
	}

	@Test
	public void TestASTORE_1(){
		ASTORE_1 instASTORE_1 = new ASTORE_1(1);

		Assert.assertEquals(instASTORE_1.getOpCode(), 0x2C);
		Assert.assertEquals(instASTORE_1.getLength(), 1);
		Assert.assertEquals(instASTORE_1.getName(), "ASTORE_1");
		Assert.assertEquals(instASTORE_1.consumeStack(), 1);
		Assert.assertEquals(instASTORE_1.getOffSet(), 1);
		Assert.assertEquals(instASTORE_1.produceStack(), 0);
	}

	@Test
	public void TestASTORE_2(){
		ASTORE_2 instASTORE_2 = new ASTORE_2(1);

		Assert.assertEquals(instASTORE_2.getOpCode(), 0x2D);
		Assert.assertEquals(instASTORE_2.getLength(), 1);
		Assert.assertEquals(instASTORE_2.getName(), "ASTORE_2");
		Assert.assertEquals(instASTORE_2.consumeStack(), 1);
		Assert.assertEquals(instASTORE_2.getOffSet(), 1);
		Assert.assertEquals(instASTORE_2.produceStack(), 0);
	}

	@Test
	public void TestASTORE_3(){
		ASTORE_3 instASTORE_3 = new ASTORE_3(1);

		Assert.assertEquals(instASTORE_3.getOpCode(), 0x2E);
		Assert.assertEquals(instASTORE_3.getLength(), 1);
		Assert.assertEquals(instASTORE_3.getName(), "ASTORE_3");
		Assert.assertEquals(instASTORE_3.consumeStack(), 1);
		Assert.assertEquals(instASTORE_3.getOffSet(), 1);
		Assert.assertEquals(instASTORE_3.produceStack(), 0);
	}

	@Test
	public void TestSSTORE_0(){
		SSTORE_0 instSSTORE_0 = new SSTORE_0(1);

		Assert.assertEquals(instSSTORE_0.getOpCode(), 0x2F);
		Assert.assertEquals(instSSTORE_0.getLength(), 1);
		Assert.assertEquals(instSSTORE_0.getName(), "SSTORE_0");
		Assert.assertEquals(instSSTORE_0.consumeStack(), 1);
		Assert.assertEquals(instSSTORE_0.getOffSet(), 1);
		Assert.assertEquals(instSSTORE_0.produceStack(), 0);
	}

	@Test
	public void TestSSTORE_1(){
		SSTORE_1 instSSTORE_1 = new SSTORE_1(1);

		Assert.assertEquals(instSSTORE_1.getOpCode(), 0x30);
		Assert.assertEquals(instSSTORE_1.getLength(), 1);
		Assert.assertEquals(instSSTORE_1.getName(), "SSTORE_1");
		Assert.assertEquals(instSSTORE_1.consumeStack(), 1);
		Assert.assertEquals(instSSTORE_1.getOffSet(), 1);
		Assert.assertEquals(instSSTORE_1.produceStack(), 0);
	}

	@Test
	public void TestSSTORE_2(){
		SSTORE_2 instSSTORE_2 = new SSTORE_2(1);

		Assert.assertEquals(instSSTORE_2.getOpCode(), 0x31);
		Assert.assertEquals(instSSTORE_2.getLength(), 1);
		Assert.assertEquals(instSSTORE_2.getName(), "SSTORE_2");
		Assert.assertEquals(instSSTORE_2.consumeStack(), 1);
		Assert.assertEquals(instSSTORE_2.getOffSet(), 1);
		Assert.assertEquals(instSSTORE_2.produceStack(), 0);
	}

	@Test
	public void TestSSTORE_3(){
		SSTORE_3 instSSTORE_3 = new SSTORE_3(1);

		Assert.assertEquals(instSSTORE_3.getOpCode(), 0x32);
		Assert.assertEquals(instSSTORE_3.getLength(), 1);
		Assert.assertEquals(instSSTORE_3.getName(), "SSTORE_3");
		Assert.assertEquals(instSSTORE_3.consumeStack(), 1);
		Assert.assertEquals(instSSTORE_3.getOffSet(), 1);
		Assert.assertEquals(instSSTORE_3.produceStack(), 0);
	}

	@Test
	public void TestISTORE_0(){
		ISTORE_0 instISTORE_0 = new ISTORE_0(1);

		Assert.assertEquals(instISTORE_0.getOpCode(), 0x33);
		Assert.assertEquals(instISTORE_0.getLength(), 1);
		Assert.assertEquals(instISTORE_0.getName(), "ISTORE_0");
		Assert.assertEquals(instISTORE_0.consumeStack(), 2);
		Assert.assertEquals(instISTORE_0.getOffSet(), 1);
		Assert.assertEquals(instISTORE_0.produceStack(), 0);
	}

	@Test
	public void TestISTORE_1(){
		ISTORE_1 instISTORE_1 = new ISTORE_1(1);

		Assert.assertEquals(instISTORE_1.getOpCode(), 0x34);
		Assert.assertEquals(instISTORE_1.getLength(), 1);
		Assert.assertEquals(instISTORE_1.getName(), "ISTORE_1");
		Assert.assertEquals(instISTORE_1.consumeStack(), 2);
		Assert.assertEquals(instISTORE_1.getOffSet(), 1);
		Assert.assertEquals(instISTORE_1.produceStack(), 0);
	}

	@Test
	public void TestISTORE_2(){
		ISTORE_2 instISTORE_2 = new ISTORE_2(1);

		Assert.assertEquals(instISTORE_2.getOpCode(), 0x35);
		Assert.assertEquals(instISTORE_2.getLength(), 1);
		Assert.assertEquals(instISTORE_2.getName(), "ISTORE_2");
		Assert.assertEquals(instISTORE_2.consumeStack(), 2);
		Assert.assertEquals(instISTORE_2.getOffSet(), 1);
		Assert.assertEquals(instISTORE_2.produceStack(), 0);
	}

	@Test
	public void TestISTORE_3(){
		ISTORE_3 instISTORE_3 = new ISTORE_3(1);

		Assert.assertEquals(instISTORE_3.getOpCode(), 0x36);
		Assert.assertEquals(instISTORE_3.getLength(), 1);
		Assert.assertEquals(instISTORE_3.getName(), "ISTORE_3");
		Assert.assertEquals(instISTORE_3.consumeStack(), 2);
		Assert.assertEquals(instISTORE_3.getOffSet(), 1);
		Assert.assertEquals(instISTORE_3.produceStack(), 0);
	}

	@Test
	public void TestAASTORE(){
		AASTORE instAASTORE = new AASTORE(1);

		Assert.assertEquals(instAASTORE.getOpCode(), 0x37);
		Assert.assertEquals(instAASTORE.getLength(), 1);
		Assert.assertEquals(instAASTORE.getName(), "AASTORE");
		Assert.assertEquals(instAASTORE.consumeStack(), 3);
		Assert.assertEquals(instAASTORE.getOffSet(), 1);
		Assert.assertEquals(instAASTORE.produceStack(), 0);
	}

	@Test
	public void TestBASTORE(){
		BASTORE instBASTORE = new BASTORE(1);

		Assert.assertEquals(instBASTORE.getOpCode(), 0x38);
		Assert.assertEquals(instBASTORE.getLength(), 1);
		Assert.assertEquals(instBASTORE.getName(), "BASTORE");
		Assert.assertEquals(instBASTORE.consumeStack(), 3);
		Assert.assertEquals(instBASTORE.getOffSet(), 1);
		Assert.assertEquals(instBASTORE.produceStack(), 0);
	}

	@Test
	public void TestSASTORE(){
		SASTORE instSASTORE = new SASTORE(1);

		Assert.assertEquals(instSASTORE.getOpCode(), 0x39);
		Assert.assertEquals(instSASTORE.getLength(), 1);
		Assert.assertEquals(instSASTORE.getName(), "SASTORE");
		Assert.assertEquals(instSASTORE.consumeStack(), 3);
		Assert.assertEquals(instSASTORE.getOffSet(), 1);
		Assert.assertEquals(instSASTORE.produceStack(), 0);
	}

	@Test
	public void TestIASTORE(){
		IASTORE instIASTORE = new IASTORE(1);

		Assert.assertEquals(instIASTORE.getOpCode(), 0x3A);
		Assert.assertEquals(instIASTORE.getLength(), 1);
		Assert.assertEquals(instIASTORE.getName(), "IASTORE");
		Assert.assertEquals(instIASTORE.consumeStack(), 4);
		Assert.assertEquals(instIASTORE.getOffSet(), 1);
		Assert.assertEquals(instIASTORE.produceStack(), 0);
	}

	@Test
	public void TestPOP(){
		POP instPOP = new POP(1);

		Assert.assertEquals(instPOP.getOpCode(), 0x3B);
		Assert.assertEquals(instPOP.getLength(), 1);
		Assert.assertEquals(instPOP.getName(), "POP");
		Assert.assertEquals(instPOP.consumeStack(), 1);
		Assert.assertEquals(instPOP.getOffSet(), 1);
		Assert.assertEquals(instPOP.produceStack(), 0);
	}

	@Test
	public void TestPOP2(){
		POP2 instPOP2 = new POP2(1);

		Assert.assertEquals(instPOP2.getOpCode(), 0x3C);
		Assert.assertEquals(instPOP2.getLength(), 1);
		Assert.assertEquals(instPOP2.getName(), "POP2");
		Assert.assertEquals(instPOP2.consumeStack(), 2);
		Assert.assertEquals(instPOP2.getOffSet(), 1);
		Assert.assertEquals(instPOP2.produceStack(), 0);
	}

	@Test
	public void TestDUP(){
		DUP instDUP = new DUP(1);

		Assert.assertEquals(instDUP.getOpCode(), 0x3D);
		Assert.assertEquals(instDUP.getLength(), 1);
		Assert.assertEquals(instDUP.getName(), "DUP");
		Assert.assertEquals(instDUP.consumeStack(), 1);
		Assert.assertEquals(instDUP.getOffSet(), 1);
		Assert.assertEquals(instDUP.produceStack(), 2);
	}

	@Test
	public void TestDUP2(){
		DUP2 instDUP2 = new DUP2(1);

		Assert.assertEquals(instDUP2.getOpCode(), 0x3E);
		Assert.assertEquals(instDUP2.getLength(), 1);
		Assert.assertEquals(instDUP2.getName(), "DUP2");
		Assert.assertEquals(instDUP2.consumeStack(), 2);
		Assert.assertEquals(instDUP2.getOffSet(), 1);
		Assert.assertEquals(instDUP2.produceStack(), 4);
	}

	@Test
	public void TestDUP_X(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		DUP_X instDUP_X = new DUP_X(0, byteArray);

		Assert.assertEquals(instDUP_X.getOpCode(), 0x3F);
		Assert.assertEquals(instDUP_X.getLength(), 2);
		Assert.assertEquals(instDUP_X.getName(), "DUP_X");
		Assert.assertEquals(instDUP_X.getOffSet(), 0);
	}

	@Test
	public void TestSWAP_X(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		SWAP_X instSWAP_X = new SWAP_X(0, byteArray);

		Assert.assertEquals(instSWAP_X.getOpCode(), 0x40);
		Assert.assertEquals(instSWAP_X.getLength(), 2);
		Assert.assertEquals(instSWAP_X.getName(), "SWAP_X");
		Assert.assertEquals(instSWAP_X.getOffSet(), 0);
	}

	@Test
	public void TestSADD(){
		SADD instSADD = new SADD(1);

		Assert.assertEquals(instSADD.getOpCode(), 0x41);
		Assert.assertEquals(instSADD.getLength(), 1);
		Assert.assertEquals(instSADD.getName(), "SADD");
		Assert.assertEquals(instSADD.consumeStack(), 2);
		Assert.assertEquals(instSADD.getOffSet(), 1);
		Assert.assertEquals(instSADD.produceStack(), 1);
	}

	@Test
	public void TestIADD(){
		IADD instIADD = new IADD(1);

		Assert.assertEquals(instIADD.getOpCode(), 0x42);
		Assert.assertEquals(instIADD.getLength(), 1);
		Assert.assertEquals(instIADD.getName(), "IADD");
		Assert.assertEquals(instIADD.consumeStack(), 4);
		Assert.assertEquals(instIADD.getOffSet(), 1);
		Assert.assertEquals(instIADD.produceStack(), 2);
	}

	@Test
	public void TestSSUB(){
		SSUB instSSUB = new SSUB(1);

		Assert.assertEquals(instSSUB.getOpCode(), 0x43);
		Assert.assertEquals(instSSUB.getLength(), 1);
		Assert.assertEquals(instSSUB.getName(), "SSUB");
		Assert.assertEquals(instSSUB.consumeStack(), 2);
		Assert.assertEquals(instSSUB.getOffSet(), 1);
		Assert.assertEquals(instSSUB.produceStack(), 1);
	}

	@Test
	public void TestISUB(){
		ISUB instISUB = new ISUB(1);

		Assert.assertEquals(instISUB.getOpCode(), 0x44);
		Assert.assertEquals(instISUB.getLength(), 1);
		Assert.assertEquals(instISUB.getName(), "ISUB");
		Assert.assertEquals(instISUB.consumeStack(), 4);
		Assert.assertEquals(instISUB.getOffSet(), 1);
		Assert.assertEquals(instISUB.produceStack(), 2);
	}

	@Test
	public void TestSMUL(){
		SMUL instSMUL = new SMUL(1);

		Assert.assertEquals(instSMUL.getOpCode(), 0x45);
		Assert.assertEquals(instSMUL.getLength(), 1);
		Assert.assertEquals(instSMUL.getName(), "SMUL");
		Assert.assertEquals(instSMUL.consumeStack(), 2);
		Assert.assertEquals(instSMUL.getOffSet(), 1);
		Assert.assertEquals(instSMUL.produceStack(), 1);
	}

	@Test
	public void TestIMUL(){
		IMUL instIMUL = new IMUL(1);

		Assert.assertEquals(instIMUL.getOpCode(), 0x46);
		Assert.assertEquals(instIMUL.getLength(), 1);
		Assert.assertEquals(instIMUL.getName(), "IMUL");
		Assert.assertEquals(instIMUL.consumeStack(), 4);
		Assert.assertEquals(instIMUL.getOffSet(), 1);
		Assert.assertEquals(instIMUL.produceStack(), 2);
	}

	@Test
	public void TestSDIV(){
		SDIV instSDIV = new SDIV(1);

		Assert.assertEquals(instSDIV.getOpCode(), 0x47);
		Assert.assertEquals(instSDIV.getLength(), 1);
		Assert.assertEquals(instSDIV.getName(), "SDIV");
		Assert.assertEquals(instSDIV.consumeStack(), 2);
		Assert.assertEquals(instSDIV.getOffSet(), 1);
		Assert.assertEquals(instSDIV.produceStack(), 1);
	}

	@Test
	public void TestIDIV(){
		IDIV instIDIV = new IDIV(1);

		Assert.assertEquals(instIDIV.getOpCode(), 0x48);
		Assert.assertEquals(instIDIV.getLength(), 1);
		Assert.assertEquals(instIDIV.getName(), "IDIV");
		Assert.assertEquals(instIDIV.consumeStack(), 4);
		Assert.assertEquals(instIDIV.getOffSet(), 1);
		Assert.assertEquals(instIDIV.produceStack(), 2);
	}

	@Test
	public void TestSREM(){
		SREM instSREM = new SREM(1);

		Assert.assertEquals(instSREM.getOpCode(), 0x49);
		Assert.assertEquals(instSREM.getLength(), 1);
		Assert.assertEquals(instSREM.getName(), "SREM");
		Assert.assertEquals(instSREM.consumeStack(), 2);
		Assert.assertEquals(instSREM.getOffSet(), 1);
		Assert.assertEquals(instSREM.produceStack(), 1);
	}

	@Test
	public void TestIREM(){
		IREM instIREM = new IREM(1);

		Assert.assertEquals(instIREM.getOpCode(), 0x4A);
		Assert.assertEquals(instIREM.getLength(), 1);
		Assert.assertEquals(instIREM.getName(), "IREM");
		Assert.assertEquals(instIREM.consumeStack(), 4);
		Assert.assertEquals(instIREM.getOffSet(), 1);
		Assert.assertEquals(instIREM.produceStack(), 2);
	}

	@Test
	public void TestSNEG(){
		SNEG instSNEG = new SNEG(1);

		Assert.assertEquals(instSNEG.getOpCode(), 0x4B);
		Assert.assertEquals(instSNEG.getLength(), 1);
		Assert.assertEquals(instSNEG.getName(), "SNEG");
		Assert.assertEquals(instSNEG.consumeStack(), 1);
		Assert.assertEquals(instSNEG.getOffSet(), 1);
		Assert.assertEquals(instSNEG.produceStack(), 1);
	}

	@Test
	public void TestINEG(){
		INEG instINEG = new INEG(1);

		Assert.assertEquals(instINEG.getOpCode(), 0x4C);
		Assert.assertEquals(instINEG.getLength(), 1);
		Assert.assertEquals(instINEG.getName(), "INEG");
		Assert.assertEquals(instINEG.consumeStack(), 2);
		Assert.assertEquals(instINEG.getOffSet(), 1);
		Assert.assertEquals(instINEG.produceStack(), 2);
	}

	@Test
	public void TestSSHL(){
		SSHL instSSHL = new SSHL(1);

		Assert.assertEquals(instSSHL.getOpCode(), 0x4D);
		Assert.assertEquals(instSSHL.getLength(), 1);
		Assert.assertEquals(instSSHL.getName(), "SSHL");
		Assert.assertEquals(instSSHL.consumeStack(), 2);
		Assert.assertEquals(instSSHL.getOffSet(), 1);
		Assert.assertEquals(instSSHL.produceStack(), 1);
	}

	@Test
	public void TestISHL(){
		ISHL instISHL = new ISHL(1);

		Assert.assertEquals(instISHL.getOpCode(), 0x4E);
		Assert.assertEquals(instISHL.getLength(), 1);
		Assert.assertEquals(instISHL.getName(), "ISHL");
		Assert.assertEquals(instISHL.consumeStack(), 4);
		Assert.assertEquals(instISHL.getOffSet(), 1);
		Assert.assertEquals(instISHL.produceStack(), 2);
	}

	@Test
	public void TestSSHR(){
		SSHR instSSHR = new SSHR(1);

		Assert.assertEquals(instSSHR.getOpCode(), 0x4F);
		Assert.assertEquals(instSSHR.getLength(), 1);
		Assert.assertEquals(instSSHR.getName(), "SSHR");
		Assert.assertEquals(instSSHR.consumeStack(), 2);
		Assert.assertEquals(instSSHR.getOffSet(), 1);
		Assert.assertEquals(instSSHR.produceStack(), 1);
	}

	@Test
	public void TestISHR(){
		ISHR instISHR = new ISHR(1);

		Assert.assertEquals(instISHR.getOpCode(), 0x50);
		Assert.assertEquals(instISHR.getLength(), 1);
		Assert.assertEquals(instISHR.getName(), "ISHR");
		Assert.assertEquals(instISHR.consumeStack(), 4);
		Assert.assertEquals(instISHR.getOffSet(), 1);
		Assert.assertEquals(instISHR.produceStack(), 2);
	}

	@Test
	public void TestSUSHR(){
		SUSHR instSUSHR = new SUSHR(1);

		Assert.assertEquals(instSUSHR.getOpCode(), 0x51);
		Assert.assertEquals(instSUSHR.getLength(), 1);
		Assert.assertEquals(instSUSHR.getName(), "SUSHR");
		Assert.assertEquals(instSUSHR.consumeStack(), 2);
		Assert.assertEquals(instSUSHR.getOffSet(), 1);
		Assert.assertEquals(instSUSHR.produceStack(), 1);
	}

	@Test
	public void TestIUSHR(){
		IUSHR instIUSHR = new IUSHR(1);

		Assert.assertEquals(instIUSHR.getOpCode(), 0x52);
		Assert.assertEquals(instIUSHR.getLength(), 1);
		Assert.assertEquals(instIUSHR.getName(), "IUSHR");
		Assert.assertEquals(instIUSHR.consumeStack(), 4);
		Assert.assertEquals(instIUSHR.getOffSet(), 1);
		Assert.assertEquals(instIUSHR.produceStack(), 2);
	}

	@Test
	public void TestSAND(){
		SAND instSAND = new SAND(1);

		Assert.assertEquals(instSAND.getOpCode(), 0x53);
		Assert.assertEquals(instSAND.getLength(), 1);
		Assert.assertEquals(instSAND.getName(), "SAND");
		Assert.assertEquals(instSAND.consumeStack(), 2);
		Assert.assertEquals(instSAND.getOffSet(), 1);
		Assert.assertEquals(instSAND.produceStack(), 1);
	}

	@Test
	public void TestIAND(){
		IAND instIAND = new IAND(1);

		Assert.assertEquals(instIAND.getOpCode(), 0x54);
		Assert.assertEquals(instIAND.getLength(), 1);
		Assert.assertEquals(instIAND.getName(), "IAND");
		Assert.assertEquals(instIAND.consumeStack(), 4);
		Assert.assertEquals(instIAND.getOffSet(), 1);
		Assert.assertEquals(instIAND.produceStack(), 2);
	}

	@Test
	public void TestSOR(){
		SOR instSOR = new SOR(1);

		Assert.assertEquals(instSOR.getOpCode(), 0x55);
		Assert.assertEquals(instSOR.getLength(), 1);
		Assert.assertEquals(instSOR.getName(), "SOR");
		Assert.assertEquals(instSOR.consumeStack(), 2);
		Assert.assertEquals(instSOR.getOffSet(), 1);
		Assert.assertEquals(instSOR.produceStack(), 1);
	}

	@Test
	public void TestIOR(){
		IOR instIOR = new IOR(1);

		Assert.assertEquals(instIOR.getOpCode(), 0x56);
		Assert.assertEquals(instIOR.getLength(), 1);
		Assert.assertEquals(instIOR.getName(), "IOR");
		Assert.assertEquals(instIOR.consumeStack(), 4);
		Assert.assertEquals(instIOR.getOffSet(), 1);
		Assert.assertEquals(instIOR.produceStack(), 2);
	}

	@Test
	public void TestSXOR(){
		SXOR instSXOR = new SXOR(1);

		Assert.assertEquals(instSXOR.getOpCode(), 0x57);
		Assert.assertEquals(instSXOR.getLength(), 1);
		Assert.assertEquals(instSXOR.getName(), "SXOR");
		Assert.assertEquals(instSXOR.consumeStack(), 2);
		Assert.assertEquals(instSXOR.getOffSet(), 1);
		Assert.assertEquals(instSXOR.produceStack(), 1);
	}

	@Test
	public void TestIXOR(){
		IXOR instIXOR = new IXOR(1);

		Assert.assertEquals(instIXOR.getOpCode(), 0x58);
		Assert.assertEquals(instIXOR.getLength(), 1);
		Assert.assertEquals(instIXOR.getName(), "IXOR");
		Assert.assertEquals(instIXOR.consumeStack(), 4);
		Assert.assertEquals(instIXOR.getOffSet(), 1);
		Assert.assertEquals(instIXOR.produceStack(), 2);
	}

	@Test
	public void TestSINC(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		SINC instSINC = new SINC(0, byteArray);

		Assert.assertEquals(instSINC.getOpCode(), 0x59);
		Assert.assertEquals(instSINC.getLength(), 3);
		Assert.assertEquals(instSINC.getName(), "SINC");
		Assert.assertEquals(instSINC.consumeStack(), 0);
		Assert.assertEquals(instSINC.getOffSet(), 0);
		Assert.assertEquals(instSINC.produceStack(), 0);
	}

	@Test
	public void TestIINC(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IINC instIINC = new IINC(0, byteArray);

		Assert.assertEquals(instIINC.getOpCode(), 0x5A);
		Assert.assertEquals(instIINC.getLength(), 3);
		Assert.assertEquals(instIINC.getName(), "IINC");
		Assert.assertEquals(instIINC.consumeStack(), 0);
		Assert.assertEquals(instIINC.getOffSet(), 0);
		Assert.assertEquals(instIINC.produceStack(), 0);
	}

	@Test
	public void TestS2B(){
		S2B instS2B = new S2B(1);

		Assert.assertEquals(instS2B.getOpCode(), 0x5B);
		Assert.assertEquals(instS2B.getLength(), 1);
		Assert.assertEquals(instS2B.getName(), "S2B");
		Assert.assertEquals(instS2B.consumeStack(), 1);
		Assert.assertEquals(instS2B.getOffSet(), 1);
		Assert.assertEquals(instS2B.produceStack(), 1);
	}

	@Test
	public void TestS2I(){
		S2I instS2I = new S2I(1);

		Assert.assertEquals(instS2I.getOpCode(), 0x5C);
		Assert.assertEquals(instS2I.getLength(), 1);
		Assert.assertEquals(instS2I.getName(), "S2I");
		Assert.assertEquals(instS2I.consumeStack(), 1);
		Assert.assertEquals(instS2I.getOffSet(), 1);
		Assert.assertEquals(instS2I.produceStack(), 2);
	}

	@Test
	public void TestI2B(){
		I2B instI2B = new I2B(1);

		Assert.assertEquals(instI2B.getOpCode(), 0x5D);
		Assert.assertEquals(instI2B.getLength(), 1);
		Assert.assertEquals(instI2B.getName(), "I2B");
		Assert.assertEquals(instI2B.consumeStack(), 2);
		Assert.assertEquals(instI2B.getOffSet(), 1);
		Assert.assertEquals(instI2B.produceStack(), 1);
	}

	@Test
	public void TestI2S(){
		I2S instI2S = new I2S(1);

		Assert.assertEquals(instI2S.getOpCode(), 0x5E);
		Assert.assertEquals(instI2S.getLength(), 1);
		Assert.assertEquals(instI2S.getName(), "I2S");
		Assert.assertEquals(instI2S.consumeStack(), 2);
		Assert.assertEquals(instI2S.getOffSet(), 1);
		Assert.assertEquals(instI2S.produceStack(), 1);
	}

	@Test
	public void TestICMP(){
		ICMP instICMP = new ICMP(1);

		Assert.assertEquals(instICMP.getOpCode(), 0x5F);
		Assert.assertEquals(instICMP.getLength(), 1);
		Assert.assertEquals(instICMP.getName(), "ICMP");
		Assert.assertEquals(instICMP.consumeStack(), 4);
		Assert.assertEquals(instICMP.getOffSet(), 1);
		Assert.assertEquals(instICMP.produceStack(), 1);
	}

	@Test
	public void TestIFEQ(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFEQ instIFEQ = new IFEQ(0, byteArray);

		Assert.assertEquals(instIFEQ.getOpCode(), 0x60);
		Assert.assertEquals(instIFEQ.getLength(), 2);
		Assert.assertEquals(instIFEQ.getName(), "IFEQ");
		Assert.assertEquals(instIFEQ.consumeStack(), 1);
		Assert.assertEquals(instIFEQ.getOffSet(), 0);
		Assert.assertEquals(instIFEQ.produceStack(), 0);
	}

	@Test
	public void TestIFNE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFNE instIFNE = new IFNE(0, byteArray);

		Assert.assertEquals(instIFNE.getOpCode(), 0x61);
		Assert.assertEquals(instIFNE.getLength(), 2);
		Assert.assertEquals(instIFNE.getName(), "IFNE");
		Assert.assertEquals(instIFNE.consumeStack(), 1);
		Assert.assertEquals(instIFNE.getOffSet(), 0);
		Assert.assertEquals(instIFNE.produceStack(), 0);
	}

	@Test
	public void TestIFLT(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFLT instIFLT = new IFLT(0, byteArray);

		Assert.assertEquals(instIFLT.getOpCode(), 0x62);
		Assert.assertEquals(instIFLT.getLength(), 2);
		Assert.assertEquals(instIFLT.getName(), "IFLT");
		Assert.assertEquals(instIFLT.consumeStack(), 1);
		Assert.assertEquals(instIFLT.getOffSet(), 0);
		Assert.assertEquals(instIFLT.produceStack(), 0);
	}

	@Test
	public void TestIFGE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFGE instIFGE = new IFGE(0,  byteArray);

		Assert.assertEquals(instIFGE.getOpCode(), 0x63);
		Assert.assertEquals(instIFGE.getLength(), 2);
		Assert.assertEquals(instIFGE.getName(), "IFGE");
		Assert.assertEquals(instIFGE.consumeStack(), 1);
		Assert.assertEquals(instIFGE.getOffSet(), 0);
		Assert.assertEquals(instIFGE.produceStack(), 0);
	}

	@Test
	public void TestIFGT(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFGT instIFGT = new IFGT(0, byteArray);

		Assert.assertEquals(instIFGT.getOpCode(), 0x64);
		Assert.assertEquals(instIFGT.getLength(), 2);
		Assert.assertEquals(instIFGT.getName(), "IFGT");
		Assert.assertEquals(instIFGT.consumeStack(), 1);
		Assert.assertEquals(instIFGT.getOffSet(), 0);
		Assert.assertEquals(instIFGT.produceStack(), 0);
	}

	@Test
	public void TestIFLE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFLE instIFLE = new IFLE(0, byteArray);

		Assert.assertEquals(instIFLE.getOpCode(), 0x65);
		Assert.assertEquals(instIFLE.getLength(), 2);
		Assert.assertEquals(instIFLE.getName(), "IFLE");
		Assert.assertEquals(instIFLE.consumeStack(), 1);
		Assert.assertEquals(instIFLE.getOffSet(), 0);
		Assert.assertEquals(instIFLE.produceStack(), 0);
	}

	@Test
	public void TestIFNULL(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFNULL instIFNULL = new IFNULL(0, byteArray);

		Assert.assertEquals(instIFNULL.getOpCode(), 0x66);
		Assert.assertEquals(instIFNULL.getLength(), 2);
		Assert.assertEquals(instIFNULL.getName(), "IFNULL");
		Assert.assertEquals(instIFNULL.consumeStack(), 1);
		Assert.assertEquals(instIFNULL.getOffSet(), 0);
		Assert.assertEquals(instIFNULL.produceStack(), 0);
	}

	@Test
	public void TestIFNONNULL(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IFNONNULL instIFNONNULL = new IFNONNULL(0, byteArray);

		Assert.assertEquals(instIFNONNULL.getOpCode(), 0x67);
		Assert.assertEquals(instIFNONNULL.getLength(), 2);
		Assert.assertEquals(instIFNONNULL.getName(), "IFNONNULL");
		Assert.assertEquals(instIFNONNULL.consumeStack(), 1);
		Assert.assertEquals(instIFNONNULL.getOffSet(), 0);
		Assert.assertEquals(instIFNONNULL.produceStack(), 0);
	}

	@Test
	public void TestIF_ACMPEQ(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_ACMPEQ instIF_ACMPEQ = new IF_ACMPEQ(0, byteArray);

		Assert.assertEquals(instIF_ACMPEQ.getOpCode(), 0x68);
		Assert.assertEquals(instIF_ACMPEQ.getLength(), 2);
		Assert.assertEquals(instIF_ACMPEQ.getName(), "IF_ACMPEQ");
		Assert.assertEquals(instIF_ACMPEQ.consumeStack(), 2);
		Assert.assertEquals(instIF_ACMPEQ.getOffSet(), 0);
		Assert.assertEquals(instIF_ACMPEQ.produceStack(), 0);
	}

	@Test
	public void TestIF_ACMPNE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_ACMPNE instIF_ACMPNE = new IF_ACMPNE(0, byteArray);

		Assert.assertEquals(instIF_ACMPNE.getOpCode(), 0x69);
		Assert.assertEquals(instIF_ACMPNE.getLength(), 2);
		Assert.assertEquals(instIF_ACMPNE.getName(), "IF_ACMPNE");
		Assert.assertEquals(instIF_ACMPNE.consumeStack(), 2);
		Assert.assertEquals(instIF_ACMPNE.getOffSet(), 0);
		Assert.assertEquals(instIF_ACMPNE.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPEQ(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_SCMPEQ instIF_SCMPEQ = new IF_SCMPEQ(0, byteArray);

		Assert.assertEquals(instIF_SCMPEQ.getOpCode(), 0x6A);
		Assert.assertEquals(instIF_SCMPEQ.getLength(), 2);
		Assert.assertEquals(instIF_SCMPEQ.getName(), "IF_SCMPEQ");
		Assert.assertEquals(instIF_SCMPEQ.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPEQ.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPEQ.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPNE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_SCMPNE instIF_SCMPNE = new IF_SCMPNE(0, byteArray);

		Assert.assertEquals(instIF_SCMPNE.getOpCode(), 0x6B);
		Assert.assertEquals(instIF_SCMPNE.getLength(), 2);
		Assert.assertEquals(instIF_SCMPNE.getName(), "IF_SCMPNE");
		Assert.assertEquals(instIF_SCMPNE.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPNE.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPNE.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPLT(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_SCMPLT instIF_SCMPLT = new IF_SCMPLT(0, byteArray);

		Assert.assertEquals(instIF_SCMPLT.getOpCode(), 0x6C);
		Assert.assertEquals(instIF_SCMPLT.getLength(), 2);
		Assert.assertEquals(instIF_SCMPLT.getName(), "IF_SCMPLT");
		Assert.assertEquals(instIF_SCMPLT.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPLT.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPLT.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPGE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_SCMPGE instIF_SCMPGE = new IF_SCMPGE(0, byteArray);

		Assert.assertEquals(instIF_SCMPGE.getOpCode(), 0x6D);
		Assert.assertEquals(instIF_SCMPGE.getLength(), 2);
		Assert.assertEquals(instIF_SCMPGE.getName(), "IF_SCMPGE");
		Assert.assertEquals(instIF_SCMPGE.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPGE.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPGE.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPGT(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_SCMPGT instIF_SCMPGT = new IF_SCMPGT(0, byteArray);

		Assert.assertEquals(instIF_SCMPGT.getOpCode(), 0x6E);
		Assert.assertEquals(instIF_SCMPGT.getLength(), 2);
		Assert.assertEquals(instIF_SCMPGT.getName(), "IF_SCMPGT");
		Assert.assertEquals(instIF_SCMPGT.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPGT.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPGT.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPLE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		IF_SCMPLE instIF_SCMPLE = new IF_SCMPLE(0, byteArray);

		Assert.assertEquals(instIF_SCMPLE.getOpCode(), 0x6F);
		Assert.assertEquals(instIF_SCMPLE.getLength(), 2);
		Assert.assertEquals(instIF_SCMPLE.getName(), "IF_SCMPLE");
		Assert.assertEquals(instIF_SCMPLE.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPLE.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPLE.produceStack(), 0);
	}

	@Test
	public void TestGOTO(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		GOTO instGOTO = new GOTO(0, byteArray);

		Assert.assertEquals(instGOTO.getOpCode(), 0x70);
		Assert.assertEquals(instGOTO.getLength(), 2);
		Assert.assertEquals(instGOTO.getName(), "GOTO");
		Assert.assertEquals(instGOTO.consumeStack(), 0);
		Assert.assertEquals(instGOTO.getOffSet(), 0);
		Assert.assertEquals(instGOTO.produceStack(), 0);
	}

	@Test
	public void TestJSR(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		JSR instJSR = new JSR(0, byteArray);

		Assert.assertEquals(instJSR.getOpCode(), 0x71);
		Assert.assertEquals(instJSR.getLength(), 3);
		Assert.assertEquals(instJSR.getName(), "JSR");
		Assert.assertEquals(instJSR.consumeStack(), 0);
		Assert.assertEquals(instJSR.getOffSet(), 0);
		Assert.assertEquals(instJSR.produceStack(), 1);
	}

	@Test
	public void TestRET(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		RET instRET = new RET(0, byteArray);

		Assert.assertEquals(instRET.getOpCode(), 0x72);
		Assert.assertEquals(instRET.getLength(), 2);
		Assert.assertEquals(instRET.getName(), "RET");
		Assert.assertEquals(instRET.consumeStack(), 0);
		Assert.assertEquals(instRET.getOffSet(), 0);
		Assert.assertEquals(instRET.produceStack(), 0);
	}

	@Test
	public void TestSTABLESWITCH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x73);

		byteArray.add((byte) 0x0D);
		byteArray.add((byte) 0x0E);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x02);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x05);

		byteArray.add((byte) 0x01);
		byteArray.add((byte) 0x02);

		byteArray.add((byte) 0x03);
		byteArray.add((byte) 0x04);

		byteArray.add((byte) 0x05);
		byteArray.add((byte) 0x06);

		byteArray.add((byte) 0x07);
		byteArray.add((byte) 0x08);

		STABLESWITCH instSTABLESWITCH = new STABLESWITCH(0, byteArray);

		Assert.assertEquals(instSTABLESWITCH.getOpCode(), 0x73);
		Assert.assertEquals(instSTABLESWITCH.getLength(), 15);
		Assert.assertEquals(instSTABLESWITCH.getName(), "STABLESWITCH");
		Assert.assertEquals(instSTABLESWITCH.consumeStack(), 1);
		Assert.assertEquals(instSTABLESWITCH.getOffSet(), 0);
		Assert.assertEquals(instSTABLESWITCH.produceStack(), 0);

		Assert.assertEquals(instSTABLESWITCH.getHighByte(), 0x0005);
		Assert.assertEquals(instSTABLESWITCH.getLowByte(), 0x0002);
		Assert.assertEquals(instSTABLESWITCH.getNbPairs(), 4);
		Assert.assertEquals(instSTABLESWITCH.getDefaultJump(), 0x0D0E);
		Assert.assertEquals(instSTABLESWITCH.getJumpTable().size(), 4);
	}

	@Test
	public void TestITABLESWITCH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x37);

		byteArray.add((byte) 0x0D);
		byteArray.add((byte) 0x0E);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x02);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x05);

		byteArray.add((byte) 0x01);
		byteArray.add((byte) 0x02);

		byteArray.add((byte) 0x03);
		byteArray.add((byte) 0x04);

		byteArray.add((byte) 0x05);
		byteArray.add((byte) 0x06);

		byteArray.add((byte) 0x07);
		byteArray.add((byte) 0x08);

		ITABLESWITCH instITABLESWITCH = new ITABLESWITCH(0, byteArray);

		Assert.assertEquals(instITABLESWITCH.getOpCode(), 0x74);
		Assert.assertEquals(instITABLESWITCH.getLength(), 19);
		Assert.assertEquals(instITABLESWITCH.getName(), "ITABLESWITCH");
		Assert.assertEquals(instITABLESWITCH.consumeStack(), 1);
		Assert.assertEquals(instITABLESWITCH.getOffSet(), 0);
		Assert.assertEquals(instITABLESWITCH.produceStack(), 0);

		Assert.assertEquals(instITABLESWITCH.getHighByte(), 0x00000005);
		Assert.assertEquals(instITABLESWITCH.getLowByte(), 0x00000002);
		Assert.assertEquals(instITABLESWITCH.getNbPairs(), 4);
		Assert.assertEquals(instITABLESWITCH.getDefaultJump(), 0x0D0E);
		Assert.assertEquals(instITABLESWITCH.getJumpTable().size(), 4);
	}

	@Test
	public void TestSLOOKUPSWITCH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x75);

		byteArray.add((byte) 0xD0);
		byteArray.add((byte) 0x0D);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x03);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x12);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x13);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x20);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x21);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x43);

		SLOOKUPSWITCH instSLOOKUPSWITCH = new SLOOKUPSWITCH(0, byteArray);

		Assert.assertEquals(instSLOOKUPSWITCH.getOpCode(), 0x75);
		Assert.assertEquals(instSLOOKUPSWITCH.getLength(), 17);
		Assert.assertEquals(instSLOOKUPSWITCH.getName(), "SLOOKUPSWITCH");
		Assert.assertEquals(instSLOOKUPSWITCH.consumeStack(), 1);
		Assert.assertEquals(instSLOOKUPSWITCH.getOffSet(), 0);
		Assert.assertEquals(instSLOOKUPSWITCH.produceStack(), 0);

		Assert.assertEquals(instSLOOKUPSWITCH.getDefaultJump(), 0xD00D);
		Assert.assertEquals(instSLOOKUPSWITCH.getNbPairs(), 0x003);
		Assert.assertEquals(instSLOOKUPSWITCH.getJumpTable().size(), 3);
	}

	@Test
	public void TestILOOKUPSWITCH(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x76);

		byteArray.add((byte) 0xD0);
		byteArray.add((byte) 0x0D);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x03);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x12);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x13);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x20);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x21);

		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x00);
		byteArray.add((byte) 0x43);

		ILOOKUPSWITCH instILOOKUPSWITCH = new ILOOKUPSWITCH(0, byteArray);

		Assert.assertEquals(instILOOKUPSWITCH.getOpCode(), 0x76);
		Assert.assertEquals(instILOOKUPSWITCH.getLength(), 23);
		Assert.assertEquals(instILOOKUPSWITCH.getName(), "ILOOKUPSWITCH");
		Assert.assertEquals(instILOOKUPSWITCH.consumeStack(), 2);
		Assert.assertEquals(instILOOKUPSWITCH.getOffSet(), 0);
		Assert.assertEquals(instILOOKUPSWITCH.produceStack(), 0);

		Assert.assertEquals(instILOOKUPSWITCH.getDefaultJump(), 0xD00D);
		Assert.assertEquals(instILOOKUPSWITCH.getNbPairs(), 0x003);
		Assert.assertEquals(instILOOKUPSWITCH.getJumpTable().size(), 3);
	}

	@Test
	public void TestARETURN(){
		ARETURN instARETURN = new ARETURN(1);

		Assert.assertEquals(instARETURN.getOpCode(), 0x77);
		Assert.assertEquals(instARETURN.getLength(), 1);
		Assert.assertEquals(instARETURN.getName(), "ARETURN");
		Assert.assertEquals(instARETURN.consumeStack(), 1);
		Assert.assertEquals(instARETURN.getOffSet(), 1);
		Assert.assertEquals(instARETURN.produceStack(), -2);
	}

	@Test
	public void TestSRETURN(){
		SRETURN instSRETURN = new SRETURN(1);

		Assert.assertEquals(instSRETURN.getOpCode(), 0x78);
		Assert.assertEquals(instSRETURN.getLength(), 1);
		Assert.assertEquals(instSRETURN.getName(), "SRETURN");
		Assert.assertEquals(instSRETURN.consumeStack(), 1);
		Assert.assertEquals(instSRETURN.getOffSet(), 1);
		Assert.assertEquals(instSRETURN.produceStack(), -2);
	}

	@Test
	public void TestIRETURN(){
		IRETURN instIRETURN = new IRETURN(1);

		Assert.assertEquals(instIRETURN.getOpCode(), 0x79);
		Assert.assertEquals(instIRETURN.getLength(), 1);
		Assert.assertEquals(instIRETURN.getName(), "IRETURN");
		Assert.assertEquals(instIRETURN.consumeStack(), 2);
		Assert.assertEquals(instIRETURN.getOffSet(), 1);
		Assert.assertEquals(instIRETURN.produceStack(), -2);
	}

	@Test
	public void TestRETURN(){
		RETURN instRETURN = new RETURN(1);

		Assert.assertEquals(instRETURN.getOpCode(), 0x7A);
		Assert.assertEquals(instRETURN.getLength(), 1);
		Assert.assertEquals(instRETURN.getName(), "RETURN");
		Assert.assertEquals(instRETURN.consumeStack(), 0);
		Assert.assertEquals(instRETURN.getOffSet(), 1);
		Assert.assertEquals(instRETURN.produceStack(), -2);
	}

	@Test
	public void TestGETSTATIC_A(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETSTATIC_A instGETSTATIC_A = new GETSTATIC_A(0, byteArray);

		Assert.assertEquals(instGETSTATIC_A.getOpCode(), 0x7B);
		Assert.assertEquals(instGETSTATIC_A.getLength(), 3);
		Assert.assertEquals(instGETSTATIC_A.getName(), "GETSTATIC_A");
		Assert.assertEquals(instGETSTATIC_A.consumeStack(), 0);
		Assert.assertEquals(instGETSTATIC_A.getOffSet(), 0);
		Assert.assertEquals(instGETSTATIC_A.produceStack(), 1);
	}

	@Test
	public void TestGETSTATIC_B(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETSTATIC_B instGETSTATIC_B = new GETSTATIC_B(0, byteArray);

		Assert.assertEquals(instGETSTATIC_B.getOpCode(), 0x7C);
		Assert.assertEquals(instGETSTATIC_B.getLength(), 3);
		Assert.assertEquals(instGETSTATIC_B.getName(), "GETSTATIC_B");
		Assert.assertEquals(instGETSTATIC_B.consumeStack(), 0);
		Assert.assertEquals(instGETSTATIC_B.getOffSet(), 0);
		Assert.assertEquals(instGETSTATIC_B.produceStack(), 1);
	}

	@Test
	public void TestGETSTATIC_S(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETSTATIC_S instGETSTATIC_S = new GETSTATIC_S(0, byteArray);

		Assert.assertEquals(instGETSTATIC_S.getOpCode(), 0x7D);
		Assert.assertEquals(instGETSTATIC_S.getLength(), 3);
		Assert.assertEquals(instGETSTATIC_S.getName(), "GETSTATIC_S");
		Assert.assertEquals(instGETSTATIC_S.consumeStack(), 0);
		Assert.assertEquals(instGETSTATIC_S.getOffSet(), 0);
		Assert.assertEquals(instGETSTATIC_S.produceStack(), 1);
	}

	@Test
	public void TestGETSTATIC_I(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETSTATIC_I instGETSTATIC_I = new GETSTATIC_I(0, byteArray);

		Assert.assertEquals(instGETSTATIC_I.getOpCode(), 0x7E);
		Assert.assertEquals(instGETSTATIC_I.getLength(), 3);
		Assert.assertEquals(instGETSTATIC_I.getName(), "GETSTATIC_I");
		Assert.assertEquals(instGETSTATIC_I.consumeStack(), 0);
		Assert.assertEquals(instGETSTATIC_I.getOffSet(), 0);
		Assert.assertEquals(instGETSTATIC_I.produceStack(), 2);
	}

	@Test
	public void TestPUTSTATIC_A(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTSTATIC_A instPUTSTATIC_A = new PUTSTATIC_A(0, byteArray);

		Assert.assertEquals(instPUTSTATIC_A.getOpCode(), 0x7F);
		Assert.assertEquals(instPUTSTATIC_A.getLength(), 3);
		Assert.assertEquals(instPUTSTATIC_A.getName(), "PUTSTATIC_A");
		Assert.assertEquals(instPUTSTATIC_A.consumeStack(), 1);
		Assert.assertEquals(instPUTSTATIC_A.getOffSet(), 0);
		Assert.assertEquals(instPUTSTATIC_A.produceStack(), 0);
	}

	@Test
	public void TestPUTSTATIC_B(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTSTATIC_B instPUTSTATIC_B = new PUTSTATIC_B(0, byteArray);

		Assert.assertEquals(instPUTSTATIC_B.getOpCode(), 0x80);
		Assert.assertEquals(instPUTSTATIC_B.getLength(), 3);
		Assert.assertEquals(instPUTSTATIC_B.getName(), "PUTSTATIC_B");
		Assert.assertEquals(instPUTSTATIC_B.consumeStack(), 1);
		Assert.assertEquals(instPUTSTATIC_B.getOffSet(), 0);
		Assert.assertEquals(instPUTSTATIC_B.produceStack(), 0);
	}

	@Test
	public void TestPUTSTATIC_S(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTSTATIC_S instPUTSTATIC_S = new PUTSTATIC_S(0, byteArray);

		Assert.assertEquals(instPUTSTATIC_S.getOpCode(), 0x81);
		Assert.assertEquals(instPUTSTATIC_S.getLength(), 3);
		Assert.assertEquals(instPUTSTATIC_S.getName(), "PUTSTATIC_S");
		Assert.assertEquals(instPUTSTATIC_S.consumeStack(), 1);
		Assert.assertEquals(instPUTSTATIC_S.getOffSet(), 0);
		Assert.assertEquals(instPUTSTATIC_S.produceStack(), 0);
	}

	@Test
	public void TestPUTSTATIC_I(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTSTATIC_I instPUTSTATIC_I = new PUTSTATIC_I(0, byteArray);

		Assert.assertEquals(instPUTSTATIC_I.getOpCode(), 0x82);
		Assert.assertEquals(instPUTSTATIC_I.getLength(), 3);
		Assert.assertEquals(instPUTSTATIC_I.getName(), "PUTSTATIC_I");
		Assert.assertEquals(instPUTSTATIC_I.consumeStack(), 2);
		Assert.assertEquals(instPUTSTATIC_I.getOffSet(), 0);
		Assert.assertEquals(instPUTSTATIC_I.produceStack(), 0);
	}

	@Test
	public void TestGETFIELD_A(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		GETFIELD_A instGETFIELD_A = new GETFIELD_A(0, byteArray);

		Assert.assertEquals(instGETFIELD_A.getOpCode(), 0x83);
		Assert.assertEquals(instGETFIELD_A.getLength(), 2);
		Assert.assertEquals(instGETFIELD_A.getName(), "GETFIELD_A");
		Assert.assertEquals(instGETFIELD_A.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_A.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_A.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_B(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		GETFIELD_B instGETFIELD_B = new GETFIELD_B(0, byteArray);

		Assert.assertEquals(instGETFIELD_B.getOpCode(), 0x84);
		Assert.assertEquals(instGETFIELD_B.getLength(), 2);
		Assert.assertEquals(instGETFIELD_B.getName(), "GETFIELD_B");
		Assert.assertEquals(instGETFIELD_B.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_B.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_B.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_S(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		GETFIELD_S instGETFIELD_S = new GETFIELD_S(0, byteArray);

		Assert.assertEquals(instGETFIELD_S.getOpCode(), 0x85);
		Assert.assertEquals(instGETFIELD_S.getLength(), 2);
		Assert.assertEquals(instGETFIELD_S.getName(), "GETFIELD_S");
		Assert.assertEquals(instGETFIELD_S.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_S.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_S.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_I(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		GETFIELD_I instGETFIELD_I = new GETFIELD_I(0, byteArray);

		Assert.assertEquals(instGETFIELD_I.getOpCode(), 0x86);
		Assert.assertEquals(instGETFIELD_I.getLength(), 2);
		Assert.assertEquals(instGETFIELD_I.getName(), "GETFIELD_I");
		Assert.assertEquals(instGETFIELD_I.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_I.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_I.produceStack(), 2);
	}

	@Test
	public void TestPUTFIELD_A(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		PUTFIELD_A instPUTFIELD_A = new PUTFIELD_A(0, byteArray);

		Assert.assertEquals(instPUTFIELD_A.getOpCode(), 0x87);
		Assert.assertEquals(instPUTFIELD_A.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_A.getName(), "PUTFIELD_A");
		Assert.assertEquals(instPUTFIELD_A.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_A.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_A.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_B(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		PUTFIELD_B instPUTFIELD_B = new PUTFIELD_B(0, byteArray);

		Assert.assertEquals(instPUTFIELD_B.getOpCode(), 0x88);
		Assert.assertEquals(instPUTFIELD_B.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_B.getName(), "PUTFIELD_B");
		Assert.assertEquals(instPUTFIELD_B.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_B.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_B.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_S(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		PUTFIELD_S instPUTFIELD_S = new PUTFIELD_S(0, byteArray);

		Assert.assertEquals(instPUTFIELD_S.getOpCode(), 0x89);
		Assert.assertEquals(instPUTFIELD_S.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_S.getName(), "PUTFIELD_S");
		Assert.assertEquals(instPUTFIELD_S.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_S.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_S.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_I(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		PUTFIELD_I instPUTFIELD_I = new PUTFIELD_I(0, byteArray);

		Assert.assertEquals(instPUTFIELD_I.getOpCode(), 0x8A);
		Assert.assertEquals(instPUTFIELD_I.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_I.getName(), "PUTFIELD_I");
		Assert.assertEquals(instPUTFIELD_I.consumeStack(), 3);
		Assert.assertEquals(instPUTFIELD_I.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_I.produceStack(), 0);
	}

	@Test
	public void TestINVOKEVIRTUAL(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		INVOKEVIRTUAL instINVOKEVIRTUAL = new INVOKEVIRTUAL(0, byteArray);

		Assert.assertEquals(instINVOKEVIRTUAL.getOpCode(), 0x8B);
		Assert.assertEquals(instINVOKEVIRTUAL.getLength(), 3);
		Assert.assertEquals(instINVOKEVIRTUAL.getName(), "INVOKEVIRTUAL");
		Assert.assertEquals(instINVOKEVIRTUAL.consumeStack(), -2);
		Assert.assertEquals(instINVOKEVIRTUAL.getOffSet(), 0);
		Assert.assertEquals(instINVOKEVIRTUAL.produceStack(), 0);
	}

	@Test
	public void TestINVOKESPECIAL(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		INVOKESPECIAL instINVOKESPECIAL = new INVOKESPECIAL(0, byteArray);

		Assert.assertEquals(instINVOKESPECIAL.getOpCode(), 0x8C);
		Assert.assertEquals(instINVOKESPECIAL.getLength(), 3);
		Assert.assertEquals(instINVOKESPECIAL.getName(), "INVOKESPECIAL");
		Assert.assertEquals(instINVOKESPECIAL.consumeStack(), -2);
		Assert.assertEquals(instINVOKESPECIAL.getOffSet(), 0);
		Assert.assertEquals(instINVOKESPECIAL.produceStack(), 0);
	}

	@Test
	public void TestINVOKESTATIC(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		INVOKESTATIC instINVOKESTATIC = new INVOKESTATIC(0, byteArray);

		Assert.assertEquals(instINVOKESTATIC.getOpCode(), 0x8D);
		Assert.assertEquals(instINVOKESTATIC.getLength(), 3);
		Assert.assertEquals(instINVOKESTATIC.getName(), "INVOKESTATIC");
		Assert.assertEquals(instINVOKESTATIC.consumeStack(), -2);
		Assert.assertEquals(instINVOKESTATIC.getOffSet(), 0);
		Assert.assertEquals(instINVOKESTATIC.produceStack(), 0);
	}

	@Test
	public void TestINVOKEINTERFACE(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);
		byteArray.add((byte) 0x44);
		byteArray.add((byte) 0x45);

		INVOKEINTERFACE instINVOKEINTERFACE = new INVOKEINTERFACE(0, byteArray);

		Assert.assertEquals(instINVOKEINTERFACE.getOpCode(), 0x8E);
		Assert.assertEquals(instINVOKEINTERFACE.getLength(), 5);
		Assert.assertEquals(instINVOKEINTERFACE.getName(), "INVOKEINTERFACE");
		Assert.assertEquals(instINVOKEINTERFACE.consumeStack(), -2);
		Assert.assertEquals(instINVOKEINTERFACE.getOffSet(), 0);
		Assert.assertEquals(instINVOKEINTERFACE.produceStack(), 0);
	}

	@Test
	public void TestNEW(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		NEW instNEW = new NEW(0, byteArray);

		Assert.assertEquals(instNEW.getOpCode(), 0x8F);
		Assert.assertEquals(instNEW.getLength(), 3);
		Assert.assertEquals(instNEW.getName(), "NEW");
		Assert.assertEquals(instNEW.consumeStack(), 0);
		Assert.assertEquals(instNEW.getOffSet(), 0);
		Assert.assertEquals(instNEW.produceStack(), 1);
	}

	@Test
	public void TestNEWARRAY(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);

		NEWARRAY instNEWARRAY = new NEWARRAY(0, byteArray);

		Assert.assertEquals(instNEWARRAY.getOpCode(), 0x90);
		Assert.assertEquals(instNEWARRAY.getLength(), 2);
		Assert.assertEquals(instNEWARRAY.getName(), "NEWARRAY");
		Assert.assertEquals(instNEWARRAY.consumeStack(), 1);
		Assert.assertEquals(instNEWARRAY.getOffSet(), 0);
		Assert.assertEquals(instNEWARRAY.produceStack(), 1);
	}

	@Test
	public void TestANEWARRAY(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		ANEWARRAY instANEWARRAY = new ANEWARRAY(0, byteArray);

		Assert.assertEquals(instANEWARRAY.getOpCode(), 0x91);
		Assert.assertEquals(instANEWARRAY.getLength(), 3);
		Assert.assertEquals(instANEWARRAY.getName(), "ANEWARRAY");
		Assert.assertEquals(instANEWARRAY.consumeStack(), 1);
		Assert.assertEquals(instANEWARRAY.getOffSet(), 0);
		Assert.assertEquals(instANEWARRAY.produceStack(), 1);
	}

	@Test
	public void TestARRAYLENGTH(){
		ARRAYLENGTH instARRAYLENGTH = new ARRAYLENGTH(1);

		Assert.assertEquals(instARRAYLENGTH.getOpCode(), 0x92);
		Assert.assertEquals(instARRAYLENGTH.getLength(), 1);
		Assert.assertEquals(instARRAYLENGTH.getName(), "ARRAYLENGTH");
		Assert.assertEquals(instARRAYLENGTH.consumeStack(), 1);
		Assert.assertEquals(instARRAYLENGTH.getOffSet(), 1);
		Assert.assertEquals(instARRAYLENGTH.produceStack(), 1);
	}

	@Test
	public void TestATHROW(){
		ATHROW instATHROW = new ATHROW(1);

		Assert.assertEquals(instATHROW.getOpCode(), 0x93);
		Assert.assertEquals(instATHROW.getLength(), 1);
		Assert.assertEquals(instATHROW.getName(), "ATHROW");
		Assert.assertEquals(instATHROW.consumeStack(), 1);
		Assert.assertEquals(instATHROW.getOffSet(), 1);
		Assert.assertEquals(instATHROW.produceStack(), 1);
	}

	@Test
	public void TestCHECKCAST(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);
		byteArray.add((byte) 0x44);

		CHECKCAST instCHECKCAST = new CHECKCAST(0, byteArray);

		Assert.assertEquals(instCHECKCAST.getOpCode(), 0x94);
		Assert.assertEquals(instCHECKCAST.getLength(), 4);
		Assert.assertEquals(instCHECKCAST.getName(), "CHECKCAST");
		Assert.assertEquals(instCHECKCAST.consumeStack(), 1);
		Assert.assertEquals(instCHECKCAST.getOffSet(), 0);
		Assert.assertEquals(instCHECKCAST.produceStack(), 1);
	}

	@Test
	public void TestINSTANCEOF(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);
		byteArray.add((byte) 0x44);

		INSTANCEOF instINSTANCEOF = new INSTANCEOF(0, byteArray);

		Assert.assertEquals(instINSTANCEOF.getOpCode(), 0x95);
		Assert.assertEquals(instINSTANCEOF.getLength(), 4);
		Assert.assertEquals(instINSTANCEOF.getName(), "INSTANCEOF");
		Assert.assertEquals(instINSTANCEOF.consumeStack(), 1);
		Assert.assertEquals(instINSTANCEOF.getOffSet(), 0);
		Assert.assertEquals(instINSTANCEOF.produceStack(), 1);
	}

	@Test
	public void TestSINC_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);
		byteArray.add((byte) 0x44);

		SINC_W instSINC_W = new SINC_W(0, byteArray);

		Assert.assertEquals(instSINC_W.getOpCode(), 0x96);
		Assert.assertEquals(instSINC_W.getLength(), 4);
		Assert.assertEquals(instSINC_W.getName(), "SINC_W");
		Assert.assertEquals(instSINC_W.consumeStack(), 0);
		Assert.assertEquals(instSINC_W.getOffSet(), 0);
		Assert.assertEquals(instSINC_W.produceStack(), 0);
	}

	@Test
	public void TestIINC_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);
		byteArray.add((byte) 0x44);

		IINC_W instIINC_W = new IINC_W(0, byteArray);

		Assert.assertEquals(instIINC_W.getOpCode(), 0x97);
		Assert.assertEquals(instIINC_W.getLength(), 4);
		Assert.assertEquals(instIINC_W.getName(), "IINC_W");
		Assert.assertEquals(instIINC_W.consumeStack(), 0);
		Assert.assertEquals(instIINC_W.getOffSet(), 0);
		Assert.assertEquals(instIINC_W.produceStack(), 0);
	}

	@Test
	public void TestIFEQ_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFEQ_W instIFEQ_W = new IFEQ_W(0, byteArray);

		Assert.assertEquals(instIFEQ_W.getOpCode(), 0x98);
		Assert.assertEquals(instIFEQ_W.getLength(), 3);
		Assert.assertEquals(instIFEQ_W.getName(), "IFEQ_W");
		Assert.assertEquals(instIFEQ_W.consumeStack(), 1);
		Assert.assertEquals(instIFEQ_W.getOffSet(), 0);
		Assert.assertEquals(instIFEQ_W.produceStack(), 0);
	}

	@Test
	public void TestIFNE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFNE_W instIFNE_W = new IFNE_W(0, byteArray);

		Assert.assertEquals(instIFNE_W.getOpCode(), 0x99);
		Assert.assertEquals(instIFNE_W.getLength(), 3);
		Assert.assertEquals(instIFNE_W.getName(), "IFNE_W");
		Assert.assertEquals(instIFNE_W.consumeStack(), 1);
		Assert.assertEquals(instIFNE_W.getOffSet(), 0);
		Assert.assertEquals(instIFNE_W.produceStack(), 0);
	}

	@Test
	public void TestIFLT_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFLT_W instIFLT_W = new IFLT_W(0, byteArray);

		Assert.assertEquals(instIFLT_W.getOpCode(), 0x9A);
		Assert.assertEquals(instIFLT_W.getLength(), 3);
		Assert.assertEquals(instIFLT_W.getName(), "IFLT_W");
		Assert.assertEquals(instIFLT_W.consumeStack(), 1);
		Assert.assertEquals(instIFLT_W.getOffSet(), 0);
		Assert.assertEquals(instIFLT_W.produceStack(), 0);
	}

	@Test
	public void TestIFGE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFGE_W instIFGE_W = new IFGE_W(0, byteArray);

		Assert.assertEquals(instIFGE_W.getOpCode(), 0x9B);
		Assert.assertEquals(instIFGE_W.getLength(), 3);
		Assert.assertEquals(instIFGE_W.getName(), "IFGE_W");
		Assert.assertEquals(instIFGE_W.consumeStack(), 1);
		Assert.assertEquals(instIFGE_W.getOffSet(), 0);
		Assert.assertEquals(instIFGE_W.produceStack(), 0);
	}

	@Test
	public void TestIFGT_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFGT_W instIFGT_W = new IFGT_W(0, byteArray);

		Assert.assertEquals(instIFGT_W.getOpCode(), 0x9C);
		Assert.assertEquals(instIFGT_W.getLength(), 3);
		Assert.assertEquals(instIFGT_W.getName(), "IFGT_W");
		Assert.assertEquals(instIFGT_W.consumeStack(), 1);
		Assert.assertEquals(instIFGT_W.getOffSet(), 0);
		Assert.assertEquals(instIFGT_W.produceStack(), 0);
	}

	@Test
	public void TestIFLE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFLE_W instIFLE_W = new IFLE_W(0, byteArray);

		Assert.assertEquals(instIFLE_W.getOpCode(), 0x9D);
		Assert.assertEquals(instIFLE_W.getLength(), 3);
		Assert.assertEquals(instIFLE_W.getName(), "IFLE_W");
		Assert.assertEquals(instIFLE_W.consumeStack(), 1);
		Assert.assertEquals(instIFLE_W.getOffSet(), 0);
		Assert.assertEquals(instIFLE_W.produceStack(), 0);
	}

	@Test
	public void TestIFNULL_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFNULL_W instIFNULL_W = new IFNULL_W(0, byteArray);

		Assert.assertEquals(instIFNULL_W.getOpCode(), 0x9E);
		Assert.assertEquals(instIFNULL_W.getLength(), 3);
		Assert.assertEquals(instIFNULL_W.getName(), "IFNULL_W");
		Assert.assertEquals(instIFNULL_W.consumeStack(), 1);
		Assert.assertEquals(instIFNULL_W.getOffSet(), 0);
		Assert.assertEquals(instIFNULL_W.produceStack(), 0);
	}

	@Test
	public void TestIFNONNULL_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IFNONNULL_W instIFNONNULL_W = new IFNONNULL_W(0, byteArray);

		Assert.assertEquals(instIFNONNULL_W.getOpCode(), 0x9F);
		Assert.assertEquals(instIFNONNULL_W.getLength(), 3);
		Assert.assertEquals(instIFNONNULL_W.getName(), "IFNONNULL_W");
		Assert.assertEquals(instIFNONNULL_W.consumeStack(), 1);
		Assert.assertEquals(instIFNONNULL_W.getOffSet(), 0);
		Assert.assertEquals(instIFNONNULL_W.produceStack(), 0);
	}

	@Test
	public void TestIF_ACMPEQ_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_ACMPEQ_W instIF_ACMPEQ_W = new IF_ACMPEQ_W(0, byteArray);

		Assert.assertEquals(instIF_ACMPEQ_W.getOpCode(), 0xA0);
		Assert.assertEquals(instIF_ACMPEQ_W.getLength(), 3);
		Assert.assertEquals(instIF_ACMPEQ_W.getName(), "IF_ACMPEQ_W");
		Assert.assertEquals(instIF_ACMPEQ_W.consumeStack(), 2);
		Assert.assertEquals(instIF_ACMPEQ_W.getOffSet(), 0);
		Assert.assertEquals(instIF_ACMPEQ_W.produceStack(), 0);
	}

	@Test
	public void TestIF_ACMPNE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_ACMPNE_W instIF_ACMPNE_W = new IF_ACMPNE_W(0, byteArray);

		Assert.assertEquals(instIF_ACMPNE_W.getOpCode(), 0xA1);
		Assert.assertEquals(instIF_ACMPNE_W.getLength(), 3);
		Assert.assertEquals(instIF_ACMPNE_W.getName(), "IF_ACMPNE_W");
		Assert.assertEquals(instIF_ACMPNE_W.consumeStack(), 2);
		Assert.assertEquals(instIF_ACMPNE_W.getOffSet(), 0);
		Assert.assertEquals(instIF_ACMPNE_W.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPEQ_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_SCMPEQ_W instIF_SCMPEQ_W = new IF_SCMPEQ_W(0, byteArray);

		Assert.assertEquals(instIF_SCMPEQ_W.getOpCode(), 0xA2);
		Assert.assertEquals(instIF_SCMPEQ_W.getLength(), 3);
		Assert.assertEquals(instIF_SCMPEQ_W.getName(), "IF_SCMPEQ_W");
		Assert.assertEquals(instIF_SCMPEQ_W.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPEQ_W.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPEQ_W.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPNE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_SCMPNE_W instIF_SCMPNE_W = new IF_SCMPNE_W(0, byteArray);

		Assert.assertEquals(instIF_SCMPNE_W.getOpCode(), 0xA3);
		Assert.assertEquals(instIF_SCMPNE_W.getLength(), 3);
		Assert.assertEquals(instIF_SCMPNE_W.getName(), "IF_SCMPNE_W");
		Assert.assertEquals(instIF_SCMPNE_W.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPNE_W.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPNE_W.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPLT_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_SCMPLT_W instIF_SCMPLT_W = new IF_SCMPLT_W(0, byteArray);

		Assert.assertEquals(instIF_SCMPLT_W.getOpCode(), 0xA4);
		Assert.assertEquals(instIF_SCMPLT_W.getLength(), 3);
		Assert.assertEquals(instIF_SCMPLT_W.getName(), "IF_SCMPLT_W");
		Assert.assertEquals(instIF_SCMPLT_W.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPLT_W.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPLT_W.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPGE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_SCMPGE_W instIF_SCMPGE_W = new IF_SCMPGE_W(0, byteArray);

		Assert.assertEquals(instIF_SCMPGE_W.getOpCode(), 0xA5);
		Assert.assertEquals(instIF_SCMPGE_W.getLength(), 3);
		Assert.assertEquals(instIF_SCMPGE_W.getName(), "IF_SCMPGE_W");
		Assert.assertEquals(instIF_SCMPGE_W.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPGE_W.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPGE_W.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPGT_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_SCMPGT_W instIF_SCMPGT_W = new IF_SCMPGT_W(0, byteArray);

		Assert.assertEquals(instIF_SCMPGT_W.getOpCode(), 0xA6);
		Assert.assertEquals(instIF_SCMPGT_W.getLength(), 3);
		Assert.assertEquals(instIF_SCMPGT_W.getName(), "IF_SCMPGT_W");
		Assert.assertEquals(instIF_SCMPGT_W.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPGT_W.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPGT_W.produceStack(), 0);
	}

	@Test
	public void TestIF_SCMPLE_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		IF_SCMPLE_W instIF_SCMPLE_W = new IF_SCMPLE_W(0, byteArray);

		Assert.assertEquals(instIF_SCMPLE_W.getOpCode(), 0xA7);
		Assert.assertEquals(instIF_SCMPLE_W.getLength(), 3);
		Assert.assertEquals(instIF_SCMPLE_W.getName(), "IF_SCMPLE_W");
		Assert.assertEquals(instIF_SCMPLE_W.consumeStack(), 2);
		Assert.assertEquals(instIF_SCMPLE_W.getOffSet(), 0);
		Assert.assertEquals(instIF_SCMPLE_W.produceStack(), 0);
	}

	@Test
	public void TestGOTO_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GOTO_W instGOTO_W = new GOTO_W(0, byteArray);

		Assert.assertEquals(instGOTO_W.getOpCode(), 0xA8);
		Assert.assertEquals(instGOTO_W.getLength(), 3);
		Assert.assertEquals(instGOTO_W.getName(), "GOTO_W");
		Assert.assertEquals(instGOTO_W.consumeStack(), 0);
		Assert.assertEquals(instGOTO_W.getOffSet(), 0);
		Assert.assertEquals(instGOTO_W.produceStack(), 0);
	}

	@Test
	public void TestGETFIELD_A_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_A_W instGETFIELD_A_W = new GETFIELD_A_W(0, byteArray);

		Assert.assertEquals(instGETFIELD_A_W.getOpCode(), 0xA9);
		Assert.assertEquals(instGETFIELD_A_W.getLength(), 3);
		Assert.assertEquals(instGETFIELD_A_W.getName(), "GETFIELD_A_W");
		Assert.assertEquals(instGETFIELD_A_W.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_A_W.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_A_W.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_B_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_B_W instGETFIELD_B_W = new GETFIELD_B_W(0, byteArray);

		Assert.assertEquals(instGETFIELD_B_W.getOpCode(), 0xAA);
		Assert.assertEquals(instGETFIELD_B_W.getLength(), 3);
		Assert.assertEquals(instGETFIELD_B_W.getName(), "GETFIELD_B_W");
		Assert.assertEquals(instGETFIELD_B_W.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_B_W.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_B_W.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_S_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_S_W instGETFIELD_S_W = new GETFIELD_S_W(0, byteArray);

		Assert.assertEquals(instGETFIELD_S_W.getOpCode(), 0xAB);
		Assert.assertEquals(instGETFIELD_S_W.getLength(), 3);
		Assert.assertEquals(instGETFIELD_S_W.getName(), "GETFIELD_S_W");
		Assert.assertEquals(instGETFIELD_S_W.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_S_W.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_S_W.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_I_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_I_W instGETFIELD_I_W = new GETFIELD_I_W(0, byteArray);

		Assert.assertEquals(instGETFIELD_I_W.getOpCode(), 0xAC);
		Assert.assertEquals(instGETFIELD_I_W.getLength(), 3);
		Assert.assertEquals(instGETFIELD_I_W.getName(), "GETFIELD_I_W");
		Assert.assertEquals(instGETFIELD_I_W.consumeStack(), 1);
		Assert.assertEquals(instGETFIELD_I_W.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_I_W.produceStack(), 2);
	}

	@Test
	public void TestGETFIELD_A_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_A_THIS instGETFIELD_A_THIS = new GETFIELD_A_THIS(0, byteArray);

		Assert.assertEquals(instGETFIELD_A_THIS.getOpCode(), 0xAD);
		Assert.assertEquals(instGETFIELD_A_THIS.getLength(), 2);
		Assert.assertEquals(instGETFIELD_A_THIS.getName(), "GETFIELD_A_THIS");
		Assert.assertEquals(instGETFIELD_A_THIS.consumeStack(), 0);
		Assert.assertEquals(instGETFIELD_A_THIS.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_A_THIS.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_B_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_B_THIS instGETFIELD_B_THIS = new GETFIELD_B_THIS(0, byteArray);

		Assert.assertEquals(instGETFIELD_B_THIS.getOpCode(), 0xAE);
		Assert.assertEquals(instGETFIELD_B_THIS.getLength(), 2);
		Assert.assertEquals(instGETFIELD_B_THIS.getName(), "GETFIELD_B_THIS");
		Assert.assertEquals(instGETFIELD_B_THIS.consumeStack(), 0);
		Assert.assertEquals(instGETFIELD_B_THIS.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_B_THIS.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_S_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_S_THIS instGETFIELD_S_THIS = new GETFIELD_S_THIS(0, byteArray);

		Assert.assertEquals(instGETFIELD_S_THIS.getOpCode(), 0xAF);
		Assert.assertEquals(instGETFIELD_S_THIS.getLength(), 2);
		Assert.assertEquals(instGETFIELD_S_THIS.getName(), "GETFIELD_S_THIS");
		Assert.assertEquals(instGETFIELD_S_THIS.consumeStack(), 0);
		Assert.assertEquals(instGETFIELD_S_THIS.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_S_THIS.produceStack(), 1);
	}

	@Test
	public void TestGETFIELD_I_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		GETFIELD_I_THIS instGETFIELD_I_THIS = new GETFIELD_I_THIS(0, byteArray);

		Assert.assertEquals(instGETFIELD_I_THIS.getOpCode(), 0xB0);
		Assert.assertEquals(instGETFIELD_I_THIS.getLength(), 2);
		Assert.assertEquals(instGETFIELD_I_THIS.getName(), "GETFIELD_I_THIS");
		Assert.assertEquals(instGETFIELD_I_THIS.consumeStack(), 0);
		Assert.assertEquals(instGETFIELD_I_THIS.getOffSet(), 0);
		Assert.assertEquals(instGETFIELD_I_THIS.produceStack(), 2);
	}

	@Test
	public void TestPUTFIELD_A_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_A_W instPUTFIELD_A_W = new PUTFIELD_A_W(0, byteArray);

		Assert.assertEquals(instPUTFIELD_A_W.getOpCode(), 0xB1);
		Assert.assertEquals(instPUTFIELD_A_W.getLength(), 3);
		Assert.assertEquals(instPUTFIELD_A_W.getName(), "PUTFIELD_A_W");
		Assert.assertEquals(instPUTFIELD_A_W.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_A_W.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_A_W.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_B_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_B_W instPUTFIELD_B_W = new PUTFIELD_B_W(0, byteArray);

		Assert.assertEquals(instPUTFIELD_B_W.getOpCode(), 0xB2);
		Assert.assertEquals(instPUTFIELD_B_W.getLength(), 3);
		Assert.assertEquals(instPUTFIELD_B_W.getName(), "PUTFIELD_B_W");
		Assert.assertEquals(instPUTFIELD_B_W.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_B_W.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_B_W.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_S_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_S_W instPUTFIELD_S_W = new PUTFIELD_S_W(0, byteArray);

		Assert.assertEquals(instPUTFIELD_S_W.getOpCode(), 0xB3);
		Assert.assertEquals(instPUTFIELD_S_W.getLength(), 3);
		Assert.assertEquals(instPUTFIELD_S_W.getName(), "PUTFIELD_S_W");
		Assert.assertEquals(instPUTFIELD_S_W.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_S_W.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_S_W.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_I_W(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_I_W instPUTFIELD_I_W = new PUTFIELD_I_W(0, byteArray);

		Assert.assertEquals(instPUTFIELD_I_W.getOpCode(), 0xB4);
		Assert.assertEquals(instPUTFIELD_I_W.getLength(), 3);
		Assert.assertEquals(instPUTFIELD_I_W.getName(), "PUTFIELD_I_W");
		Assert.assertEquals(instPUTFIELD_I_W.consumeStack(), 3);
		Assert.assertEquals(instPUTFIELD_I_W.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_I_W.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_A_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_A_THIS instPUTFIELD_A_THIS = new PUTFIELD_A_THIS(0, byteArray);

		Assert.assertEquals(instPUTFIELD_A_THIS.getOpCode(), 0xB5);
		Assert.assertEquals(instPUTFIELD_A_THIS.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_A_THIS.getName(), "PUTFIELD_A_THIS");
		Assert.assertEquals(instPUTFIELD_A_THIS.consumeStack(), 1);
		Assert.assertEquals(instPUTFIELD_A_THIS.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_A_THIS.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_B_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_B_THIS instPUTFIELD_B_THIS = new PUTFIELD_B_THIS(0, byteArray);

		Assert.assertEquals(instPUTFIELD_B_THIS.getOpCode(), 0xB6);
		Assert.assertEquals(instPUTFIELD_B_THIS.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_B_THIS.getName(), "PUTFIELD_B_THIS");
		Assert.assertEquals(instPUTFIELD_B_THIS.consumeStack(), 1);
		Assert.assertEquals(instPUTFIELD_B_THIS.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_B_THIS.produceStack(), 0);
	}

	@Test
	public void TestPUTFIELD_S_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_S_THIS instPUTFIELD_S_THIS = new PUTFIELD_S_THIS(0, byteArray);

		Assert.assertEquals(instPUTFIELD_S_THIS.getOpCode(), 0xB7);
		Assert.assertEquals(instPUTFIELD_S_THIS.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_S_THIS.getName(), "PUTFIELD_S_THIS");
		Assert.assertEquals(instPUTFIELD_S_THIS.consumeStack(), 1);
		Assert.assertEquals(instPUTFIELD_S_THIS.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_S_THIS.produceStack(), 0);
	}


	@Test
	public void TestPUTFIELD_I_THIS(){

		ArrayList<Byte> byteArray = new ArrayList<Byte>();
		byteArray.add((byte) 0x42);
		byteArray.add((byte) 0x43);

		PUTFIELD_I_THIS instPUTFIELD_I_THIS = new PUTFIELD_I_THIS(0, byteArray);

		Assert.assertEquals(instPUTFIELD_I_THIS.getOpCode(), 0xB8);
		Assert.assertEquals(instPUTFIELD_I_THIS.getLength(), 2);
		Assert.assertEquals(instPUTFIELD_I_THIS.getName(), "PUTFIELD_I_THIS");
		Assert.assertEquals(instPUTFIELD_I_THIS.consumeStack(), 2);
		Assert.assertEquals(instPUTFIELD_I_THIS.getOffSet(), 0);
		Assert.assertEquals(instPUTFIELD_I_THIS.produceStack(), 0);
	}

}

