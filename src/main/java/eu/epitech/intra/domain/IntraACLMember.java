package eu.epitech.intra.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntraACLMember implements Serializable {
	private static final long serialVersionUID = 7154040736872403713L;

	@JsonProperty(value = "edit_rights")
	private Boolean editRights;

	public Boolean getEditRights() {
		return editRights;
	}

	public void setEditRights(Boolean edit_rights) {
		this.editRights = edit_rights;
	}

	@JsonProperty(value = "force_note")
	private Boolean forceNote;

	public Boolean getForceNote() {
		return forceNote;
	}

	public void setForceNote(Boolean forceNote) {
		this.forceNote = forceNote;
	}

	@JsonProperty(value = "force_register")
	private Boolean forceRegister;

	public Boolean getForceRegister() {
		return forceRegister;
	}

	public void setForceRegister(Boolean forceRegister) {
		this.forceRegister = forceRegister;
	}

	@JsonProperty(value = "generate_token")
	private Boolean generateToken;

	public Boolean getGenerateToken() {
		return generateToken;
	}

	public void setGenerateToken(Boolean generateToken) {
		this.generateToken = generateToken;
	}

	@JsonProperty(value = "assistant")
	private Boolean assistant;

	public Boolean getAssistant() {
		return assistant;
	}

	public void setAssistant(Boolean assistant) {
		this.assistant = assistant;
	}

	@JsonProperty(value = "invite_ass")
	private Boolean inviteAssistants;

	public Boolean getInviteAssistants() {
		return inviteAssistants;
	}

	public void setInviteAssistants(Boolean inviteAssistants) {
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
	private Boolean planify;

	public Boolean getPlanify() {
		return planify;
	}

	public void setPlanify(Boolean planify) {
		this.planify = planify;
	}

	@JsonProperty(value = "prof_inst")
	private Boolean profInstance;

	public Boolean getProfInstance() {
		return profInstance;
	}

	public void setProfInstance(Boolean profInstance) {
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
	private Boolean visible;

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}