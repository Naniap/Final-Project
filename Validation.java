
public class Validation {
	/**
	 * Validates whether something is a double or not
	 * @param str takes a string to use a parse function to check whether if valid or not
	 * @return true if valid, false otherwise
	 */
	public static boolean isDouble(String str) {
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	/**
	 * 
	 * @param str takes a string and uses the Integer parse function to check whether if string is a valid int
	 * @return true if valid, false otherwise
	 */
	public static boolean isInteger(String str) {
		try { 
			Integer.parseInt(str); 
			return true;
		} catch(NumberFormatException e) { 
			return false; 
		}
	}
}
