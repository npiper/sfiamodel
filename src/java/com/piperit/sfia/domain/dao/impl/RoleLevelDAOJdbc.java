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

import com.piperit.sfia.domain.Role;
import com.piperit.sfia.domain.RoleLevel;
import com.piperit.sfia.domain.SkillLevel;
import com.piperit.sfia.domain.dao.RoleLevelDAO;
import com.piperit.sfia.domain.dao.impl.SkillLevelDAOJDBC.SkillLevelMapper;
import com.piperit.sfia.factory.SpringFactory;
import com.piperit.sfia.spring.domain.SpringRole;

public class RoleLevelDAOJdbc implements RoleLevelDAO {


    private JdbcTemplate jdbcTemplate;
	
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
    public Collection getRoleLevels(Role r) throws DataAccessException
    {
		
		List ll = this.jdbcTemplate.query("SELECT ROLENAME,ROLE_LEVEL,MIN_SALARY,MAX_SALARY,DESCRIPTION from role_level where ROLENAME = ?", new Object[] {r.getRoleName()}, new RoleLevelMapper());
        return ll;      
    }
    
	public RoleLevel getRoleLevel(int id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertRoleLevel(RoleLevel rl) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public void updateRole(RoleLevel rl) throws DataAccessException {
		// TODO Auto-generated method stub

	}
	
	public class RoleLevelMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            
        	SpringFactory sf = new SpringFactory();
            
            // Clob conversion
            Clob cc = rs.getClob("description");
            String desc = cc.getSubString(1L, 10000);
            
            SpringRole sr = new SpringRole();
            Role rr = (Role)sr;
            Integer ii = new Integer( rs.getInt("role_level"));
            
            RoleLevel rl = sf.createRoleLevel(rr, ii, new Float(rs.getFloat("min_salary")), new Float(rs.getFloat("max_salary")),
            			    desc);
            
        	return rl;
        }
        

    }

}
