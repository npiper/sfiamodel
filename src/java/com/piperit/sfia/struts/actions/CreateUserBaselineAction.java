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
import org.apache.struts.action.DynaActionForm;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.factory.SpringFactory;



public class CreateUserBaselineAction extends Action {

	private Logger logg = Logger.getLogger(CreateUserBaselineAction.class);
	
	  public ActionForward execute( ActionMapping mapping,

              ActionForm form,

              HttpServletRequest request,

              HttpServletResponse response )

throws Exception{

		  logg.debug("CreateUserBaselineAction-->execute()");
		  
		  ActionErrors errors = new ActionErrors();

		  logg.debug("Getting user form values");
		  

		  
		  String user = ((DynaActionForm)form).get("username").toString();
  
		  String blName = ((DynaActionForm)form).get("baselineName").toString();  
		  
		  if (user == null || blName == null) 
		  {
			  errors.add("",new ActionError("Form values not populated."));
			  return mapping.findForward("Failure");
	      }
   
		  logg.debug("CreateUserBaselineAction<--execute()");
		  
          return mapping.findForward("Success");
  }
    
	
	
}
