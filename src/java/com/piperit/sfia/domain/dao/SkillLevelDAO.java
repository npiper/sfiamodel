package com.piperit.sfia.domain.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.piperit.sfia.domain.Skill;

public interface SkillLevelDAO {

	  public Collection getSkillLevels(Skill s) throws DataAccessException;

	  public void insertSkillLevel(Skill s, String desc, short level) throws DataAccessException;

	  public void updateSkill(Skill s, String desc, short level) throws DataAccessException;
	
}
