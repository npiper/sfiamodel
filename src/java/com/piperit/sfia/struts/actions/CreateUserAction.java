package com.piperit.sfia.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.factory.SpringFactory;

public class CreateUserAction extends Action {

	
	  public ActionForward execute( ActionMapping mapping,

              ActionForm form,

              HttpServletRequest request,

              HttpServletResponse response )

throws Exception{

ActionErrors errors = new ActionErrors();
	
    String user = ((DynaActionForm)form).get("username").toString();
	
    ClassPathResource cpr = new ClassPathResource("context.xml");

	XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
	
  UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");

  SpringFactory sf = new SpringFactory();
  sf.createUser( user );
  
  
  try
  {
    userDAO.insertUser( sf.createUser( user ) );          
  }
  catch (Exception e)
  {
  	  errors.add("userNotFound",new ActionError("global.error.invalidlogin" ));
      return mapping.findForward("Failure");
  }
  
  request.setAttribute("username", user);
  
  return mapping.findForward("Success");
	  }
    
}
