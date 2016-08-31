package com.piperit.sfia.appconfig;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.piperit.sfia.domain.Role;
import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.SkillLevel;
import com.piperit.sfia.domain.User;
import com.piperit.sfia.domain.UserSkillBaseline;
import com.piperit.sfia.domain.dao.RoleDAO;
import com.piperit.sfia.domain.dao.SkillDAO;
import com.piperit.sfia.domain.dao.UserDAO;
import com.piperit.sfia.domain.dao.UserSkillBaselineDAO;
import com.piperit.sfia.domain.dao.impl.SkillLevelDAOJDBC;
import com.piperit.sfia.spring.domain.SpringSkill;


public class SFIADriver {

	
	public static void main(String [] args)
	{
        ClassPathResource cpr = new ClassPathResource("context.xml");

		XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
		SkillDAO skillDAO = (SkillDAO)beanFactory.getBean("skillDAO");
		
		Skill skill = skillDAO.getSkill(new Integer(52));

		
		UserDAO udao = (UserDAO)beanFactory.getBean( "userDAO" );
		
		User train01 = udao.getUser("train01");

		
		String blname = train01.getCurrentBaseline().getBaselineName();
		
		blname.substring(0);
	}
	
}
