package eu.epitech.intra.commons.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IntraDateHelper {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final int DAY_TIME_IN_MILLIS = 24 * 60 * 60 * 1000;

	public static final Date parseString(String date) {
		try {
			return DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static final String formatDate(Date date) {
		return DATE_FORMAT.format(date);
	}

	public static final Date getFirstDateOfWeek() {
		final Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		int todayDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		int firstDayOfWeek = today.getFirstDayOfWeek();
		if (todayDayOfWeek < firstDayOfWeek) {
			todayDayOfWeek += 7;
		}
		final long firstDayOfWeekTime = today.getTimeInMillis() + (firstDayOfWeek - todayDayOfWeek) * DAY_TIME_IN_MILLIS;
		return new Date(firstDayOfWeekTime);
	}

	public static final Date getDateWeekLater(Date startDate) {
		return new Date(startDate.getTime() + 7 * DAY_TIME_IN_MILLIS);
	}

}
