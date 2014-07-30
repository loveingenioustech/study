package thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	private final DateFormat format = new SimpleDateFormat("yyyyMMdd");

	public Date convert(String source) throws ParseException {
		Date d = format.parse(source);
		return d;
	}

	public Date safeConvert(String source) throws ParseException {
		synchronized (format) {
			Date d = format.parse(source);
			return d;
		}
	}

}
