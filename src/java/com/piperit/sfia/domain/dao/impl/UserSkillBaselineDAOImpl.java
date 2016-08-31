package com.piperit.sfia.domain.dao.impl;

import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.domain.dao.UserSkillBaselineDAO;
import com.piperit.sfia.factory.SpringFactory;
import com.piperit.sfia.spring.domain.SpringUserSkillBaseline;

public class UserSkillBaselineDAOImpl implements UserSkillBaselineDAO {


	 private JdbcTemplate jdbcTemplate;
	 private TransactionTemplate tt;
	
	 private UserSkillBaselineItemDAOImpl usblItemDAO = new UserSkillBaselineItemDAOImpl();
	 
	 
	 public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	        this.tt = new TransactionTemplate();
	        usblItemDAO.setDataSource(dataSource);
	    } 
	
	 /*
	  * 
	  * create table USER_SKILL_BASELINE(
  USER_BASELINE_ID NUMBER(9) NOT NULL,
  BASELINE_NAME VARCHAR2(256) NOT NULL,
  USER_ID VARCHAR2(120) NOT NULL,
  CREATION_DATE TIMESTAMP NOT NULL,
  DESCRIPTION CLOB,
  CONSTRAINT TABLE_USER_SKILL_BL_PK PRIMARY KEY ( USER_ID, BASELINE_NAME, USER_BASELINE_ID )
);
	  * (non-Javadoc)
	  * @see com.piperit.sfia.domain.dao.UserSkillBaselineDAO#getUserSkillBaseline(com.piperit.sfia.domain.User, java.lang.String)
	  */
	 
	public UserSkillBaseline getUserSkillBaseline(User u, String name)
			throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println( "User: " + u.getUserName() + " " + name );
		//AND user_ID = ?
		return (UserSkillBaseline)this.jdbcTemplate.queryForObject("select USER_BASELINE_ID, BASELINE_NAME, USER_ID, CREATION_DATE, DESCRIPTION, LATEST from USER_SKILL_BASELINE where baseline_name = ? AND USER_ID = ?", new Object[] {name, u.getUserName() }, new UserSkillBaselineMapper());
	}

	
	public Collection getUserBaselines(User u) throws DataAccessException
	{
		List ll = this.jdbcTemplate.query("SELECT USER_BASELINE_ID,baseline_name,user_id,creation_date, description, latest from USER_SKILL_BASELINE where user_id = ?", new Object[] {u.getUserName()}, new UserSkillBaselineMapper());
        return ll;    
	}

	public void insertUserSkillBaseline(User u, Collection skills, String blName)
			throws DataAccessException {
		// TODO Auto-generated method stub
		// User must exist and be active
		// Skills identified must exist and be active
		
        UserDAOJdbc udao = new UserDAOJdbc();
        if ( u == null || udao.getUser( u.getUserName() ) == null )
        {
            throw new DataIntegrityViolationException("The user to insert the baseline for in the database does not currently exist");	
        }
        
        java.sql.Date sqlDate = new java.sql.Date( new java.util.Date().getTime() );
            
        
        tt.execute( new TransactionCallbackWithoutResult() {
        	protected void doInTransactionWithoutResult(TransactionStatus status) {
        	    
        		//jdbcTemplate.
        		
        		
        	}
        	});
		

	}

	public void updateUserSkillBaseline(UserSkillBaseline usbl)
			throws DataAccessException {
		// TODO Auto-generated method stub

	}
	
	/*
	 * 
	 * 
	 */
	
	
	public class UserSkillBaselineMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SpringFactory sf = new SpringFactory(); 

            User uss = sf.createUser( rs.getString("user_id") );
            
            Clob cc = rs.getClob("description");
            String desc = cc.getSubString(1L, 10000);
            
            Collection coll = getBaselineSkills(rs.getString("USER_BASELINE_ID"));
            
            Timestamp ts = rs.getTimestamp("creation_date");
            java.util.Date date = new java.util.Date( ts.getTime() ); 
            
            UserSkillBaseline usbl = sf.createUserSkillBaseline(rs.getString("baseline_name"), uss, 
            		date, desc );
            
            String latest = rs.getString("LATEST");

            boolean b = false;
            
            if ( latest.equalsIgnoreCase("Y")) { b = true;}
            
            SpringUserSkillBaseline susbl = (SpringUserSkillBaseline)usbl;
            susbl.setIsLatest(b);
            susbl.setCreationDate(date);
            // Get the skill levels for this user baseline
            susbl.setSkillLevels( coll );
            
        	return susbl;
        }
        
       public Collection getBaselineSkills( String blName)
        {
    	   int i = 0; i++;
           return usblItemDAO.getBaselineSkillLevels(blName);
        }
       

    }
	

}
