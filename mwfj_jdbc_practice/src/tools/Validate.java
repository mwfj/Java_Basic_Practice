package tools;

/**
 * 
 * @author mwfj 判断非法信息
 *
 */
public class Validate {
	/**
	 * 判断是否为空值
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNull(String str) {
		if (str == null || str.trim().equals("") || str.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumber(String str) {
		if (str == null) {
			System.out.println("空字符串，无法判断是否为数字");
			return false;
		}

		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("不是数字");
			return false;
		}
	}
	/**
	 * 判断年龄是否合法
	 * @param max_age
	 * @param min_age
	 * @param age
	 * @return
	 */
	public boolean isAgeillegal(int max_age, int min_age, int age){
		if (age<min_age || age>max_age) {
			return false;
		}
		return true;
	}
}
