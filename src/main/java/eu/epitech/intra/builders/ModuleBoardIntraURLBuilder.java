package eu.epitech.intra.builders;

import java.util.Date;

import eu.epitech.intra.commons.IntraURLBuilder;
import eu.epitech.intra.commons.helpers.IntraDateHelper;

public class ModuleBoardIntraURLBuilder extends IntraURLBuilder {
	private static final String PARAM_END_DATE = "end";

	private static final String PARAM_START_DATE = "start";

	private static final String PATH = "/module/board/";

	private Date startDate;
	private Date endDate;

	public ModuleBoardIntraURLBuilder setStartDate(Date date) {
		startDate = date;
		return this;
	}

	public ModuleBoardIntraURLBuilder setEndDate(Date date) {
		this.endDate = date;
		return this;
	}

	private ModuleBoardIntraURLBuilder() {
		super(PATH);
	}

	@Override
	protected void build(Parameters parameters) {
		parameters.add(PARAM_START_DATE, IntraDateHelper.formatDate(startDate));
		parameters.add(PARAM_END_DATE, IntraDateHelper.formatDate(endDate));
	}

	public static final ModuleBoardIntraURLBuilder newBuilder(Date startDate, Date endDate) {
		return new ModuleBoardIntraURLBuilder().setStartDate(startDate).setEndDate(endDate);
	}

	public static final ModuleBoardIntraURLBuilder newBuilder(Date date) {
		return newBuilder(date, IntraDateHelper.getDateWeekLater(date));
	}

	public static final ModuleBoardIntraURLBuilder newBuilder() {
		return newBuilder(IntraDateHelper.getFirstDateOfWeek());
	}
}
