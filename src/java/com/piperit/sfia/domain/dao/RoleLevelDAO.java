package com.piperit.sfia.domain.dao;

import org.springframework.dao.DataAccessException;

import com.piperit.sfia.domain.RoleLevel;

public interface RoleLevelDAO {

	  public RoleLevel getRoleLevel(int id) throws DataAccessException;

	  public void insertRoleLevel(RoleLevel rl) throws DataAccessException;

	  public void updateRole(RoleLevel rl) throws DataAccessException;
	
}
