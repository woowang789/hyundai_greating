package util;
/**
 * 
 * @author 이세아
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date strToDateWithTime(String str) {
		try {
			return df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
	public static String dateWithTimeToStr(Date date) {
		return df.format(date);
	}

	public static String datetoStr(Date date) {
		return df2.format(date);
	}
	public static Date strToDate(String str) {
		try {
			return df2.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}
}
