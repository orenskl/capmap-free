package fuzzing;

import javacard.framework.*;

/**
 * Secure electronic wallet.
 * 
 * @author Clement Mazin
 * @version 0.1
 */
public class fuzzingApplet extends javacard.framework.Applet {

	/* CONSTANTS */
	private static final byte CLA = (byte) 0x80;
	private static final byte INS_GETBALANCE = (byte) 0x20;
	private static final byte INS_DEBIT = (byte) 0x21;
	private static final byte INS_CREDIT = (byte) 0x22;
	private static final byte INS_CHECKPIN = (byte) 0x23;
	
	private static final short LENGTH_CREDIT = (byte) 4;
	private static final short LENGTH_DEBIT = (byte) 4;
	private static final byte LENTGTH_PIN = (byte) 4;
	
	private static final short INITIAL_BALANCE = (short) 100;
	
	private static final byte PIN_MAX_TRIES = (byte) 3;
	private static final short SHORT_SIZE = (short) 2;
	private static final short SW_PIN_BLOCKED = (short) 0x6F10;
	private static final short SW_INCORRECT_PIN = (short) 0x6F20;
	private static final short SW_DEBIT_NOT_EFFECTUATE = (short) 0x6F30;

	/*Static Field*/
	private static byte staticField = 0x42;
	private static byte[] staticArrayField = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };

	/* VARIABLES */
	private short balance;
	// pin code
	private byte[] pinvalue = { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };
	private OwnerPIN pin;

	/**
	 * Default constructor Only this class's install method should create the
	 * applet object.
	 */
	protected fuzzingApplet(byte[] bArray, short bOffset, byte bLength) {

		register(bArray, (short) (bOffset + 1), (byte) bArray[bOffset]);

        //		JCSystem.beginTransaction();
		this.balance = this.INITIAL_BALANCE;
		this.pin = new OwnerPIN(PIN_MAX_TRIES, (byte) this.pinvalue.length);
		// set Pin Value
		this.pin.update(this.pinvalue, (short) 0, (byte) this.pinvalue.length);
        //		JCSystem.commitTransaction();
	}

	/**
	 * Method installing the applet.
	 * 
	 * @param bArray
	 *            the array constaining installation parameters
	 * @param bOffset
	 *            the starting offset in bArray
	 * @param bLength
	 *            the length in bytes of the data parameter in bArray
	 * @throws ISOException
	 */
	public static void install(byte[] bArray, short bOffset, byte bLength)
			throws ISOException {
		// applet instance creation
		new fuzzingApplet(bArray, bOffset, bLength);
	}

	/**
	 * Select method returns true if applet selection is supported.
	 * 
	 * @return boolean status of selection.
	 */
	public boolean select() {
		/** TODO : PUT YOUR SELECTION ACTION HERE */

		// return status of selection
		return true;
	}

	/**
	 * Deselect method called by the system in the deselection process.
	 */
	public void deselect() {
		/** TODO : PUT YOUR SELECTION ACTION HERE */
		return;
	}

	/**
	 * Method processing an incoming APDU.
	 * 
	 * @see APDU
	 * @param apdu
	 *            the incoming APDU
	 * @exception ISOException
	 *                with the response bytes defined by ISO 7816-4
	 */
	public void process(APDU apdu) throws ISOException {

		

		if (selectingApplet()) {
			return;
		}

        // get the APDU buffer
        byte[] buffer = apdu.getBuffer();

		// check CLA
		if( (byte) (buffer[ISO7816.OFFSET_CLA]) != (byte) 0x80)
			ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
		
		if ((buffer[ISO7816.OFFSET_P1] != (byte) (0x00)) || (buffer[ISO7816.OFFSET_P2] != (byte) (0x00))) {
			ISOException.throwIt(ISO7816.SW_INCORRECT_P1P2);
		}

		switch (buffer[ISO7816.OFFSET_INS]) {
			case INS_GETBALANCE: // Get balance
				this.getBalance(apdu, buffer);
				break;
			case INS_CREDIT: // Credit
				this.credit(apdu, buffer);
				break;
			case INS_DEBIT: // Debit
				this.checkPin();
				this.debit(apdu, buffer);
				break;
			case INS_CHECKPIN: //check pin
				this.verify(apdu, buffer);
                		break;
			default:
				ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
		}

	}

	/**
	 * Check if pin code is validated
	 */
	private void checkPin() {
		if (!this.pin.isValidated()) {
			ISOException.throwIt(ISO7816.SW_CONDITIONS_NOT_SATISFIED);
		}
	}

	/**
	 * get Balance value
	 * 
	 * @param apdu
	 *            APDU buffer
	 * @param buffer
	 *            data received
	 */
	private void getBalance(APDU apdu, byte[] buffer) {
		Util.setShort(buffer, (short) 0, this.balance);
		apdu.setOutgoingAndSend((short) 0, (short) 2);
	}

	/**
	 * credit
	 * 
	 * @param apdu
	 *            APDU buffer
	 * @param buffer
	 *            data received
	 */
	private void credit(APDU apdu, byte[] buffer) {

		// Receiving data
		byte octetLus = (byte) apdu.setIncomingAndReceive();

		if (octetLus != (byte) LENGTH_CREDIT) {
			ISOException.throwIt(ISO7816.SW_WRONG_LENGTH);
		}

		short amount = Util.getShort(buffer, ISO7816.OFFSET_CDATA);
			// Begin transaction
			JCSystem.beginTransaction();
				this.balance += amount;
			// Ending transaction => commit
			JCSystem.commitTransaction();


	}

	/**
	 * debit
	 * 
	 * @param apdu
	 *            APDU buffer
	 * @param buffer
	 *            data received
	 */
	private void debit(APDU apdu, byte[] buffer) {
		// Receiving data
		byte octetLus = (byte) apdu.setIncomingAndReceive();

		if (octetLus != (byte) LENGTH_DEBIT) {
			ISOException.throwIt(ISO7816.SW_WRONG_LENGTH);
		}

		short amount = Util.makeShort(buffer[ISO7816.OFFSET_CDATA],
				buffer[(short)(ISO7816.OFFSET_CDATA + 1)]);

		if ((short) (amount) < (short) 0 || (short) ((short) (this.balance) - (short) (amount)) < (short) 0) {
			ISOException.throwIt(SW_DEBIT_NOT_EFFECTUATE);
		}
		else {
			// Begin transaction
			JCSystem.beginTransaction();
				this.balance += amount;
			// Ending transaction => commit
			JCSystem.commitTransaction();
		}
		apdu.setOutgoingAndSend((short) 0, (short) 0x08);

	}

   /**
	 * Verify pin code
	 * 
	 * @param apdu
	 *            APDU buffer
	 * @param buffer
	 *            data received
	 */
	private void verify(APDU apdu, byte[] buffer) {

		// Receiving data
		byte octetLus = (byte) apdu.setIncomingAndReceive();

		if (octetLus != LENTGTH_PIN) {
			ISOException.throwIt(ISO7816.SW_WRONG_LENGTH);
		}

		// There is not any try to authenticate the user
		if (this.pin.getTriesRemaining() == (byte) 0) {
			ISOException.throwIt(SW_PIN_BLOCKED);
		}

		// Check the pin code
		if (!this.pin.check(buffer, ISO7816.OFFSET_CDATA,
				(byte) pinvalue.length)) {
			// Incorrect PIN
			ISOException.throwIt(SW_INCORRECT_PIN);
		}

		// pin code OK
		return;
	}

	public static boolean isStatic() {
		if(staticField == 0x42)
			return true;
		else
			return false;
	}

	public byte[] getStaticArrayField() {
		return staticArrayField;
	}

}
