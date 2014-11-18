package eu.epitech.intra.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntraUser implements Serializable {
	private static final long serialVersionUID = 7678311136075358488L;

	@JsonProperty(value = "title")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty(value = "type")
	private IntraUserType type;

	public IntraUserType getType() {
		return type;
	}

	public void setType(IntraUserType type) {
		this.type = type;
	}

	@JsonProperty(value = "login")
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonProperty(value = "picture")
	private String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@JsonProperty(value = "course_code")
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@JsonProperty(value = "promo")
	private String promo;

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	@JsonProperty(value = "course")
	private String course;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@JsonProperty(value = "picture_fun")
	private String pictureFun;

	public String getPictureFun() {
		return pictureFun;
	}

	public void setPictureFun(String pictureFun) {
		this.pictureFun = pictureFun;
	}

}