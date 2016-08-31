package com.piperit.sfia.domain;

import java.io.Serializable;
import java.util.Collection;

import com.piperit.sfia.domain.datatypes.Category;
import com.piperit.sfia.domain.datatypes.SubCategory;

/** Skill represents an SFIA Skill, there are a range of level descriptions across each skill
 * 
 * @author Piper
 *
 */
public interface Skill extends Serializable{

	/** Return the SFIA skill ID (4 digits)
	 * 
	 * @return
	 */
	public String getSkillID();
	
  /** Set the Skill ID for this skill (4 digits)
  * 
  * @param ID
  */
	//public void setSkillID( String ID);
	
	
	/** Gets the sequence order of the skill in the SFIA standard
	 * 
	 * @return
	 */
	public Integer getSequence();
	
	/** Sets the sequence order of the skill in the SFIA standard
	 * 
	 * @param seq
	 */
	//public void setSequence(Integer seq);
	
	public Category getCategory();	
	
	public SubCategory getSubCategory();
	
	//public void setSubCategory(SubCategory scg);
	
	public String getSkill();
	
	//public void setSkill(String skill);
	
	public String getDescription();
	
	public void setDescription(String ss);
	
	public boolean isActive();
	
	public void setActive(boolean active);
	
	/** Get the SkillLevel objects that are valid for this skill
	 * Each object has a level and description which a user can choose to rate themselves agains.
	 * 
	 * @return
	 */
	public Collection getSkillLevels();
	
	public void setSkillLevels( Collection c);
	
}
