package eu.epitech.intra.domain;

import java.io.Serializable;

public class IntraACLMember implements Serializable {
	private static final long serialVersionUID = 7154040736872403713L;

	private Integer edit_rights;

	public Integer getEdit_rights() {
		return edit_rights;
	}

	public void setEdit_rights(Integer edit_rights) {
		this.edit_rights = edit_rights;
	}

	private Integer force_note;

	public Integer getForce_note() {
		return force_note;
	}

	public void setForce_note(Integer force_note) {
		this.force_note = force_note;
	}

	private Integer force_register;

	public Integer getForce_register() {
		return force_register;
	}

	public void setForce_register(Integer force_register) {
		this.force_register = force_register;
	}

	private Integer generate_token;

	public Integer getGenerate_token() {
		return generate_token;
	}

	public void setGenerate_token(Integer generate_token) {
		this.generate_token = generate_token;
	}

	private Integer assistant;

	public Integer getAssistant() {
		return assistant;
	}

	public void setAssistant(Integer assistant) {
		this.assistant = assistant;
	}

	private Integer invite_ass;

	public Integer getInvite_ass() {
		return invite_ass;
	}

	public void setInvite_ass(Integer invite_ass) {
		this.invite_ass = invite_ass;
	}

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	private Integer planify;

	public Integer getPlanify() {
		return planify;
	}

	public void setPlanify(Integer planify) {
		this.planify = planify;
	}

	private Integer prof_inst;

	public Integer getProf_inst() {
		return prof_inst;
	}

	public void setProf_inst(Integer prof_inst) {
		this.prof_inst = prof_inst;
	}

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private IntraACLMemberType type;

	public IntraACLMemberType getType() {
		return type;
	}

	public void setType(IntraACLMemberType type) {
		this.type = type;
	}

	private Integer visible;

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

}