package eu.epitech.intra.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IntraUserNetsoulState extends ArrayList<Double> implements Serializable {
	private static final long serialVersionUID = 7678311136075358488L;

	private Double getDouble(int i) {
		if (size() != 6) {
			throw new RuntimeException();
		}
		if (i >= 6) {
			throw new RuntimeException();
		}
		return get(i);
	}

	public Date getDate() {
		long date = getDouble(0).longValue() * 1000L;
		return new Date(date);
	}

	public String getDateAsString() {
		return new SimpleDateFormat("Y/M/d").format(getDate());
	}

	public long getTimeInActive() {
		return getDouble(1).longValue();
	}

	public long getTimeInIdle() {
		return getDouble(2).longValue();
	}

	public long getTimeOutActive() {
		return getDouble(3).longValue();
	}

	public long getTimeOutIdle() {
		return getDouble(4).longValue();
	}

	public float getTimeAverage() {
		return getDouble(5).floatValue();
	}
}