package twt.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandle {
	public static Date date(String birth) throws ParseException{
		SimpleDateFormat bartDateFormat = 
				new SimpleDateFormat("yyyy-MM-dd");
				Date date = bartDateFormat.parse(birth);
				return date; 
}
}