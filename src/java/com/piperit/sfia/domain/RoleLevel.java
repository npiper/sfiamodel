package com.piperit.sfia.domain;

import java.util.Collection;
import java.util.Date;

/** Represents an officially recognised role level such
 * as a Senior Business Analyst, their salary range and
 * a description.
 * 
 * @author Piper
 *
 */
public interface RoleLevel {

	public Integer getId();
	
	public String getLevel();
	public void setLevel(String level);
	
	public Integer getMinSalary();
	public void setMinSalary(Integer i);
	
	public Integer getMaxSalary();
	public void setMaxSalary(Integer i);
	
	public String getDescription();
	public void setDescription(String desc);
	
	public Date getCreationDate();
	public void setCreationDate(Date dd);
	
	public Date getModifiedDate();
	public void setModifiedDate(Date dd);

	
}
