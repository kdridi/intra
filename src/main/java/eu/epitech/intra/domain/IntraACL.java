package eu.epitech.intra.domain;

import java.io.Serializable;
import java.util.Collection;

public class IntraACL implements Serializable {
	private static final long serialVersionUID = -4722935611788842136L;

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private Collection<IntraACLMember> members;

	public Collection<IntraACLMember> getMembers() {
		return members;
	}

	public void setMembers(Collection<IntraACLMember> members) {
		this.members = members;
	}

}
