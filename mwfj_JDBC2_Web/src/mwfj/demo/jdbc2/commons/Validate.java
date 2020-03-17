package mwfj.demo.jdbc2.commons;

public class Validate {
	
	/**
	 * “空”
	 * NULL
	 * ""
	 * "      "
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		/**
		 * &&
		 * ||
		 * --------------------------
		 * &
		 * |
		 * -------------------------
		 * 
		 * x=5
		 * if(x < 10 || x++ < 12 ||  x++ > 0) {
		 * 	
		 * }
		 * x = ?
		 */
		if(str == null || str.trim().equals("") || str.trim().length() == 0) {
			/**
			 * 判断是否为空
			 */
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String str) {
		/**
		 * 判断是否为数字
		 */
		if(str == null) {
			return false;
		}
		
		try {
			Integer.parseInt(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static boolean isAgeOK(int age, int min, int max) {
		/**
		 * 判断年龄是否越界
		 */
		if(age >= min && age <= max) {
			return true;
		}
		
		return false;
	}

}
