package com.piperit.sfia.domain;

import java.util.Collection;

/** Represents a corporate role such as Programmer,
 * Developer, Analyst.  Each role has a series of levels
 * that cover a range of salary conditions and skill criteria to
 * achieve.
 * 
 * @author Piper
 *
 */
public interface Role extends CorporateEntity {
	
	public String getRoleName();
	
	public void setRoleName(String name);
	
	public Boolean isActive();
	
	public void setActive(Boolean bb);
	
	public String getDescription();
	
	public void setDescription(String desc);
	
	public Collection getRoleLevels();
	
	public void addRoleLevel(RoleLevel r);
	
	public void setRoleLevels(Collection levels);
	
}
