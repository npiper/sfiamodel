package com.piperit.sfia.domain.dao;

import org.springframework.dao.DataAccessException;

import com.piperit.sfia.domain.Role;


public interface RoleDAO {

	  public Role getRole(String name) throws DataAccessException;

	  public void insertRole(Role r) throws DataAccessException;

	  public void updateRole(Role r) throws DataAccessException;
	
}
