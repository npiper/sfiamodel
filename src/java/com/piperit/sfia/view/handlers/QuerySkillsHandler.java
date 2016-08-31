 package com.piperit.sfia.view.handlers;

import java.util.Collection;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.piperit.sfia.domain.Skill;
import com.piperit.sfia.domain.dao.SkillDAO;

public class QuerySkillsHandler implements ActionListener {

	private DataModel reportsModel;
	
	private Skill currentSkill = null;
	
	public QuerySkillsHandler()
	{
		System.out.println( "Initialised Query Skills Handler" );
		//getSkillsModel();
	}
	
	/** Process when a user presses a button on the query page to get the Skill
	 * information for a particular skill in focus
	 * 
	 */
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		        
        ;

	}
	
    public DataModel getSkillsModel( ) {

        if (reportsModel == null) {

            reportsModel = new ListDataModel( );

        }

        Collection cc = getActiveSkillsList();
        
        reportsModel.setWrappedData(cc);

        if (currentSkill == null && cc.size() >= 1)
        {
        	currentSkill = (Skill)cc.iterator().next();
        }
        
        return reportsModel;

    }

    public Skill getCurrentSkill()
    {
    	return currentSkill;
    }
    
	public void setCurrentSkill( Skill sk )
	{
		this.currentSkill = sk;
	}
	
    /**
     * Makes the Skill at the current row in the Skill set DataModel the
     * current skill
     */
    public String viewSkill() 
    
    {
        Skill selectedSkill = (Skill) reportsModel.getRowData( );
        
        setCurrentSkill(selectedSkill);
        
        return "success";
    }

	
	
	public Collection getActiveSkillsList()
	{
		System.out.println(" Getting active skills list ");
		try
		{
		  ClassPathResource cpr = new ClassPathResource("context.xml");

		  XmlBeanFactory beanFactory = new XmlBeanFactory(cpr);
		
          SkillDAO skillDAO = (SkillDAO)beanFactory.getBean("skillDAO");
		
          Collection cc = skillDAO.getAllActiveSkills();
          
          System.out.println( "Found " + cc.size() + " skills." );
          
          return cc;
		}
		catch (Exception e)
		{
			System.err.println("error getting current list of active skills QuerySkillHandler");
			return null;
		}
	}

}
