package com.piperit.sfia.domain.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.piperit.sfia.domain.Role;

import com.piperit.sfia.domain.dao.RoleDAO;
import com.piperit.sfia.factory.SpringFactory;


public class RoleDAOJdbc implements RoleDAO {

	 private JdbcTemplate jdbcTemplate;
	 
	 private RoleLevelDAOJdbc roleLevelDAO = new RoleLevelDAOJdbc();
	 
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	        
	        roleLevelDAO.setDataSource(dataSource);
	    } 
	 
	public Role getRole(String name) throws DataAccessException {
		return (Role)this.jdbcTemplate.queryForObject("SELECT rolename, active, description from role where rolename = ?", new Object[] {name} , new RoleMapper());
	}

	public void insertRole(Role r) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public void updateRole(Role r) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public class RoleMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SpringFactory sf = new SpringFactory(); 
            
            java.util.Collection coll = new java.util.ArrayList();
            
            String activeVal = rs.getString("active");
            Boolean bb = new Boolean(true);
            if ( activeVal.equals("false")) { bb = new Boolean(false);  }
            
            
        	Role rol = sf.createRole(rs.getString("rolename"), bb,
        			rs.getString("description"), coll );
            coll = getRoleLevels(rol);
            rol.setRoleLevels(coll);
        	return rol;
        }

        
        public Collection getRoleLevels( Role rol)
        {
           return roleLevelDAO.getRoleLevels(rol);
        }

    }
	
}
