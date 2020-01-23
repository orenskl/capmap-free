package fr.xlim.ssd.capmanipulator.bcel.utils;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: nizam
 * Date: 26/06/12
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class Tools {

	public static byte[] List2Array(ArrayList<Byte> list) {
		byte[] array = new byte[list.size()];
		for(int i = 0; i < list.size(); i++) {
			array[i] = list.get(i).byteValue();
		}
		return array;
	}
}
