package fr.xlim.ssd.capmanipulator.bcel;


import fr.xlim.ssd.capmanipulator.library.*;

import java.util.ArrayList;

public class CapConstantPool {

	ArrayList<CapConstantPoolInfo> ConstantPool;

	public CapConstantPool() throws Exception {
		ConstantPool = new ArrayList<CapConstantPoolInfo>();
		for (ConstantPoolInfo constantPollInfo: CapFileFactory.getCapFile().getConstantPoolComponent().getConstantPool()) {
			switch (constantPollInfo.getTag()) {
				case ConstantPoolComponent.TAG_CLASS_REF:
					ConstantPool.add(new CapConstantClassRef(((ConstantClassRef) constantPollInfo)));
					break;
				case ConstantPoolComponent.TAG_INSTANCE_FIELD_REF:
					ConstantPool.add(new CapConstantInstanceFieldRef(((ConstantInstanceFieldRef) constantPollInfo)));
					break;
				case ConstantPoolComponent.TAG_STATIC_FIELD_REF:
					ConstantPool.add(new CapConstantStaticFieldRef(((ConstantStaticFieldRef) constantPollInfo)));
					break;
				case ConstantPoolComponent.TAG_STATIC_METHOD_REF:
					ConstantPool.add(new CapConstantStaticMethodRef(((ConstantStaticMethodRef) constantPollInfo)));
					break;
				case ConstantPoolComponent.TAG_SUPER_METHOD_REF:
					ConstantPool.add(new CapConstantSuperMethodRef(((ConstantSuperMethodRef) constantPollInfo)));
					break;
				case ConstantPoolComponent.TAG_VIRTUAL_METHOD_REF:
					ConstantPool.add(new CapConstantVirtualMethodRef(((ConstantVirtualMethodRef) constantPollInfo)));
					break;
				default:
					throw new Exception("Constant Pool Tag unknown");
			}
		}

	}

	public CapConstantPoolInfo getCPConstant(int index) {
		return ConstantPool.get(index);
	}
}
