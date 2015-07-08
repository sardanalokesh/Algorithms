package lsardana.algorithms;
/**
 * 
 * @author lokesh.sardana
 *
 */
public class Helper {
	public static String getCoordinateArrayString(Coordinates[] cArray) {
		String arrayString = "";
		for (int i = 0; i < cArray.length; i++) {
			arrayString += cArray[i].toString();
			if (i != cArray.length-1) {
				arrayString += ",";
			}
		}
		return "["+arrayString+"]";
	}
}
