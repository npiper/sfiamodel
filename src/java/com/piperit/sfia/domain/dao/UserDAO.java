package com.piperit.sfia.domain.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.piperit.sfia.domain.User;

public interface UserDAO {

	  public User getUser(String username) throws DataAccessException;
	  
	  public Collection getAllUsers() throws DataAccessException;
	  
	  public Collection getUsersWithSkill( String skillId );
	  
	  public void insertUser(User u) throws DataAccessException;

	  public void updateUser(User u) throws DataAccessException;
	
}
