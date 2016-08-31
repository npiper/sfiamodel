package com.piperit.sfia.domain;

import java.util.Collection;

public interface User extends CorporateEntity
{

	public String getUserName();
	
	public void setUserName(String username);
	
	public Collection getBaselines();
	
	public UserSkillBaseline getCurrentBaseline();
	
}
