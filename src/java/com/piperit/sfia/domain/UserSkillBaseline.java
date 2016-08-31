package com.piperit.sfia.domain;

import java.util.Date;
import java.util.Collection;

public interface UserSkillBaseline extends Baseline{

	public Collection getSkillLevels();
	
	public void addSkillLevel(SkillLevel sl);
	
	public void setSkillLevels(Collection cc);
	
	public Date getCreationDate();
	
	public String getBaselineName();
	
	public void setBaselineName(String blname);
	
	public User getUser();
	
	public void setUser(User usr);
	
	public String getDescription();
	
	public void setDescription(String desc);
	
	public boolean isLatest();
}
