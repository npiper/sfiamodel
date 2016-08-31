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

import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.dao.SkillDAO;
import com.piperit.sfia.domain.dao.UserDAO;

public class ShowSkillAction extends Action {

	
	 public ActionForward execute( ActionMapping mapping,

             ActionForm form,

             HttpServletRequest request,

             HttpServletResponse response )

throws Exception{

ActionErrors errors = new ActionErrors();

// Get the user's login name and password. They should have already

// validated by the ActionForm.

ClassPathResource cpr = new ClassPathResource("context.xml");

XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);

String skillID = request.getParameter("id");

SkillDAO skillDAO = (SkillDAO)beanFactory.getBean("skillDAO");

Skill sk = null;

try
{
  sk = skillDAO.getSkill(skillID);          
}
catch (Exception e)
{
errors.add("userNotFound",new ActionError("global.error.invalidlogin" ));
return mapping.findForward("Failure");
}

request.getSession().setAttribute("skill", sk);

return mapping.findForward("Success");

}
}
