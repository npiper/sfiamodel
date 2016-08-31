package com.piperit.sfia.domain.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.piperit.sfia.domain.Role;
import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.SkillLevel;
import com.piperit.sfia.domain.dao.impl.SkillLevelDAOJDBC.SkillLevelMapper;
import com.piperit.sfia.factory.SpringFactory;

public class UserSkillBaselineItemDAOImpl {
	
	
	 private JdbcTemplate jdbcTemplate;
	
	 private DataSource ds;
	 
	 public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
            ds = dataSource;
	}
	 
	public Collection getBaselineSkillLevels(String blname) throws DataAccessException {
		
		//TODO: Baseline name may not be unique across users, either use the ID or 
		// a combination of User,BLNAME
		
		List ll = this.jdbcTemplate.query("SELECT USER_BASELINE_ID,SKILL_ID,LEVEL_NUMBER  from USER_SKILL_BASELINE_ITEM where USER_BASELINE_ID = ?", new Object[] {blname}, new UserSkillBaselineItemMapper());
        return ll;        		
	}
	
	
	public class UserSkillBaselineItemMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SpringFactory sf = new SpringFactory(); 
            
            SkillDAOJdbc sd = new SkillDAOJdbc();
            sd.setDataSource(ds);
            
            String skill = rs.getString("SKILL_ID");
            
            Skill ss = sd.getSkill( skill );
            
            java.util.Collection cc = ss.getSkillLevels();
            
            java.util.Iterator it = cc.iterator();
            
            SkillLevel skillL = null;
            
            while ( it.hasNext())
            {
            	SkillLevel sl = (SkillLevel)it.next();
            	
            	if ( sl.getLevel().equals( new Short( rs.getShort("LEVEL_NUMBER") )) )
            	{
            		skillL = sl;
            		
            	}
            }
            
            return skillL;
        }

        
       /* public Collection getRoleLevels( Role rol)
        {
           return roleLevelDAO.getRoleLevels(rol);
        }
        */

    }
	
}
