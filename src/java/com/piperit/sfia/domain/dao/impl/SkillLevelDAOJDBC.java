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
import com.piperit.sfia.domain.SkillLevel;
import com.piperit.sfia.domain.dao.SkillLevelDAO;
import com.piperit.sfia.factory.SpringFactory;
import com.piperit.sfia.spring.domain.SpringSkill;

public class SkillLevelDAOJDBC implements SkillLevelDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public Collection getSkillLevels(Skill s) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println( s.getSkillID() );
		
		List ll = this.jdbcTemplate.query("SELECT description,LEVEL_NUMBER,SKILL_ID  from skill_level where SKILL_ID = ?", new Object[] {s.getSkillID()}, new SkillLevelMapper());
        return ll;        		
	}

	public void insertSkillLevel(Skill s, String desc, short level)
			throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public void updateSkill(Skill s, String desc, short level)
			throws DataAccessException {
		// TODO Auto-generated method stub

	}
	
	public class SkillLevelMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            
        	SpringFactory sf = new SpringFactory();
            
            // Clob conversion
            Clob cc = rs.getClob("description");
            String desc = cc.getSubString(1L, 10000);
            
            SkillLevel sl = sf.createSkillLevel(desc, rs.getShort("level_number"),rs.getString("skill_id"));
            
        	return sl;
        }
        

    }

}
