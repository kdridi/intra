package eu.epitech.intra.domain;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntraCourse implements Serializable {
	private static final long serialVersionUID = 4565135608056019766L;

	@JsonProperty(value = "id")
	private Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty(value = "title_cn")
	private String titleCN;

	public String getTitleCN() {
		return this.titleCN;
	}

	public void setTitleCN(String titleCN) {
		this.titleCN = titleCN;
	}

	@JsonProperty(value = "semester")
	private Integer semester;

	public Integer getSemester() {
		return this.semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	@JsonProperty(value = "num")
	private Integer number;

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@JsonProperty(value = "begin")
	private String begin;

	public String getBegin() {
		return this.begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	@JsonProperty(value = "end")
	private String end;

	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@JsonProperty(value = "end_register")
	private String endRegister;

	public String getEndRegister() {
		return this.endRegister;
	}

	public void setEndRegister(String endRegister) {
		this.endRegister = endRegister;
	}

	@JsonProperty(value = "scolaryear")
	private Integer scolarYear;

	public Integer getScolarYear() {
		return this.scolarYear;
	}

	public void setScolarYear(Integer scolarYear) {
		this.scolarYear = scolarYear;
	}

	@JsonProperty(value = "code")
	private String code;

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty(value = "codeinstance")
	private String codeInstance;

	public String getCodeInstance() {
		return this.codeInstance;
	}

	public void setCodeInstance(String codeInstance) {
		this.codeInstance = codeInstance;
	}

	@JsonProperty(value = "location_title")
	private String locationTitle;

	public String getLocationTitle() {
		return this.locationTitle;
	}

	public void setLocationTitle(String locationTitle) {
		this.locationTitle = locationTitle;
	}

	@JsonProperty(value = "instance_location")
	private String instanceLocation;

	public String getInstanceLocation() {
		return this.instanceLocation;
	}

	public void setInstanceLocation(String instanceLocation) {
		this.instanceLocation = instanceLocation;
	}

	@JsonProperty(value = "flags")
	private String flags;

	public String getFlags() {
		return this.flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	@JsonProperty(value = "credits")
	private String credits;

	public String getCredits() {
		return this.credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	@JsonProperty(value = "rights")
	private List<IntraCourseRight> rights;

	public List<IntraCourseRight> getRights() {
		return this.rights;
	}

	public void setRights(List<IntraCourseRight> rights) {
		this.rights = rights;
	}

	@JsonProperty(value = "waiting_grades")
	private String waitingGrades;

	public String getWaitingGrades() {
		return this.waitingGrades;
	}

	public void setWaitingGrades(String waitingGrades) {
		this.waitingGrades = waitingGrades;
	}

	@JsonProperty(value = "active_promo")
	private String activePromo;

	public String getActivePromo() {
		return this.activePromo;
	}

	public void setActivePromo(String activePromo) {
		this.activePromo = activePromo;
	}

	@JsonProperty(value = "open")
	private String open;

	public String getOpen() {
		return this.open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	@JsonProperty(value = "title")
	private String title;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
