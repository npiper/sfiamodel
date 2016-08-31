package com.piperit.sfia.struts.actions;

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

import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.domain.dao.SkillDAO;
import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.domain.dao.UserSkillBaselineDAO;
import com.piperit.sfia.struts.controller.SFIAActionServlet;

public class ShowUserBaselineAction extends Action {

	
	private Logger logg = Logger.getLogger(ShowUserBaselineAction.class);
	
	 public ActionForward execute( ActionMapping mapping,

             ActionForm form,

             HttpServletRequest request,

             HttpServletResponse response )

throws Exception{
		 
		 ActionErrors errors = new ActionErrors();

		ClassPathResource cpr = new ClassPathResource("context.xml");

		XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);

		String userID = request.getParameter("user");
		
		String baseline = request.getParameter("baseline");

		UserSkillBaselineDAO ublDAO = (UserSkillBaselineDAO)beanFactory.getBean("userSkillBaselineDAO");

		UserDAO usrDAO = (UserDAO)beanFactory.getBean("userDAO");

		User uu =usrDAO.getUser(userID);
		
		UserSkillBaseline usbl = null; 

		try
		{
		  usbl = ublDAO.getUserSkillBaseline(uu, baseline);
			          
		}
		catch (Exception e)
		{
		errors.add("userNotFound",new ActionError("global.error.invalidlogin" ));
		return mapping.findForward("Failure");
		}

		request.setAttribute("usbl", usbl);
		

		return mapping.findForward("Success");
	 }
	
}
