package com.piperit.sfia.spring.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.datatypes.Category;
import com.piperit.sfia.domain.datatypes.SubCategory;

public class SpringSkill implements Skill {

	private Integer sequence;
	private String category;
	private String subcategory;
	private String skill;
	private String skill_id;
	private String description;
	private Collection skillLevels = new ArrayList();
	
	public SpringSkill() {};
	
	public Category getCategory() {
		// TODO Auto-generated method stub
		return new SpringCategory( this.category );
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	public void setDescription(String ss) {
		this.description = ss;
		// TODO Auto-generated method stub

	}
		
	public Integer getSequence() {
		// TODO Auto-generated method stub
		return sequence;
	}
	
	public void setSequence(Integer seq)
	{
	  this.sequence = seq;			
	}

	public String getSkill() {
		// TODO Auto-generated method stub
		return skill;
	}

	public void setSkill(String sk)
	{
		this.skill = sk;		
	}
	
	public String getSkillID() {
		// TODO Auto-generated method stub
		return skill_id;
	}
	
	public void setSkillID(String ski)
	{
		this.skill_id = ski;
		
	}

	public Collection getSkillLevels() {
		// TODO Auto-generated method stub
		return skillLevels;
	}


	public void setSkillLevels( Collection c)
	{
		// Sort the skill Levels
				
		java.util.List ll = new java.util.ArrayList(c);
		
		Collections.sort( ll, SpringSkillLevel.SKILL_LEVEL_COMPARATOR );
		
		skillLevels = ll;
	}
	
	public SubCategory getSubCategory() {
		// TODO Auto-generated method stub
		SpringCategory cc = new SpringCategory( this.category  );
		return new SpringSubCategory(cc, this.subcategory);
	}
	
	public void setSubCategory(SubCategory ss)
	{
		this.subcategory = ss.getSubCategory();
		this.category = ss.getCategory().getCategory();
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setActive(boolean active) {
		// TODO Auto-generated method stub
        ;
	}


	
}
