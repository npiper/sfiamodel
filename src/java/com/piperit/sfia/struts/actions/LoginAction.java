package com.piperit.sfia.struts.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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


public class LoginAction extends Action {

	
	 protected static Log log = LogFactory.getLog( LoginAction.class );

	  /**

	   * Called by the controller when the a user attempts to login to the

	   * storefront application.

	   */

	  public ActionForward execute( ActionMapping mapping,

	                                ActionForm form,

	                                HttpServletRequest request,

	                                HttpServletResponse response )

	  throws Exception{

			ActionErrors errors = new ActionErrors();

	    // Get the user's login name and password. They should have already

	    // validated by the ActionForm.

	    String user = ((DynaActionForm)form).get("username").toString();

	    String password = ((DynaActionForm)form).get("password").toString();

	    ClassPathResource cpr = new ClassPathResource("context.xml");

		  XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
        UserDAO userDAO = (UserDAO)beanFactory.getBean("userDAO");

        User uu = null;
        try
        {
          uu = userDAO.getUser( user );          
        }
        catch (Exception e)
        {
        	errors.add("userNotFound",new ActionError("global.error.invalidlogin" ));
            return mapping.findForward("Failure");
        }
        
        request.getSession().setAttribute("currentuser", uu);
        
	    request.setAttribute("user", uu);
 
	    return mapping.findForward("Success");

	  }

	}
	

