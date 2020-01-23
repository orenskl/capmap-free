package fr.xlim.ssd.capmanipulator.bcel;

public abstract class CapConstantPoolInfo {

	private byte tag;

	protected CapConstantPoolInfo(byte tag) {
		this.tag = tag;
	}

	public byte getTag() {
		return tag;
	}

	public void setTag(byte tag) {
		this.tag = tag;
	}
}
