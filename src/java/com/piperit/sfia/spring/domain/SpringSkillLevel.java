package com.piperit.sfia.spring.domain;

import java.util.Comparator;

import com.piperit.sfia.domain.SkillLevel;

public class SpringSkillLevel implements SkillLevel {

	

	
	private String description;
	private short level;
	private String skillId;
	
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public Short getLevel() {
		// TODO Auto-generated method stub
		return new Short(level);
	}

	public void setDescription(String desc) {
		// TODO Auto-generated method stub
        this.description = desc;
	}

	public void setLevel(short s) {
		// TODO Auto-generated method stub
        this.level = s;
	}
	
	public String getSkillID() { return skillId;  }
	
	public void setSkillID(String id) 
	{
		this.skillId = id;
	}

    public static final Comparator SKILL_LEVEL_COMPARATOR = new Comparator() {
        public int compare(Object o1, Object o2) {
            int s1 = ((SkillLevel) o1).getLevel().intValue();
            int s2 = ((SkillLevel) o2).getLevel().intValue();
            if (s1 < s2) { return 0;}
            else { return 1;}
        }
    };
}
