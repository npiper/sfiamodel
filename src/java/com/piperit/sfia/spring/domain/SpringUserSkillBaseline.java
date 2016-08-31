package com.piperit.sfia.spring.domain;

import java.sql.Date;
import java.util.Collection;

import com.piperit.sfia.domain.SkillLevel;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;

public class SpringUserSkillBaseline implements UserSkillBaseline {

	public Collection skillLevels = new java.util.ArrayList();
	public String baselineName;
	public java.util.Date creationDate;
	public String description;
	public User user;
	public boolean latest;
	
	public void addSkillLevel(SkillLevel sl) {
		// TODO Auto-generated method stub
        skillLevels.add( sl );
	}

	public String getBaselineName() {
		// TODO Auto-generated method stub
		return baselineName;
	}

	public java.util.Date getCreationDate() {
		// TODO Auto-generated method stub
		return creationDate;
	}
	
	public void setCreationDate(java.util.Date dd)
	{
		this.creationDate = dd;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public Collection getSkillLevels() {
		// TODO Auto-generated method stub
		return skillLevels;
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}

	public void setBaselineName(String blname) {
		// TODO Auto-generated method stub
        this.baselineName = blname;
	}

	public void setDescription(String desc) {
		// TODO Auto-generated method stub
        this.description = desc;
	}

	public void setSkillLevels(Collection cc) {
		// TODO Auto-generated method stub
        this.skillLevels = cc;
	}

	public void setUser(User usr) {
		// TODO Auto-generated method stub
        this.user = usr;
	}
	
	public void setIsLatest(boolean b)
	{
		this.latest = b;
	}
	
	public boolean isLatest()
	{
		return latest;
	}

}
