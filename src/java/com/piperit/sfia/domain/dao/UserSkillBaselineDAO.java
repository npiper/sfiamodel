package com.piperit.sfia.domain.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;

public interface UserSkillBaselineDAO {

	  public UserSkillBaseline getUserSkillBaseline(User u, String blname) throws DataAccessException;
	  
	  public void insertUserSkillBaseline(User u, Collection skills, String blName) throws DataAccessException;

	  public void updateUserSkillBaseline(UserSkillBaseline usbl) throws DataAccessException;
	
}
