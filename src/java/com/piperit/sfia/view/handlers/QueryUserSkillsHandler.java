package com.piperit.sfia.view.handlers;

import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.domain.dao.SkillDAO;
import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.domain.dao.UserSkillBaselineDAO;

public class QueryUserSkillsHandler implements ActionListener {

	
	private Collection userList;
	
	private UserSkillBaseline userSkillBaseline;

	private String userName;

	private String baselineName;
	
	public UserSkillBaseline userBasline;

	private DataModel userBaselines;
	
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
	}       
	
	public DataModel getUserBaselineModel()
	{
		
	       if (userBaselines == null) {

	            userBaselines = new ListDataModel( );

	        }

	        userBaselines.setWrappedData(getUserBaselines());

	        return userBaselines;

	}
	
	public Collection getUserBaselines()
	{
		
		try
		{
		  ClassPathResource cpr = new ClassPathResource("context.xml");

		  XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
          UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");
		 
          userList = userDAO.getAllUsers();
               
          java.util.Iterator it = userList.iterator();
          
          java.util.Collection userBLS = new java.util.ArrayList();
          
          while (it.hasNext())
          {
              User uu =  (User)it.next();
              
              java.util.Iterator itt = uu.getBaselines().iterator();
              
              while (itt.hasNext())
              {
            	    UserSkillBaseline usbl =(UserSkillBaseline) itt.next();
            	    
            	    UserAndBaseline uandb = new UserAndBaseline(uu, usbl);
            	  
            	    userBLS.add(uandb);
              }
              
          }
          
          return userBLS;
		}
		catch (Exception e)
		{
			System.err.println("error getting current list of current users");
			return null;
		}
	}
	
	
    public String showBaseline( ) {

       
    	UserAndBaseline uandb = (UserAndBaseline) userBaselines.getRowData();
    	
    	setBaselineName( uandb.getBaseline().getBaselineName() );
    	
    	setUserName( uandb.getUser().getUserName());
    	
    	return "success";

        }


	
	public String getUserName()
	{
		return userName;
	}
	
	public void setUserName(String un)
	{
		this.userName = un;
		
	}
     		
	public String getBaselineName()
	{
		return baselineName;
	}
	
	public void setBaselineName(String blName)
	{
		this.baselineName = blName;
	}
	
	public UserSkillBaseline getUserBaseline()
	{
		return userBasline;
		
	}
	public void setUserBaseline(UserSkillBaseline usbl)
	{
		this.userBasline = usbl;		
	}
    
    private Collection listUsers()
    {
		try
		{
		  ClassPathResource cpr = new ClassPathResource("context.xml");

		  XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
          UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");
		 
          userList = userDAO.getAllUsers();
                    
          return userList;
		}
		catch (Exception e)
		{
			System.err.println("error getting current list of current users");
			return null;
		}
    }
    
	public Collection getUsers()
	{
        return listUsers();
	}
	
	/*
	public String showBaseline()
	{
		try
		{
		  ClassPathResource cpr = new ClassPathResource("context.xml");

		  XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
          UserSkillBaselineDAO userblDAO = (UserSkillBaselineDAO)beanFactory.getBean("userSkillBaselineDAO");
		 
          UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");
          
          
          User uu = userDAO.getUser(this.userName);
          
          String blName = this.baselineName;
          
          setUserBaseline( userblDAO.getUserSkillBaseline(uu, blName));
          
          return "success";
		}
		catch (Exception e)
		{
			System.err.println("error getting baseline " + baselineName + " for user " + userName );
			return "failure";
		}
		
	}
	*/
	
	public String showUsers()
	{
		try
		{
		  ClassPathResource cpr = new ClassPathResource("context.xml");

		  XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
          UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");
		 
          userList = userDAO.getAllUsers();
          
          System.out.println( "Found " + userList.size() + " users." );
          
          return "success";
		}
		catch (Exception e)
		{
			System.err.println("error getting current list of current users");
			return "failure";
		}
		
	}

	public class UserAndBaseline
	{
		public User user;
		
		public UserSkillBaseline baseline;
		
		public UserAndBaseline(User u, UserSkillBaseline usbl)
		{
		   this.user = u;
		   this.baseline = usbl;
		}
		
		public User getUser() { return user; }
		public UserSkillBaseline getBaseline() { return baseline; }
		
	}
	
	
}
