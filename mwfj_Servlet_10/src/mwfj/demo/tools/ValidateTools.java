package rico.demo.tools;

public class ValidateTools {
	
	public static boolean isNumber(String str) {
		try {
			Long.parseLong(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
