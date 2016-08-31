package com.piperit.sfia.factory;


import java.util.Collection;
import java.util.Date;

import com.piperit.sfia.domain.Role;
import com.piperit.sfia.domain.RoleLevel;
import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.SkillLevel;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.spring.domain.SpringCategory;
import com.piperit.sfia.spring.domain.SpringRole;
import com.piperit.sfia.spring.domain.SpringRoleLevel;
import com.piperit.sfia.spring.domain.SpringSkill;
import com.piperit.sfia.spring.domain.SpringSkillLevel;
import com.piperit.sfia.spring.domain.SpringSubCategory;
import com.piperit.sfia.spring.domain.SpringUser;
import com.piperit.sfia.spring.domain.SpringUserSkillBaseline;

public class SpringFactory {

	public User createUser( String userName )
	{
		SpringUser su = new SpringUser();
		su.setUserName(userName);
		return su;
	}
	
	public SkillLevel createSkillLevel( String desc, short level, String skillId)
	{
		SpringSkillLevel ssl = new SpringSkillLevel();
		ssl.setDescription(desc);
		ssl.setLevel(level);
		ssl.setSkillID(skillId);
		return ssl;
	}
	
	public RoleLevel createRoleLevel( Role r, Integer role_level, Float minSalary, Float maxSalary, String desc)
	{
		SpringRoleLevel srl = new SpringRoleLevel();
        
		//TODO:  Fix SpringRoleLevel and create a proper object
		
		return srl;
	}
	
	public Role createRole(String name, Boolean active, String desc, Collection levels)
	{
		SpringRole sr = new SpringRole();
		
		sr.setRoleName(name);
		sr.setActive(active);
		sr.setDescription(desc);
		sr.setRoleLevels(levels);
		return sr;
	}
	
	public Skill createSkill(Integer sequence, String category, String subcategory,
			String skill,String skill_id, String description)
	{
		SpringSkill ss = new SpringSkill();
		ss.setSequence(sequence);
		ss.setSkill(skill);
		ss.setSkillID(skill_id);
		ss.setActive(true);
		ss.setDescription(description);
		
		SpringCategory sc = new SpringCategory( category );
		
		ss.setSubCategory( new SpringSubCategory( sc, subcategory ));
		
		return ss;
	}

	public UserSkillBaseline createUserSkillBaseline(String blname, User uid, Date creationDate, String desc)
	{
		SpringUserSkillBaseline sbl = new SpringUserSkillBaseline();
		
		sbl.setBaselineName(blname);
		sbl.setUser(uid);
		sbl.setDescription(desc);
		
		return sbl;
	}
}
