package com.piperit.sfia.domain.dao;


import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.piperit.sfia.domain.Skill;

public interface SkillDAO {

	  public Skill getSkill(Integer i) throws DataAccessException;

	  public Skill getSkill(String skill) throws DataAccessException;

	  public void insertSkill(Skill s) throws DataAccessException;

	  public void updateSkill(Skill s) throws DataAccessException;
	
	  public Collection getAllActiveSkills() throws DataAccessException;
}
