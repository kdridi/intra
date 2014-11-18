package eu.epitech.intra.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntraACLMember implements Serializable {
	private static final long serialVersionUID = 7154040736872403713L;

	@JsonProperty(value = "edit_rights")
	private Integer editRights;

	public Integer getEditRights() {
		return editRights;
	}

	public void setEditRights(Integer edit_rights) {
		this.editRights = edit_rights;
	}

	@JsonProperty(value = "force_note")
	private Integer forceNote;

	public Integer getForceNote() {
		return forceNote;
	}

	public void setForceNote(Integer forceNote) {
		this.forceNote = forceNote;
	}

	@JsonProperty(value = "force_register")
	private Integer forceRegister;

	public Integer getForceRegister() {
		return forceRegister;
	}

	public void setForceRegister(Integer forceRegister) {
		this.forceRegister = forceRegister;
	}

	@JsonProperty(value = "generate_token")
	private Integer generateToken;

	public Integer getGenerateToken() {
		return generateToken;
	}

	public void setGenerateToken(Integer generateToken) {
		this.generateToken = generateToken;
	}

	@JsonProperty(value = "assistant")
	private Integer assistant;

	public Integer getAssistant() {
		return assistant;
	}

	public void setAssistant(Integer assistant) {
		this.assistant = assistant;
	}

	@JsonProperty(value = "invite_ass")
	private Integer inviteAssistants;

	public Integer getInviteAssistants() {
		return inviteAssistants;
	}

	public void setInviteAssistants(Integer inviteAssistants) {
		this.inviteAssistants = inviteAssistants;
	}

	@JsonProperty(value = "login")
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonProperty(value = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty(value = "picture")
	private String picture;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@JsonProperty(value = "planify")
	private Integer planify;

	public Integer getPlanify() {
		return planify;
	}

	public void setPlanify(Integer planify) {
		this.planify = planify;
	}

	@JsonProperty(value = "prof_inst")
	private Integer profInstance;

	public Integer getProfInstance() {
		return profInstance;
	}

	public void setProfInstance(Integer profInstance) {
		this.profInstance = profInstance;
	}

	@JsonProperty(value = "title")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty(value = "type")
	private IntraACLMemberType type;

	public IntraACLMemberType getType() {
		return type;
	}

	public void setType(IntraACLMemberType type) {
		this.type = type;
	}

	@JsonProperty(value = "visible")
	private Integer visible;

	public Integer getVisible() {
		return visible;
	}

	public void setVisible(Integer visible) {
		this.visible = visible;
	}

}