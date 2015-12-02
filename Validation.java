
public class Validation {
	public static boolean isDouble(String str) {
	    try {
	        Double.parseDouble(str);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	public static boolean isInteger(String s) {
		try { 
			Integer.parseInt(s); 
			return true;
		} catch(NumberFormatException e) { 
			return false; 
		}
	}
}
