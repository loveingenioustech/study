package util;

public class CharSetUtil {
	public static String toChinese(String ss) {
		if (ss != null) {
			try {
				String tmpe = ss;
				byte[] temp_t = tmpe.getBytes("ISO8859-1");
				ss = new String(temp_t, "gb2312");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return ss;
	}

}
