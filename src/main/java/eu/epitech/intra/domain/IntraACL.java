package eu.epitech.intra.domain;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntraACL implements Serializable {
	private static final long serialVersionUID = -4722935611788842136L;

	@JsonProperty(value = "type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty(value = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty(value = "title")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty(value = "members")
	private Collection<IntraACLMember> members;

	public Collection<IntraACLMember> getMembers() {
		return members;
	}

	public void setMembers(Collection<IntraACLMember> members) {
		this.members = members;
	}

}
