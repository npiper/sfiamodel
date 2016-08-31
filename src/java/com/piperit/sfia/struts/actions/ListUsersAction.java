package com.piperit.sfia.struts.actions;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.view.handlers.QueryUserSkillsHandler.UserAndBaseline;

public class ListUsersAction extends Action {

	private Logger logg = Logger.getLogger(ListUsersAction.class);
	
	public ActionForward execute( ActionMapping mapping,

            ActionForm form,

            HttpServletRequest request,

            HttpServletResponse response )

throws Exception{

ActionErrors errors = new ActionErrors();

ClassPathResource cpr = new ClassPathResource("context.xml");

XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);

UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");

java.util.Collection userList = userDAO.getAllUsers();
     
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

request.getSession().setAttribute("users", userBLS);

return mapping.findForward("Success");


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
