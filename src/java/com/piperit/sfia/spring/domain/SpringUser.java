package com.piperit.sfia.spring.domain;

import java.util.Collection;

import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;

public class SpringUser implements User {

	private String userName;
	private Collection baselines;
	private UserSkillBaseline currentBaseline;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public void setBaselines(Collection bl)
	{
		this.baselines = bl;
	}
	
	public void setCurrentBaseline( UserSkillBaseline usbl )
	{
		this.currentBaseline = usbl;
	}
	
	public Collection getBaselines()
	{
		return baselines;
	}
	
	public UserSkillBaseline getCurrentBaseline()
	{
		return currentBaseline;		
	}
	
}
