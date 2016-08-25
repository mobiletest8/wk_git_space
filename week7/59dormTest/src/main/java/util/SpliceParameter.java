package util;

public class SpliceParameter {
	
	
	/**
	 * 拼接参数
	 * @param key
	 * @param value
	 * @return
	 */
	public static String sParameter(String key,String value) {

		String result  = key + "=" + value + "&";
		
		return result;
	}

}
