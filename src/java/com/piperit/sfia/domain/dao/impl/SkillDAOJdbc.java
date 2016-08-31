package com.piperit.sfia.domain.dao.impl;


import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.dao.SkillDAO;
import com.piperit.sfia.domain.dao.impl.RoleLevelDAOJdbc.RoleLevelMapper;
import com.piperit.sfia.factory.SpringFactory;
import com.piperit.sfia.spring.domain.SpringCategory;
import com.piperit.sfia.spring.domain.SpringSkill;
import com.piperit.sfia.spring.domain.SpringSubCategory;

public class SkillDAOJdbc implements SkillDAO {

    private JdbcTemplate jdbcTemplate;

    private SkillLevelDAOJDBC skillLevelDAO = new SkillLevelDAOJDBC();
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

        skillLevelDAO.setDataSource(dataSource);

    }

	
	public Skill getSkill(Integer i) throws DataAccessException {

		    return (Skill)this.jdbcTemplate.queryForObject("SELECT sequence,category,subcategory,skill,skill_id,description from skills where sequence = ?", new Object[] {i} , new SkillMapper());
	}

	public Skill getSkill(String skill) throws DataAccessException {
		// TODO Auto-generated method stub
		return (Skill)this.jdbcTemplate.queryForObject("SELECT sequence,category,subcategory,skill,skill_id,description from skills where skill_id = ?", new Object[] {skill} , new SkillMapper());
	}

	public Collection getAllActiveSkills() throws DataAccessException
	{
		List ll = this.jdbcTemplate.query("select sequence,category,subcategory,skill,skill_id,description from skills", new SkillMapper());
        return ll;      
	}
	
	public void insertSkill(Skill s) throws DataAccessException {
		// TODO Auto-generated method stub
		// Maybe a generic skill insertion business rule 
		// should be formulated
		
		// Cannot be a duplicate of an existing or disabled skill
		// Find similar skills?
		// until levels are populated also then do not enable skill
		// Category / SubCategory must exist

		// Modify history table?
	}

	public void updateSkill(Skill s) throws DataAccessException {
		// TODO Auto-generated method stub
		// Cannot update SKILL_ID or other key fields
		// Only allow turning on/off active and editing description
        // Modify History table?
		
		
		
	}
	
	public class SkillMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SpringFactory sf = new SpringFactory();
            
            // Clob conversion
            Clob cc = rs.getClob("description");
            String desc = cc.getSubString(1L, 10000);
            
        	Skill skill = sf.createSkill(new Integer(rs.getInt("sequence")),rs.getString("category"),
        			rs.getString("subcategory"),rs.getString("skill"),
        			rs.getString("skill_id"), desc);
        	
        	SpringSkill sprSkill = (SpringSkill)skill;
        	         	
        	skill.setSkillLevels( getSkillLevels( skill ));
        	return skill;
        }
        
        public Collection getSkillLevels( Skill skill)
        {
           return skillLevelDAO.getSkillLevels(skill);
        }
        

    }

}
