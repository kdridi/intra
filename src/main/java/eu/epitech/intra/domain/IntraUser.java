package eu.epitech.intra.domain;

import java.io.Serializable;

public class IntraUser implements Serializable {
	private static final long serialVersionUID = 7678311136075358488L;

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private IntraUserType type;

	public IntraUserType getType() {
		return type;
	}

	public void setType(IntraUserType type) {
		this.type = type;
	}

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	private String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	private String course_code;

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	private String promo;

	public String getPromo() {
		return promo;
	}

	private String course;

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	private String picture_fun;

	public String getPicture_fun() {
		return picture_fun;
	}

	public void setPicture_fun(String picture_fun) {
		this.picture_fun = picture_fun;
	}

}