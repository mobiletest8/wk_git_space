package util;

public class SpliceParam {
	
	
	/**
	 * 拼接参数
	 * @param key
	 * @param value
	 * @return
	 */
	public static String sParam(String key,String value) {

		String result  = key + "=" + value + "&";
		
		return result;
	}

}
