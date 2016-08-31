package com.piperit.sfia.spring.domain;

import java.util.Collection;

import com.piperit.sfia.domain.Role;
import com.piperit.sfia.domain.RoleLevel;

public class SpringRole implements Role {

	private String description;
	private String name;
	private boolean active;
	private Collection roleLevels = new java.util.ArrayList();
	
	public void addRoleLevel(RoleLevel r) {
		roleLevels.add(r);
	}

	public String getDescription() {
       return description;
	}

	public Collection getRoleLevels() {
		
		return roleLevels;
	}

	public String getRoleName() {
       return name;
	}

	public Boolean isActive() {
       return new Boolean(this.active);
	}

	public void setActive(Boolean bb) {
      this.active = bb.booleanValue();
	}

	public void setDescription(String desc) {
       this.description = desc;
	}

	public void setRoleLevels(Collection levels) {
		this.roleLevels = levels;
	}

	public void setRoleName(String name) {
		this.name = name;
	}

}
