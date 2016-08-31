package com.piperit.sfia.domain.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.factory.SpringFactory;
import com.piperit.sfia.spring.domain.SpringUser;

public class UserDAOJdbc implements UserDAO {

    private JdbcTemplate jdbcTemplate;
	
    private UserSkillBaselineDAOImpl ublDAO = new UserSkillBaselineDAOImpl();
    
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        
        ublDAO.setDataSource(dataSource);
    }
    
    
    public Collection getUsersWithSkill( String skillId )
    {
    	List ll = this.jdbcTemplate.query("select usr.user_id, USER_SKILL_BASELINE.BASELINE_NAME, USER_SKILL_BASELINE_ITEM.SKILL_ID from USR, USER_SKILL_BASELINE, USER_SKILL_BASELINE_ITEM  where USR.USER_ID = USER_SKILL_BASELINE.USER_ID AND USER_SKILL_BASELINE.LATEST = 'Y' AND USER_SKILL_BASELINE_ITEM.SKILL_ID = ?", new Object[] { skillId }, new UserMapper()  );
    	return ll;
    }
	
    
	public User getUser(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return (User)this.jdbcTemplate.queryForObject("select user_id from usr where user_id = ?", new Object[] {username}, new UserMapper());
	}

	public Collection getAllUsers() throws DataAccessException
	{
		List ll = this.jdbcTemplate.query("select user_id from usr", new UserMapper());
        return ll;     
	}
	
	public void insertUser(User u) throws DataAccessException {
		this.jdbcTemplate.update("insert into usr (user_id) values (?)", new Object[] {u.getUserName()});
	}

	public void updateUser(User u) throws DataAccessException {
		this.jdbcTemplate.update("update usr set user_id = ? where user_id = ?", new Object[] {u.getUserName(), u.getUserName()});
	}

	public class UserMapper implements RowMapper
	{
    
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            SpringFactory sf = new SpringFactory();                        
        	User usr = sf.createUser( rs.getString("user_id"));
        	
        	
        	
        	java.util.Collection coll = ublDAO.getUserBaselines(usr);
        	
        	java.util.Iterator it = coll.iterator();
        	
        	UserSkillBaseline currUsbl = null;
        	
        	while (it.hasNext())
        	{
        		currUsbl = (UserSkillBaseline)it.next();
        		
        		if (currUsbl.isLatest())
        		{ break; }
        	}
        	
        	SpringUser su = (SpringUser)usr;
        	su.setCurrentBaseline(currUsbl);
        	su.setBaselines( coll );
        	        	
        	return su;
        }
        

    }
	
}
